package com.jakewharton.pingdom.entities;

import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.BannerType;

public final class ReportShared implements PingdomEntity {
	private static final long serialVersionUID = 7591271345410192470L;

	public static final class Banner implements PingdomEntity {
		private static final long serialVersionUID = -5407286248217918402L;
		
		@Since(2.0) private Integer id;
		@Since(2.0) private String name;
		@Since(2.0) private Integer checkId;
		@Since(2.0) private Boolean auto;
		@Since(2.0) private BannerType type;
		@Since(2.0) private String url;
		@Since(2.0) private Integer fromYear;
		@Since(2.0) private Integer fromMonth;
		@Since(2.0) private Integer fromDay;
		@Since(2.0) private Integer toYear;
		@Since(2.0) private Integer toMonth;
		@Since(2.0) private Integer toDay;
		
		/**
		 * Banner identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getId() {
			return this.id;
		}
		
		/**
		 * Banner name
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * Check identifier
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getCheckId() {
			return this.checkId;
		}
		
		/**
		 * Automatic period activated?
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getAuto() {
			return this.auto;
		}
		
		/**
		 * Banner type
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public BannerType getType() {
			return this.type;
		}
		
		/**
		 * Banner URL.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUrl() {
			return this.url;
		}
		
		/**
		 * Period start: year.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getFromYear() {
			return this.fromYear;
		}
		
		/**
		 * Period start: month
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getFromMonth() {
			return this.fromMonth;
		}
		
		/**
		 * Period start: day.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getFromDay() {
			return this.fromDay;
		}
		
		/**
		 * Period end: year.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getToYear() {
			return this.toYear;
		}
		
		/**
		 * Period end: month.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getToMonth() {
			return this.toMonth;
		}
		
		/**
		 * Period end: day.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getToDay() {
			return this.toDay;
		}
	}

	@Since(2.0) public List<Banner> banners;
	
	/**
	 * Get a list of banners.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Banner> getBanners() {
		return this.banners;
	}
}
