package com.anma.bh.sb.springtesting.core.rest;

import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/paged")
    public Page<Building> getAllPosts(Pageable pageable) {
        return buildingRepository.findAll(pageable);
    }

    @GetMapping("{buildingId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Building> getBuilding(@PathVariable UUID buildingId) {

        return ResponseEntity.ok().body(buildingRepository.findById(buildingId).get());
    }
}
