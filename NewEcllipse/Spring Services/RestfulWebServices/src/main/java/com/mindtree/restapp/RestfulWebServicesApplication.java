package com.mindtree.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mindtree.restapp.exception.serviceexception.EmployeeServiceException;

@SpringBootApplication
@ComponentScan("com.mindtree.restapp.service")
public class RestfulWebServicesApplication {

	public static void main(String[] args) throws EmployeeServiceException {
		SpringApplication.run(RestfulWebServicesApplication.class, args);

	}

}
