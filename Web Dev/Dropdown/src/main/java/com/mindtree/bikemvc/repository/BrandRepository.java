package com.mindtree.bikemvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bikemvc.entity.Brand;


@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
	public Brand findByName(String name);
}
