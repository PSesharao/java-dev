package com.mindtree.exception;

@SuppressWarnings("serial")
public class AlbumException extends Exception {

	public AlbumException() {
		super();
	}

	public AlbumException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AlbumException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AlbumException(String arg0) {
		super(arg0);
	}

	public AlbumException(Throwable arg0) {
		super(arg0);
	}

}
