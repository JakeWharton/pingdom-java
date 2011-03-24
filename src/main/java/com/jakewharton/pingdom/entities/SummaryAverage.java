package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.jakewharton.pingdom.PingdomEntity;

public final class SummaryAverage implements PingdomEntity {
	private static final long serialVersionUID = 3520826935687167298L;
	
	public static final class ResponseTime implements PingdomEntity {
		private static final long serialVersionUID = 8364849955528404640L;
		
		public static final class ProbeResponseTime implements PingdomEntity {
			private static final long serialVersionUID = -3534320994889323071L;
			
			private String countryIso;
			private Integer probeId;
			private Integer avgResponse;
			
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
		
		private Date from;
		private Date to;
		private Integer avgResponse;
		//private List<ProbeResponseTime> avgResponse;
		
		public Date getFrom() {
			return this.from;
		}
		public Date getTo() {
			return this.to;
		}
		public Integer getAvgResponse() {
			return this.avgResponse;
		}
	}
	public static final class Status implements PingdomEntity {
		private static final long serialVersionUID = -3936926231697862075L;
		
		private Integer totalUp;
		private Integer totalDown;
		private Integer totalUnknown;
		
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
	
	private ResponseTime responseTime;
	private Status status;
	
	public ResponseTime getResponseTime() {
		return this.responseTime;
	}
	public Status getStatus() {
		return this.status;
	}
}
