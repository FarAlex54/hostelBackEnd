package com.example.hostelbackend.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="feedback")
public class Feedback {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id; // порядковый номер
    @Column(name="date_in")
    private String dateIncome; // дата добавления пользователя
    @Column(name="description")
    private String Description; // текст отзыва
    @Column(name="owner")
    private String Owner; //Имя пользователя владельца отзыва
    @Column(name="aproove")
    private String aproove; //флаг видимости на странице
    @Column(name="stars")
    private String stars; //количество звезд

    @Column(name="date_time")
    private LocalDateTime dateTime;

    public Feedback(String dateIncome, String description, String owner, String aproove, String stars, LocalDateTime dateTime) {
        this.dateIncome = dateIncome;
        Description = description;
        Owner = owner;
        this.aproove = aproove;
        this.stars = stars;
        this.dateTime = dateTime;
    }

    public Feedback() {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateIncome() {
        return dateIncome;
    }

    public void setDateIncome(String dateIncome) {
        this.dateIncome = dateIncome;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getAproove() {
        return aproove;
    }

    public void setAproove(String aproove) {
        this.aproove = aproove;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
