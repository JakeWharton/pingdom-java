package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom trace route object.
 */
public class TraceRoute implements PingdomEntity {
	private static final long serialVersionUID = 7173775526745510114L;

	@Since(2.0) private String result;
	@Since(2.0) private Integer probeId;
	@Since(2.0) private String probeDescription;
	
	/**
	 * Traceroute output.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Probe identifier.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getProbeId() {
		return this.probeId;
	}
	
	/**
	 * Probe description.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getProbeDescription() {
		return this.probeDescription;
	}
}
