package com.mindtree.exception.serviceexception;

import com.mindtree.exception.HotelException;

@SuppressWarnings("serial")
public class HotelServiceException extends HotelException{

	public HotelServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HotelServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HotelServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HotelServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
