package com.example.hostelbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthenticationController {
    @GetMapping("/authentication")
    public String login(){
        return "authentication";
    }
}