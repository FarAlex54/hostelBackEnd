package com.example.hostelbackend.services;



import com.example.hostelbackend.models.Person;
import com.example.hostelbackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
    public Person findByLogin(Person person){
        Optional<Person> person_db = personRepository.findByLogin(person.getLogin());
        return person_db.orElse(null);
    }

    public Person findByEmail(Person person){
        Optional<Person> person_db = personRepository.findByEmail(person.getEmail());
        return person_db.orElse(null);
    }

    public Person findByPhone(Person person){
        Optional<Person> person_db = personRepository.findByPhone(person.getPhone());
        return person_db.orElse(null);
    }
    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }
}
