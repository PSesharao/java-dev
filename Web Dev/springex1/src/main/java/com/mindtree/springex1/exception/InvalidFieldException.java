package com.mindtree.springex1.exception;

@SuppressWarnings("serial")
public class InvalidFieldException extends RuntimeException {

	public InvalidFieldException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidFieldException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidFieldException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidFieldException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidFieldException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
