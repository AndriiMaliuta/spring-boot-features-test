package com.anma.bh.sb.springtesting.controllers;

import com.google.gson.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

//import org.json.JSONObject;

@Controller
public class DataFromTemplateController {

    @GetMapping("/from-url")
    public String getData(Model model) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        GsonBuilder builder = new GsonBuilder();

        builder.setPrettyPrinting();

        Gson gson = builder.create();

//        JsonObject jsonObject = new JsonParser().parse("{\"name\" : \" Andrii\"}").getAsJsonObject();

//        JsonObject convertedObject = new Gson().fromJson("https://jsonplaceholder.typicode.com/posts/", JsonObject.class);

//        JsonObject jsonObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JsonObject.class);
//        JsonObject responseEntity = gson.fromJson("https://jsonplaceholder.typicode.com/posts/1", ResponseEntity.class);

//        Object  jsonObject = restTemplate.getForEntity("https://swapi.co/api/vehicles/4/", Object.class);
//        JsonObject  jsonObject = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", JsonObject.class);

        ResponseEntity<Object[]> objects = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", Object[].class);
//        Object[] objects = restTemplate.getForObject("https://swapi.co/api/vehicles", Object[].class);

        JsonArray jsonArray = (JsonArray) objects.getBody()[0];

//        model.addAttribute("jsonObject", jsonObject);
        model.addAttribute("jsonObject", jsonArray);

//        System.out.println(jsonObject);
        System.out.println(jsonArray);
//        System.out.println(convertedObject.toString());








        return "data-from-url";
    }
}
