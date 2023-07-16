package com.mindtree.shoppingmvc.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.shoppingmvc.dto.ProductDto;
import com.mindtree.shoppingmvc.entity.Product;

@Component
public class ProductConverter {
	public ProductDto entityToDto(Product product) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(product, ProductDto.class);
	}

	public Product dtoToEntity(ProductDto productDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(productDto, Product.class);

	}
}
