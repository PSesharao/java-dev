package com.mindtree.exception;

@SuppressWarnings("serial")
public class PhoneException extends Exception {

	public PhoneException() {
	}

	public PhoneException(String arg0) {
		super(arg0);
	}

	public PhoneException(Throwable arg0) {
		super(arg0);
	}

	public PhoneException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PhoneException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
