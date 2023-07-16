package com.mindtree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springapp.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
