package com.mindtree.shoppingmvc;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mindtree.shoppingmvc.service.impl.ProductServiceImpl;


@SpringBootApplication
public class ShoppingCartMVCApp {

	public static void main(String[] args) {
		// Below line will create "uploads" folder at startup if not created.
		new File(ProductServiceImpl.uploadDirectory).mkdir();
		SpringApplication.run(ShoppingCartMVCApp.class, args);
	}

}
