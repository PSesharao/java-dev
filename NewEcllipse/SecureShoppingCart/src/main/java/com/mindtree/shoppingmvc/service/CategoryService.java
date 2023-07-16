package com.mindtree.shoppingmvc.service;

import com.mindtree.shoppingmvc.dto.CategoryDto;
import com.mindtree.shoppingmvc.entity.Category;

public interface CategoryService {
	Category createCategory(CategoryDto categoryDto);
}
