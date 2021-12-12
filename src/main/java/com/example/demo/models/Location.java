package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "locationId")
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    private String name;
    private String description;
    private double xpos;
    private double ypos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "location_attraction",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id"))
    private List<Attraction> attractions;

    @OneToMany(mappedBy = "location", cascade=CascadeType.ALL)
    private List<Quiz> quiz;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "location_route",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;


    public Location() {
    }

    public Location(int locationId, String name, String description, double xpos, double ypos) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public Location(int locationId, String name, String description, double xpos, double ypos, List<Attraction> attractions, List<Quiz> quiz, List<Route> routes) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.xpos = xpos;
        this.ypos = ypos;
        this.attractions = attractions;
        this.quiz = quiz;
        this.routes = routes;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getXpos() {
        return xpos;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    //metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", name='" + name + '\'' +
                ", xpos=" + xpos +
                ", ypos=" + ypos +
                ", attractions=" + attractions +
                ", quiz=" + quiz +
                ", routes=" + routes +
                '}';
    }
}