package com.mindtree.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.converter.ProductConverter;
import com.mindtree.shopping.dto.ProductDto;
import com.mindtree.shopping.entity.Product;
import com.mindtree.shopping.exception.serviceexception.ProductServiceException;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository ;
	@Autowired
	private ProductConverter productConverter;
	
	@Override
	public Product createProduct(ProductDto productDto) throws ProductServiceException{
		
		return productRepository.save(productConverter.dtoToEntity(productDto));
	}

}
