package com.example.hostelbackend.repository;


import com.example.hostelbackend.models.PackageCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepository extends JpaRepository<PackageCompany, Integer> {
    @Override
    Optional<PackageCompany> findById(Integer integer);
}
