package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class Error implements PingdomEntity {
	private static final long serialVersionUID = 4351246390203620969L;

	@Since(2.0) private Integer statusCode;
	@Since(2.0) private String statusDesc;
	@Since(2.0) private String errorMessage;
	
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
