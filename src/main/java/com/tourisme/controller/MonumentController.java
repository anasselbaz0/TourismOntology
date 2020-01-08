package com.tourisme.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourisme.business.MonumentBusiness;
import com.tourisme.business.MonumentBusinessImpl;
import com.tourisme.entity.Monument;

@RestController
public class MonumentController {

	MonumentBusiness monumentBusiness = new MonumentBusinessImpl();
	
	
	@GetMapping("/monuments")
	public List<Monument> getAllMonuments() {
		return monumentBusiness.getAllMonuments();
	}
	
	@PostMapping("/monuments")
	public Monument addMonument(Monument m) {
		return monumentBusiness.saveOrUpdateMonument(m);
	}
	
	@GetMapping("/monuments/{Id}")
	public Monument getMonumentById(@PathVariable("Id") int id) {
		return monumentBusiness.getMonumentById(id);
	}
	
	@PutMapping("/monuments/{Id}")
	public Monument updateMonument(@PathVariable("Id") int id) {
		Monument t = monumentBusiness.getMonumentById(id);
		return monumentBusiness.saveOrUpdateMonument(t);
	}
	
	@DeleteMapping("/monuments/{Id}")
	public void deleteMonument(@PathVariable("Id") int id) {
		monumentBusiness.deleteMonument(id);
	}
	
}
