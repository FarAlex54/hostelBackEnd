package com.example.hostelbackend.controller;


import com.example.hostelbackend.repository.FeedbackRepository;
import com.example.hostelbackend.repository.PackageRepository;
import com.example.hostelbackend.repository.PersonRepository;
import com.example.hostelbackend.repository.RoomRepository;
import com.example.hostelbackend.services.FeedbackService;
import com.example.hostelbackend.services.PackageService;
import com.example.hostelbackend.services.PersonService;
import com.example.hostelbackend.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    private final PackageRepository packageRepository;
    private final PackageService packageService;
    private final PersonService personService;
    private final PersonRepository personRepository;
    private final RoomService roomService;
    private final RoomRepository roomRepository;
    private final FeedbackService feedbackService;
    private final FeedbackRepository feedbackRepository;

    public AdminController(PackageRepository packageRepository, PackageService packageService, PersonService personService, PersonRepository personRepository, RoomService roomService, RoomRepository roomRepository, FeedbackService feedbackService, FeedbackRepository feedbackRepository) {
        this.packageRepository = packageRepository;
        this.packageService = packageService;
        this.personService = personService;
        this.personRepository = personRepository;
        this.roomService = roomService;
        this.roomRepository = roomRepository;
        this.feedbackService = feedbackService;
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("person", personService.getAllPerson());
        model.addAttribute("packages",packageService.getAllPackage());
        model.addAttribute("rooms",roomService.getAllRoom());
        model.addAttribute("feedbacks",feedbackService.getAllFeedback());
        return "admin";
    }
    @GetMapping("/admin/person/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/admin";
    }
}