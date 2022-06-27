package ru.studentsbase.model;

import ru.studentsbase.enums.StudyProfile;

import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

    private StudyProfile mainProfile;
    private float avgExamScore;
    private int studentQuantity;
    private int universityQuantity;
    private String universityFullName;

    public Statistics() {
    }

    public StudyProfile  getMainProfile() {
        return mainProfile;
    }

    public Statistics setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public Statistics setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
        return this;
    }

    public int getUniversityQuantity() {
        return universityQuantity;
    }

    public Statistics setUniversityQuantity(int universityQuantity) {
        this.universityQuantity = universityQuantity;
        return this;
    }

    public String getUniversityFullName() {
        return universityFullName;
    }

    public Statistics setUniversityFullName(String universityFullName) {
        this.universityFullName = universityFullName;
        return this;
    }

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        /*
        * Для каждого профиля, в котором есть хотя бы один университет, создать экземпляр класса Statistics.
        * Заполнить все поля: пробежаться по стриму университетов функцией map, вытащить значения mainprofile
        * Отфильтровать дубли
        * Из оставшегося списка по каждому элементу создать класс Statistics */

        List<Statistics> statisticsList = universities.stream()
                .map(x -> x.getMainProfile())
                .distinct()
                .map(x -> new Statistics().setMainProfile(x))
                .collect(Collectors.toList());
        return statisticsList;
    }
}
