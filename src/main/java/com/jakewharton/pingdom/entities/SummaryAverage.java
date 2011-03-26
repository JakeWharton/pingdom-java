package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom summary average object.
 */
public final class SummaryAverage implements PingdomEntity {
	private static final long serialVersionUID = 3520826935687167298L;
	
	/**
	 * Represents a Pingdom response time object.
	 */
	public static final class ResponseTime implements PingdomEntity {
		private static final long serialVersionUID = 8364849955528404640L;
		
		/**
		 * Represents a Pingdom probe response time object.
		 */
		public static final class ProbeResponseTime implements PingdomEntity {
			private static final long serialVersionUID = -3534320994889323071L;
			
			@Since(2.0) private String countryIso;
			@Since(2.0) private Integer probeId;
			@Since(2.0) private Integer avgResponse;
			
			/**
			 * Country group ISO code.
			 * 
			 * @return Value.
			 * @since 2.0
			 */
			public String getCountryIso() {
				return this.countryIso;
			}
			
			/**
			 * Probe group probe identifier.
			 * 
			 * @return Value.
			 * @since 2.0
			 */
			public Integer getProbeId() {
				return this.probeId;
			}

			/**
			 * Group average response time in milliseconds.
			 * 
			 * @return Value.
			 * @since 2.0
			 */
			public Integer getAvgResponse() {
				return this.avgResponse;
			}
		}
		
		/**
		 * Wrapper for the average response field of a {@link ResponseTime}
		 * providing either a single integer value or a list of
		 * probe-specific response times.
		 * 
		 * @author Jake Wharton <jakewharton@gmail.com>
		 */
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
			
			/**
			 * Get as single value.
			 * 
			 * @return Value.
			 */
			public Integer getSingle() {
				return this.single;
			}
			
			/**
			 * Get as list of values.
			 * 
			 * @return List of values.
			 */
			public List<ProbeResponseTime> getList() {
				return this.list;
			}
		}
		
		@Since(2.0) private Date from;
		@Since(2.0) private Date to;
		@Since(2.0) private AvgResponseWrapper avgResponse;
		
		/**
		 * Start time of period.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getFrom() {
			return this.from;
		}
		
		/**
		 * End time of period.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getTo() {
			return this.to;
		}
		
		/**
		 * Total average response time in milliseconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public AvgResponseWrapper getAvgResponse() {
			return this.avgResponse;
		}
	}
	
	/**
	 * Represents a Pingdom summary average status object.
	 */
	public static final class Status implements PingdomEntity {
		private static final long serialVersionUID = -3936926231697862075L;
		
		@Since(2.0) private Integer totalUp;
		@Since(2.0) private Integer totalDown;
		@Since(2.0) private Integer totalUnknown;
		
		/**
		 * Total uptime in seconds (Please note that the accuracy of this value
		 * is depending on your check resolution).
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getTotalUp() {
			return this.totalUp;
		}
		
		/**
		 * Total downtime in seconds (Please note that the accuracy of this
		 * value is depending on your check resolution).
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getTotalDown() {
			return this.totalDown;
		}
		
		/**
		 * Total unknown/unmonitored/paused in seconds (Please note that the
		 * accuracy of this value is depending on your check resolution. Also
		 * note that time before the check was created counts as unknown).
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getTotalUnknown() {
			return this.totalUnknown;
		}
	}
	
	@Since(2.0) private ResponseTime responseTime;
	@Since(2.0) private Status status;
	
	/**
	 * Get response time information.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public ResponseTime getResponseTime() {
		return this.responseTime;
	}
	
	/**
	 * Get status information.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Status getStatus() {
		return this.status;
	}
}
