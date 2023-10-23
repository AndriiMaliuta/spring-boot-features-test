package com.anma.bh.sb.springtesting.core.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;

@RestController
public class RestTemplateExe {

    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    @GetMapping("/rest/http")
    public String testRestTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json"));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://example.com", HttpMethod.GET, requestEntity, String.class);

        return response.getBody();
    }

    @GetMapping("/graph/hasura/1")
    public ResponseEntity<String> getHasuraGraphqlData() throws IOException, InterruptedException {

       /* HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json"));
        headers.add("x-hasura-admin-secret", "MMvQhb2HBguozrfCIjTFhkXxoMscm4yQPAE4aNSYmWw9i62kxYUbuPlJit0n58hc");
        RequestEntity<String> request =
                new RequestEntity<>("{dogs_by_pk(id: \"42600792-6066-44bd-87f0-e8871fed472d\") {id, name, born}}",
                        HttpMethod.POST,
                        URI.create("https://hostman-1.hasura.app/v1/graphql"));
        Dog tuzik = restTemplate.postForObject("https://hostman-1.hasura.app/v1/graphql", request, Dog.class);*/

        String requestBody = "{\"query\": \"{dogs_by_pk(id: \"42600792-6066-44bd-87f0-e8871fed472d\") {id, name, born}}\"}";
        String requestBody2 = " { \"query\": \"{dogs_by_pk(id: \"42600792-6066-44bd-87f0-e8871fed472d\") {id, name, born}}\"\n" +
                "}";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String dogJson = gson.toJson(requestBody);

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create("https://hostman-1.hasura.app/v1/graphql"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("x-hasura-admin-secret", "MMvQhb2HBguozrfCIjTFhkXxoMscm4yQPAE4aNSYmWw9i62kxYUbuPlJit0n58hc")
                .POST(java.net.http.HttpRequest.BodyPublishers
                        .ofString(requestBody2))
                .build();

        java.net.http.HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(dogJson);
        System.out.println(requestBody2);
        System.out.println(">>>> dog is " + response);

        return ResponseEntity.ok(response.body());
    }
}

class Dog {
    String name;
    String age;

    @Override
    public String toString() {
        return "{ name: " + name + " , age: " + age + "}";
    }
}
