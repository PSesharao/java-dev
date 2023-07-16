package com.mindtree.playerauction.exception.dao;

import com.mindtree.playerauction.exception.PlayerException;

@SuppressWarnings("serial")
public class BowlerExceedException extends PlayerException {

	public BowlerExceedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BowlerExceedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BowlerExceedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BowlerExceedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BowlerExceedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
