package com.anma.bh.sb.springtesting.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Controller
public class DataFromTemplateController {

    public String getData(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        JsonObject  jsonObject = restTemplate.getForObject("https://swapi.co/api/vehicles/4/", JsonObject.class);

        model.addAttribute("jsonObject", jsonObject);

        return "data-from-url";
    }
}
