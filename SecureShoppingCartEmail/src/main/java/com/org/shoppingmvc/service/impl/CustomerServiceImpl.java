package com.org.shoppingmvc.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.shoppingmvc.converter.CustomerConverter;
import com.org.shoppingmvc.dto.CustomerDto;
import com.org.shoppingmvc.entity.Customer;
import com.org.shoppingmvc.repository.CustomerRepository;
import com.org.shoppingmvc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Override
	public Customer createCustomer(CustomerDto customerDto) {
		Customer customer = customerConverter.dtoToEntity(customerDto);
		MultipartFile imageFile = customerDto.getImageFile();
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
		
		customer.setImage(fileName);
		return customerRepository.save(customer);
	}

}
