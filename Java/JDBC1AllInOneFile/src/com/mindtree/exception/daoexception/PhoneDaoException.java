package com.mindtree.exception.daoexception;

import com.mindtree.exception.PhoneException;

@SuppressWarnings("serial")
public class PhoneDaoException extends PhoneException{

	public PhoneDaoException() {
	}

	public PhoneDaoException(String arg0) {
		super(arg0);
	}

	public PhoneDaoException(Throwable arg0) {
		super(arg0);
	}

	public PhoneDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PhoneDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
