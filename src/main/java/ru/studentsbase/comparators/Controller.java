package ru.StudentsBase.comparators;
import ru.StudentsBase.comparators.students.*;
import ru.StudentsBase.comparators.students.FullNameComparison;
import ru.StudentsBase.comparators.universities.*;
import ru.StudentsBase.enums.StudCompareEnum;
import ru.StudentsBase.enums.UnivCompareEnum;


public class Controller {

    private Controller() {}

    public static StudentComparator getComparator(StudCompareEnum compareEnum) {
        switch (compareEnum) {
            case AVGEXSCORECOMPARISON:
                return new AvgExScoreComparison();
            case CURSENUMCOMPARISON:
                return new CurseNumComparison();
            case FULLNAMECOMPARISON:
                return new FullNameComparison();
            case UNIVIDCOMPARISON:
                return new UnivIdComparison();
            default:
                System.out.println("Не найдена функция для сравнения. Выбери одну из:\nAVGEXSCORECOMPARISON,\n" +
                        "    CURSENUMCOMPARISON,\n" +
                        "    FULLNAMECOMPARISON,\n" +
                        "    UNIVIDCOMPARISON;");
                return null;
        }
    }

    public static UniversityComparator getComparator(UnivCompareEnum compareEnum) {
        switch (compareEnum) {
            case FOUNDATIONCOMPARISON:
                return new FoundationComparison();
            case IDCOMPARISON:
                return new IdComparison();
            case FULLNAMECOMPARISON:
                return new ru.StudentsBase.comparators.universities.FullNameComparison();
            case MAINPROFILECOMPARISON:
                return new MainProfileComparison();
            case SHORTNAMECOMPARISON:
                return new ShortNameComparison();
            default:
                System.out.println("Не найдена функция для сравнения. Выбери одну из:\nFOUNDATIONCOMPARISON,\n" +
                        "    FULLNAMECOMPARISON,\n" +
                        "    IDCOMPARISON,\n" +
                        "    MAINPROFILECOMPARISON,\n" +
                        "    SHORTNAMECOMPARISON;");
                return null;
        }
    }
}
