package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "natureId")
@Entity
public class Nature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nature_id")
    private int natureId;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "natures")
    private List<Location> locations;

    public Nature(){}

    public Nature(int natureId, String name, String description, List<Location> locations) {
        this.natureId = natureId;
        this.name = name;
        this.description = description;
        this.locations = locations;
    }

    public int getNatureId() {
        return natureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nature nature = (Nature) o;
        return Objects.equals(name, nature.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Nature{" +
                "natureId=" + natureId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", locations=" + locations +
                '}';
    }
}
