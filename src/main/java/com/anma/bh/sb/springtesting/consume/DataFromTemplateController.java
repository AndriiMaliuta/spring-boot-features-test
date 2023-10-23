package com.anma.bh.sb.springtesting.consume;

import com.anma.bh.sb.springtesting.core.models.dto.Post;
import com.google.gson.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

//import org.json.JSONObject;

@Controller
public class DataFromTemplateController {

    @GetMapping("/from-url")
    public String getData(Model model) throws IOException, URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

/*        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Post convertedObject = new Gson()
                .fromJson(new BufferedReader(
                        new InputStreamReader(
                                new URL("https://jsonplaceholder.typicode.com/posts/1").openStream())), Post.class);
       System.out.println(convertedObject);
       model.addAttribute("convertedObject", convertedObject);
 */

//        ResponseEntity responseEntity = gson.fromJson("https://jsonplaceholder.typicode.com/posts/1", ResponseEntity.class);
        JsonObject jsonObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JsonObject.class);
        Object responseEntity = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/2", Object.class);
        Post responseEntity2 = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", Post.class);

//        Object  jsonObject = restTemplate.getForEntity("https://swapi.co/api/vehicles/4/", Object.class);
//        JsonObject  jsonObject = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", JsonObject.class);

//        Object[] objects = restTemplate.getForObject("https://swapi.co/api/vehicles", Object[].class);
//        JsonArray jsonArray = (JsonArray) objects.getBody()[0];

        model.addAttribute("responseEntity2", responseEntity2);
        System.out.println(responseEntity);
        System.out.println(responseEntity2);
        System.out.println(jsonObject);

        return "data-from-url";
    }
}
