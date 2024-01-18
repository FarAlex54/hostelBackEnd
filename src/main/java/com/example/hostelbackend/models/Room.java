package com.example.hostelbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="category", nullable = false)//описание номера
    @NotEmpty(message = "Категория не может быть пустой")
    private String category;
    @Column(name="description", columnDefinition = "text", nullable = false)//описание номера
    @NotEmpty(message = "Описание не может быть пустым")
    private String description;

    @Column(name="price", nullable = false)//ценна номера за 1 ночь
    @NotEmpty(message = "Должна быть цена за 1 ночь")
    private int price;

    @Column(name="bed", nullable = false)//количество спальных мест
    @NotEmpty(message = "Количество спальных мест")
    private int bed;
    @Column(name="date_time")
    private LocalDateTime dateTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
    private List<Image> imageList = new ArrayList<>();

    public void addImageToRoom(Image image){
        image.setRoom(this);
        imageList.add(image);
    }

    //Метод заполняет поле даты и времени при создании объекта класса
    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Room(String category, String description, int price, int bed, LocalDateTime dateTime, List<Image> imageList) {
        this.category = category;
        this.description = description;
        this.price = price;
        this.bed = bed;
        this.dateTime = dateTime;
        this.imageList = imageList;
    }

    public Room() {
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }


}
