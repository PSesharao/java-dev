package com.mindtree.springexception.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoctorExceptionHandler {
	
	@ExceptionHandler
	public String dealInvalidField(InvalidFieldException e)
	{
		return e.getMessage();
	}
}
