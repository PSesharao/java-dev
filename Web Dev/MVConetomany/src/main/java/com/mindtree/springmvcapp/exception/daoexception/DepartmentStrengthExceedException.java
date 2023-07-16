package com.mindtree.springmvcapp.exception.daoexception;

import com.mindtree.springmvcapp.exception.DepartmentException;

@SuppressWarnings("serial")
public class DepartmentStrengthExceedException extends DepartmentException {

	public DepartmentStrengthExceedException() {
		super();
		
	}

	public DepartmentStrengthExceedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public DepartmentStrengthExceedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public DepartmentStrengthExceedException(String arg0) {
		super(arg0);
		
	}

	public DepartmentStrengthExceedException(Throwable arg0) {
		super(arg0);
		
	}
	
}
