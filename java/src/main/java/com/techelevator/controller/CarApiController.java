package com.techelevator.controller;

import com.techelevator.services.CarApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CarApiController {
    private final CarApiService carApiService;

    public CarApiController(CarApiService carApiService) {
        this.carApiService = carApiService;
    }

    @GetMapping("/makes")
    public List<String> getMakes() {
        return carApiService.getMakes();
    }

    @GetMapping("/models")
    public List<String> getModelsByMake(@RequestParam String make) {
        return carApiService.getModelsByMake(make);
    }
}