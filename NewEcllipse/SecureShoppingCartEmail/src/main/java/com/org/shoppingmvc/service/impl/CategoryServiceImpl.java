package com.org.shoppingmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.shoppingmvc.converter.CategoryConverter;
import com.org.shoppingmvc.dto.CategoryDto;
import com.org.shoppingmvc.entity.Category;
import com.org.shoppingmvc.repository.CategoryRepository;
import com.org.shoppingmvc.service.CategoryService;
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
