package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "routeId")
@Entity
public class Route {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="route_id")
    private int routeId;

    private String name;
    private double length;

    @ManyToMany(mappedBy = "routes")
    private List<Location> locationsOnRoute;

    @OneToMany(mappedBy = "route")
    private List<GuidedTour> guidedTours;

    public Route(){}

    public Route(int routeId, String name, double length, List<Location> locationsOnRoute, List<GuidedTour> guidedTours) {
        this.routeId = routeId;
        this.name = name;
        this.length = length;
        this.locationsOnRoute = locationsOnRoute;
        this.guidedTours = guidedTours;
    }

    public int getRouteId() {
        return routeId;
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
    //metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(name, route.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", locationsOnRoute=" + locationsOnRoute +
                ", guidedTours=" + guidedTours +
                '}';
    }
}

