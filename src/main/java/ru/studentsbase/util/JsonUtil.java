package ru.studentsbase.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {}

    //Методы для сериализации студента и университета в JSON
    public static String studentToJson(Student student) {
        return gson.toJson(student);
    }

    public static String universityToJson(University university) {
        return gson.toJson(university);
    }

    //Методы для сериализации коллекций студентов и университетов в JSON
    public static String studentListToJson(List<Student> studentList) {
        return gson.toJson(studentList);
    }

    public static String universitiesListToJson(List<University> universityList) {
        return gson.toJson(universityList);
    }

    //Методы десериализации из JSON в объекты
    public static Student studentFromJson(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static University universityFromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public static List<Student> studentListFromJson(String json) {
        Type collectionType = new TypeToken<List<Student>>(){}.getType();
        return gson.fromJson(json, collectionType);
    }

    public static List<University> universitiesListFromJson(String json) {
        Type collectionType = new TypeToken<List<University>>(){}.getType();
        return gson.fromJson(json, collectionType);
    }
}
