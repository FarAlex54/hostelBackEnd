package com.example.hostelbackend.controller;


import com.example.hostelbackend.models.Person;
import com.example.hostelbackend.services.PersonService;
import com.example.hostelbackend.util.PersonValidator;
import jakarta.validation.Valid;
import com.example.hostelbackend.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final PersonValidator personValidator;
    private final PersonService personService;


    public MainController(PersonValidator personValidator, PersonService personService) {
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping("/index")
    public String index(){
        // Получаем обьект аутентификации -> спомощью SpringContextHolder обращаемся к контексту и на нем вызываем метод
        //аутентификации. Из сессии текущего пользователя получаем обьект, который был положен в данную сессию после
        //аутентификации пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        System.out.println(personDetails.getPerson());
//        System.out.println("ID пользователя: " + personDetails.getPerson().getId());
//        System.out.println("login пользователя: " + personDetails.getPerson().getLogin());
//        System.out.println("Password пользователя: " + personDetails.getPerson().getPassword());
//        System.out.println("Имя пользователя: " + personDetails.getPerson().getName());
//        System.out.println("Email пользователя: " + personDetails.getPerson().getEmail());
//        System.out.println("Роль пользователя: " + personDetails.getPerson().getRole());
        String role = personDetails.getPerson().getRole();
        if (role.equals("ROLE_ADMIN")){return "redirect:/admin";}
        return "index";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("person") Person person){
        return "registration";
    }

    @PostMapping("/registration")
    public String resultRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }
        personService.register(person);
        return "redirect:/index";
    }

}