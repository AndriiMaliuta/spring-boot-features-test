package com.anma.bh.sb.springtesting.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@Slf4j
public class ExcelController {

    @GetMapping("/excel")
    public String getExcelPage(Model model) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("test");
        Row firstRow = sheet.createRow(0);
        Cell cell1 = firstRow.createCell(0);
        cell1.setCellValue("ID");
        Cell cell2 = firstRow.createCell(1);
        cell2.setCellValue("Name");
        Cell cell3 = firstRow.createCell(2);
        cell3.setCellValue("Age");
        Cell cell4 = firstRow.createCell(3);
        cell4.setCellValue("Color");

        for (int i = 1; i <= 3; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 4; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("TEST");
            }
        }
        log.info(ExcelController.class.getClassLoader().getResource("static/files/doc-test-1.docx").toString());
        //  /home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/files/test

//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/src/main/resources/files/test-excel.xlsx";
//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/static/files/test-excel.xlsx";
        final String FILE_NAME = "/test-excel.xlsx";
        try {
            FileOutputStream stream = new FileOutputStream(FILE_NAME);
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("fileName", FILE_NAME);

        return "excel";
    }
}
