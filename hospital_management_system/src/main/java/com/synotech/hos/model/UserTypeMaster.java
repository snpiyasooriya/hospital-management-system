package com.synotech.hos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "user_type_master")
@Entity
public class UserTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @Column(nullable = false, length = 20)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<User> user = new ArrayList<>();

    public UserTypeMaster(int id, String type, List<User> user) {
        this.id = id;
        this.type = type;
        this.user = user;
    }

    public UserTypeMaster(int id) {
        this.id = id;
    }

    public UserTypeMaster() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserTypeMaster{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", user=" + user +
                '}';
    }
}