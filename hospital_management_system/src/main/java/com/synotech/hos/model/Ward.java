package com.synotech.hos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ward")
public class Ward {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String ward;

    @JsonIgnore
    @OneToMany(mappedBy = "ward")
    private List<Patient> patients;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id")
    private Location location;

    public Ward() {
    }

    public Ward(Long id, String ward, List<Patient> patients, Location location) {
        this.id = id;
        this.ward = ward;
        this.patients = patients;
        this.location = location;
    }

    public Ward(Long id, String ward, List<Patient> patients) {
        this.id = id;
        this.ward = ward;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "id=" + id +
                ", ward='" + ward + '\'' +
                ", patients=" + patients +
                ", location=" + location +
                '}';
    }
}
