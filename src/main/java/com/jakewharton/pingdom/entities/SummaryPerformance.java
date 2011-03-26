package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class SummaryPerformance implements PingdomEntity {
	private static final long serialVersionUID = 4741817235617335661L;

	public static final class Hour implements PingdomEntity {
		private static final long serialVersionUID = 8901699621396348130L;
		
		@Since(2.0) private Date startTime;
		@Since(2.0) private Integer avgResponse;
		@Since(2.0) private Integer uptime;
		@Since(2.0) private Integer downtime;
		@Since(2.0) private Integer unmonitored;
		
		/**
		 * Hour interval start.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getStartTime() {
			return this.startTime;
		}
		
		/**
		 * Average response time for this interval in milliseconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		
		/**
		 * Total uptime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUptime() {
			return this.uptime;
		}
		
		/**
		 * Total downtime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getDowntime() {
			return this.downtime;
		}
		
		/**
		 * Total unmonitored time for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}
	public static final class Day implements PingdomEntity {
		private static final long serialVersionUID = 4373734505420295307L;
		
		@Since(2.0) private Date startTime;
		@Since(2.0) private Integer avgResponse;
		@Since(2.0) private Integer uptime;
		@Since(2.0) private Integer downtime;
		@Since(2.0) private Integer unmonitored;

		/**
		 * Day interval start.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getStartTime() {
			return this.startTime;
		}
		
		/**
		 * Average response time for this interval in milliseconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		
		/**
		 * Total uptime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUptime() {
			return this.uptime;
		}
		
		/**
		 * Total downtime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getDowntime() {
			return this.downtime;
		}
		
		/**
		 * Total unmonitored time for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}
	public static final class Week implements PingdomEntity {
		private static final long serialVersionUID = -3145455384315445757L;
		
		@Since(2.0) private Date startTime;
		@Since(2.0) private Integer avgResponse;
		@Since(2.0) private Integer uptime;
		@Since(2.0) private Integer downtime;
		@Since(2.0) private Integer unmonitored;

		/**
		 * Week interval start.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getStartTime() {
			return this.startTime;
		}
		
		/**
		 * Average response time for this interval in milliseconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		
		/**
		 * Total uptime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUptime() {
			return this.uptime;
		}
		
		/**
		 * Total downtime for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getDowntime() {
			return this.downtime;
		}
		
		/**
		 * Total unmonitored time for this interval in seconds.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}

	@Since(2.0) private List<Hour> hours;
	@Since(2.0) private List<Day> days;
	@Since(2.0) private List<Week> weeks;
	
	/**
	 * List of hours.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Hour> getHours() {
		return this.hours;
	}
	
	/**
	 * List of days.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Day> getDays() {
		return this.days;
	}
	
	/**
	 * List of weeks.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Week> getWeeks() {
		return this.weeks;
	}
}
