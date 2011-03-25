package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.PublicReportMonths;

public final class Settings implements PingdomEntity {
	private static final long serialVersionUID = -6026433660169558378L;
	
	public static class Country implements PingdomEntity {
		private static final long serialVersionUID = 1903607660627351396L;
		
		@Since(2.0) private String name;
		@Since(2.0) private String iso;
		
		public String getName() {
			return this.name;
		}
		public String getIso() {
			return this.iso;
		}
	}
	public static final class TimeZone implements PingdomEntity {
		private static final long serialVersionUID = 3197864693073444070L;
		
		@Since(2.0) private String id;
		@Since(2.0) private String description;
		
		public String getId() {
			return this.id;
		}
		public String getDescription() {
			return this.description;
		}
	}
	public static final class PublicReports implements PingdomEntity {
		private static final long serialVersionUID = 2293995761282466640L;
		
		@Since(2.0) private Boolean customDesign;
		@Since(2.0) private String textColor;
		@Since(2.0) private String backgroundColor;
		@Since(2.0) private String logoUrl;
		@Since(2.0) private PublicReportMonths months;
		@Since(2.0) private Boolean showOverview;
		@Since(2.0) private String customDomain;
		
		public Boolean getCustomDesign() {
			return this.customDesign;
		}
		public String getTextColor() {
			return this.textColor;
		}
		public String getBackgroundColor() {
			return this.backgroundColor;
		}
		public String getLogoUrl() {
			return this.logoUrl;
		}
		public PublicReportMonths getMonths() {
			return this.months;
		}
		public Boolean getShowOverview() {
			return this.showOverview;
		}
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
	@Since(2.0) private String status;
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
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getCompany() {
		return this.company;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getCellPhone() {
		return this.cellPhone;
	}
	public String getAddress() {
		return this.address;
	}
	public String getAddress2() {
		return this.address2;
	}
	public String getZip() {
		return this.zip;
	}
	public String getLocation() {
		return this.location;
	}
	public String getStatus() {
		return this.status;
	}
	public Boolean getAutoLogout() {
		return this.autoLogout;
	}
	public Country getCountry() {
		return this.country;
	}
	public String getRegion() {
		return this.region;
	}
	public Date getAccountCreated() {
		return this.accountCreated;
	}
	public TimeZone getTimeZone() {
		return this.timeZone;
	}
	public String getDateFormat() {
		return this.dateFormat;
	}
	public String getTimeFormat() {
		return this.timeFormat;
	}
	public String getNumberFormat() {
		return this.numberFormat;
	}
	public String getNumberExample() {
		return this.numberExample;
	}
	public PublicReports getPublicReports() {
		return this.publicReports;
	}
}
