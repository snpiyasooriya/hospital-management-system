package com.synotech.hos.controllers;

import com.synotech.hos.model.Patient;
import com.synotech.hos.model.Ward;
import com.synotech.hos.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@RestController
@RequestMapping(path = "api/ward")
public class WardController {

    final WardService wardService;

    @Autowired
    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping
    @CrossOrigin
    public List<Ward> getWards(){
        return wardService.getWard();
    }

    @GetMapping(path = "/location")
    @CrossOrigin
    public List<Ward> getWardsByLocationId(@RequestParam("location") Integer location){
        return wardService.getWardsByLocationId(location);
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ward> create(@RequestBody
                                                  Ward newWard
    ) throws SerialException {
        Ward ward = wardService.save(newWard);

        if(ward == null) {
            throw new SerialException();
        }else {
            return new ResponseEntity<>(ward, HttpStatus.CREATED);
        }

    }
}
