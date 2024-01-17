package com.example.hostelbackend.security;


import com.example.hostelbackend.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    public Person getPerson(){
        return this.person;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {//Метод проверки на Аккаунт активный
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//Метод проверки на Аккаунт не заблочен
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//Метод проверки на действиетольнность пароля
        return true;
    }

    @Override
    public boolean isEnabled() {//Метод проверки на  активный аккаунт
        return true;
    }
}
