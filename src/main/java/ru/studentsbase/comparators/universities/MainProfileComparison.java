package ru.studentsbase.comparators.universities;

import org.apache.commons.lang3.StringUtils;
import ru.studentsbase.model.University;

public class MainProfileComparison implements UniversityComparator{

    @Override
    public int compare(University o1, University o2) {
        if (null == o1.getMainProfile()) {
            return 1;
        } else if (null == o2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}
