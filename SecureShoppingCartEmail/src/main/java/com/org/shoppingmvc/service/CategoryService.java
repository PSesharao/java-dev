package com.org.shoppingmvc.service;

import com.org.shoppingmvc.dto.CategoryDto;
import com.org.shoppingmvc.entity.Category;

public interface CategoryService {
	Category createCategory(CategoryDto categoryDto);
}
