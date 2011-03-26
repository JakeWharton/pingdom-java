package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom banner type enumeration.
 */
public enum BannerType implements PingdomEnumeration {
	Response("response"),
	Uptime("uptime");
	
	private final String value;
	
	private BannerType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, BannerType> STRING_MAPPING = new HashMap<String, BannerType>();

	static {
		for (BannerType via : BannerType.values()) {
			STRING_MAPPING.put(via.toString(), via);
		}
	}
	
	public static BannerType fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}