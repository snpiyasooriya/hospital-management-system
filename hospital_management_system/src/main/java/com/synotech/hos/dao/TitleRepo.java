package com.synotech.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synotech.hos.model.Title;

@Repository
public interface TitleRepo extends JpaRepository<Title, Integer> {

}
