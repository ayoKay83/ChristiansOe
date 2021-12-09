package com.example.demo.controllers;

import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LocationController {

    LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @GetMapping("/")
    public List<Location> allLocations() {
        return locationRepository.findAll();
    }
}
