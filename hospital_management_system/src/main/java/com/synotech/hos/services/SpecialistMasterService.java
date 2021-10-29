package com.synotech.hos.services;

import com.synotech.hos.dao.DoctorRepo;
import com.synotech.hos.dao.SpecialistMasterRepo;
import com.synotech.hos.model.Doctor;
import com.synotech.hos.model.SpecialistMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistMasterService {

    final SpecialistMasterRepo specialistMasterRepo;

    @Autowired
    public SpecialistMasterService(SpecialistMasterRepo specialistMasterRepo) {
        this.specialistMasterRepo = specialistMasterRepo;
    }

    public List<SpecialistMaster> getSpecialistMasters(){
        return specialistMasterRepo.findAll();
    }

    public SpecialistMaster save(SpecialistMaster newSpecialistMaster){
        return specialistMasterRepo.save(newSpecialistMaster);
    }
}
