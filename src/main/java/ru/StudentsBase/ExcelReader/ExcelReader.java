package ru.StudentsBase.ExcelReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.StudentsBase.model.Student;
import ru.StudentsBase.model.University;
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

    public static List<Student> readStudents() {
        Student student;
        try (FileInputStream fis = new FileInputStream(univInfoXlsx)) {
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheet("Студенты");
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (!((row.getCell(0).toString()).equals("id университета"))) {
                    studentList.add(student = new Student.StudentBuilder()
                            .setUniversityId(row.getCell(0).getStringCellValue())
                            .setFullName(row.getCell(1).getStringCellValue())
                            .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                            .setAvgExamScore((float) row.getCell(3).getNumericCellValue())
                            .createStudent()
                    );
                    studentList.add(student);
                    System.out.println(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Файла нет");
            e.printStackTrace();
        }
        return studentList;
    }

    public static List<University> readUniversities() {
        University university;
        try (FileInputStream fis = new FileInputStream(univInfoXlsx)) {
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheet("Университеты");
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (!((row.getCell(0).getStringCellValue()).equals("id университета"))) {
                    universityList.add(university = new University.UniversityBuilder()
                            .setId(row.getCell(0).getStringCellValue())
                            .setFullName(row.getCell(1).getStringCellValue())
                            .setShortName(row.getCell(2).getStringCellValue())
                            .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                            .setMainProfile(University.StudyProfile.valueOf(row.getCell(4).getStringCellValue()))
                            .createUniversity()
                    );
                    universityList.add(university);
                    System.out.println(university);
                }
            }
        } catch (IOException e) {
            System.out.println("Файла нет");
            e.printStackTrace();
        }
        return universityList;
    }
}
