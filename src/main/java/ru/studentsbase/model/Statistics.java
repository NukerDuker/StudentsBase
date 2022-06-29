package ru.studentsbase.model;

import ru.studentsbase.enums.StudyProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Statistics {

    private StudyProfile mainProfile;
    private Optional<Float> avgExamScore;
    private Optional<Integer> studentQuantity;
    private int universityQuantity;
    private List<String> universitiesFullNameList = new ArrayList<>();
    private List<String> universitiesIdList = new ArrayList<>();

    public Statistics() {
    }

    public StudyProfile  getMainProfile() {
        return mainProfile;
    }

    public Statistics setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public Optional<Float> getAvgExamScore() {
        return avgExamScore;
    }

    public Optional<Float> setAvgExamScore(float avgExamScore) {
        return this.avgExamScore = Optional.ofNullable(avgExamScore);
    }

    public Optional<Integer> getStudentQuantity() {
        return studentQuantity;
    }

    public Optional<Integer> setStudentQuantity(int studentQuantity) {
        return this.studentQuantity = Optional.ofNullable(studentQuantity);
    }

    public int getUniversityQuantity() {
        return universityQuantity;
    }

    public Statistics setUniversityQuantity(int universityQuantity) {
        this.universityQuantity = universityQuantity;
        return this;
    }

    public List<String> getUniversitiesList() {
        return universitiesFullNameList;
    }

    public Statistics addUniversityFullName(String universityFullName) {
        this.universitiesFullNameList.add(universityFullName);
        return this;
    }

    public List<String> getUniversitiesIdList() {
        return universitiesIdList;
    }

    public Statistics addUniversitiesIdList(String universitiyId) {
        this.universitiesIdList.add(universitiyId);
        return this;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", studentQuantity=" + studentQuantity +
                ", universityQuantity=" + universityQuantity +
                ", universitiesFullNameList=" + universitiesFullNameList +
                ", universitiesIdList=" + universitiesIdList +
                '}';
    }
}
