package com.mindtree.springapp.exception.serviceexception;

import com.mindtree.springapp.exception.HospitalException;

@SuppressWarnings("serial")
public class HospitalServiceException extends HospitalException{

	public HospitalServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitalServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HospitalServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HospitalServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HospitalServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
