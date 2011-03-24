package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.AlertStatus;
import com.jakewharton.pingdom.enumerations.AlertVia;

public final class Actions implements PingdomEntity {
	private static final long serialVersionUID = -1156218153258462856L;
	
	public static final class Alert implements PingdomEntity {
		private static final long serialVersionUID = 5463127549305988443L;
		
		private String contactName;
		private Integer contactId;
		private Integer checkId;
		private Date time;
		private AlertVia via;
		private AlertStatus status;
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
		public AlertVia getVia() {
			return this.via;
		}
		public AlertStatus getStatus() {
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
