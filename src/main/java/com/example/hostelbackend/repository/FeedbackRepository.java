package com.example.hostelbackend.repository;

import com.example.hostelbackend.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Override
    Optional<Feedback> findById(Integer integer);
}
