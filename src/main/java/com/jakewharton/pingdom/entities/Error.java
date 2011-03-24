package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public final class Error implements PingdomEntity {
	private static final long serialVersionUID = 4351246390203620969L;

	private Integer statusCode;
	private String statusDesc;
	private String errorMessage;
	
	public Integer getStatusCode() {
		return this.statusCode;
	}
	public String getStatusDescription() {
		return this.statusDesc;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
