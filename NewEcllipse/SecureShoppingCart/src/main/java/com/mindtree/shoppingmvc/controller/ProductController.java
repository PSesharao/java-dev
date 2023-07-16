package com.mindtree.shoppingmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mindtree.shoppingmvc.dto.ProductDto;
import com.mindtree.shoppingmvc.entity.Category;
import com.mindtree.shoppingmvc.entity.Product;
import com.mindtree.shoppingmvc.repository.ProductRepository;
import com.mindtree.shoppingmvc.service.ProductService;

@Controller
//@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	// {image}
	@ResponseBody
	@RequestMapping(value = "/createproduct")
	public Product addProduct(ProductDto productDto) {

		/*
		 * System.out.println(productDto.getName());
		 * System.out.println(productDto.getPrice());
		 * System.out.println(productDto.getCatageory()); MultipartFile imageFile
		 * =productDto.getImageFile();
		 * System.out.println(imageFile.getOriginalFilename());
		 * 
		 * return null;
		 */
		return productService.createProduct(productDto);
	}

	@ResponseBody
	@RequestMapping(value = "/getProduct/{productId}")
	public Product getProduct(@PathVariable("productId") long productId) {
		return productRepository.findById(productId).get();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getProductList/{productIdList}")
	public List<Product> getProducts(@PathVariable("productIdList") List<Long> productIdList) {
		
		 List<Product> productList = new ArrayList<>();
		 for(Long productId : productIdList)
			 productList.add(productRepository.findById(productId).get());
		return productList;
	}

}
