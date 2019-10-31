package com.adobe.devcamp.http;
import com.adobe.devcamp.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class WebClient {
    private static final String SERVER = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public WebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUsers(String uri) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        final ResponseEntity<User[]> responseEntity = restTemplate.exchange(SERVER + uri, HttpMethod.GET, httpEntity, User[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    public List<User> getUsersByGender(String uri, String gender) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        final ResponseEntity<User[]> responseEntity = restTemplate.exchange(SERVER + uri + "?gender="+gender, HttpMethod.GET, httpEntity, User[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    private HttpHeaders getHttpHeaders() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
