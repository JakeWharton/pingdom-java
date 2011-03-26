package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom shared report type enumeration.
 */
public enum SharedReportType implements PingdomEnumeration {
	Banner("banner");
	
	private final String value;
	
	private SharedReportType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, SharedReportType> STRING_MAPPING = new HashMap<String, SharedReportType>();

	static {
		for (SharedReportType months : SharedReportType.values()) {
			STRING_MAPPING.put(months.toString(), months);
		}
	}
	
	public static SharedReportType fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}
