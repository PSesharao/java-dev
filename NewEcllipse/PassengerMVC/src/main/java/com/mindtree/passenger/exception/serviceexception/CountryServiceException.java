package com.mindtree.passenger.exception.serviceexception;

import com.mindtree.passenger.exception.globalexception.CountryException;

@SuppressWarnings("serial")
public class CountryServiceException extends CountryException{

	public CountryServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CountryServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CountryServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CountryServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
