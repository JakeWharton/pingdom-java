package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public class TraceRoute implements PingdomEntity {
	private static final long serialVersionUID = 7173775526745510114L;

	@Since(2.0) private String result;
	@Since(2.0) private Integer probeId;
	@Since(2.0) private String probeDescription;
	
	public String getResult() {
		return this.result;
	}
	public Integer getProbeId() {
		return this.probeId;
	}
	public String getProbeDescription() {
		return this.probeDescription;
	}
}
