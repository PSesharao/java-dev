package com.mindtree.exception.serviceexception;

import com.mindtree.exception.AlbumException;

@SuppressWarnings("serial")
public class AlbumServiceException extends AlbumException {

	public AlbumServiceException() {
		super();
	}

	public AlbumServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AlbumServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AlbumServiceException(String arg0) {
		super(arg0);
	}

	public AlbumServiceException(Throwable arg0) {
		super(arg0);
	}

}
