package com.tourisme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("")
	public @ResponseBody String home() {
		return "<h1 style='color:red; font-size:30px;'>Connected to the server.</h1>";
	}

	
}
