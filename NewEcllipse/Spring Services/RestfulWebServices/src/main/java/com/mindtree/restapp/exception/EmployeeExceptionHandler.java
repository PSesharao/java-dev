package com.mindtree.restapp.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(Exception.class)

	public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", true);
		response.put("HttpStatus ",  HttpStatus.INTERNAL_SERVER_ERROR);
		response.put("message ", exception.getLocalizedMessage());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>>  handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		List<String> details = new ArrayList<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", true);
		response.put("HttpStatus ",  HttpStatus.BAD_REQUEST);
		for(ObjectError error : exception.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
		response.put("message ", details);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleEmployeeNotFoundExceptions(EmployeeNotFoundException exception) {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", true);
		response.put("HttpStatus ",  HttpStatus.NOT_FOUND);
		response.put("message ", exception.getLocalizedMessage());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

	}
	
	

}
