package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom performance resolution enumeration.
 */
public enum PerformanceResolution implements PingdomEnumeration {
	Hour("hour"),
	Day("day"),
	Week("week");
	
	private final String value;
	
	private PerformanceResolution(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, PerformanceResolution> STRING_MAPPING = new HashMap<String, PerformanceResolution>();

	static {
		for (PerformanceResolution resolution : PerformanceResolution.values()) {
			STRING_MAPPING.put(resolution.toString(), resolution);
		}
	}
	
	public static PerformanceResolution fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}