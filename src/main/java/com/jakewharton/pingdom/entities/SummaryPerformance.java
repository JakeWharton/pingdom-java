package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class SummaryPerformance implements PingdomEntity {
	private static final long serialVersionUID = 4741817235617335661L;
	
	public enum Resolution implements HasValue {
		Hour("hour"),
		Day("day"),
		Week("week");
		
		private final String value;
		
		private Resolution(String value) {
			this.value = value;
		}

		@Override
		public String value() {
			return this.value;
		}
		
		private static final Map<String, Resolution> stringToEnum = new HashMap<String, Resolution>();

		static {
			for (Resolution resolution : values()) {
				stringToEnum.put(resolution.value(), resolution);
			}
		}
		
		public static Resolution fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	public static final class Hour implements PingdomEntity {
		private static final long serialVersionUID = 8901699621396348130L;
		
		private Date startTime;
		private Integer avgResponse;
		private Integer uptime;
		private Integer downtime;
		private Integer unmonitored;
		
		public Date getStartTime() {
			return this.startTime;
		}
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		public Integer getUptime() {
			return this.uptime;
		}
		public Integer getDowntime() {
			return this.downtime;
		}
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}
	public static final class Day implements PingdomEntity {
		private static final long serialVersionUID = 4373734505420295307L;
		
		private Date startTime;
		private Integer avgResponse;
		private Integer uptime;
		private Integer downtime;
		private Integer unmonitored;
		
		public Date getStartTime() {
			return this.startTime;
		}
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		public Integer getUptime() {
			return this.uptime;
		}
		public Integer getDowntime() {
			return this.downtime;
		}
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}
	public static final class Week implements PingdomEntity {
		private static final long serialVersionUID = -3145455384315445757L;
		
		private Date startTime;
		private Integer avgResponse;
		private Integer uptime;
		private Integer downtime;
		private Integer unmonitored;
		
		public Date getStartTime() {
			return this.startTime;
		}
		public Integer getAverageResponse() {
			return this.avgResponse;
		}
		public Integer getUptime() {
			return this.uptime;
		}
		public Integer getDowntime() {
			return this.downtime;
		}
		public Integer getUnmonitored() {
			return this.unmonitored;
		}
	}

	private List<Hour> hours;
	private List<Day> days;
	private List<Week> weeks;
	
	public List<Hour> getHours() {
		return this.hours;
	}
	public List<Day> getDays() {
		return this.days;
	}
	public List<Week> getWeeks() {
		return this.weeks;
	}
}
