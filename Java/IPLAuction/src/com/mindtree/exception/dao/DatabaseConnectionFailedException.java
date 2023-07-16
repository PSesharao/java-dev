package com.mindtree.exception.dao;


@SuppressWarnings("serial")
public class DatabaseConnectionFailedException extends PlayerAuctionDaoException{

	public DatabaseConnectionFailedException() {

	}

	public DatabaseConnectionFailedException(String message) {
		super(message);

	}

	public DatabaseConnectionFailedException(Throwable cause) {
		super(cause);

	}

	public DatabaseConnectionFailedException(String message, Throwable cause) {
		super(message, cause);

	}

	public DatabaseConnectionFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
