package com.mindtree.exception;

@SuppressWarnings("serial")
public class CarException extends Exception {

	public CarException() {
		super();
	}

	public CarException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CarException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CarException(String arg0) {
		super(arg0);
	}

	public CarException(Throwable arg0) {
		super(arg0);
	}

}
