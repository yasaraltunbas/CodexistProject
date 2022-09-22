package com.project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entity.Places;
public interface PlacesJpaRepository extends JpaRepository<Places, String>{

}
