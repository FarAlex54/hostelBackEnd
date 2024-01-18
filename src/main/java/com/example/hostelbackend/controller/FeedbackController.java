package com.example.hostelbackend.controller;

import com.example.hostelbackend.models.Feedback;
import com.example.hostelbackend.models.PackageCompany;
import com.example.hostelbackend.repository.FeedbackRepository;
import com.example.hostelbackend.services.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/feedback")
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackRepository feedbackRepository, FeedbackService feedbackService) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/add")
    public String addFeedback(Model model){
        model.addAttribute("feedbacks",new Feedback());
        return "Feedbacks/addFeedback";
    }
    @PostMapping("/add")
    public String addFeedback(@ModelAttribute("feedbacks") @Valid Feedback feedback, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка в контроллере с отзывами при добавлении");
            return "Feedbacks/addFeedback";
        }
        feedbackService.saveFeedback(feedback);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable("id") int id){
        feedbackService.deleteFeedback(id);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editFeedback(@PathVariable("id") int id){ // для обычного изменения поля активного отзыва
        feedbackService.changeFeedback(id,feedbackService.getFeedbackId(id));
        return "redirect:/admin";
    }

}
