package com.example.hostelbackend.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="users")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не должен быть пустым")
    @Size(min=3, max=100, message = "Логин долженбыть от 3 до 100 символов")
    @Column(name = "login")
    private String login;
    @NotEmpty(message = "Пароль не должен быть пустым")
    @Size(min=3, max=100, message = "Пароль долженбыть от 3 до 100 символов")
    @Column(name = "pass")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "phone")
    private String phone;
    @Column(name="date_time")
    private LocalDateTime dateTime;

    public Person(String login, String password, String name, String email, String role, String phone, LocalDateTime dateTime) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.dateTime = dateTime;
    }

    public Person() {
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(login, person.login) && Objects.equals(password, person.password) && Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(role, person.role) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, email, role, phone);
    }
}
