package com.jakewharton.pingdom.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class Contact implements PingdomEntity {
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
	public String getName() {
		return this.name;
	}
	public String getCellPhone() {
		return this.cellPhone;
	}
	public DefaultSmsProvider getDefaultSmsProvider() {
		return this.defaultSmsProvider;
	}
	public Boolean getDirectTwitter() {
		return this.directTwitter;
	}
	public String getTwitterUser() {
		return this.twitterUser;
	}
	public List<String> getiPhoneTokens() {
		return this.iPhoneTokens;
	}
	public Boolean getPaused() {
		return this.paused;
	}
}
