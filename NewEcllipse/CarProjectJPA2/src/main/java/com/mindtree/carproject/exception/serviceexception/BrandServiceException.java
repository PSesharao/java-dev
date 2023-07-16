package com.mindtree.carproject.exception.serviceexception;

import com.mindtree.carproject.exception.globalexception.BrandException;

@SuppressWarnings("serial")
public class BrandServiceException extends BrandException {

	public BrandServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BrandServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BrandServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BrandServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
