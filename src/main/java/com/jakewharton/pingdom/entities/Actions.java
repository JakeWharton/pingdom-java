package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.AlertStatus;
import com.jakewharton.pingdom.enumerations.AlertVia;

/**
 * Represents a Pingdom actions object.
 */
public final class Actions implements PingdomEntity {
	private static final long serialVersionUID = -1156218153258462856L;
	
	/**
	 * Represents a Pingdom alert object.
	 */
	public static final class Alert implements PingdomEntity {
		private static final long serialVersionUID = 5463127549305988443L;
		
		@Since(2.0) private String contactName;
		@Since(2.0) private Integer contactId;
		@Since(2.0) private Integer checkId;
		@Since(2.0) private Date time;
		@Since(2.0) private AlertVia via;
		@Since(2.0) private AlertStatus status;
		@Since(2.0) private String messageShort;
		@Since(2.0) private String messageFull;
		@Since(2.0) private String sentTo;
		@Since(2.0) private Boolean charged;
		
		/**
		 * Name of alerted contact.
		 *  
		 * @return Value.
		 * @since 2.0
		 */
		public String getContactName() {
			return this.contactName;
		}
		
		/**
		 * Identifier of alerted contact.
		 * 
		 * @return Value.
		 */
		public Integer getContactId() {
			return this.contactId;
		}
		
		/**
		 * Identifier of check.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getCheckId() {
			return this.checkId;
		}
		
		/**
		 * Time of alert generation.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Date getTime() {
			return this.time;
		}
		
		/**
		 * Alert medium.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public AlertVia getVia() {
			return this.via;
		}
		
		/**
		 * Alert status.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public AlertStatus getStatus() {
			return this.status;
		}
		
		/**
		 * Short description of message.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getMessageShort() {
			return this.messageShort;
		}
		
		/**
		 * Full message body.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getMessageFull() {
			return this.messageFull;
		}
		
		/**
		 * Target address, phone number, etc.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getSentTo() {
			return this.sentTo;
		}
		
		/**
		 * True if your account was charged for this message.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getCharged() {
			return this.charged;
		}
	}
	
	private List<Alert> alerts;
	
	/**
	 * Alert entries.
	 * 
	 * @return List of {@link Alert}s.
	 * @since 2.0
	 */
	public List<Alert> getAlerts() {
		return this.alerts;
	}
}
