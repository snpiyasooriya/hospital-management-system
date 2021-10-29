package com.synotech.hos.services;

import com.synotech.hos.dao.DoctorRepo;
import com.synotech.hos.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    final DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public List<Doctor> getDoctor(){
        return doctorRepo.findAll();
    }

    public Doctor save(Doctor newDoctor){
        return doctorRepo.save(newDoctor);
    }
}
