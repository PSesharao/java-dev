package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Long>{
	Library findByName(String name);
}
