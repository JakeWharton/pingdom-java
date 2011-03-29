package com.jakewharton.pingdom.services;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Message;
import com.jakewharton.pingdom.entities.Reference;
import com.jakewharton.pingdom.entities.Settings;
import com.jakewharton.pingdom.enumerations.PublicReportMonths;

/**
 * Represents Pingdom's remote settings service.
 */
public class SettingsService extends PingdomApiService {
	/**
	 * Returns all account-specific settings.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get() {
		return new GetBuilder(this);
	}

	/**
	 * Request builder for {@link SettingsService#get()}.
	 */
	public static final class GetBuilder extends PingdomApiBuilder<Settings> {
		private static final String URI = "/settings";
		
		private GetBuilder(SettingsService service) {
			super(service, new TypeToken<Settings>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("settings");
		}
	}
	
	/**
	 * Modify account-specific settings.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ModifyBuilder modify() {
		return new ModifyBuilder(this);
	}

	/**
	 * Request builder for {@link SettingsService#modify()}.
	 */
	public static final class ModifyBuilder extends PingdomApiBuilder<Message> {
		private static final String POST_FIRST_NAME = "firstname";
		private static final String POST_LAST_NAME = "lastname";
		private static final String POST_COMPANY = "company";
		private static final String POST_EMAIL = "email";
		private static final String POST_CELL_PHONE = "cellphone";
		private static final String POST_CELL_COUNTRY_CODE = "cellcountrycode";
		private static final String POST_CELL_COUNTRY_ISO = "cellcountryiso";
		private static final String POST_PHONE = "phone";
		private static final String POST_PHONE_COUNTRY_CODE = "phonecountrycode";
		private static final String POST_PHONE_COUNTRY_ISO = "phonecountryiso";
		private static final String POST_ADDRESS = "address";
		private static final String POST_ADDRESS_2 = "address2";
		private static final String POST_ZIP = "zip";
		private static final String POST_LOCATION = "location";
		private static final String POST_STATE = "state";
		private static final String POST_AUTO_LOGOUT = "autologout";
		private static final String POST_REGION_ID = "regionid";
		private static final String POST_TIME_ZONE_ID = "timezoneid";
		private static final String POST_DATE_TIME_FORMAT_ID = "datetimeformatid";
		private static final String POST_NUMBER_FORMAT_ID = "numberformatid";
		private static final String POST_PUBLIC_REPORT_CUSTOM_DESIGN = "pubrcustomdesign";
		private static final String POST_PUBLIC_REPORT_TEXT_COLOR = "pubrtextcolor";
		private static final String POST_PUBLIC_REPORT_BACKGROUND_COLOR = "pubrbackgroundcolor";
		private static final String POST_PUBLIC_REPORT_LOGO_URL = "pubrlogourl";
		private static final String POST_PUBLIC_REPORT_MONTHS = "pubrmonths";
		private static final String POST_PUBLIC_REPORT_SHOW_OVERVIEW = "pubrshowoverview";
		private static final String POST_PUBLIC_REPORT_CUSTOM_DOMAIN = "pubrcustomdomain";
		
		private static final String URI = "/settings";
		
		private ModifyBuilder(SettingsService service) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Put);
		}
		
		/**
		 * First name.
		 * 
		 * @param firstName Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder firstName(String firstName) {
			this.postParameter(POST_FIRST_NAME, firstName);
			return this;
		}
		
		/**
		 * Last name.
		 * 
		 * @param lastName Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder lastName(String lastName) {
			this.postParameter(POST_LAST_NAME, lastName);
			return this;
		}
		
		/**
		 * Company.
		 * 
		 * @param company Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder company(String company) {
			this.postParameter(POST_COMPANY, company);
			return this;
		}
		
		/**
		 * <p>Email.</p>
		 * 
		 * <p><strong>NOTE:</strong> Your email is used for authentication
		 * purposes such as using this API or logging into the Pingdom
		 * Panel.</p>
		 * 
		 * @param email Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder email(String email) {
			this.postParameter(POST_EMAIL, email);
			return this;
		}
		
		/**
		 * <p>Cellphone (without country code).</p>
		 * 
		 * <p>(Requires {@link #cellCountryCode(String)} and
		 * {@link #cellCountryIso(String)})</p>
		 * 
		 * @param cellPhone Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder cellPhone(String cellPhone) {
			this.postParameter(POST_CELL_PHONE, cellPhone);
			return this;
		}
		
		/**
		 * Cellphone country code.
		 * 
		 * @param cellCountryCode Value (example: 1 (USA) or 46 (Sweden)).
		 * @return Builder instance.
		 */
		public ModifyBuilder cellCountryCode(String cellCountryCode) {
			this.postParameter(POST_CELL_COUNTRY_CODE, cellCountryCode);
			return this;
		}
		
		/**
		 * Cellphone country ISO code.
		 * 
		 * @param cellCountryIso Value (example: US (USA) or SE (Sweden)).
		 * @return Builder instance.
		 */
		public ModifyBuilder cellCountryIso(String cellCountryIso) {
			this.postParameter(POST_CELL_COUNTRY_ISO, cellCountryIso);
			return this;
		}
		
		/**
		 * <p>Phone (without country code).</p>
		 * 
		 * <p>(Requires {@link #phoneCountryCode(String)} and
		 * {@link #phoneCountryIso(String)})</p>
		 * 
		 * @param phone Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder phone(String phone) {
			this.postParameter(POST_PHONE, phone);
			return this;
		}
		
		/**
		 * Phone country code.
		 * 
		 * @param phoneCountryCode Value (example: 1 (USA) or 46 (Sweden)).
		 * @return Builder instance.
		 */
		public ModifyBuilder phoneCountryCode(String phoneCountryCode) {
			this.postParameter(POST_PHONE_COUNTRY_CODE, phoneCountryCode);
			return this;
		}
		
