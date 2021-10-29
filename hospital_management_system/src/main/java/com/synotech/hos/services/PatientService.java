package com.synotech.hos.services;

import java.util.List;

import com.synotech.hos.model.Location;
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

	public List<Patient> getPatientForTable(){

		return patientRepo.getPatientForTable();
	}
	public Patient save(Patient newPatient) {

		return patientRepo.save(newPatient);
	}

	public void transfer(Integer location, Integer id){
		Integer admit = 2;
		 patientRepo.updateLocation(location, id, admit);
	}

	public void admit(Integer location, Integer id, Integer wid){
		 int admit = 1;
		patientRepo.updateWard(location, id, wid, admit);
	}

	public void discharge(Integer id){
		int admit = 0;
		patientRepo.discharge(id, admit);
	}

	public List<Patient> getPatientsForAdmit(){
		return patientRepo.getPatientForAdmit();
	}

	public List<Patient> getPatientsForDischrge(){
		return patientRepo.getPatientsForDischarge();
	}
}
