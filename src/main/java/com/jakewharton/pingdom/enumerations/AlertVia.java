package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom alert via enumeration.
 */
public enum AlertVia implements PingdomEnumeration {
	Email("email"),
	Sms("sms"),
	Twitter("twitter"),
	iPhone("iphone");
	
	private final String value;
	
	private AlertVia(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, AlertVia> STRING_MAPPING = new HashMap<String, AlertVia>();

	static {
		for (AlertVia via : AlertVia.values()) {
			STRING_MAPPING.put(via.toString(), via);
		}
	}
	
	public static AlertVia fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}