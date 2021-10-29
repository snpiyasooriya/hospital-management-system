package com.synotech.hos.dao;

import com.synotech.hos.model.Patient;
import com.synotech.hos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    User finByEmail(String email);
}
