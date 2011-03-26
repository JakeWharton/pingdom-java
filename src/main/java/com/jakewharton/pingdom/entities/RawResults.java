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
		 * Time when test was performed.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getTime() {
			return this.time;
		}
		
		/**
		 * Result status.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public CheckStatus getStatus() {
			return this.status;
		}
		
		/**
		 * Response time (in milliseconds) (Will be 0 if no response was received).
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getResponseTime() {
			return this.responseTime;
		}
		
		/**
		 * Short status description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStatusDesc() {
			return this.statusDesc;
		}
		
		/**
		 * Long status description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStatusDescLong() {
			return this.statusDescLong;
		}
		
		/**
		 * Analysis identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getAnalysisId() {
			return this.analysisId;
		}
	}
	
	@Since(2.0) private List<RawResults> results;
	@Since(2.0) private List<Integer> somethingIds;
	
	/**
	 * List of raw result data.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<RawResults> getResults() {
		return this.results;
	}
	
	/**
	 * For your convinience, a list of used probes that produced the showed
	 * results.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public List<Integer> getSomethingIds() {
		return this.somethingIds;
	}
}
