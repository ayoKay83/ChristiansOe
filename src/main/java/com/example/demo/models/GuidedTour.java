package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "guidedtourId")
@Entity
public class GuidedTour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="guidedtour_id")
    private int guidedtourId;

    private String name;
    private LocalDateTime time;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="route_id", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filemanager_id", nullable = false)
    private FileManager fileManager;

    public GuidedTour(){}

    public GuidedTour(int guidedtourId, String name, LocalDateTime time, String description, Route route, FileManager fileManager) {
        this.guidedtourId = guidedtourId;
        this.name = name;
        this.time = time;
        this.description = description;
        this.route = route;
        this.fileManager = fileManager;
    }

    public int getGuidedtourId() {
        return guidedtourId;
    }

    public void setGuidedtourId(int guidedtourId) {
        this.guidedtourId = guidedtourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    //-- metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn --\\
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuidedTour guidedTour = (GuidedTour) o;
        return Objects.equals(name, guidedTour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GuidedTour{" +
                "guidedtourId=" + guidedtourId +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", route=" + route +
                ", fileManager=" + fileManager +
                '}';
    }
}
