package com.synotech.hos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppoinmnetController {
	@GetMapping(path = "/hello")
	public String test() {
			return "hdfhgfh";
		}

}
