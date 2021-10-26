package com.synotech.hos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synotech.hos.dao.PatientRepo;
import com.synotech.hos.model.Patient;

@Service
public class PatientService {
	
	private final PatientRepo patientRepo;
	
	@Autowired
	public PatientService(PatientRepo patientRepo) {
		this.patientRepo = patientRepo;
	}
	
	public List<Patient> getPatients(){
		return patientRepo.findAll();
	}

	public Patient save(Patient newPateint) {
		return patientRepo.save(newPateint);
	}
}
