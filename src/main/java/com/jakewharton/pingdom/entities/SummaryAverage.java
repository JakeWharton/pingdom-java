package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.jakewharton.pingdom.PingdomEntity;

public class SummaryAverage implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 3520826935687167298L;
	
	public static final class ResponseTime implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 8364849955528404640L;
		
		public static final class ProbeResponseTime implements PingdomEntity {
			/**
			 * Serial Version UID.
			 */
			private static final long serialVersionUID = -3534320994889323071L;
			
			private String countryIso;
			private Integer probeId;
			private Integer avgResponse;
			
			public String getCountryIso() {
				return this.countryIso;
			}
			public ProbeResponseTime setCountryIso(String countryIso) {
				this.countryIso = countryIso;
				return this;
			}
			public Integer getProbeId() {
				return this.probeId;
			}
			public ProbeResponseTime setProbeId(Integer probeId) {
				this.probeId = probeId;
				return this;
			}
			public Integer getAvgResponse() {
				return this.avgResponse;
			}
			public ProbeResponseTime setAvgResponse(Integer avgResponse) {
				this.avgResponse = avgResponse;
				return this;
			}
		}
		
		private Date from;
		private Date to;
		private Integer avgResponse;
		//private List<ProbeResponseTime> avgResponse;
		
		public Date getFrom() {
			return this.from;
		}
		public ResponseTime setFrom(Date from) {
			this.from = from;
			return this;
		}
		public Date getTo() {
			return this.to;
		}
		public ResponseTime setTo(Date to) {
			this.to = to;
			return this;
		}
		public Integer getAvgResponse() {
			return this.avgResponse;
		}
		public ResponseTime setAvgResponse(Integer avgResponse) {
			this.avgResponse = avgResponse;
			return this;
		}
	}
	public static final class Status implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = -3936926231697862075L;
		
		private Integer totalUp;
		private Integer totalDown;
		private Integer totalUnknown;
		
		public Integer getTotalUp() {
			return this.totalUp;
		}
		public Status setTotalUp(Integer totalUp) {
			this.totalUp = totalUp;
			return this;
		}
		public Integer getTotalDown() {
			return this.totalDown;
		}
		public Status setTotalDown(Integer totalDown) {
			this.totalDown = totalDown;
			return this;
		}
		public Integer getTotalUnknown() {
			return this.totalUnknown;
		}
		public Status setTotalUnknown(Integer totalUnknown) {
			this.totalUnknown = totalUnknown;
			return this;
		}
	}
	
	private ResponseTime responseTime;
	private Status status;
	
	public ResponseTime getResponseTime() {
		return this.responseTime;
	}
	public SummaryAverage setResponseTime(ResponseTime responseTime) {
		this.responseTime = responseTime;
		return this;
	}
	public Status getStatus() {
		return this.status;
	}
	public SummaryAverage setStatus(Status status) {
		this.status = status;
		return this;
	}
}
