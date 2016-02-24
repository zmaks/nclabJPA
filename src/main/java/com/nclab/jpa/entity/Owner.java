package com.nclab.jpa.entity;


import javax.persistence.*;

@Entity
@Table(name="owner")
public class Owner {
    private long id;
    private String fname;
    private String lname;

    public Owner(){};

    public Owner(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
