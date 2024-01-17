package com.example.hostelbackend.services;


import com.example.hostelbackend.models.Teaching;
import com.example.hostelbackend.repository.TeachingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class TeachingService{
    public TeachingService(TeachingRepository teachingRepository) {
        this.teachingRepository = teachingRepository;
    }
    private final TeachingRepository teachingRepository;

    //получаем списко всех статей
    public List<Teaching> getAllTeaching(){
        return teachingRepository.findAll();
    }

    //для вывода статей или редактирования конкретной статьи
    public Teaching getTeachingId(int id){
        Optional<Teaching> optionalTeaching = teachingRepository.findById(id);
        return optionalTeaching.orElse(null);
    }

    public void saveTeaching(Teaching teaching){
        teachingRepository.save(teaching);
    }

    public void updateTeaching(int id, Teaching teaching){
        teaching.setId(id);
        teachingRepository.save(teaching);
    }

    public void deleteTeaching(int id){
        teachingRepository.deleteById(id);
    }
}
