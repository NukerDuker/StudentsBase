package ru.studentsbase.model;

import com.google.gson.annotations.SerializedName;
import ru.studentsbase.enums.StudyProfile;

public class University {

    //Добавляем поля класса
    @SerializedName(value = "UniversityId")
    private String id;
    @SerializedName(value = "UniversityName")
    private String fullName;
    @SerializedName(value = "UniversityShortName")
    private String shortName;
    @SerializedName(value = "YearOfFoundation")
    private int yearOfFoundation;
    @SerializedName(value = "Profile")
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

    public String getMainProfile() {
        return mainProfile.getProfileName();
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

    public University setMainProfile(StudyProfile mainProfile) {
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
        private StudyProfile mainProfile;

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

        public UniversityBuilder setMainProfile(StudyProfile mainProfile) {
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
