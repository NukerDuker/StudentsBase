package ru.studentsbase.model;

public class Student {

    //Поля класса
    private String fullName, universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    //Конструкторы


    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
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

    public float getAvgExamScore() {
        return avgExamScore;
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

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
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
