package com.org.shoppingmvc.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.org.shoppingmvc.dto.ProductDto;
import com.org.shoppingmvc.entity.Product;

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
