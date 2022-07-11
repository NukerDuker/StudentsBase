package ru.studentsbase.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.studentsbase.comparators.students.*;
import ru.studentsbase.comparators.students.FullNameComparison;
import ru.studentsbase.comparators.universities.*;
import ru.studentsbase.enums.StudCompareEnum;
import ru.studentsbase.enums.UnivCompareEnum;


public class Controller {

    private static Logger logger = LogManager.getLogger(Controller.class.getName());

    private Controller() {}

    public static StudentComparator getComparator(StudCompareEnum compareEnum) {
        logger.info("Выбираем компаратор студентов");
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
                logger.warn("Не найдена функция для сравнения. Выбери одну из:\nAVGEXSCORECOMPARISON,\n" +
                        "    CURSENUMCOMPARISON,\n" +
                        "    FULLNAMECOMPARISON,\n" +
                        "    UNIVIDCOMPARISON;");
                return null;
        }
    }

    public static UniversityComparator getComparator(UnivCompareEnum compareEnum) {
        logger.info("Выбираем компаратор университетов");
        switch (compareEnum) {
            case FOUNDATIONCOMPARISON:
                return new FoundationComparison();
            case IDCOMPARISON:
                return new IdComparison();
            case FULLNAMECOMPARISON:
                return new ru.studentsbase.comparators.universities.FullNameComparison();
            case MAINPROFILECOMPARISON:
                return new MainProfileComparison();
            case SHORTNAMECOMPARISON:
                return new ShortNameComparison();
            default:
                logger.warn("Не найдена функция для сравнения. Выбери одну из:\nFOUNDATIONCOMPARISON,\n" +
                        "    FULLNAMECOMPARISON,\n" +
                        "    IDCOMPARISON,\n" +
                        "    MAINPROFILECOMPARISON,\n" +
                        "    SHORTNAMECOMPARISON;");
                return null;
        }
    }
}
