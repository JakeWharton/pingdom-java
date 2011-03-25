package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class ReportPublic implements PingdomEntity {
	private static final long serialVersionUID = -9170672319763547666L;

	@Since(2.0) private Integer checkId;
	@Since(2.0) private String checkName;
	@Since(2.0) private String reportUrl;
	
	public Integer getCheckId() {
		return this.checkId;
	}
	public String getCheckName() {
		return this.checkName;
	}
	public String getReportUrl() {
		return this.reportUrl;
	}
}
