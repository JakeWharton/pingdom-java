package com.jakewharton.pingdom.entities;

import java.util.List;
import com.jakewharton.pingdom.PingdomEntity;

public final class ReportEmailSubscription implements PingdomEntity {
	private static final long serialVersionUID = -3601535119841289488L;

	private Integer id;
	private String name;
	private String type;
	private String checkId;
	private String frequency;
	private List<String> additionalEmails;
	private List<Integer> contactIds;
	
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
