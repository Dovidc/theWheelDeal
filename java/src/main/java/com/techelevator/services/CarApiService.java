package com.techelevator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class CarApiService {
    private final String API_BASE_URL = "https://carapi.app/api/";

    private final String API_BASE_URL_FOR_MODELS = "https://api.api-ninjas.com/v1/cars?make=";

    private final String API_URL_LIMIT = "&limit=100";

    private static final String API_KEY = System.getenv("API_KEY");

    private static final String JWT_TOKEN = System.getenv("JWT_TOKEN");
    private final RestTemplate restTemplate;

    public CarApiService() {
        this.restTemplate = new RestTemplate();
    }
//build an object that holds a list of makes
    public List<String> getMakes() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + JWT_TOKEN);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url = API_BASE_URL + "makes";
        ResponseEntity<String[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, String[].class);

        return Arrays.asList(response.getBody());
    }

    public List<String> getModelsByMake(String make) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", API_KEY);
        String url = API_BASE_URL_FOR_MODELS + make + API_URL_LIMIT;
        ResponseEntity<String[]> response = restTemplate.getForEntity(url, String[].class);
        return Arrays.asList(response.getBody());
    }
}



