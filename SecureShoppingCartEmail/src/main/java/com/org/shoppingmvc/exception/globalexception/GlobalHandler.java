package com.org.shoppingmvc.exception.globalexception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(Exception.class)

	public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}


	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Map<String, Object>> handleProductExceptions(ProductException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<Map<String, Object>>  handleOrderExceptions(OrderException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<Map<String, Object>>  handleCustomerExceptions(CustomerException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
