package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.CheckStatus;

public final class RawResults implements PingdomEntity {
	private static final long serialVersionUID = 1337764235518032289L;

	public static final class Results implements PingdomEntity {
		private static final long serialVersionUID = -1523654956707062927L;
		
		@Since(2.0) private Integer probeId;
		@Since(2.0) private Date time;
		@Since(2.0) private CheckStatus status;
		@Since(2.0) private Integer responseTime;
		@Since(2.0) private String statusDesc;
		@Since(2.0) private String statusDescLong;
		@Since(2.0) private Integer analysisId;
		
		public Integer getProbeId() {
			return this.probeId;
		}
		public Date getTime() {
			return this.time;
		}
		public CheckStatus getStatus() {
			return this.status;
		}
		public Integer getResponseTime() {
			return this.responseTime;
		}
		public String getStatusDesc() {
			return this.statusDesc;
		}
		public String getStatusDescLong() {
			return this.statusDescLong;
		}
		public Integer getAnalysisId() {
			return this.analysisId;
		}
	}
	
	@Since(2.0) private List<RawResults> results;
	@Since(2.0) private List<Integer> somethingIds;
	
	public List<RawResults> getResults() {
		return this.results;
	}
	public List<Integer> getSomethingIds() {
		return this.somethingIds;
	}
}
