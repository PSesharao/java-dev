package com.org.shoppingmvc.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.shoppingmvc.converter.ProductConverter;
import com.org.shoppingmvc.dto.ProductDto;
import com.org.shoppingmvc.entity.Category;
import com.org.shoppingmvc.entity.Product;
import com.org.shoppingmvc.repository.CategoryRepository;
import com.org.shoppingmvc.repository.ProductRepository;
import com.org.shoppingmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter productConverter;
	@Autowired
	private CategoryRepository categoryRepository;
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Override
	public Product createProduct(ProductDto productDto) {
		Product product = productConverter.dtoToEntity(productDto);
		MultipartFile imageFile = productDto.getImageFile();
		String fileName = imageFile.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		
		// Save the file locally

		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(imageFile.getBytes());
			stream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		Category category = categoryRepository.findByName(productDto.getCatageory());
		product.setImage(fileName);
		product.setCategory(category);
		category.getProductList().add(product);
		return productRepository.save(product);
	}

}
