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
	
	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public String getCheckId() {
		return this.checkId;
	}
	public String getFrequency() {
		return this.frequency;
	}
	public List<String> getAdditionalEmails() {
		return this.additionalEmails;
	}
	public List<Integer> getContactIds() {
		return this.contactIds;
	}
}
