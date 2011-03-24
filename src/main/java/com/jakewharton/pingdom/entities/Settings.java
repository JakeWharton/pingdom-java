package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public class Settings implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -6026433660169558378L;
	
	public static class Country implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 1903607660627351396L;
		
		private String name;
		private String iso;
		
		public String getName() {
			return this.name;
		}
		public Country setName(String name) {
			this.name = name;
			return this;
		}
		public String getIso() {
			return this.iso;
		}
		public Country setIso(String iso) {
			this.iso = iso;
			return this;
		}
	}
	public static class TimeZone implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 3197864693073444070L;
		
		private String id;
		private String description;
		
		public String getId() {
			return this.id;
		}
		public TimeZone setId(String id) {
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
	public static class PublicReports implements PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 2293995761282466640L;
		
		public enum Months implements HasValue {
			None("none"),
			All("all"),
			Three("3");
			
			private final String value;
			
			private Months(String value) {
				this.value = value;
			}

			@Override
			public String value() {
				return this.value;
			}
			
			private static final Map<String, Months> stringToEnum = new HashMap<String, Months>();

			static {
				for (Months months : values()) {
					stringToEnum.put(months.value(), months);
				}
			}
			
			public static Months fromValue(String value) {
				return stringToEnum.get(value);
			}
		}
		
		private Boolean customDesign;
		private String textColor;
		private String backgroundColor;
		private String logoUrl;
		private Months months;
		private Boolean showOverview;
		private String customDomain;
		
		public Boolean getCustomDesign() {
			return this.customDesign;
		}
		public PublicReports setCustomDesign(Boolean customDesign) {
			this.customDesign = customDesign;
			return this;
		}
		public String getTextColor() {
			return this.textColor;
		}
		public PublicReports setTextColor(String textColor) {
			this.textColor = textColor;
			return this;
		}
		public String getBackgroundColor() {
			return this.backgroundColor;
		}
		public PublicReports setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
			return this;
		}
		public String getLogoUrl() {
			return this.logoUrl;
		}
		public PublicReports setLogoUrl(String logoUrl) {
			this.logoUrl = logoUrl;
			return this;
		}
		public Months getMonths() {
			return this.months;
		}
		public PublicReports setMonths(Months months) {
			this.months = months;
			return this;
		}
		public Boolean getShowOverview() {
			return this.showOverview;
		}
		public PublicReports setShowOverview(Boolean showOverview) {
			this.showOverview = showOverview;
			return this;
		}
		public String getCustomDomain() {
			return this.customDomain;
		}
		public PublicReports setCustomDomain(String customDomain) {
			this.customDomain = customDomain;
			return this;
		}
	}
	
	private String firstName;
	private String lastName;
	private String company;
	private String email;
	private String phone;
	private String cellPhone;
	private String address;
	private String address2;
	private String zip;
	private String location;
	private String status;
	private Boolean autoLogout;
	private Country country;
	private String region;
	private Date accountCreated;
	private TimeZone timeZone;
	private String dateFormat;
	private String timeFormat;
	private String numberFormat;
	private String numberExample;
	private PublicReports publicReports;
	
	public String getFirstName() {
		return this.firstName;
	}
	public Settings setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return this.lastName;
	}
	public Settings setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getCompany() {
		return this.company;
	}
	public Settings setCompany(String company) {
		this.company = company;
		return this;
	}
	public String getEmail() {
		return this.email;
	}
	public Settings setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPhone() {
		return this.phone;
	}
	public Settings setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getCellPhone() {
		return this.cellPhone;
	}
	public Settings setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
		return this;
	}
	public String getAddress() {
		return this.address;
	}
	public Settings setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getAddress2() {
		return this.address2;
	}
	public Settings setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	public String getZip() {
		return this.zip;
	}
	public Settings setZip(String zip) {
		this.zip = zip;
		return this;
	}
	public String getLocation() {
		return this.location;
	}
	public Settings setLocation(String location) {
		this.location = location;
		return this;
	}
	public String getStatus() {
		return this.status;
	}
	public Settings setStatus(String status) {
		this.status = status;
		return this;
	}
	public Boolean getAutoLogout() {
		return this.autoLogout;
	}
	public Settings setAutoLogout(Boolean autoLogout) {
		this.autoLogout = autoLogout;
		return this;
	}
	public Country getCountry() {
		return this.country;
	}
	public Settings setCountry(Country country) {
		this.country = country;
		return this;
	}
	public String getRegion() {
		return this.region;
	}
	public Settings setRegion(String region) {
		this.region = region;
		return this;
	}
	public Date getAccountCreated() {
		return this.accountCreated;
	}
	public Settings setAccountCreated(Date accountCreated) {
		this.accountCreated = accountCreated;
		return this;
	}
	public TimeZone getTimeZone() {
		return this.timeZone;
	}
	public Settings setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
		return this;
	}
	public String getDateFormat() {
		return this.dateFormat;
	}
	public Settings setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		return this;
	}
	public String getTimeFormat() {
		return this.timeFormat;
	}
	public Settings setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
		return this;
	}
	public String getNumberFormat() {
		return this.numberFormat;
	}
	public Settings setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
		return this;
	}
	public String getNumberExample() {
		return this.numberExample;
	}
	public Settings setNumberExample(String numberExample) {
		this.numberExample = numberExample;
		return this;
	}
	public PublicReports getPublicReports() {
		return this.publicReports;
	}
	public Settings setPublicReports(PublicReports publicReports) {
		this.publicReports = publicReports;
		return this;
	}
}
