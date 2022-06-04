import ru.StudentsBase.comparators.Controller;
import ru.StudentsBase.comparators.students.FullNameComparison;
import ru.StudentsBase.comparators.students.StudentComparator;
import ru.StudentsBase.comparators.universities.ShortNameComparison;
import ru.StudentsBase.comparators.universities.UniversityComparator;
import ru.StudentsBase.enums.StudCompareEnum;
import ru.StudentsBase.enums.UnivCompareEnum;
import ru.StudentsBase.model.Student;
import ru.StudentsBase.service.ExcelReader;
import ru.StudentsBase.comparators.universities.FoundationComparison;
import ru.StudentsBase.model.University;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        UniversityComparator shortname = Controller.getComparator(UnivCompareEnum.SHORTNAMECOMPARISON);
        UniversityComparator found = Controller.getComparator(UnivCompareEnum.FOUNDATIONCOMPARISON);
        UniversityComparator fullName = Controller.getComparator(UnivCompareEnum.FULLNAMECOMPARISON);
        UniversityComparator id = Controller.getComparator(UnivCompareEnum.IDCOMPARISON);
        UniversityComparator mainprof = Controller.getComparator(UnivCompareEnum.MAINPROFILECOMPARISON);

        StudentComparator studname = Controller.getComparator(StudCompareEnum.FULLNAMECOMPARISON);


        List<University> lu = ExcelReader.readUniversities().stream()
                .sorted((x, y) -> (shortname.compare(x.getShortName(), y.getShortName())))
                .collect(Collectors.toList());
        lu.stream().forEach(System.out::println);

        List<Student> ls = ExcelReader.readStudents()
                .stream()
                .sorted((x, y) -> (studname.compare(x.getFullName(), y.getFullName())))
                .collect(Collectors.toList());
        ls.stream().forEach(System.out::println);




    }
}
