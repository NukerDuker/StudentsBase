import ru.studentsbase.comparators.Controller;
import ru.studentsbase.comparators.students.StudentComparator;
import ru.studentsbase.comparators.universities.UniversityComparator;
import ru.studentsbase.enums.StudCompareEnum;
import ru.studentsbase.enums.UnivCompareEnum;
import ru.studentsbase.model.Student;
import ru.studentsbase.service.ExcelReader;
import ru.studentsbase.model.University;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Компараторы университетов
        UniversityComparator shortname = Controller.getComparator(UnivCompareEnum.SHORTNAMECOMPARISON);
        UniversityComparator found = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        UniversityComparator fullName = Controller.getComparator(UnivCompareEnum.FULLNAMECOMPARISON);
        UniversityComparator id = Controller.getComparator(UnivCompareEnum.IDCOMPARISON);
        UniversityComparator mainprof = Controller.getComparator(UnivCompareEnum.MAINPROFILECOMPARISON);

        //Компараторы студентов
        StudentComparator studname = Controller.getComparator(StudCompareEnum.AVGEXSCORECOMPARISON);

        //Сортировка полученного списка университетов
        List<University> lu = ExcelReader.readUniversities().stream()
                .sorted((x, y) -> (shortname.compare(x.getShortName(), y.getShortName())))
                .collect(Collectors.toList());


        //Сортировка полученного списка студентов
        List<Student> ls = ExcelReader.readStudents().stream()
                .sorted((x, y) -> (studname.compare(x.getAvgExamScore(), y.getAvgExamScore())))
                .peek(System.out::println)
                .collect(Collectors.toList());







    }
}
