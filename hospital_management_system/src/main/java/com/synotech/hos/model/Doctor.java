package com.synotech.hos.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String dob;

    @Column(nullable = false, length = 20)
    private String  phone;

    @Column(nullable = false, length = 20)
    private String address;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = false, length = 20)
    private String nic;

    @ManyToMany
    @JoinTable(
            name = "doctor_specialist",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialist_id")
    )
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<SpecialistMaster> specialist;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private Location location;

    public Doctor(Long id, String firstName, String lastName, String dob, String phone, String address, String email, List<SpecialistMaster> specialist) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.specialist = specialist;
    }

    public Doctor(Long id, String firstName, String lastName, String dob, String phone, String address, String email, String nic, List<SpecialistMaster> specialist, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.nic = nic;
        this.specialist = specialist;
        this.location = location;
    }

    public Doctor(Long id, String firstName, String lastName, String dob, String phone, String address, String email, List<SpecialistMaster> specialist, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.specialist = specialist;
        this.location = location;
    }

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Location getLocation() {
        return location;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SpecialistMaster> getSpecialist() {
        return specialist;
    }

    public void setSpecialist(List<SpecialistMaster> specialist) {
        this.specialist = specialist;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", specialist=" + specialist +
                ", location=" + location +
                '}';
    }
}
