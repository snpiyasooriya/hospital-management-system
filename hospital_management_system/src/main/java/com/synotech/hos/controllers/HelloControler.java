package com.synotech.hos.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
@GetMapping(path = "/")
public String index() {
	return "Hello";
}
}
