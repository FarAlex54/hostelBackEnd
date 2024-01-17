package com.example.hostelbackend.repository;


import com.example.hostelbackend.models.Teaching;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeachingRepository extends JpaRepository<Teaching, Integer> {
    @Override
    Optional<Teaching> findById(Integer integer);
}

