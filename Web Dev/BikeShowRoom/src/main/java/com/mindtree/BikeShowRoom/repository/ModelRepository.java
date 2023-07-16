package com.mindtree.BikeShowRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.BikeShowRoom.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{
		
		public List<Model> findAllByName(String name);
		
}
