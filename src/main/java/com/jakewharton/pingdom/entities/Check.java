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
	public Check setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return this.name;
	}
	public Check setName(String name) {
		this.name = name;
		return this;
	}
	//public Object getType() {
	//	return this.type;
	//}
	//public Check setType(Object type) {
	//	this.type = type;
	//	return this;
	//}
	public Date getLastErrorTime() {
		return this.lastErrorTime;
	}
	public Check setLastErrorTime(Date lastErrorTime) {
		this.lastErrorTime = lastErrorTime;
		return this;
	}
	public Date getLastTestTime() {
		return this.lastTestTime;
	}
	public Check setLastTestTime(Date lastTestTime) {
		this.lastTestTime = lastTestTime;
		return this;
	}
	public Date getLastResponseTime() {
		return this.lastResponseTime;
	}
	public Check setLastResponseTime(Date lastResponseTime) {
		this.lastResponseTime = lastResponseTime;
		return this;
	}
	public Status getStatus() {
		return this.status;
	}
	public Check setStatus(Status status) {
		this.status = status;
		return this;
	}
	public Integer getResolution() {
		return this.resolution;
	}
	public Check setResolution(Integer resolution) {
		this.resolution = resolution;
		return this;
	}
	public String getHostName() {
		return this.hostName;
	}
	public Check setHostName(String hostName) {
		this.hostName = hostName;
		return this;
	}
	public Boolean getSendToEmail() {
		return this.sendToEmail;
	}
	public Check setSendToEmail(Boolean sendToEmail) {
		this.sendToEmail = sendToEmail;
		return this;
	}
	public Boolean getSendToSms() {
		return this.sendToSms;
	}
	public Check setSendToSms(Boolean sendToSms) {
		this.sendToSms = sendToSms;
		return this;
	}
	public Boolean getSendToTwitter() {
		return this.sendToTwitter;
	}
	public Check setSendToTwitter(Boolean sendToTwitter) {
		this.sendToTwitter = sendToTwitter;
		return this;
	}
	public Boolean getSendToIPhone() {
		return this.sendToIPhone;
	}
	public Check setSendToIPhone(Boolean sendToIPhone) {
		this.sendToIPhone = sendToIPhone;
		return this;
	}
	public Integer getSendNotificationWhenDown() {
		return this.sendNotificationWhenDown;
	}
	public Check setSendNotificationWhenDown(Integer sendNotificationWhenDown) {
		this.sendNotificationWhenDown = sendNotificationWhenDown;
		return this;
	}
	public Integer getNotifyAgainEvery() {
		return this.notifyAgainEvery;
	}
	public Check setNotifyAgainEvery(Integer notifyAgainEvery) {
		this.notifyAgainEvery = notifyAgainEvery;
		return this;
	}
	public Boolean getNotifyWhenBackUp() {
		return this.notifyWhenBackUp;
	}
	public Check setNotifyWhenBackUp(Boolean notifyWhenBackUp) {
		this.notifyWhenBackUp = notifyWhenBackUp;
		return this;
	}
	public Date getCreated() {
		return this.created;
	}
	public Check setCreated(Date created) {
		this.created = created;
		return this;
	}
}
