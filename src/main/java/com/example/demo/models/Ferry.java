package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Ferry {

    @Id
    @GeneratedValue
    private int id;

    private int departureTimeInterval;
    private LocalDateTime islandTime;

    public Ferry(){}

    }







