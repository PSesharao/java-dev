package com.mindtree.carproject.exception.daoexception;

import com.mindtree.carproject.exception.serviceexception.BrandServiceException;

@SuppressWarnings("serial")
public class BrandAlreadyExistsException extends BrandServiceException {

	public BrandAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BrandAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BrandAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BrandAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
