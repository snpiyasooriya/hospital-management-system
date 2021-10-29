package com.synotech.hos.services;

import com.synotech.hos.dao.TitleRepo;
import com.synotech.hos.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    final TitleRepo titleRepo;

    @Autowired
    public TitleService(TitleRepo titleRepo){
        this.titleRepo = titleRepo;
    }

    public List<Title> getTitles(){
        return titleRepo.findAll();
    }
}
