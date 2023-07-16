package com.mindtree.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.passenger.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, String>{
	
}
