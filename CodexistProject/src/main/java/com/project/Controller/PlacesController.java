package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.Places;
import com.project.Repository.PlacesJpaRepository;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

	private PlacesJpaRepository placesJpaRepository;
	
	
	@Autowired
	public PlacesController(PlacesJpaRepository placesJpaRepository) {
		super();
		this.placesJpaRepository = placesJpaRepository;
	}
	
	
	@GetMapping("/getAll")
	public List<Places> getAll() {
		return this.placesJpaRepository.findAll();
	}
	

}
