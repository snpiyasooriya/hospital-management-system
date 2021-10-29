package com.synotech.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.synotech.hos.model.Patient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {


    @Query(value = "SELECT first_name FROM patient", nativeQuery = true)
    List<Patient> getPatientForTable();

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient SET location_id = ?1, admit = ?3 WHERE id = ?2", nativeQuery = true)
    void updateLocation(Integer location, Integer patientId, Integer admit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient SET ward_id = ?3, location_id=?1, admit = ?4 WHERE id = ?2", nativeQuery = true)
    void updateWard(Integer location, Integer patientId, Integer wid, Integer admit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient SET admit = ?2 WHERE id = ?1", nativeQuery = true)
    void discharge(Integer patientId, Integer admit);

    @Query(value = "SELECT * FROM patient WHERE admit != 1", nativeQuery = true)
    List<Patient> getPatientForAdmit();

    @Query(value = "SELECT * FROM patient WHERE admit = 1", nativeQuery = true)
    List<Patient> getPatientsForDischarge();
}
