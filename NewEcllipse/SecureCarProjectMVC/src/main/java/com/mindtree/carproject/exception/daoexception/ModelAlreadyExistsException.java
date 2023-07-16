package com.mindtree.carproject.exception.daoexception;

import com.mindtree.carproject.exception.serviceexception.ModelServiceException;

@SuppressWarnings("serial")
public class ModelAlreadyExistsException extends ModelServiceException {

	public ModelAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ModelAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ModelAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ModelAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
