package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.jakewharton.pingdom.PingdomEntity;

public class ServerTime extends PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -3782819340976494833L;

	private Date serverTime;
	
	public Date getServiceTime() {
		return this.serverTime;
	}
	public ServerTime setServiceTime(Date serverTime) {
		this.serverTime = serverTime;
		return this;
	}
}
