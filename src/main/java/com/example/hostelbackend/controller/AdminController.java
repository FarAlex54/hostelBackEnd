package com.example.hostelbackend.controller;


import com.example.hostelbackend.repository.PackageRepository;
import com.example.hostelbackend.repository.PersonRepository;
import com.example.hostelbackend.repository.TeachingRepository;
import com.example.hostelbackend.services.PackageService;
import com.example.hostelbackend.services.PersonService;
import com.example.hostelbackend.services.TeachingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    private final TeachingService teachingService;
    private final TeachingRepository teachingRepository;
    private final PackageRepository packageRepository;
    private final PackageService packageService;
    private final PersonService personService;
    private final PersonRepository personRepository;

    public AdminController(TeachingService teachingService, TeachingRepository teachingRepository, PackageRepository packageRepository, PackageService packageService, PersonService personService, PersonRepository personRepository) {
        this.teachingService = teachingService;
        this.teachingRepository = teachingRepository;
        this.packageRepository = packageRepository;
        this.packageService = packageService;
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("person", personService.getAllPerson());
        model.addAttribute("teaching", teachingService.getAllTeaching());
        model.addAttribute("packages",packageService.getAllPackage());
        return "admin";
    }
    @GetMapping("/admin/person/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/admin";
    }
}