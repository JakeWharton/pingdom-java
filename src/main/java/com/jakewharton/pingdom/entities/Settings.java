package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.PublicReportMonths;

/**
 * Represents a Pingdom settings object.
 */
public final class Settings implements PingdomEntity {
	private static final long serialVersionUID = -6026433660169558378L;
	
	/**
	 * Represents a Pingdom country object.
	 */
	public static class Country implements PingdomEntity {
		private static final long serialVersionUID = 1903607660627351396L;
		
		@Since(2.0) private String name;
		@Since(2.0) private String iso;
		
		/**
		 * Country name.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * Country ISO-code.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getIso() {
			return this.iso;
		}
	}
	
	/**
	 * Represents a Pingdom time zone object.
	 */
	public static final class TimeZone implements PingdomEntity {
		private static final long serialVersionUID = 3197864693073444070L;
		
		@Since(2.0) private String id;
		@Since(2.0) private String description;
		
		/**
		 * Time zone identifier.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getId() {
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
	
	/**
	 * Represents a Pingdom public report settings object.
	 */
	public static final class PublicReports implements PingdomEntity {
		private static final long serialVersionUID = 2293995761282466640L;
		
		@Since(2.0) private Boolean customDesign;
		@Since(2.0) private String textColor;
		@Since(2.0) private String backgroundColor;
		@Since(2.0) private String logoUrl;
		@Since(2.0) private PublicReportMonths months;
		@Since(2.0) private Boolean showOverview;
		@Since(2.0) private String customDomain;
		
		/**
		 * Use custom design for public reports.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getCustomDesign() {
			return this.customDesign;
		}
		
		/**
		 * Custom text color.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getTextColor() {
			return this.textColor;
		}
		
		/**
		 * Background color.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getBackgroundColor() {
			return this.backgroundColor;
		}
		
		/**
		 * URL to custom logotype.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getLogoUrl() {
			return this.logoUrl;
		}
		
		/**
		 * Number of months to show.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public PublicReportMonths getMonths() {
			return this.months;
		}
		
		/**
		 * Enable overview.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getShowOverview() {
			return this.showOverview;
		}
		
		/**
		 * Custom domain.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getCustomDomain() {
			return this.customDomain;
		}
	}
	
	@Since(2.0) private String firstName;
	@Since(2.0) private String lastName;
	@Since(2.0) private String company;
	@Since(2.0) private String email;
	@Since(2.0) private String phone;
	@Since(2.0) private String cellPhone;
	@Since(2.0) private String address;
	@Since(2.0) private String address2;
	@Since(2.0) private String zip;
	@Since(2.0) private String location;
	@Since(2.0) private String state;
	@Since(2.0) private Boolean autoLogout;
	@Since(2.0) private Country country;
	@Since(2.0) private String region;
	@Since(2.0) private Date accountCreated;
	@Since(2.0) private TimeZone timeZone;
	@Since(2.0) private String dateFormat;
	@Since(2.0) private String timeFormat;
	@Since(2.0) private String numberFormat;
	@Since(2.0) private String numberExample;
	@Since(2.0) private PublicReports publicReports;
	
	/**
	 * First name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Last name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Company.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Email.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Phone.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Cellphone.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCellPhone() {
		return this.cellPhone;
	}
	
	/**
	 * Address line 1.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Address line 2.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getAddress2() {
		return this.address2;
	}
	
	/**
	 * Zip, postal code, or equivalent.
	 * 
	 * @return Value
	 * @since 2.0
	 */
	public String getZip() {
		return this.zip;
	}
	
	/**
	 * City / location.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * State or equivalent.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getState() {
		return this.state;
	}
	
	/**
	 * Enable auto-logout.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getAutoLogout() {
		return this.autoLogout;
	}
	
	/**
	 * Country.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Country getCountry() {
		return this.country;
	}
	
	/**
	 * Region.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Account creation timestamp.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getAccountCreated() {
		return this.accountCreated;
	}
	
	/**
	 * Time zone.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public TimeZone getTimeZone() {
		return this.timeZone;
	}
	
	/**
	 * Date format.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getDateFormat() {
		return this.dateFormat;
	}
	
	/**
	 * Time format.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getTimeFormat() {
		return this.timeFormat;
	}
	
	/**
	 * Number format.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getNumberFormat() {
		return this.numberFormat;
	}
	
	/**
	 * Example of number presentation.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getNumberExample() {
		return this.numberExample;
	}
	
	/**
	 * Public reports settings.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public PublicReports getPublicReports() {
		return this.publicReports;
	}
}
