package ru.studentsbase.enums;

//????????? Enum
public enum StudyProfile {

    MEDICINE("медицина"),
    PHYSICS("физика"),
    LINGUISTICS("лингвистика"),
    MATHEMATICS("математика");

    StudyProfile(String profile) {
        this.profileName = profile;
    }

    public String profileName;

    public String getProfileName() {
        return profileName;
    }
}