package com.synotech.hos.controllers;

import com.synotech.hos.model.Location;
import com.synotech.hos.model.UserTypeMaster;
import com.synotech.hos.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/usertype")
public class UserTypeController {

    final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    @CrossOrigin
    public List<UserTypeMaster> getUserTypes(){
        return userTypeService.getUserTypeMasters();
    }


}
