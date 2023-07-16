package com.mindtree.shoppingmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.shoppingmvc.dto.CategoryDto;
import com.mindtree.shoppingmvc.entity.Category;
import com.mindtree.shoppingmvc.entity.Product;
import com.mindtree.shoppingmvc.repository.CategoryRepository;
import com.mindtree.shoppingmvc.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@ResponseBody
	@RequestMapping(value = "/createcategory")
	public Category addCategory(CategoryDto categoryDto)
	{
		return categoryService.createCategory(categoryDto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCategories")
	public List<Category> getCategories()
	{
		return categoryRepository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getProducts/{catageoryName}")
	public List<Product> getProducts(@PathVariable("catageoryName") String catageoryName)
	{
		return categoryRepository.findByName(catageoryName).getProductList();
	}
	
}
