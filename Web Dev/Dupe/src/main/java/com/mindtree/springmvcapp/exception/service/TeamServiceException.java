package com.mindtree.springmvcapp.exception.service;

import com.mindtree.springmvcapp.exception.TeamException;

@SuppressWarnings("serial")
public class TeamServiceException extends TeamException {

	public TeamServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TeamServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TeamServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TeamServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
