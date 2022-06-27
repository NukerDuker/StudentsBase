package ru.studentsbase.util;

import ru.studentsbase.model.Statistics;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;

import java.util.List;
import java.util.stream.Collectors;

public class StatsUtil {

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        //Шаг 1. Получить список всех профилей, которые хоть раз упоминаются в файле
        List<Statistics> statisticsList = universities.stream()
                .map(x -> x.getMainProfile())
                .distinct()
                .map(x -> new Statistics().setMainProfile(x))
                .collect(Collectors.toList());
        //Шаг 2. Заполнить количество университетов по профилям
        int unisCount = 0;
        statisticsList.stream().peek(x -> {
            universities
                    .forEach(z -> {
                        if (x.getMainProfile().name().equals(z.getMainProfile().name())) {
                            x.addUniversityFullName(z.getFullName());
                        }
                    });
        })
                .forEach(stat -> stat.setUniversityQuantity(stat.getUniversitiesList().size()));

        return statisticsList;
    }
}
