package ru.studentsbase.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
    }

    public static String toJson(Jsonable object) {
        return gson.toJson(object);
    }


    public static String listToJson(List<? extends Jsonable> studentList) {
        return gson.toJson(studentList);
    }

    public static String universitiesListToJson(List<University> universityList) {
        return gson.toJson(universityList);
    }

    public static Student studentFromJson(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static University universityFromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public static List<Student> studentListFromJson(String json) {
        Type collectionType = new TypeToken<List<Student>>() {
        }.getType();
        return gson.fromJson(json, collectionType);
    }

    public static List<University> universitiesListFromJson(String json) {
        Type collectionType = new TypeToken<List<University>>() {
        }.getType();
        return gson.fromJson(json, collectionType);
    }
}
