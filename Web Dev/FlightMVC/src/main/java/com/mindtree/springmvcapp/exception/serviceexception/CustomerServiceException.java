package com.mindtree.springmvcapp.exception.serviceexception;

import com.mindtree.springmvcapp.exception.CustomerException;

@SuppressWarnings("serial")
public class CustomerServiceException extends CustomerException {

	public CustomerServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
