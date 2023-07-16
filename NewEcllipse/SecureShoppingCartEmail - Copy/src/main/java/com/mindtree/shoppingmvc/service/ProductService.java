package com.mindtree.shoppingmvc.service;

import com.mindtree.shoppingmvc.dto.ProductDto;
import com.mindtree.shoppingmvc.entity.Product;

public interface ProductService {
	Product createProduct(ProductDto productDto ) ;
}
