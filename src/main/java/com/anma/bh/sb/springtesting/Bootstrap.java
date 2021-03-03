package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.props.TestProps;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
                .houseNumber(21)
                .street("Lisova")
                .build();

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
