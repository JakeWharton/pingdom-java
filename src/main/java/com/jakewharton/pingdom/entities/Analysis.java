package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public final class Analysis implements PingdomEntity {
	private static final long serialVersionUID = 7129478343144347162L;

	private Integer id;
	private Integer timeFirstTest;
	private Integer timeConfirmTest;
	
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
