package com.mindtree.exception;

@SuppressWarnings("serial")
public class InvalidPriceException extends Exception {
	public InvalidPriceException(String message)
	{
		super(message);
	}
}
