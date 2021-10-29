package com.synotech.hos.controllers;

import com.synotech.hos.model.SpecialistMaster;
import com.synotech.hos.services.SpecialistMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/specialist")
public class SpecialistMasterController {

    final SpecialistMasterService specialistMasterService;

    @Autowired
    public SpecialistMasterController(SpecialistMasterService specialistMasterService) {
        this.specialistMasterService = specialistMasterService;
    }

    @GetMapping
    @CrossOrigin
    public List<SpecialistMaster> getSpecialist(){
        return specialistMasterService.getSpecialistMasters();
    }
}
