package com.anma.bh.sb.springtesting.core.controllers;

import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
@Log
public class BuildingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/building")
    public String getBuildingsPage(Model model) {

        Pageable buildingPageable = PageRequest.of(1,10);


        List<Map<String, Object>> buildings = jdbcTemplate.query("select * from buildings", new Building[] {}, new ColumnMapRowMapper());
        log.info("**** " + buildings);
        model.addAttribute("buildings", buildings);

        return "building";
    }


}
