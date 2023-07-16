package com.mindtree.springex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springex1.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String>{
	Doctor findByName(String name);
}
