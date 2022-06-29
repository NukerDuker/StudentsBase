package ru.studentsbase.service;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.studentsbase.model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsWriter {
    private static CellStyle headerStyle;
    private static CellStyle bodyStyle;
    private static List<Object> stats = new ArrayList<>();
    private static final String[] HEADERS = {"Основной профиль", "Средний балл", "Количество студентов", "Количество университетов", "Название университета"};

    public static boolean writeStats(List<Statistics> list, String filepath) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            //Устанавливаем стили заголовковка
            setHeaderCellStyle(workbook);
            setBodyStyle(workbook);
            //Создаем страницу
            XSSFSheet sheet = workbook.createSheet("Статистика");
            //Устанавливаем заголовки столбцов
            XSSFRow row = sheet.createRow(0);
            fillHeaders(row);
            fillTableBody(sheet, list);
            //Пишем таблицу в файл:
            FileOutputStream fos = new FileOutputStream(filepath);
            workbook.write(fos);
            fos.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void setHeaderCellStyle(XSSFWorkbook workbook) {
        headerStyle = workbook.createCellStyle();
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        font.setBold(true);
        headerStyle.setFont(font);
    }

    private static void setBodyStyle(XSSFWorkbook workbook) {
        bodyStyle = workbook.createCellStyle();
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        bodyStyle.setFont(font);
    }

    private static void fillHeaders(XSSFRow row) {
        int cellId = 0;
        for (String header : HEADERS) {
            Cell cell = row.createCell(cellId++);
            cell.setCellValue(header);
            cell.setCellStyle(headerStyle);
        }
    }

    private static void fillTableBody(XSSFSheet sheet, List<Statistics> list) {
        int rowId = 1;
        for (Statistics stat : list) {
            XSSFRow row = sheet.createRow(rowId++);
            for (int cellId = 0; cellId <= 4; cellId++) {
                Cell cell = row.createCell(cellId);
                if (cellId == 0) cell.setCellValue(stat.getMainProfile().name());
                if (cellId == 1) cell.setCellValue(stat.getAvgExamScore().get());
                if (cellId == 2) cell.setCellValue(stat.getStudentQuantity().get());
                if (cellId == 3) cell.setCellValue(stat.getUniversityQuantity());
                if (cellId == 4) cell.setCellValue(stat.getUniversitiesList().toString());
                cell.setCellStyle(bodyStyle);
            }
        }


    }
}
