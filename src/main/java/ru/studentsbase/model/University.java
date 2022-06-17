package ru.studentsbase.model;

public class University {

    public University createUniversity() {
        return new UniversityBuilder().setId(id).setFullName(fullName).setShortName(shortName).setYearOfFoundation(yearOfFoundation).setMainProfile(mainProfile).createUniversity();
    }

    //Добавляем Enum
    public StudyProfile profileName;

    public enum StudyProfile {

        MEDICINE("медицина"),
        PHYSICS("физика"),
        LINGUISTICS("лингвистика"),
        MATHEMATICS("математика");

        StudyProfile(String profile) {
            this.profileName = profile;
        }

        public String profileName;
    }

    //Добавляем поля класса
    private String id, fullName, shortName;
    private int yearOfFoundation;
    StudyProfile mainProfile;

    //Конструкторы

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    //Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(University.StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public static class UniversityBuilder {
        private String id;
        private String fullName;
        private String shortName;
        private int yearOfFoundation;
        private University.StudyProfile mainProfile;

        public UniversityBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UniversityBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UniversityBuilder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public UniversityBuilder setYearOfFoundation(int yearOfFoundation) {
            this.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public UniversityBuilder setMainProfile(University.StudyProfile mainProfile) {
            this.mainProfile = mainProfile;
            return this;
        }

        public University createUniversity() {
            return new University(id, fullName, shortName, yearOfFoundation, mainProfile);
        }

        @Override
        public String toString() {
            return "UniversityBuilder{" +
                    "id='" + id + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", shortName='" + shortName + '\'' +
                    ", yearOfFoundation=" + yearOfFoundation +
                    ", mainProfile=" + mainProfile +
                    '}';
        }
    }
}
