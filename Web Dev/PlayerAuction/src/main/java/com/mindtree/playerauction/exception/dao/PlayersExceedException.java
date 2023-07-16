package com.mindtree.playerauction.exception.dao;

import com.mindtree.playerauction.exception.TeamException;

@SuppressWarnings("serial")
public class PlayersExceedException extends TeamException{

	public PlayersExceedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayersExceedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PlayersExceedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayersExceedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PlayersExceedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
