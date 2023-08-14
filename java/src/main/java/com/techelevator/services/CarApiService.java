package com.techelevator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class CarApiService {
    private final String API_BASE_URL = "https://carapi.app/api/";

    private final RestTemplate restTemplate;

    public CarApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getMakes() {
        String url = API_BASE_URL + "makes";
        ResponseEntity<String[]> response = restTemplate.getForEntity(url, String[].class);
        return Arrays.asList(response.getBody());
    }

    public List<String> getModelsByMake(String make) {
        String url = API_BASE_URL + "models/" + make;
        ResponseEntity<String[]> response = restTemplate.getForEntity(url, String[].class);
        return Arrays.asList(response.getBody());
    }
}

