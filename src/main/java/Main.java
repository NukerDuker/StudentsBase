import ru.studentsbase.util.Controller;
import ru.studentsbase.comparators.students.StudentComparator;
import ru.studentsbase.comparators.universities.UniversityComparator;
import ru.studentsbase.enums.StudCompareEnum;
import ru.studentsbase.enums.UnivCompareEnum;
import ru.studentsbase.model.Student;
import ru.studentsbase.service.ExcelReader;
import ru.studentsbase.model.University;
import ru.studentsbase.util.JsonUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //—ортировка полученного списка университетов
        List<University> universities = ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        universities.stream()
                .sorted(universityComparator)
                .map(JsonUtil::universityToJson)
                .peek(System.out::println)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        //—ортировка полученного списка студентов
        List<Student> students = ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Controller.getComparator(StudCompareEnum.AVGEXSCORECOMPARISON);
        students.stream()
                .sorted(studentComparator)
                .map(JsonUtil::studentToJson)
                .peek(System.out::println)
                .map(JsonUtil::studentFromJson)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

    }
}
