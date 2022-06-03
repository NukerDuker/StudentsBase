import ru.StudentsBase.service.ExcelReader;
import ru.StudentsBase.comparators.universities.FoundationComparison;
import ru.StudentsBase.model.University;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoundationComparison fs = new FoundationComparison();

        //ExcelReader.readStudents();
        List<University> lu = ExcelReader.readUniversities();
        lu.sort((x , y) -> fs.compare(x.getYearOfFoundation(), y.getYearOfFoundation()));
        lu.stream().forEach(System.out::println);


    }
}
