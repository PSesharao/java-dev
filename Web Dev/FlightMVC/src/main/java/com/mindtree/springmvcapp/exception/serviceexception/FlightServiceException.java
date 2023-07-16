package com.mindtree.springmvcapp.exception.serviceexception;

import com.mindtree.springmvcapp.exception.FlightException;

@SuppressWarnings("serial")
public class FlightServiceException extends FlightException {

	public FlightServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public FlightServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public FlightServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FlightServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
