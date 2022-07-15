package ru.studentsbase.comparators.students;

import ru.studentsbase.model.Student;

public class AvgExScoreComparison implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgScore(), o2.getAvgScore());
    }
}

