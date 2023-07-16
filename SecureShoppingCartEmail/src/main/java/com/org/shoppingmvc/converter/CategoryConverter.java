package com.org.shoppingmvc.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.org.shoppingmvc.dto.CategoryDto;
import com.org.shoppingmvc.entity.Category;

@Component
public class CategoryConverter {
	public CategoryDto entityToDto(Category category) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(category, CategoryDto.class);
	}

	public Category dtoToEntity(CategoryDto categoryDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(categoryDto, Category.class);

	}
}
