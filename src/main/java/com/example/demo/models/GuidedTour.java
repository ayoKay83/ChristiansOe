package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class GuidedTour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private LocalDateTime time; //mener vi længde?
    private String description;


}

//-  id : int
//- name : String
//- time : LocalDateTime
//- route : Route
//- description : String
//- fileList : List <File>