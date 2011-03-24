package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public class Check implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 6610462680859684444L;
	
	public enum Status implements HasValue {
		Up("up"),
		Down("down"),
		UnconfirmedDown("unconfirmed_down"),
		Unknown("unknown"),
		Paused("paused");
		
		private final String value;
		
		private Status(String value) {
			this.value = value;
		}

		@Override
		public String value() {
			return this.value;
		}
		
		private static final Map<String, Status> stringToEnum = new HashMap<String, Status>();

		static {
			for (Status status : values()) {
				stringToEnum.put(status.value(), status);
			}
		}
		
		public static Status fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	private Integer id;
	private String name;
	//private Object type; //TODO: fix this
	private Date lastErrorTime;
	private Date lastTestTime;
	private Date lastResponseTime;
	private Status status;
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
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//public Object getType() {
	//	return this.type;
	//}
	//public void setType(Object type) {
	//	this.type = type;
	//}
	public Date getLastErrorTime() {
		return this.lastErrorTime;
	}
	public void setLastErrorTime(Date lastErrorTime) {
		this.lastErrorTime = lastErrorTime;
	}
	public Date getLastTestTime() {
		return this.lastTestTime;
	}
	public void setLastTestTime(Date lastTestTime) {
		this.lastTestTime = lastTestTime;
	}
	public Date getLastResponseTime() {
		return this.lastResponseTime;
	}
	public void setLastResponseTime(Date lastResponseTime) {
		this.lastResponseTime = lastResponseTime;
	}
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getResolution() {
		return this.resolution;
	}
	public void setResolution(Integer resolution) {
		this.resolution = resolution;
	}
	public String getHostName() {
		return this.hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Boolean getSendToEmail() {
		return this.sendToEmail;
	}
	public void setSendToEmail(Boolean sendToEmail) {
		this.sendToEmail = sendToEmail;
	}
	public Boolean getSendToSms() {
		return this.sendToSms;
	}
	public void setSendToSms(Boolean sendToSms) {
		this.sendToSms = sendToSms;
	}
	public Boolean getSendToTwitter() {
		return this.sendToTwitter;
	}
	public void setSendToTwitter(Boolean sendToTwitter) {
		this.sendToTwitter = sendToTwitter;
	}
	public Boolean getSendToIPhone() {
		return this.sendToIPhone;
	}
	public void setSendToIPhone(Boolean sendToIPhone) {
		this.sendToIPhone = sendToIPhone;
	}
	public Integer getSendNotificationWhenDown() {
		return this.sendNotificationWhenDown;
	}
	public void setSendNotificationWhenDown(Integer sendNotificationWhenDown) {
		this.sendNotificationWhenDown = sendNotificationWhenDown;
	}
	public Integer getNotifyAgainEvery() {
		return this.notifyAgainEvery;
	}
	public void setNotifyAgainEvery(Integer notifyAgainEvery) {
		this.notifyAgainEvery = notifyAgainEvery;
	}
	public Boolean getNotifyWhenBackUp() {
		return this.notifyWhenBackUp;
	}
	public void setNotifyWhenBackUp(Boolean notifyWhenBackUp) {
		this.notifyWhenBackUp = notifyWhenBackUp;
	}
	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
