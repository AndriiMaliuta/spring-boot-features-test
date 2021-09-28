package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.controllers.ExcelController;
import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.props.TestProps;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import lombok.extern.java.Log;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Log
@PropertySource("classpath:application.properties")
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private BuildingRepository buildingRepository;

    @Value("${values.value1}")
    private String value1;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        loadData();
//        createFiles();
    }

    private void createFiles() {
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
        log.info(ExcelController.class.getClassLoader().getResource("static/files/doc-test-1.docx").getFile().toString());
        //  /home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/files/test

//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/src/main/resources/files/test-excel.xlsx";
//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/static/files/test-excel.xlsx";
        try {
            final String FILE_NAME = "./src/main/resources/static/excel2.xlsx";
            log.info(ResourceUtils.getFile("classpath:application.properties").toString());
            FileOutputStream stream = new FileOutputStream(FILE_NAME);
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        Building building1 = Building.builder()
                .id(UUID.randomUUID())
                .entrance(1)
                .houseNumber(12)
                .street("Shevchenko")
                .build();
        log.info("*** Building created " + building1.toString());
        buildingRepository.save(building1);

        Building building2 = Building.builder()
                .id(UUID.randomUUID())
                .entrance(2)
                .houseNumber(34)
                .street("Tsentralna")
                .build();
        log.info("*** Building created " + building2.toString());
        buildingRepository.save(building2);

        Building building3 = Building.builder()
                .id(UUID.randomUUID())
                .entrance(3)
                .houseNumber(12)
                .street("Lisova")
                .build();
        log.info("*** Building created " + building3.toString());
        buildingRepository.save(building3);

        TestProps testProps = new TestProps();

        log.info(">>>>> test Props: " + testProps.getName());
        log.info(">>>>> test Props: " + testProps.getAge());
        log.info(">>>>> Value1 from Props: " + value1);
//        List<Object[]> batchArgs = new ArrayList<>();
//        batchArgs.add(new Object[] { building3.getId().toString() });
//        batchArgs.add(new Object[] { building3.getStreet() });
//        batchArgs.add(new Object[] { String.valueOf(building3.getHouseNumber()) });
//        batchArgs.add(new Object[] { String.valueOf(building3.getEntrance()) });
//
//        int[] created = jdbcTemplate.batchUpdate("insert into buildings (building_id, street, house_number, entrance) values (?, ?, ?, ?)", batchArgs);
//        log.info("***** Created building with JDBC Template " + created.length);

    }
}
