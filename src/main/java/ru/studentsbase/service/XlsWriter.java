package ru.studentsbase.service;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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
    private static CellStyle dataFormat;
    private static List<Object> stats = new ArrayList<>();
    private static final String[] HEADERS = {"Основной профиль", "Средний балл", "Количество студентов", "Количество университетов", "Название университета"};

    public static boolean writeStats(List<Statistics> list, String filepath) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            //Устанавливаем стили заголовковка
            headerStyle = workbook.createCellStyle();
            bodyStyle = workbook.createCellStyle();
            dataFormat = workbook.createCellStyle();
            setBorders(workbook, headerStyle, bodyStyle, dataFormat);
            setFont(workbook, "Calibri", true, headerStyle);
            setFont(workbook, "Calibri", false, bodyStyle, dataFormat);
            //Отдельный стиль для средних баллов, чтобы было два знака после запятой
            setDataCellFormat(workbook, dataFormat);
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

    private static void setBorders(XSSFWorkbook workbook, CellStyle... styles) {
        for (CellStyle style : styles) {
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
        }
    }

    private static void setFont(XSSFWorkbook workbook, String font, boolean bold, CellStyle... styles) {
        for (CellStyle style : styles) {
            Font f = workbook.createFont();
            f.setFontName(font);
            if (bold) f.setBold(true);
            style.setFont(f);
        }
    }


    private static void setDataCellFormat(XSSFWorkbook workbook, CellStyle... styles) {
        for (CellStyle style : styles) {
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        }
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
                if (cellId == 1) {
                    cell.setCellValue(stat.getAvgExamScore().get());
                    //Второму столбцу присваеваем свой стиль
                    cell.setCellStyle(dataFormat);
                }
                if (cellId == 2) cell.setCellValue(stat.getStudentQuantity().get());
                if (cellId == 3) cell.setCellValue(stat.getUniversityQuantity());
                if (cellId == 4) cell.setCellValue(stat.getUniversitiesList().toString());
                //Всем, кроме второго столбца, ставим стиль
                if (cellId != 1) cell.setCellStyle(bodyStyle);
            }
        }


    }
}
