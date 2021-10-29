package com.synotech.hos.services;

import com.synotech.hos.dao.TitleRepo;
import com.synotech.hos.dao.UserTypeMasterRepo;
import com.synotech.hos.model.Title;
import com.synotech.hos.model.UserTypeMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {

    final UserTypeMasterRepo userTypeMasterRepo;

    @Autowired
    public UserTypeService(UserTypeMasterRepo userTypeMasterRepo){
        this.userTypeMasterRepo = userTypeMasterRepo;
    }

    public List<UserTypeMaster> getUserTypeMasters(){
        return userTypeMasterRepo.findAll();
    }
}
