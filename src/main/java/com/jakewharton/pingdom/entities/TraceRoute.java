package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class TraceRoute implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7173775526745510114L;

	private String result;
	private Integer probeId;
	private String probeDescription;
	
	public String getResult() {
		return this.result;
	}
	public TraceRoute setResult(String result) {
		this.result = result;
		return this;
	}
	public Integer getProbeId() {
		return this.probeId;
	}
	public TraceRoute setProbeId(Integer probeId) {
		this.probeId = probeId;
		return this;
	}
	public String getProbeDescription() {
		return this.probeDescription;
	}
	public TraceRoute setProbeDescription(String probeDescription) {
		this.probeDescription = probeDescription;
		return this;
	}
}
