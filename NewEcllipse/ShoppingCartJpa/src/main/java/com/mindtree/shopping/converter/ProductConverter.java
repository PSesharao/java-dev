package com.mindtree.shopping.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.shopping.dto.ProductDto;
import com.mindtree.shopping.entity.Product;

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
