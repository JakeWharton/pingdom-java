package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class Analysis implements PingdomEntity {
	private static final long serialVersionUID = 7129478343144347162L;

	@Since(2.0) private Integer id;
	@Since(2.0) private Integer timeFirstTest;
	@Since(2.0) private Integer timeConfirmTest;
	
	public Integer getId() {
		return this.id;
	}
	public Integer getTimeFirstTest() {
		return this.timeFirstTest;
	}
	public Integer getTimeConfirmTest() {
		return this.timeConfirmTest;
	}
}
