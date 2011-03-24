package com.jakewharton.pingdom.entities;

import java.util.List;
import com.jakewharton.pingdom.PingdomEntity;

public class Reference implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1520773720748154146L;

	public static class Region implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 724802908814038335L;
		
		private Integer id;
		private String description;
		
		public Integer getId() {
			return this.id;
		}
		public Region setId(Integer id) {
			this.id = id;
			return this;
		}
		public String getDescription() {
			return this.description;
		}
		public Region setDescription(String description) {
			this.description = description;
			return this;
		}
	}
	public static class TimeZone implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 120109984053431615L;
		
		private Integer id;
		private String description;
		
		public Integer getId() {
			return this.id;
		}
		public TimeZone setId(Integer id) {
			this.id = id;
			return this;
		}
		public String getDescription() {
			return this.description;
		}
		public TimeZone setDescription(String description) {
			this.description = description;
			return this;
		}
	}
	public static class DateTimeFormat implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 7727285130594582813L;
		
		private Integer id;
		private String description;
		
		public Integer getId() {
			return this.id;
		}
		public DateTimeFormat setId(Integer id) {
			this.id = id;
			return this;
		}
		public String getDescription() {
			return this.description;
		}
		public DateTimeFormat setDescription(String description) {
			this.description = description;
			return this;
		}
	}
	public static class NumberFormat implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 5715785072740352075L;
		
		private Integer id;
		private String description;
		
		public Integer getId() {
			return this.id;
		}
		public NumberFormat setId(Integer id) {
			this.id = id;
			return this;
		}
		public String getDescription() {
			return this.description;
		}
		public NumberFormat setDescription(String description) {
			this.description = description;
			return this;
		}
	}
	
	private List<Region> regions;
	private List<TimeZone> timeZones;
	private List<DateTimeFormat> dateTimeFormats;
	private List<NumberFormat> numberFormats;
	
	public List<Region> getRegions() {
		return this.regions;
	}
	public Reference setRegions(List<Region> regions) {
		this.regions = regions;
		return this;
	}
	public List<TimeZone> getTimeZones() {
		return this.timeZones;
	}
	public Reference setTimeZones(List<TimeZone> timeZones) {
		this.timeZones = timeZones;
		return this;
	}
	public List<DateTimeFormat> getDateTimeFormats() {
		return this.dateTimeFormats;
	}
	public Reference setDateTimeFormats(List<DateTimeFormat> dateTimeFormats) {
		this.dateTimeFormats = dateTimeFormats;
		return this;
	}
	public List<NumberFormat> getNumberFormats() {
		return this.numberFormats;
	}
	public Reference setNumberFormats(List<NumberFormat> numberFormats) {
		this.numberFormats = numberFormats;
		return this;
	}
}
