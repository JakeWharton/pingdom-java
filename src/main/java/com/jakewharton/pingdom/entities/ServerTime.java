package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom server time object.
 */
public final class ServerTime implements PingdomEntity {
	private static final long serialVersionUID = -3782819340976494833L;

	@Since(2.0) private Date serverTime;
	
	/**
	 * Current server time.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getServiceTime() {
		return this.serverTime;
	}
}
