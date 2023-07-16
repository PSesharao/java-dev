package com.mindtree.springapp.exception.serviceexception;

import com.mindtree.springapp.exception.DoctorException;

@SuppressWarnings("serial")
public class DoctorServiceException extends DoctorException{

	public DoctorServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DoctorServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DoctorServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DoctorServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
