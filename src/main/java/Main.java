import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.studentsbase.enums.StudyProfile;
import ru.studentsbase.model.Statistics;
import ru.studentsbase.service.XlsWriter;
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

    private static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        //Сортировка полученного списка университетов
        List<University> universities = ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        universities.stream()
                .sorted(universityComparator)
                .collect(Collectors.toList());

        //Сортировка полученного списка студентов
        List<Student> students = ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Controller.getComparator(StudCompareEnum.AVGEXSCORECOMPARISON);
        students.stream()
                .sorted(studentComparator)
                .collect(Collectors.toList());

        //Статистика
        List<Statistics> statistics = StatsUtil.getStatistics(students, universities);
        XlsWriter.writeStats(statistics, "src/main/resources/statistics.xlsx");
        statistics.stream()
                .map(x -> x.getAvgExamScore().get())
                .collect(Collectors.toList());

    }
}
