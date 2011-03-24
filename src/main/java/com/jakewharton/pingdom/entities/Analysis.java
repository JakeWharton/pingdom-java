package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class Analysis implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7129478343144347162L;

	private Integer id;
	private Integer timeFirstTest;
	private Integer timeConfirmTest;
	
	public Integer getId() {
		return this.id;
	}
	public Analysis setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getTimeFirstTest() {
		return this.timeFirstTest;
	}
	public Analysis setTimeFirstTest(Integer timeFirstTest) {
		this.timeFirstTest = timeFirstTest;
		return this;
	}
	public Integer getTimeConfirmTest() {
		return this.timeConfirmTest;
	}
	public Analysis setTimeConfirmTest(Integer timeConfirmTest) {
		this.timeConfirmTest = timeConfirmTest;
		return this;
	}
}
