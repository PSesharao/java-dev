package com.mindtree.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springmvcapp.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	Flight findByName(String flightName);
}
