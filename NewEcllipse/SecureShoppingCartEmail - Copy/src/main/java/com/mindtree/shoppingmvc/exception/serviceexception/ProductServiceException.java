package com.mindtree.shoppingmvc.exception.serviceexception;

import com.mindtree.shoppingmvc.exception.globalexception.ProductException;

@SuppressWarnings("serial")
public class ProductServiceException extends ProductException {

	public ProductServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
