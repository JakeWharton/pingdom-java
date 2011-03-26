package com.jakewharton.pingdom.entities;

import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class ReportSubscription implements PingdomEntity {
	private static final long serialVersionUID = -3601535119841289488L;

	@Since(2.0) private Integer id;
	@Since(2.0) private String name;
	@Since(2.0) private String type;
	@Since(2.0) private String checkId;
	@Since(2.0) private String frequency;
	@Since(2.0) private List<String> additionalEmails;
	@Since(2.0) private List<Integer> contactIds;
	
	/**
	 * Subscription identifier.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Subscription name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Subscription type.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Check identifier for check subscriptions.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCheckId() {
		return this.checkId;
	}
	
	/**
	 * Report frequency.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getFrequency() {
		return this.frequency;
	}
	
	/**
	 * Additional receiving emails.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<String> getAdditionalEmails() {
		return this.additionalEmails;
	}
	
	/**
	 * Identifier for receiving contacts.
	 * 
	 * @return List of values.
	 * @since 2.0
	 */
	public List<Integer> getContactIds() {
		return this.contactIds;
	}
}
