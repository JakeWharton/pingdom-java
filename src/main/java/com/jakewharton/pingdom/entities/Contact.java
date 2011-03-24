package com.jakewharton.pingdom.entities;

import java.util.List;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.SmsProvider;

public final class Contact implements PingdomEntity {
	private static final long serialVersionUID = -1534828012196092863L;

	private Integer id;
	private String name;
	private String cellPhone;
	private SmsProvider defaultSmsProvider;
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
	public SmsProvider getDefaultSmsProvider() {
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
