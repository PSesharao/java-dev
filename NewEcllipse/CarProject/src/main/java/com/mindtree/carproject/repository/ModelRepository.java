package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Model;

public interface ModelRepository extends JpaRepository<Model, String> {
	
}
