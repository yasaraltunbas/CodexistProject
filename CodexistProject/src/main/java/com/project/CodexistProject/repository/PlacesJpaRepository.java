package com.project.CodexistProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.CodexistProject.entity.PlaceDbEntity;

public interface PlacesJpaRepository extends JpaRepository<PlaceDbEntity, Integer>{

	
	

	List<PlaceDbEntity> findByLatAndLongiAndRadius(double latitude, double longitude, int radius);
}
