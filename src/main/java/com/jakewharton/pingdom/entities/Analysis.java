package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom analysis object.
 */
public final class Analysis implements PingdomEntity {
	private static final long serialVersionUID = 7129478343144347162L;

	@Since(2.0) private Integer id;
	@Since(2.0) private Integer timeFirstTest;
	@Since(2.0) private Integer timeConfirmTest;
	
	/**
	 * Analysis id.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Time of test that initiated the confirmation test.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getTimeFirstTest() {
		return this.timeFirstTest;
	}
	
	/**
	 * Time of the confirmation test that performed the error analysis.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getTimeConfirmTest() {
		return this.timeConfirmTest;
	}
}
