package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom alert status enumeration.
 */
public enum AlertStatus implements PingdomEnumeration {
	Sent("send"),
	Delivered("delivered"),
	Error("error"),
	NotDelivered("not_delivered"),
	NoCredits("no_credits");
	
	private final String value;
	
	private AlertStatus(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, AlertStatus> STRING_MAPPING = new HashMap<String, AlertStatus>();

	static {
		for (AlertStatus via : AlertStatus.values()) {
			STRING_MAPPING.put(via.toString(), via);
		}
	}
	
	public static AlertStatus fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}