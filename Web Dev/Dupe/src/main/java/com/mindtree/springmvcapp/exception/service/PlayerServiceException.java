package com.mindtree.springmvcapp.exception.service;

import com.mindtree.springmvcapp.exception.PlayerException;

@SuppressWarnings("serial")
public class PlayerServiceException extends PlayerException {

	public PlayerServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PlayerServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PlayerServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
