package com.synotech.hos.services;

import com.synotech.hos.dao.LocationRepo;
import com.synotech.hos.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    final LocationRepo locationRepo;

    @Autowired
    public LocationService(LocationRepo locationRepo){
        this.locationRepo = locationRepo;
    }

    public List<Location> getLocations(){
        return locationRepo.findAll();
    }
}
