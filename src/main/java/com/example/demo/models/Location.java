package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double xpos;
    private double ypos;

    @ManyToMany (mappedBy = "location")
    private List<Attraction> attractions;

    @OneToMany (mappedBy = "location")
    private List <Quiz> quiz;




}

//-  id : int
//- name : String
//- xpos : double
//- ypos : double
//- quiz : Quiz