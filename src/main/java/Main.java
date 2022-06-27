import ru.studentsbase.enums.StudyProfile;
import ru.studentsbase.model.Statistics;
import ru.studentsbase.util.Controller;
import ru.studentsbase.comparators.students.StudentComparator;
import ru.studentsbase.comparators.universities.UniversityComparator;
import ru.studentsbase.enums.StudCompareEnum;
import ru.studentsbase.enums.UnivCompareEnum;
import ru.studentsbase.model.Student;
import ru.studentsbase.service.ExcelReader;
import ru.studentsbase.model.University;
import ru.studentsbase.util.JsonUtil;
import ru.studentsbase.util.StatsUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Сортировка полученного списка университетов
        List<University> universities = ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        universities.stream()
                .sorted(universityComparator)
                .map(JsonUtil::universityToJson)
                .peek(System.out::println)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        //Сортировка полученного списка студентов
        List<Student> students = ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Controller.getComparator(StudCompareEnum.AVGEXSCORECOMPARISON);
        students.stream()
                .sorted(studentComparator)
                .map(JsonUtil::studentToJson)
                .peek(System.out::println)
                .map(JsonUtil::studentFromJson)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        //Статистика
        List<Statistics> statistics = StatsUtil.getStatistics(students, universities);
        Map<StudyProfile, String> map = statistics.stream()
                .collect(Collectors.toMap(Statistics::getMainProfile,Statistics::getUniversitiesList));
        for(Map.Entry<StudyProfile, String> entry:map.entrySet()) {
            System.out.println("Profile: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}
