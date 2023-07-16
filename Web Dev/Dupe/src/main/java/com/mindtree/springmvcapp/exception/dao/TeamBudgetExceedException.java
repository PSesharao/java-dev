package com.mindtree.springmvcapp.exception.dao;

import com.mindtree.springmvcapp.exception.TeamException;

@SuppressWarnings("serial")
public class TeamBudgetExceedException extends TeamException {

	public TeamBudgetExceedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamBudgetExceedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TeamBudgetExceedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TeamBudgetExceedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TeamBudgetExceedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
