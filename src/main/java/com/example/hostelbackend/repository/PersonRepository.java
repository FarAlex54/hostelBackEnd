package com.example.hostelbackend.repository;


import com.example.hostelbackend.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByLogin(String login);
    Optional<Person> findByEmail(String email);
    Optional<Person> findByPhone(String phone);
    Optional<Person> findById(int id);
}