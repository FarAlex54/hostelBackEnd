package com.example.hostelbackend.controller;


import com.example.hostelbackend.models.Teaching;
import com.example.hostelbackend.repository.TeachingRepository;
import com.example.hostelbackend.services.TeachingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeachingController {
    private final TeachingService teachingService;

    private final TeachingRepository teachingRepository;

    public TeachingController(TeachingService teachingService, TeachingRepository teachingRepository) {
        this.teachingService = teachingService;
        this.teachingRepository = teachingRepository;
    }

    @GetMapping("/admin/teaching/add")
    public String addTeaching(Model model){
        model.addAttribute("teaching",new Teaching());
        return "Teaching/addTeaching";
    }

    @PostMapping("/admin/teaching/add")
    public String addTeaching(@ModelAttribute("teaching") @Valid Teaching teaching, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка");
            return "addTeaching";
        }
        teachingService.saveTeaching(teaching);
        return "redirect:/admin";
    }
    @GetMapping("/admin/teaching/delete/{id}")
    public String deleteTeaching(@PathVariable("id") int id){
        teachingService.deleteTeaching(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/teaching/edit/{id}")//Метод получения данных для метода редактирования
    public String editTeaching(Model model, @PathVariable("id") int id){
        model.addAttribute("teaching", teachingService.getTeachingId(id));
        return "Teaching/editTeaching";
    }
    @PostMapping("/admin/teaching/edit/{id}")//Метод редактирования объекта со статьей по id
    public String editTeaching(@ModelAttribute("teaching") @Valid Teaching teaching, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка при редактировании статьи");
            return "editTeaching";
        }
        teachingService.updateTeaching(id, teaching);
        return "redirect:/admin";
    }

}
