package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.carproject.entity.Color;
@Repository
public interface ColorRepository extends JpaRepository<Color, String>{

}
