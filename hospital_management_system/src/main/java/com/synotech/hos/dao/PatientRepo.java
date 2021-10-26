package com.synotech.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.synotech.hos.model.Patient;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT first_name FROM patient", nativeQuery = true)
    List<Patient> getPatientForTable();
}
