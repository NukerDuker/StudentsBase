package ru.studentsbase.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.studentsbase.enums.StudyProfile;
import ru.studentsbase.model.Student;
import ru.studentsbase.model.University;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    private static final List<University> universityList = new ArrayList<>();
    private static final List<Student> studentList = new ArrayList<>();
    private static final File univInfoXlsx = new File("src/main/resources/universityInfo.xlsx");

    private ExcelReader() {
    }

    public static List<Student> readStudents(String filepath) {
        Student student;

        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheet("��������");
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (!((row.getCell(0).toString()).equals("id ������������"))) {
                    studentList
                            .add(new Student.StudentBuilder()
                            .setUniversityId(row.getCell(0).getStringCellValue())
                            .setFullName(row.getCell(1).getStringCellValue())
                            .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                            .setAvgExamScore((float) row.getCell(3).getNumericCellValue())
                            .createStudent()
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("����� ���");
            e.printStackTrace();
        }
        return studentList;
    }

    public static List<University> readUniversities(String filepath) {
        University university;
        List<University> universityList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheet("������������");
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (!((row.getCell(0).getStringCellValue()).equals("id ������������"))) {
                    universityList
                            .add(new University.UniversityBuilder()
                            .setId(row.getCell(0).getStringCellValue())
                            .setFullName(row.getCell(1).getStringCellValue())
                            .setShortName(row.getCell(2).getStringCellValue())
                            .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                            .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()))
                            .createUniversity()
                    );

                }
            }
        } catch (IOException e) {
            System.out.println("����� ���");
            e.printStackTrace();
        }
        return universityList;
    }
}
