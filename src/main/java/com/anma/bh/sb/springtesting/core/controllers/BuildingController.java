package com.anma.bh.sb.springtesting.core.controllers;

import com.anma.bh.sb.springtesting.core.models.Building;
import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log
public class BuildingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/building")
    public String getBuildingsPage(Model model) {

        List buildings = jdbcTemplate.query("select * from buildings", new Building[] {}, new ColumnMapRowMapper());
        log.info("**** " + buildings);
        model.addAttribute("buildings", buildings);

        return "building";
    }


}
