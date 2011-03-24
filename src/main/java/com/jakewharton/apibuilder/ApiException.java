package com.jakewharton.apibuilder;

public class ApiException extends RuntimeException {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -6336249534326959151L;
	
	public ApiException(Throwable e) {
		super(e);
	}
	public ApiException(String message) {
		super(message);
	}
}
