package com.example.hostelbackend.repository;

import com.example.hostelbackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Override
    Optional<Room> findById(Integer integer);
}
