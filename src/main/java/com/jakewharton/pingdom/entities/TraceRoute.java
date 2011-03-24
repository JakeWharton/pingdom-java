package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class TraceRoute implements PingdomEntity {
	private static final long serialVersionUID = 7173775526745510114L;

	private String result;
	private Integer probeId;
	private String probeDescription;
	
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
