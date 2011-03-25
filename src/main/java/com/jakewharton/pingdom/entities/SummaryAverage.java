package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class SummaryAverage implements PingdomEntity {
	private static final long serialVersionUID = 3520826935687167298L;
	
	public static final class ResponseTime implements PingdomEntity {
		private static final long serialVersionUID = 8364849955528404640L;
		
		public static final class ProbeResponseTime implements PingdomEntity {
			private static final long serialVersionUID = -3534320994889323071L;
			
			@Since(2.0) private String countryIso;
			@Since(2.0) private Integer probeId;
			@Since(2.0) private Integer avgResponse;
			
			public String getCountryIso() {
				return this.countryIso;
			}
			public Integer getProbeId() {
				return this.probeId;
			}
			public Integer getAvgResponse() {
				return this.avgResponse;
			}
		}
		
		public static final class AvgResponseWrapper {
			private final Integer single;
			private final List<ProbeResponseTime> list;
			
			public AvgResponseWrapper(int avgResponse) {
				this.single = avgResponse;
				this.list = null;
			}
			public AvgResponseWrapper(List<ProbeResponseTime> avgResponses) {
				this.single = null;
				this.list = avgResponses;
			}
			
			public Integer getSingle() {
				return this.single;
			}
			public List<ProbeResponseTime> getList() {
				return this.list;
			}
		}
		
		@Since(2.0) private Date from;
		@Since(2.0) private Date to;
		@Since(2.0) private AvgResponseWrapper avgResponse;
		
		public Date getFrom() {
			return this.from;
		}
		public Date getTo() {
			return this.to;
		}
		public AvgResponseWrapper getAvgResponse() {
			return this.avgResponse;
		}
	}
	public static final class Status implements PingdomEntity {
		private static final long serialVersionUID = -3936926231697862075L;
		
		@Since(2.0) private Integer totalUp;
		@Since(2.0) private Integer totalDown;
		@Since(2.0) private Integer totalUnknown;
		
		public Integer getTotalUp() {
			return this.totalUp;
		}
		public Integer getTotalDown() {
			return this.totalDown;
		}
		public Integer getTotalUnknown() {
			return this.totalUnknown;
		}
	}
	
	@Since(2.0) private ResponseTime responseTime;
	@Since(2.0) private Status status;
	
	public ResponseTime getResponseTime() {
		return this.responseTime;
	}
	public Status getStatus() {
		return this.status;
	}
}
