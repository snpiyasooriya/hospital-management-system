package com.synotech.hos.controllers;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synotech.hos.dao.TitleRepo;
import com.synotech.hos.model.Patient;
import com.synotech.hos.services.PatientService;


@RestController
@RequestMapping(path = "api/patient")
public class PatientController {

	
	private final PatientService patientService;
	@Autowired
	public PatientController(PatientService patientService, TitleRepo titleRepo) {
		this.patientService = patientService;
	}

	@CrossOrigin
	@GetMapping
	public List<Patient> getPatients(){

		return patientService.getPatients();
	}

	@CrossOrigin
	@GetMapping(path = "/admit")
	public List<Patient> getPatientsForAdmit(){

		return patientService.getPatientsForAdmit();
	}

	@CrossOrigin
	@GetMapping(path = "/discharge")
	public List<Patient> getPatientsForDischarge(){

		return patientService.getPatientsForDischrge();
	}

	@PutMapping("/{location}/{id}")
	@CrossOrigin
	public void updateLocation(@PathVariable(value = "location") Integer location, @PathVariable("id") Integer id){
		 patientService.transfer(location, id);

	}
	@PutMapping(path = "/admit/{location}/{id}/{wid}")
	@CrossOrigin
	public void updateWard(@PathVariable(value = "location") Integer location, @PathVariable("id") Integer id, @PathVariable(name = "wid") Integer wid){
		patientService.admit(location, id, wid);

	}

	@PutMapping(path = "/discharge/{id}")
	@CrossOrigin
	public void updateWard( @PathVariable("id") Integer id){
		patientService.discharge(id);

	}

	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> create(@RequestBody 
			Patient newPatient
			) throws SerialException{
		
		Patient newPateint = newPatient;
		
		Patient patient = patientService.save(newPateint);
		
		if(patient == null) {
			throw new SerialException();
		}else {
			return new ResponseEntity<>(patient, HttpStatus.CREATED);
		}
		
	}
	

	
}
