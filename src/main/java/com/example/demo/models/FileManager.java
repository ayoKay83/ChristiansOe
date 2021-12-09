package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class FileManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String data;

    private LocalDateTime timestamp;

    @OneToMany
    private List<GuidedTour> guidedTours;

    public FileManager(){}

    public FileManager(int id, String name, String data, LocalDateTime timestamp, List<GuidedTour> guidedTours) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.timestamp = timestamp;
        this.guidedTours = guidedTours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    //-- metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn --\\
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileManager fileManager = (FileManager) o;
        return Objects.equals(name, fileManager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FileManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                ", guidedTours=" + guidedTours +
                '}';
    }
}

