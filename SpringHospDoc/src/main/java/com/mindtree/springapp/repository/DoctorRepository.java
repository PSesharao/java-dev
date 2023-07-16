package com.mindtree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springapp.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
