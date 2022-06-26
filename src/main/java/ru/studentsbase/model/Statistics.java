package ru.studentsbase.model;

import ru.studentsbase.enums.StudyProfile;

import java.util.List;

public class Statistics {

    private StudyProfile mainProfile;
    private float avgExamScore;
    private int studentQuantity;
    private int universityQuantity;
    private String universityFullName;

    public Statistics() {
    }

    public String  getMainProfile() {
        return mainProfile.getProfileName();
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

    public List<Statistics> getStatistics(List<Student> students, List<University> universities) {

    }
}
