package com.org.shoppingmvc.service;

import com.org.shoppingmvc.dto.ProductDto;
import com.org.shoppingmvc.entity.Product;

public interface ProductService {
	Product createProduct(ProductDto productDto ) ;
}
