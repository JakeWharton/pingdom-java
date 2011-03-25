package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class ServerTime implements PingdomEntity {
	private static final long serialVersionUID = -3782819340976494833L;

	@Since(2.0) private Date serverTime;
	
	public Date getServiceTime() {
		return this.serverTime;
	}
}
