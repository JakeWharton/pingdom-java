package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public final class ReportPublic implements PingdomEntity {
	private static final long serialVersionUID = -9170672319763547666L;

	private Integer checkId;
	private String checkName;
	private String reportUrl;
	
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
