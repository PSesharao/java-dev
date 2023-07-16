package com.mindtree.exception.serviceexception;

import com.mindtree.exception.CarException;

@SuppressWarnings("serial")
public class CarServiceException extends CarException{

	public CarServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public CarServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CarServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CarServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
