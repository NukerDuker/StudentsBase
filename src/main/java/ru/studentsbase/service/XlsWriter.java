package ru.studentsbase.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.studentsbase.model.Statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsWriter {
    private static List<Object> stats = new ArrayList<>();
    private static final String[] HEADERS = {"mainProfile", "avgExemScore", "StudentQuantity", "universityQuantity", "universityFullName"};

    public static boolean writeStats(List<Statistics> list, String filepath) {

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(new File(filepath));
            //Устанавливаем стили заголовковка
            setHeaderCellStyle(workbook);
            //Создаем страницу
            XSSFSheet sheet = workbook.createSheet("Статистика");
            //Устанавливаем заголовки столбцов
            XSSFRow row = sheet.createRow(0);
            fillHeaders(row);
            fillTableBody(sheet, list);
            //Пишем таблицу в файл:
            FileOutputStream fos = new FileOutputStream(new File(filepath));
            workbook.write(fos);
            return true;

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void setHeaderCellStyle (XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        font.setBold(true);
    }

    private static void fillHeaders(XSSFRow row) {
        for (String header : HEADERS) {
            int cellId = 0;
            Cell cell = row.createCell(cellId++);
            cell.setCellValue(header);
        }
    }

    private static void fillTableBody(XSSFSheet sheet, List<Statistics> list) {
        int rowId = 1;
        for (Statistics stat : list) {
            XSSFRow row = sheet.createRow(rowId++);
            for (int cellId = 0; cellId <= 4; cellId++) {
                Cell cell = row.createCell(cellId);
                if (cellId == 0) cell.setCellValue(stat.getMainProfile());
                if (cellId == 1) cell.setCellValue(stat.getAvgExamScore());
                if (cellId == 2) cell.setCellValue(stat.getStudentQuantity());
                if (cellId == 3) cell.setCellValue(stat.getUniversityQuantity());
                if (cellId == 4) cell.setCellValue(stat.getUniversityFullName());
            }
        }


    }
}
