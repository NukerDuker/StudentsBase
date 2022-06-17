package ru.studentsbase.comparators.students;

import org.apache.commons.lang3.StringUtils;
import ru.studentsbase.model.Student;

public class FullNameComparison implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
