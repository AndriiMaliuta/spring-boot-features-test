package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.models.Building;
import com.anma.bh.sb.springtesting.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Boostrap implements CommandLineRunner {

    private final BuildingRepository buildingRepository;

    @Autowired
    public Boostrap(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    private void loadData() {

        Building building1 = new Building();
        building1.setId(UUID.randomUUID());
        building1.setStreet("Shevchenko");
        building1.setHouseNumber(Short.parseShort("12"));
        building1.setEntrance(Short.parseShort("2"));
        buildingRepository.save(building1);

    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
}
