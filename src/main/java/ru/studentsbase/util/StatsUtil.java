package ru.studentsbase.util;

import ru.studentsbase.model.Statistics;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;

import java.util.List;
import java.util.stream.Collectors;

public class StatsUtil {

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        //��� 1. �������� ������ ���� ��������, ������� ���� ��� ����������� � �����
        List<Statistics> statisticsList = universities.stream()
                .map(x -> x.getMainProfile())
                .distinct()
                .map(x -> new Statistics().setMainProfile(x))
                .collect(Collectors.toList());
        //��� 2. ��������� ���������� ������������� �� ��������
        statisticsList.forEach(x -> {
            universities.forEach(z -> {
                        if (x.getMainProfile().name().equals(z.getMainProfile().name())) {
                            x.addUniversityFullName(z.getFullName());
                        }
                    });
        });

        return statisticsList;
    }
}
