package com.mindtree.carproject.exception.daoexception;

import com.mindtree.carproject.exception.serviceexception.ModelColorPriceServiceException;

@SuppressWarnings("serial")
public class ModelColorPairAlreadyExistsException extends ModelColorPriceServiceException {

	public ModelColorPairAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelColorPairAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ModelColorPairAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ModelColorPairAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ModelColorPairAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
