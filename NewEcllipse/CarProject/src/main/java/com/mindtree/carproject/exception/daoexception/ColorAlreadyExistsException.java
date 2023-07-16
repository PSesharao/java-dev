package com.mindtree.carproject.exception.daoexception;

import com.mindtree.carproject.exception.serviceexception.ColorServiceException;

@SuppressWarnings("serial")
public class ColorAlreadyExistsException extends ColorServiceException {

	public ColorAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColorAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ColorAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ColorAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ColorAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
