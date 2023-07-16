package com.org.shoppingmvc.exception.serviceexception;

import com.org.shoppingmvc.exception.globalexception.OrderException;

@SuppressWarnings("serial")
public class OrderServiceException extends OrderException {

	public OrderServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OrderServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrderServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrderServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
