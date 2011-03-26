package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom public report months enumeration.
 */
public enum PublicReportMonths implements PingdomEnumeration {
	None("none"),
	All("all"),
	Three("3");
	
	private final String value;
	
	private PublicReportMonths(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, PublicReportMonths> STRING_MAPPING = new HashMap<String, PublicReportMonths>();

	static {
		for (PublicReportMonths months : PublicReportMonths.values()) {
			STRING_MAPPING.put(months.toString(), months);
		}
	}
	
	public static PublicReportMonths fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}