package com.example.hostelbackend.services;

import com.example.hostelbackend.models.Feedback;
import com.example.hostelbackend.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }
    public Feedback getFeedbackId(int id){ //исчпользуем Optional на тот случай если отзывов нету вовсе
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);
        return optionalFeedback.orElse(null);
    }
    public void saveFeedback(Feedback feedback){ //Сохраняем отзыв в базу
        feedbackRepository.save(feedback);
    }
    public void updateFeedback(int id, Feedback feedback){
        feedback.setId(id);
        feedbackRepository.save(feedback);
    }
    public void deleteFeedback(int id){
        feedbackRepository.deleteById(id);
    }
    public void changeFeedback(int id, Feedback feedback){ //метод нужен для изменения статуса отзыва чтобы отображался во фронте
        String activity = "true";
        feedback.setId(id);
        if (feedback.getAproove().equals("true")){
            feedback.setAproove("false");
        } else {
            feedback.setAproove("true");
        }
        feedbackRepository.save(feedback);
    }
}
