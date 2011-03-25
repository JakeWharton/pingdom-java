package com.jakewharton.pingdom.entities;

import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.SmsProvider;

public final class Contact implements PingdomEntity {
	private static final long serialVersionUID = -1534828012196092863L;

	@Since(2.0) private Integer id;
	@Since(2.0) private String name;
	@Since(2.0) private String cellPhone;
	@Since(2.0) private SmsProvider defaultSmsProvider;
	@Since(2.0) private Boolean directTwitter;
	@Since(2.0) private String twitterUser;
	@Since(2.0) private List<String> iPhoneTokens;
	@Since(2.0) private Boolean paused;
	
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
