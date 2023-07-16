package com.mindtree.exception.daoexception;


@SuppressWarnings("serial")
public class DataBaseEmptyException extends AirlineDaoException {

	public DataBaseEmptyException() {
		
	}

	public DataBaseEmptyException(String arg0) {
		super(arg0);
	}

	public DataBaseEmptyException(Throwable arg0) {
		super(arg0);
	}

	public DataBaseEmptyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataBaseEmptyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
