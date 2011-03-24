package com.jakewharton.pingdom.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public class Contact implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1534828012196092863L;
	
	public enum DefaultSmsProvider implements HasValue {
		Clickatell("clickatell"),
		BulkSms("bulksms"),
		Esendex("esendex"),
		CellSynt("cellsynt");
		
		private final String value;
		
		private DefaultSmsProvider(String value) {
			this.value = value;
		}

		@Override
		public String value() {
			return this.value;
		}
		
		private static final Map<String, DefaultSmsProvider> stringToEnum = new HashMap<String, DefaultSmsProvider>();

		static {
			for (DefaultSmsProvider defaultSmsProvider : values()) {
				stringToEnum.put(defaultSmsProvider.value(), defaultSmsProvider);
			}
		}
		
		public static DefaultSmsProvider fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	private Integer id;
	private String name;
	private String cellPhone;
	private DefaultSmsProvider defaultSmsProvider;
	private Boolean directTwitter;
	private String twitterUser;
	private List<String> iPhoneTokens;
	private Boolean paused;
	
	public Integer getId() {
		return this.id;
	}
	public Contact setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return this.name;
	}
	public Contact setName(String name) {
		this.name = name;
		return this;
	}
	public String getCellPhone() {
		return this.cellPhone;
	}
	public Contact setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
		return this;
	}
	public DefaultSmsProvider getDefaultSmsProvider() {
		return this.defaultSmsProvider;
	}
	public Contact setDefaultSmsProvider(DefaultSmsProvider defaultSmsProvider) {
		this.defaultSmsProvider = defaultSmsProvider;
		return this;
	}
	public Boolean getDirectTwitter() {
		return this.directTwitter;
	}
	public Contact setDirectTwitter(Boolean directTwitter) {
		this.directTwitter = directTwitter;
		return this;
	}
	public String getTwitterUser() {
		return this.twitterUser;
	}
	public Contact setTwitterUser(String twitterUser) {
		this.twitterUser = twitterUser;
		return this;
	}
	public List<String> getiPhoneTokens() {
		return this.iPhoneTokens;
	}
	public Contact setiPhoneTokens(List<String> iPhoneTokens) {
		this.iPhoneTokens = iPhoneTokens;
		return this;
	}
	public Boolean getPaused() {
		return this.paused;
	}
	public Contact setPaused(Boolean paused) {
		this.paused = paused;
		return this;
	}
}
