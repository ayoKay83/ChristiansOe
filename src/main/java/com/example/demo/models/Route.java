package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Route {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double length;

    @ManyToMany(mappedBy = "route")
    private List<Location> locationsOnRoute;

    public Route(){}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public List<Location> getLocationsOnRoute() {
        return locationsOnRoute;
    }

    public void setLocationsOnRoute(List<Location> locationsOnRoute) {
        this.locationsOnRoute = locationsOnRoute;
    }
}

