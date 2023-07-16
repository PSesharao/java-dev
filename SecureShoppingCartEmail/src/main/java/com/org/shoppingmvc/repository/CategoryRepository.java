package com.org.shoppingmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shoppingmvc.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String categoryName);
}
