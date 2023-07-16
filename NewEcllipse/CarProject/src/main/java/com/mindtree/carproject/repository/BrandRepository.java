package com.mindtree.carproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	Optional<Brand> findByName(String brandName);
}
