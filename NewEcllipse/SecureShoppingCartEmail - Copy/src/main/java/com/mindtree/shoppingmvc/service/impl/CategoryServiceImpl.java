package com.mindtree.shoppingmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingmvc.converter.CategoryConverter;
import com.mindtree.shoppingmvc.dto.CategoryDto;
import com.mindtree.shoppingmvc.entity.Category;
import com.mindtree.shoppingmvc.repository.CategoryRepository;
import com.mindtree.shoppingmvc.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public Category createCategory(CategoryDto categoryDto) {

		return categoryRepository.save(categoryConverter.dtoToEntity(categoryDto));
	}

}
