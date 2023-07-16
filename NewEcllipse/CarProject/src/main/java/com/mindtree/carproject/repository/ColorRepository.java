package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Color;

public interface ColorRepository extends JpaRepository<Color, String>{

}
