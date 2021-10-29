package com.synotech.hos.dao;

import com.synotech.hos.model.SpecialistMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistMasterRepo extends JpaRepository<SpecialistMaster, Long> {
}
