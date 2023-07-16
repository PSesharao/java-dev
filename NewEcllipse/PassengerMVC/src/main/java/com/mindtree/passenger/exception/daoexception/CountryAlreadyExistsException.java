package com.mindtree.passenger.exception.daoexception;

import com.mindtree.passenger.exception.serviceexception.CountryServiceException;

@SuppressWarnings("serial")
public class CountryAlreadyExistsException extends CountryServiceException {

	public CountryAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CountryAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CountryAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CountryAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
