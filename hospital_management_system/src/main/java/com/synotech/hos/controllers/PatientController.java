package com.synotech.hos.controllers;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
