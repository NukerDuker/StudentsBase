package ru.studentsbase.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.studentsbase.model.Statistics;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatsUtil {

    private static Logger logger = LogManager.getLogger(StatsUtil.class.getName());

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        //Шаг 1. Получить список всех профилей, которые хоть раз упоминаются в файле
        logger.info("Получаем список всех профилей, которые есть в файле");
        List<Statistics> statisticsList = universities.stream()
                .map(x -> x.getMainProfile())
                .distinct()
                .map(x -> new Statistics().setMainProfile(x))
                .collect(Collectors.toList());
        //Шаг 2. Заполнить количество университетов по профилям
        logger.info("Заполняем количество университетов по профилю");
        int unisCount = 0;
        statisticsList.stream().peek(statistics -> {
                    universities.forEach(university -> {
                        if (statistics.getMainProfile().name().equals(university.getMainProfile().name())) {
                            statistics.addUniversityFullName(university.getFullName());
                            statistics.addUniversitiesIdList(university.getId());
                        }
                    });
                    List<Float> avgScoreList = new ArrayList<>();
                    students.forEach(student -> {
                        for (String id : statistics.getUniversitiesIdList()) {
                            if (id.equals(student.getUniversityId())) {
                                avgScoreList.add(student.getAvgScore());
                            }
                        }
                    });
                    statistics.setStudentQuantity(avgScoreList.size());
                    statistics.setAvgExamScore(getAverageScore(avgScoreList, statistics));
                    logger.info("Средний балл " + statistics.getAvgExamScore());

                })
                .forEach(stat -> stat.setUniversityQuantity(stat.getUniversitiesList().size()));

        return statisticsList;
    }

    private static float getAverageScore(List<Float> avgScoreList, Statistics stat) {
        logger.info("Считаем средний балл по профилю " + stat.getMainProfile().toString());
        float average = 0;
        //Если студентов нет, возвращаем Optional.empty();
        if (avgScoreList.size() == 0) stat.setAvgExamScore(0);
        //В остальных случаях считаем средний бал:
        else {
            float sum = 0;
            for (Float score : avgScoreList) {
                sum += score;
            }
            average = sum / avgScoreList.size();
        }
        BigDecimal bd = new BigDecimal(average).setScale(2, RoundingMode.HALF_EVEN);
        return bd.floatValue();
    }
}
