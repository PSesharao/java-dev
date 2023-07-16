package com.mindtree.BikeShowRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.BikeShowRoom.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {

}
