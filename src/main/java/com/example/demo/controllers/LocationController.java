package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
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
    @GetMapping("/{id}")
    public Location locationById(@PathVariable int id){
        return locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location with id: " + id + " not found"));
    }
}
