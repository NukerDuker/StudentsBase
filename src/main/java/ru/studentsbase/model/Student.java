package ru.studentsbase.model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    //Поля класса
    @SerializedName(value = "Student")
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName(value = "University")
    @XmlElement(name = "universityId")
    private String universityId;

    @XmlTransient
    @SerializedName(value = "Course")
    private int currentCourseNumber;

    @SerializedName(value = "AverageScore")
    private float avgScore;

    //Конструкторы


    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgScore = avgExamScore;
    }

    //Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgScore +
                '}';
    }

    //Билдер
    public static class StudentBuilder {
        private String fullName;
        private String universityId;
        private int currentCourseNumber;
        private float avgExamScore;

        public StudentBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public StudentBuilder setUniversityId(String universityId) {
            this.universityId = universityId;
            return this;
        }

        public StudentBuilder setCurrentCourseNumber(int currentCourseNumber) {
            this.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public StudentBuilder setAvgExamScore(float avgExamScore) {
            this.avgExamScore = avgExamScore;
            return this;
        }

        public Student createStudent() {
            return new Student(fullName, universityId, currentCourseNumber, avgExamScore);
        }

        @Override
        public String toString() {
            return "StudentBuilder{" +
                    "fullName='" + fullName + '\'' +
                    ", universityId='" + universityId + '\'' +
                    ", currentCourseNumber=" + currentCourseNumber +
                    ", avgExamScore=" + avgExamScore +
                    '}';
        }
    }

}
