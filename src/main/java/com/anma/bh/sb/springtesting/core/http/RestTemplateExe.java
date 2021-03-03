package com.anma.bh.sb.springtesting.core.http;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
