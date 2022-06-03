package ru.StudentsBase.comparators.universities;

import org.apache.poi.ss.formula.functions.T;
import ru.StudentsBase.model.University;

import java.util.Comparator;

public interface UniversityComparator extends Comparator<University> {

    int compare(int o1, int o2);
    int compare(String o1, String o2);
    int compare(float o1, float o2);

    @Override
    default int compare(University o1, University o2) {
        return 0;
    }
}