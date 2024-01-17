package com.example.hostelbackend.util;


import com.example.hostelbackend.models.Person;
import com.example.hostelbackend.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personService.findByLogin(person)!=null){
            errors.rejectValue("login","", "Данный логин уже зарегистрирован");
        }
        if(personService.findByEmail(person)!=null){
            errors.rejectValue("email","","Пользователь с таким email уже зарегистрирован");
        }
        if(personService.findByPhone(person)!=null){
            errors.rejectValue("phone","","Номер телефона уже использует зарегистрированый пользователь");
        }
    }
}