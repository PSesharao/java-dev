package com.mindtree.shoppingmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mindtree.shoppingmvc.dto.ProductDto;
import com.mindtree.shoppingmvc.entity.Product;
import com.mindtree.shoppingmvc.service.ProductService;

@Controller
//@RequestMapping("/api")
public class ProductController {
	
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	//{image}
	@ResponseBody
	@RequestMapping(value = "/createproduct")
	public Product addProduct(
			 ProductDto productDto  ) {
		
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

}
