package com.synotech.hos.controllers;

import com.synotech.hos.model.Location;
import com.synotech.hos.services.LocationService;
import com.synotech.hos.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @CrossOrigin
    public List<Location> getTitles(){
        return locationService.getLocations();
    }
}
