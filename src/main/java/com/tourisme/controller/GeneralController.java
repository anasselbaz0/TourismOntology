package com.tourisme.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tourisme.business.GeneralBusiness;
import com.tourisme.business.GeneralBusinessImpl;

@RestController
public class GeneralController {

	GeneralBusiness generalBusiness = new GeneralBusinessImpl();
	
	
	@GetMapping("/search/{object}/{type}")
	public List<Object> getSubjects(@PathVariable("object") String obj, @PathVariable("type") String type) {
		return generalBusiness.getSubjects(obj, type);
	}

	
	
}
