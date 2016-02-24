package com.nclab.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    private long id;
    private String mark;
    private String model;
    private String color;
    private Owner owner;

    public Car(){}

    public Car(String mark, String model, String color, Owner owner){
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.owner = owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
