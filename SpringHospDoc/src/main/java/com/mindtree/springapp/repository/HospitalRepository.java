package com.mindtree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springapp.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
