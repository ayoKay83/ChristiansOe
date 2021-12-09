package com.example.demo.repositories;

import com.example.demo.models.Attraction;
import com.example.demo.models.GuidedTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidedTourRepository extends JpaRepository<GuidedTour, Integer> {
}
