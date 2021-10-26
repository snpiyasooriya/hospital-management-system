package com.synotech.hos.controllers;

import com.synotech.hos.model.User;
import com.synotech.hos.model.User;
import com.synotech.hos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUser(){
       return userService.getUsers();
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User newUser) throws SerialException {

        User user = userService.save(newUser);

        if(user == null) {
            throw new SerialException();
        }else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

    }
}
