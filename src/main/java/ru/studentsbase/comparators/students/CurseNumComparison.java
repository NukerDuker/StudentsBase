package ru.studentsbase.comparators.students;

import org.apache.commons.lang3.StringUtils;
import ru.studentsbase.model.Student;

public class CurseNumComparison implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
