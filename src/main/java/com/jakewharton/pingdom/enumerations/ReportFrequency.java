package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom report frequency enumeration.
 */
public enum ReportFrequency implements PingdomEnumeration {
	Daily("daily"),
	Weekly("weekly"),
	Monthly("monthly");
	
	private final String value;
	
	private ReportFrequency(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, ReportFrequency> STRING_MAPPING = new HashMap<String, ReportFrequency>();

	static {
		for (ReportFrequency frequency : ReportFrequency.values()) {
			STRING_MAPPING.put(frequency.toString(), frequency);
		}
	}
	
	public static ReportFrequency fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}
