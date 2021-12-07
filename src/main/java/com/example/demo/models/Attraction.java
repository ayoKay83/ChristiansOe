package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Attraction {

    @Id
    private int id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "attraction")
    @JsonBackReference
    private List<Location> locations;
}
