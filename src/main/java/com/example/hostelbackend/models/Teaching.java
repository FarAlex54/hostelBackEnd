package com.example.hostelbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="articles")
public class Teaching{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(name="head")
    private String Head;

    @Column(name="description")
    private String Description;
}