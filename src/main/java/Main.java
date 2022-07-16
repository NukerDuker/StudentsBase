import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.studentsbase.model.Statistics;
import ru.studentsbase.model.XmlModel;
import ru.studentsbase.service.JsonWriter;
import ru.studentsbase.service.XmlWriter;
import ru.studentsbase.util.Controller;
import ru.studentsbase.comparators.students.StudentComparator;
import ru.studentsbase.comparators.universities.UniversityComparator;
import ru.studentsbase.enums.StudCompareEnum;
import ru.studentsbase.enums.UnivCompareEnum;
import ru.studentsbase.model.Student;
import ru.studentsbase.service.ExcelReader;
import ru.studentsbase.model.University;
import ru.studentsbase.util.StatsUtil;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class.getName());
    List<University> universities;

    List<Student> students;

    List<Statistics> statistics;

    public static void main(String[] args) {

        //���������� ����������� ������ �������������
        List<University> universities = ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        universities.stream()
                .sorted(universityComparator)
                .collect(Collectors.toList());

        //���������� ����������� ������ ���������
        List<Student> students = ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Controller.getComparator(StudCompareEnum.AVGEXSCORECOMPARISON);
        students.stream()
                .sorted(studentComparator)
                .collect(Collectors.toList());

        //����������
        List<Statistics> statistics = StatsUtil.getStatistics(students, universities);
        //XlsWriter.writeStats(statistics, "src/main/resources/statistics.xlsx");

        XmlModel model = XmlModel.builder()
                .students(students)
                .universities(universities)
                .statistics(statistics)
                .build();

        logger.info("����������� ������ ��� xml � JSON");
        XmlWriter.marshal(model);
        JsonWriter.marshal(model);
    }
}
