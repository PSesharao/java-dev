package com.mindtree.springJpa1toMany.exception.serviceexception;

import com.mindtree.springJpa1toMany.exception.StudentException;

@SuppressWarnings("serial")
public class StudentServiceException extends StudentException {

	public StudentServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
