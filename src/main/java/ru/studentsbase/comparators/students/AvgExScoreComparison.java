package ru.StudentsBase.comparators.students;

import org.apache.commons.lang3.StringUtils;
import ru.StudentsBase.model.Student;

public class AvgExScoreComparison implements StudentComparator {

    @Override
    public int compare(String o1, String o2) {
        return StringUtils.compare(o1, o2);
    }

    @Override
    public int compare(int o1, int o2) {
        return Integer.compare(o1, o2);
    }

    @Override
    public int compare(float o1, float o2) {
        return -(Float.compare(o1, o2));
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}

