package com.jakewharton.apibuilder;

public class ApiException extends RuntimeException {
	public ApiException(Throwable e) {
		super(e);
	}
	public ApiException(String message) {
		super(message);
	}

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -6336249534326959151L;
}
