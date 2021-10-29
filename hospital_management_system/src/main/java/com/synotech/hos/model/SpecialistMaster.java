package com.synotech.hos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialist_master")
public class SpecialistMaster {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "specialist")
    @JsonIgnore
    private List<Doctor> doctors;

    public SpecialistMaster(Long id, String name, List<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
    }

    public SpecialistMaster(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public SpecialistMaster(Long id) {
        this.id = id;
    }

    public SpecialistMaster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "SpecialistMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
