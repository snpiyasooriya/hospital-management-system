package com.synotech.hos.dao;

import com.synotech.hos.model.Patient;
import com.synotech.hos.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepo extends JpaRepository<Ward, Long> {
    @Query(value = "SELECT * FROM ward where location_id =?1 ", nativeQuery = true)
    List<Ward> getWardByLocationId(Integer location);
}
