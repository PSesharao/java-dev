package com.mindtree.passenger.exception.daoexception;

import com.mindtree.passenger.exception.serviceexception.CityServiceException;

@SuppressWarnings("serial")
public class CityAlreadyExistsException extends CityServiceException {

	public CityAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CityAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CityAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CityAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
