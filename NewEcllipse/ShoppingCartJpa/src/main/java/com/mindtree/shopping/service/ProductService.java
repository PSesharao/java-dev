package com.mindtree.shopping.service;

import com.mindtree.shopping.dto.ProductDto;
import com.mindtree.shopping.entity.Product;
import com.mindtree.shopping.exception.serviceexception.ProductServiceException;

public interface ProductService {
	Product createProduct(ProductDto productDto) throws ProductServiceException;
}
