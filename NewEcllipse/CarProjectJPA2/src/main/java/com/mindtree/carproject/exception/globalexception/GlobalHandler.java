package com.mindtree.carproject.exception.globalexception;

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
		response.put("Header", "CarProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@ExceptionHandler(BrandException.class)
	public ResponseEntity<Map<String, Object>> handleBrandExceptions(BrandException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(ColorException.class)
	public ResponseEntity<Map<String, Object>> handleColorExceptions(ColorException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(ModelException.class)
	public ResponseEntity<Map<String, Object>> handleModelExceptions(ModelException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(ModelColorException.class)
	public ResponseEntity<Map<String, Object>> handleModelColorExceptions(ModelColorException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
