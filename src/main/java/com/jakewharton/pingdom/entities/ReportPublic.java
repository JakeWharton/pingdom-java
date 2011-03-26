package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom public report object.
 */
public final class ReportPublic implements PingdomEntity {
	private static final long serialVersionUID = -9170672319763547666L;

	@Since(2.0) private Integer checkId;
	@Since(2.0) private String checkName;
	@Since(2.0) private String reportUrl;
	
	/**
	 * Check identifier.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getCheckId() {
		return this.checkId;
	}
	
	/**
	 * Check name
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCheckName() {
		return this.checkName;
	}
	
	/**
	 * URL to report
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getReportUrl() {
		return this.reportUrl;
	}
}
