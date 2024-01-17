package com.example.hostelbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="packages")
public class PackageCompany {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="pointOne")
    private String pointOne;
    @Column(name="pointTwo")
    private String pointTwo;
    @Column(name="pointThree")
    private String pointThree;
    @Column(name="pointFour")
    private String pointFour;
    @Column(name="pointFive")
    private String pointFive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPointOne() {
        return pointOne;
    }

    public void setPointOne(String pointOne) {
        this.pointOne = pointOne;
    }

    public String getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(String pointTwo) {
        this.pointTwo = pointTwo;
    }

    public String getPointThree() {
        return pointThree;
    }

    public void setPointThree(String pointThree) {
        this.pointThree = pointThree;
    }

    public String getPointFour() {
        return pointFour;
    }

    public void setPointFour(String pointFour) {
        this.pointFour = pointFour;
    }

    public String getPointFive() {
        return pointFive;
    }

    public void setPointFive(String pointFive) {
        this.pointFive = pointFive;
    }
}
