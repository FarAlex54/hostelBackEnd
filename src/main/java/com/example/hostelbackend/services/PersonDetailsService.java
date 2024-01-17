package com.example.hostelbackend.services;

import com.example.hostelbackend.models.Person;
import com.example.hostelbackend.repository.PersonRepository;
import com.example.hostelbackend.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //получаем пользователя из таблицы по логину c формы аутентификации
        Optional<Person> person = personRepository.findByLogin(username);
        //Если полльзователь не был найден
        if(person.isEmpty()){
            //Выбрасываем исключение что данный пользователь не найден
            //Это исключение поймает SpringSecurity и выведет сообщением на страницу
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new PersonDetails(person.get());
    }
}
