package com.synotech.hos.controllers;

import com.synotech.hos.model.Doctor;
import com.synotech.hos.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@RestController
@RequestMapping(path = "api/doctor")
public class DoctorController {


    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @CrossOrigin
    public List<Doctor> getDoctors() {
        return doctorService.getDoctor();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Doctor> create(@RequestBody
                                                     Doctor newDoctor
    ) throws SerialException {

        Doctor doctor = doctorService.save(newDoctor);
        if (doctor == null) {
            throw new SerialException();
        } else {
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        }
    }
}
