package com.synotech.hos.controllers;

import com.synotech.hos.model.Title;
import com.synotech.hos.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/title")
public class TitleController {

    private final TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    @CrossOrigin
    public List<Title> getTitles(){
        return titleService.getTitles();
    }
}
