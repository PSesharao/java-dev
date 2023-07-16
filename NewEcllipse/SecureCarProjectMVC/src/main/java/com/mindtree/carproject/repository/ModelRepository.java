package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.carproject.entity.Model;
@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
	
}
