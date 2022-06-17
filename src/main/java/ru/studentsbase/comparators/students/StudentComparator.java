package ru.studentsbase.comparators.students;

import ru.studentsbase.model.Student;

import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {

    int compare(String o1, String o2);
    int compare(int o1, int o2);
    int compare(float o1, float o2);

    @Override
    default int compare(Student o1, Student o2) {
        return 0;
    }

}
