package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class Error implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 4351246390203620969L;

	private Integer statusCode;
	private String statusDesc;
	private String errorMessage;
	
	public Integer getStatusCode() {
		return this.statusCode;
	}
	public Error setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getStatusDescription() {
		return this.statusDesc;
	}
	public Error setStatusDescription(String statusDesc) {
		this.statusDesc = statusDesc;
		return this;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}
	public Error setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
}
