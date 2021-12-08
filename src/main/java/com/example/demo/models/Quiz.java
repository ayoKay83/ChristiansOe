package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "quizId")
@Entity
public class Quiz {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int quizId;

    private String name;

    @ElementCollection
    private List<String> questions;

    @ElementCollection
    private Map <Integer, String> answers;

    @ElementCollection
    private Map<Integer, String> userAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id", nullable = false)
    @JsonBackReference
    private Location location;

    public Quiz(){}

    public Quiz(int quizId, String name, List<String> questions, Map<Integer, String> answers, Map<Integer, String> userAnswers, Location location) {
        this.quizId = quizId;
        this.name = name;
        this.questions = questions;
        this.answers = answers;
        this.userAnswers = userAnswers;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public Map<Integer, String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Map<Integer, String> userAnswers) {
        this.userAnswers = userAnswers;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    //metode der kan tjekke om 2 objekter er ens, og som pt tjekker på navn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(name, quiz.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                ", answers=" + answers +
                ", userAnswers=" + userAnswers +
                ", location=" + location +
                '}';
    }
}

