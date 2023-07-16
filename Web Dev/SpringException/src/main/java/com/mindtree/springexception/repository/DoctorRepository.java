package com.mindtree.springexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springexception.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String>{
	Doctor findByName(String name);
}
