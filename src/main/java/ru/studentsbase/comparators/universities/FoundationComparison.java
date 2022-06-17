package ru.studentsbase.comparators.universities;

import org.apache.commons.lang3.StringUtils;
import ru.studentsbase.model.University;

public class FoundationComparison implements UniversityComparator{

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
