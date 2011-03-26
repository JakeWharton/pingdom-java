package com.jakewharton.pingdom.entities;

import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class Reference implements PingdomEntity {
	private static final long serialVersionUID = 1520773720748154146L;

	public static final class Region implements PingdomEntity {
		private static final long serialVersionUID = 724802908814038335L;
		
		@Since(2.0) private Integer id;
		@Since(2.0) private String description;
		
		/**
		 * Region identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getId() {
			return this.id;
		}
		
		/**
		 * Region description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getDescription() {
			return this.description;
		}
	}
	public static final class TimeZone implements PingdomEntity {
		private static final long serialVersionUID = 120109984053431615L;
		
		@Since(2.0) private Integer id;
		@Since(2.0) private String description;
		
		/**
		 * Time zone identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getId() {
			return this.id;
		}
		
		/**
		 * Time zone description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getDescription() {
			return this.description;
		}
	}
	public static final class DateTimeFormat implements PingdomEntity {
		private static final long serialVersionUID = 7727285130594582813L;
		
		@Since(2.0) private Integer id;
		@Since(2.0) private String description;
		
		/**
		 * Date/time format identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getId() {
			return this.id;
		}
		
		/**
		 * Date/time format description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getDescription() {
			return this.description;
		}
	}
	public static final class NumberFormat implements PingdomEntity {
		private static final long serialVersionUID = 5715785072740352075L;
		
		@Since(2.0) private Integer id;
		@Since(2.0) private String description;
		
		/**
		 * Number format identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getId() {
			return this.id;
		}
		
		/**
		 * Number format description.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getDescription() {
			return this.description;
		}
	}
	
	@Since(2.0) private List<Region> regions;
	@Since(2.0) private List<TimeZone> timeZones;
	@Since(2.0) private List<DateTimeFormat> dateTimeFormats;
	@Since(2.0) private List<NumberFormat> numberFormats;
	
	/**
	 * Get a list of regions.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Region> getRegions() {
		return this.regions;
	}
	
	/**
	 * Get a list of time zones.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<TimeZone> getTimeZones() {
		return this.timeZones;
	}
	
	/**
	 * Get a list of date/time formats.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<DateTimeFormat> getDateTimeFormats() {
		return this.dateTimeFormats;
	}
	
	/**
	 * Get a list of number formats.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<NumberFormat> getNumberFormats() {
		return this.numberFormats;
	}
}
