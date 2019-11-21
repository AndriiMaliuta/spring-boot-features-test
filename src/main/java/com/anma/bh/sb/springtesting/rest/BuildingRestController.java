package com.anma.bh.sb.springtesting.rest;

import com.anma.bh.sb.springtesting.models.Building;
import com.anma.bh.sb.springtesting.repositories.BuildingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(BuildingRestController.BASE_URL)
public class BuildingRestController {

    static final String BASE_URL = "/rest/api/v1/buildings";

    private final BuildingRepository buildingRepository;

    public BuildingRestController(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Building> getAllBuildings() {

        return buildingRepository.findAll();
    }

    @GetMapping("{building_id}")
    @ResponseStatus(HttpStatus.OK)
    public Building getBuilding(@PathVariable UUID building_id) {

        return buildingRepository.findById(building_id).get();
    }
}
