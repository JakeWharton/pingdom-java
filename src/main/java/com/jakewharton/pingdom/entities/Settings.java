package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class Settings implements PingdomEntity {
	private static final long serialVersionUID = -6026433660169558378L;
	
	public static class Country implements PingdomEntity {
		private static final long serialVersionUID = 1903607660627351396L;
		
		private String name;
		private String iso;
		
		public String getName() {
			return this.name;
		}
		public String getIso() {
			return this.iso;
		}
	}
	public static final class TimeZone implements PingdomEntity {
		private static final long serialVersionUID = 3197864693073444070L;
		
		private String id;
		private String description;
		
		public String getId() {
			return this.id;
		}
		public String getDescription() {
			return this.description;
		}
	}
	public static final class PublicReports implements PingdomEntity {
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
		public String getTextColor() {
			return this.textColor;
		}
		public String getBackgroundColor() {
			return this.backgroundColor;
		}
		public String getLogoUrl() {
			return this.logoUrl;
		}
		public Months getMonths() {
			return this.months;
		}
		public Boolean getShowOverview() {
			return this.showOverview;
		}
		public String getCustomDomain() {
			return this.customDomain;
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
