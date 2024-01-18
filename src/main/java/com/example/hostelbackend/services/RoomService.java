package com.example.hostelbackend.services;

import com.example.hostelbackend.models.Room;
import com.example.hostelbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public List<Room> getAllRoom(){
        return roomRepository.findAll();
    }
    public Room getRoomId(int id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElse(null);
    }
    public void saveRoom(Room room){
        roomRepository.save(room);
    }
    public void updateRoom(int id, Room room){
        room.setId(id);
        roomRepository.save(room);
    }

    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }
}
