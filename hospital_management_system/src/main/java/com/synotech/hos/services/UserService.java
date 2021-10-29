package com.synotech.hos.services;

import java.util.List;

import com.synotech.hos.dao.UserRepo;
import com.synotech.hos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.synotech.hos.dao.PatientRepo;
import com.synotech.hos.model.Patient;

@Service
public class UserService {

    private final UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {

        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User save(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepo.save(newUser);
    }
}
