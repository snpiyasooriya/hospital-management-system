package com.synotech.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synotech.hos.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
