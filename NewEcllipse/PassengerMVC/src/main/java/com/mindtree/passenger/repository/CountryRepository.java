package com.mindtree.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.passenger.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

}
