package com.mindtree.exception.daoexception;

import com.mindtree.exception.daoexception.HotelDaoException;

@SuppressWarnings("serial")
public class DataBaseEmptyException extends HotelDaoException {

	public DataBaseEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataBaseEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataBaseEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataBaseEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataBaseEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
