package com.mindtree.dropdownmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.dropdownmvc.entity.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
	
}
