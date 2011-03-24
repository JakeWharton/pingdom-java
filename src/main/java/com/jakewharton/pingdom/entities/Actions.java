package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class Actions implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1156218153258462856L;
	
	private List<Alert> alerts;
	
	public List<Alert> getAlerts() {
		return this.alerts;
	}
	public Actions setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
		return this;
	}
	
	public static class Alert implements PingdomEntity {
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
		public Alert setContactBame(String contactName) {
			this.contactName = contactName;
			return this;
		}
		public Integer getContactId() {
			return this.contactId;
		}
		public Alert setContactId(Integer contactId) {
			this.contactId = contactId;
			return this;
		}
		public Integer getCheckId() {
			return this.checkId;
		}
		public Alert setCheckId(Integer checkId) {
			this.checkId = checkId;
			return this;
		}
		public Date getTime() {
			return this.time;
		}
		public Alert setTime(Date time) {
			this.time = time;
			return this;
		}
		public Via getVia() {
			return this.via;
		}
		public Alert setVia(Via via) {
			this.via = via;
			return this;
		}
		public Status getStatus() {
			return this.status;
		}
		public Alert setStatus(Status status) {
			this.status = status;
			return this;
		}
		public String getMessageShort() {
			return this.messageShort;
		}
		public Alert setMessageShort(String messageShort) {
			this.messageShort = messageShort;
			return this;
		}
		public String getMessageFull() {
			return this.messageFull;
		}
		public Alert setMessageFull(String messageFull) {
			this.messageFull = messageFull;
			return this;
		}
		public String getSentTo() {
			return this.sentTo;
		}
		public Alert setSentTo(String sentTo) {
			this.sentTo = sentTo;
			return this;
		}
		public Boolean getCharged() {
			return this.charged;
		}
		public Alert setCharged(Boolean charged) {
			this.charged = charged;
			return this;
		}
	}
}
