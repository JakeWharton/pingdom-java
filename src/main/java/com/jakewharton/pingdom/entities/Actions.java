package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class Actions extends PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1156218153258462856L;
	
	private List<Alert> alerts;
	
	public List<Alert> getAlerts() {
		return this.alerts;
	}
	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}
	
	public static class Alert extends PingdomEntity {
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 5463127549305988443L;
		
		public enum Via implements HasValue {
			Email("email"),
			Sms("sms"),
			Twitter("twitter"),
			iPhone("iphone");
			
			private final String value;
			
			private Via(String value) {
				this.value = value;
			}
			
			@Override
			public String value() {
				return this.value;
			}
			
			private static final Map<String, Via> stringToEnum = new HashMap<String, Via>();

			static {
				for (Via via : values()) {
					stringToEnum.put(via.value(), via);
				}
			}
			
			public static Via fromValue(String value) {
				return stringToEnum.get(value);
			}
		}
		
		public enum Status implements HasValue {
			Sent("send"),
			Delivered("delivered"),
			Error("error"),
			NotDelivered("not_delivered"),
			NoCredits("no_credits");
			
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
				for (Status via : values()) {
					stringToEnum.put(via.value(), via);
				}
			}
			
			public static Status fromValue(String value) {
				return stringToEnum.get(value);
			}
		}
		
		private String contactName;
		private Integer contactId;
		private Integer checkId;
		private Date time;
		private Via via;
		private Status status;
		private String messageShort;
		private String messageFull;
		private String sentTo;
		private Boolean charged;
		
		public String getContactName() {
			return this.contactName;
		}
		public void setContactBame(String contactName) {
			this.contactName = contactName;
		}
		public Integer getContactId() {
			return this.contactId;
		}
		public void setContactId(Integer contactId) {
			this.contactId = contactId;
		}
		public Integer getCheckId() {
			return this.checkId;
		}
		public void setCheckId(Integer checkId) {
			this.checkId = checkId;
		}
		public Date getTime() {
			return this.time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public Via getVia() {
			return this.via;
		}
		public void setVia(Via via) {
			this.via = via;
		}
		public Status getStatus() {
			return this.status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public String getMessageShort() {
			return this.messageShort;
		}
		public void setMessageShort(String messageShort) {
			this.messageShort = messageShort;
		}
		public String getMessageFull() {
			return this.messageFull;
		}
		public void setMessageFull(String messageFull) {
			this.messageFull = messageFull;
		}
		public String getSentTo() {
			return this.sentTo;
		}
		public void setSentTo(String sentTo) {
			this.sentTo = sentTo;
		}
		public Boolean getCharged() {
			return this.charged;
		}
		public void setCharged(Boolean charged) {
			this.charged = charged;
		}
	}
}
