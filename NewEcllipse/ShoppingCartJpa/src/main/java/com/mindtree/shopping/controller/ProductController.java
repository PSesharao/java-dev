package com.mindtree.shopping.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shopping.dto.ProductDto;
import com.mindtree.shopping.exception.globalexception.ProductException;
import com.mindtree.shopping.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/createproduct")
	public ResponseEntity<Map<String, Object>> addCustomer(@RequestBody ProductDto productDto) throws ProductException{
		productService.createProduct(productDto);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", false);
		response.put("message :", productDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
