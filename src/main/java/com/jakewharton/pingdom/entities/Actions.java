package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class Actions implements PingdomEntity {
	private static final long serialVersionUID = -1156218153258462856L;
	
	public static final class Alert implements PingdomEntity {
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
		public Integer getContactId() {
			return this.contactId;
		}
		public Integer getCheckId() {
			return this.checkId;
		}
		public Date getTime() {
			return this.time;
		}
		public Via getVia() {
			return this.via;
		}
		public Status getStatus() {
			return this.status;
		}
		public String getMessageShort() {
			return this.messageShort;
		}
		public String getMessageFull() {
			return this.messageFull;
		}
		public String getSentTo() {
			return this.sentTo;
		}
		public Boolean getCharged() {
			return this.charged;
		}
	}
	
	private List<Alert> alerts;
	
	public List<Alert> getAlerts() {
		return this.alerts;
	}
}
