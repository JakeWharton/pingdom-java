package com.jakewharton.pingdom.entities;

import java.util.Date;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.CheckStatus;

public final class Check implements PingdomEntity {
	private static final long serialVersionUID = 6610462680859684444L;
	
	private Integer id;
	private String name;
	//private Object type; //TODO: fix this
	private Date lastErrorTime;
	private Date lastTestTime;
	private Date lastResponseTime;
	private CheckStatus status;
	private Integer resolution;
	private String hostName;
	private Boolean sendToEmail;
	private Boolean sendToSms;
	private Boolean sendToTwitter;
	private Boolean sendToIPhone;
	private Integer sendNotificationWhenDown;
	private Integer notifyAgainEvery;
	private Boolean notifyWhenBackUp;
	private Date created;
	
	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	//public Object getType() {
	//	return this.type;
	//}
	public Date getLastErrorTime() {
		return this.lastErrorTime;
	}
	public Date getLastTestTime() {
		return this.lastTestTime;
	}
	public Date getLastResponseTime() {
		return this.lastResponseTime;
	}
	public CheckStatus getStatus() {
		return this.status;
	}
	public Integer getResolution() {
		return this.resolution;
	}
	public String getHostName() {
		return this.hostName;
	}
	public Boolean getSendToEmail() {
		return this.sendToEmail;
	}
	public Boolean getSendToSms() {
		return this.sendToSms;
	}
	public Boolean getSendToTwitter() {
		return this.sendToTwitter;
	}
	public Boolean getSendToIPhone() {
		return this.sendToIPhone;
	}
	public Integer getSendNotificationWhenDown() {
		return this.sendNotificationWhenDown;
	}
	public Integer getNotifyAgainEvery() {
		return this.notifyAgainEvery;
	}
	public Boolean getNotifyWhenBackUp() {
		return this.notifyWhenBackUp;
	}
	public Date getCreated() {
		return this.created;
	}
}
