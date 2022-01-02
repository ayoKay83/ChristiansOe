package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String renderMap(){
        return "index.html";
    }

    @GetMapping("/nature")
    public String renderNature(){
        return "nature.html";
    }

    @GetMapping("/guidedtour")
    public String renderGuidedTour(){
        return "guidedtour.html";
    }
}
