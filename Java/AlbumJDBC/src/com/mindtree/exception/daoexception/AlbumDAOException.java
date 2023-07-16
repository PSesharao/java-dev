package com.mindtree.exception.daoexception;

import com.mindtree.exception.AlbumException;

@SuppressWarnings("serial")
public class AlbumDAOException extends AlbumException{

	public AlbumDAOException() {
		super();
	}

	public AlbumDAOException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AlbumDAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AlbumDAOException(String arg0) {
		super(arg0);
	}

	public AlbumDAOException(Throwable arg0) {
		super(arg0);
	}

}