		/**
		 * Phone country ISO code.
		 * 
		 * @param phoneCountryIso Value (example: US (USA) or SE (Sweden)).
		 * @return Builder instance.
		 */
		public ModifyBuilder phoneCountryIso(String phoneCountryIso) {
			this.postParameter(POST_PHONE_COUNTRY_ISO, phoneCountryIso);
			return this;
		}
		
		/**
		 * Address line 1.
		 * 
		 * @param address Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder address(String address) {
			this.postParameter(POST_ADDRESS, address);
			return this;
		}
		
		/**
		 * Address line 2.
		 * 
		 * @param address2 Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder address2(String address2) {
			this.postParameter(POST_ADDRESS_2, address2);
			return this;
		}
		
		/**
		 * Zip, postal code, or equivalent.
		 * 
		 * @param zip Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder zip(String zip) {
			this.postParameter(POST_ZIP, zip);
			return this;
		}
		
		/**
		 * City / location.
		 * 
		 * @param location Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder location(String location) {
			this.postParameter(POST_LOCATION, location);
			return this;
		}
		
		/**
		 * State, province, or equivalent.
		 * 
		 * @param state Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder state(String state) {
			this.postParameter(POST_STATE, state);
			return this;
		}
		
		/**
		 * Enable auto-logout.
		 * 
		 * @param autoLogout Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder autoLogout(boolean autoLogout) {
			this.postParameter(POST_AUTO_LOGOUT, autoLogout);
			return this;
		}
		
		/**
		 * Region identifier.
		 * 
		 * @param regionId Value.
		 * @return Builder instance.
		 * @see Reference#getRegions()
		 */
		public ModifyBuilder regionId(int regionId) {
			this.postParameter(POST_REGION_ID, regionId);
			return this;
		}
		
		/**
		 * Time zone identifier.
		 * 
		 * @param timeZoneId Value.
		 * @return Builder instance.
		 * @see Reference#getTimeZones()
		 */
		public ModifyBuilder timeZoneId(int timeZoneId) {
			this.postParameter(POST_TIME_ZONE_ID, timeZoneId);
			return this;
		}
		
		/**
		 * Date/time format identifier.
		 * 
		 * @param dateTimeFormatId Value.
		 * @return Builder instance.
		 * @see Reference#getDateTimeFormats()
		 */
		public ModifyBuilder dateTimeFormatId(int dateTimeFormatId) {
			this.postParameter(POST_DATE_TIME_FORMAT_ID, dateTimeFormatId);
			return this;
		}
		
		/**
		 * Number format identifier.
		 * 
		 * @param numberFormatId Value.
		 * @return Builder instance.
		 * @see Reference#getNumberFormats()
		 */
		public ModifyBuilder numberFormatId(int numberFormatId) {
			this.postParameter(POST_NUMBER_FORMAT_ID, numberFormatId);
			return this;
		}
		
		/**
		 * Use custom design for public reports.
		 * 
		 * @param publicReportCustomDesign Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportCustomDesign(boolean publicReportCustomDesign) {
			this.postParameter(POST_PUBLIC_REPORT_CUSTOM_DESIGN, publicReportCustomDesign);
			return this;
		}
		
		/**
		 * Public reports, custom text color.
		 * 
		 * @param publicReportTextColor Value (example: FEFFFE or 99CC00).
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportTextColor(String publicReportTextColor) {
			this.postParameter(POST_PUBLIC_REPORT_TEXT_COLOR, publicReportTextColor);
			return this;
		}
		
		/**
		 * Public reports, background color.
		 * 
		 * @param publicReportBackgroundColor Value (example: FEFFFE or 99CC00).
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportBackgroundColor(String publicReportBackgroundColor) {
			this.postParameter(POST_PUBLIC_REPORT_BACKGROUND_COLOR, publicReportBackgroundColor);
			return this;
		}
		
		/**
		 * Public reports, URL to custom logotype.
		 * 
		 * @param publicReportLogoUrl Value (example: stats.pingdom.com/images/logo.png).
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportLogoUrl(String publicReportLogoUrl) {
			this.postParameter(POST_PUBLIC_REPORT_LOGO_URL, publicReportLogoUrl);
			return this;
		}
		
		/**
		 * Public reports, number of months to show.
		 * 
		 * @param publicReportsMonths Value (none, all, 3).
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportMonths(PublicReportMonths publicReportsMonths) {
			this.postParameter(POST_PUBLIC_REPORT_MONTHS, publicReportsMonths);
			return this;
		}
		
		/**
		 * Public reports, enable overview.
		 * 
		 * @param publicReportsShowOverview Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportShowOverview(boolean publicReportsShowOverview) {
			this.postParameter(POST_PUBLIC_REPORT_SHOW_OVERVIEW, publicReportsShowOverview);
			return this;
		}
		
		/**
		 * <p>Public reports, custom domain.</p>
		 * 
		 * <p>Must be a DNS CNAME with target stats.pingdom.com.</p>
		 * 
		 * @param publicReportsCustomDomain Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder publicReportCustomDomain(String publicReportsCustomDomain) {
			this.postParameter(POST_PUBLIC_REPORT_CUSTOM_DOMAIN, publicReportsCustomDomain);
			return this;
		}
	}
}
