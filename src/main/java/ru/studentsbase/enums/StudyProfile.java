package ru.studentsbase.enums;

//��������� Enum
public enum StudyProfile {

    MEDICINE("��������"),
    PHYSICS("������"),
    LINGUISTICS("�����������"),
    MATHEMATICS("����������");

    StudyProfile(String profile) {
        this.profileName = profile;
    }

    public String profileName;

    public String getProfileName() {
        return profileName;
    }
}