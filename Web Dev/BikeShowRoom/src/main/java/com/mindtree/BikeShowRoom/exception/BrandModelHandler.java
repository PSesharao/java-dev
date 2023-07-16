package com.mindtree.BikeShowRoom.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BrandModelHandler {
	@ExceptionHandler(Exception.class)

	public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@ExceptionHandler(BrandException.class)
	public ResponseEntity<Map<String, Object>> handleStudentExceptions(BrandException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@ExceptionHandler(ModelException.class)
	public ResponseEntity<Map<String, Object>> handleDepartmentExceptions(ModelException exception) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", true);
		response.put("message :", exception.getLocalizedMessage());
		response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
