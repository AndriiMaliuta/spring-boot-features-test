package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.controllers.ExcelController;
import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.props.TestProps;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Component
@PropertySource("classpath:application.properties")
public class Bootstrap implements CommandLineRunner {
    public static final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    private final BuildingRepository buildingRepository;
    private final JdbcTemplate jdbcTemplate;

    @Value("${values.value1}")
    private String value1;

    @Autowired
    public Bootstrap(BuildingRepository buildingRepository, JdbcTemplate jdbcTemplate) {
        this.buildingRepository = buildingRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

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
        LOG.info(ExcelController.class.getClassLoader().getResource("static/files/doc-test-1.docx").getFile().toString());
        //  /home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/files/test

//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/src/main/resources/files/test-excel.xlsx";
//        final String FILE_NAME = "/home/andrii/programming/spring/spring-boot-features-test/target/spring-testing-0.0.2.jar!/BOOT-INF/classes!/static/files/test-excel.xlsx";
        try {
            final String FILE_NAME = "./src/main/resources/static/excel2.xlsx";
            LOG.info(ResourceUtils.getFile("classpath:application.properties").toString());
            FileOutputStream stream = new FileOutputStream(FILE_NAME);
            workbook.write(stream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        Building building = new Building();
        building.setId(UUID.randomUUID());
        building.setEntrance(1);
        building.setHouseNumber(12);
        building.setStreet("Shevchenko");

        LOG.info("*** Building created " + building.toString());

        buildingRepository.save(building);

        Building building2 = new Building();
        building2.setId(UUID.randomUUID());
        building2.setEntrance(2);
        building2.setHouseNumber(34);
        building2.setStreet("Tsentralna");

        LOG.info("*** Building created " + building2.toString());

        buildingRepository.save(building2);

        TestProps testProps = new TestProps();

        LOG.info(">>>>> test Props: " + testProps.getName());
        LOG.info(">>>>> test Props: " + testProps.getAge());
        LOG.info(">>>>> Value1 from Props: " + value1);

//        List<Object[]> batchArgs = new ArrayList<>();
//        batchArgs.add(new Object[] { building3.getId().toString() });
//        batchArgs.add(new Object[] { building3.getStreet() });
//        batchArgs.add(new Object[] { String.valueOf(building3.getHouseNumber()) });
//        batchArgs.add(new Object[] { String.valueOf(building3.getEntrance()) });
//
//        int[] created = jdbcTemplate.batchUpdate("insert into buildings (building_id, street, house_number, entrance) values (?, ?, ?, ?)", batchArgs);
//        LOG.info("***** Created building with JDBC Template " + created.length);

    }
}
