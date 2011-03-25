package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class Message implements PingdomEntity {
	private static final long serialVersionUID = -2236235836826419242L;

	@Since(2.0) private String message;
	
	public String getMessage() {
		return this.message;
	}
}
