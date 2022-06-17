package ru.studentsbase.comparators.universities;

import org.apache.commons.lang3.StringUtils;
import ru.studentsbase.model.University;

public class ShortNameComparison implements UniversityComparator{

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
