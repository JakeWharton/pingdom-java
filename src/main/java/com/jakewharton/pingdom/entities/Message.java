package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public final class Message implements PingdomEntity {
	private static final long serialVersionUID = -2236235836826419242L;

	private String message;
	
	public String getMessage() {
		return this.message;
	}
}
