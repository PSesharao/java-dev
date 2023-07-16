package com.mindtree.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.passenger.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
