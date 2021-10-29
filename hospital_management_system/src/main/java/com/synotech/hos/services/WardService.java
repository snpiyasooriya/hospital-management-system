package com.synotech.hos.services;

import com.synotech.hos.dao.WardRepo;
import com.synotech.hos.model.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    final WardRepo wardRepo;

    @Autowired
    public WardService(WardRepo wardRepo) {
        this.wardRepo = wardRepo;
    }

    public List<Ward> getWard(){
        return wardRepo.findAll();
    }

    public Ward save(Ward newWard){
        return wardRepo.save(newWard);
    }

    public List<Ward> getWardsByLocationId(Integer location){

        return wardRepo.getWardByLocationId(location);
    }
}
