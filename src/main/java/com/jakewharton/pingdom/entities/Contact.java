package com.jakewharton.pingdom.entities;

import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.SmsProvider;

/**
 * Represents a Pingdom contact object.
 */
public final class Contact implements PingdomEntity {
	private static final long serialVersionUID = -1534828012196092863L;

	@Since(2.0) private Integer id;
	@Since(2.0) private String name;
	@Since(2.0) private String email;
	@Since(2.0) private String cellPhone;
	@Since(2.0) private SmsProvider defaultSmsProvider;
	@Since(2.0) private Boolean directTwitter;
	@Since(2.0) private String twitterUser;
	@Since(2.0) private List<String> iPhoneTokens;
	@Since(2.0) private Boolean paused;
	
	/**
	 * Contact identifier.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Contact name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Contact email.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Contact cellphone.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCellPhone() {
		return this.cellPhone;
	}
	
	/**
	 * Default SMS provider.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public SmsProvider getDefaultSmsProvider() {
		return this.defaultSmsProvider;
	}
	
	/**
	 * Send Twitter messages as Direct Messages.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getDirectTwitter() {
		return this.directTwitter;
	}
	
	/**
	 * Twitter username.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getTwitterUser() {
		return this.twitterUser;
	}
	
	/**
	 * iPhone tokens.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<String> getiPhoneTokens() {
		return this.iPhoneTokens;
	}
	
	/**
	 * True if contact is paused.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getPaused() {
		return this.paused;
	}
}
