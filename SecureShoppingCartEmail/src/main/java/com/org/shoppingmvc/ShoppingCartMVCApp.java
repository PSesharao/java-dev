package com.org.shoppingmvc;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.shoppingmvc.service.impl.ProductServiceImpl;


@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class ShoppingCartMVCApp {

	public static void main(String[] args) {
		// Below line will create "uploads" folder at startup if not created.
		new File(ProductServiceImpl.uploadDirectory).mkdir();
		SpringApplication.run(ShoppingCartMVCApp.class, args);
	}

}
