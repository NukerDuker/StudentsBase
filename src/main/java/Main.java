import ru.StudentsBase.model.Student;
import ru.StudentsBase.model.University;


public class Main {
    public static void main(String[] args) {
        //Выводим в консоль тестовый универ
        System.out.println(
                new University.UniversityBuilder()
                        .setId("1")
                        .setShortName("Test")
                        .setFullName("Full Test")
                        .setYearOfFoundation(1993)
                        .setMainProfile(University.StudyProfile.MEDICINE));

        //Выводим в консоль тестового студента
        System.out.println(
                new Student.StudentBuilder()
                        .setUniversityId("1")
                        .setFullName("Student Test")
                        .setCurrentCourseNumber(1)
                        .setAvgExamScore(98)
        );
    }
}
