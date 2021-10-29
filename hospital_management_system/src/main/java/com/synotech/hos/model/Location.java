package com.synotech.hos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(nullable = true, length = 20)
    private String Name;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<User> user = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Patient> patients = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Ward> wards = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Doctor> doctors = new ArrayList<>();
    public Location(int id, String name, List<User> user) {
        this.id = id;
        Name = name;
        this.user = user;
    }

    public Location(int id, String name, List<User> user, List<Doctor> doctors) {
        this.id = id;
        Name = name;
        this.user = user;
        this.doctors = doctors;
    }

    public Location(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Location(int id) {
        this.id = id;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", user=" + user +
                ", doctors=" + doctors +
                '}';
    }
}
