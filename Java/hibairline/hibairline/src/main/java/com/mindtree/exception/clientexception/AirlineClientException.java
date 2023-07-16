package com.mindtree.exception.clientexception;

import com.mindtree.exception.AirlineException;

@SuppressWarnings("serial")
public class AirlineClientException extends AirlineException{

	public AirlineClientException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirlineClientException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AirlineClientException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AirlineClientException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AirlineClientException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
