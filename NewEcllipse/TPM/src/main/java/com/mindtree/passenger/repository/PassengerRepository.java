package com.mindtree.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.passenger.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
}
