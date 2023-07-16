package com.mindtree.shoppingmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingmvc.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String categoryName);
}
