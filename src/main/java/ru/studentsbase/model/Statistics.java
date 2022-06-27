package ru.studentsbase.model;

import ru.studentsbase.enums.StudyProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

    private StudyProfile mainProfile;
    private float avgExamScore;
    private int studentQuantity;
    private int universityQuantity;
    private List<String> universityFullName = new ArrayList<>();

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

    public List<String> getUniversitiesList() {
        return universityFullName;
    }

    public Statistics addUniversityFullName(String universityFullName) {
        this.universityFullName.add(universityFullName);
        return this;
    }


}
