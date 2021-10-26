package com.synotech.hos.services;

import java.util.List;

import com.synotech.hos.dao.UserRepo;
import com.synotech.hos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synotech.hos.dao.PatientRepo;
import com.synotech.hos.model.Patient;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User save(User newUser) {
        return userRepo.save(newUser);
    }
}
