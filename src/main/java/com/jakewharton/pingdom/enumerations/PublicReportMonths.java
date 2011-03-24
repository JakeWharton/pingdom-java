package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum PublicReportMonths implements HasValue {
	None("none"),
	All("all"),
	Three("3");
	
	private final String value;
	
	private PublicReportMonths(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, PublicReportMonths> stringToEnum = new HashMap<String, PublicReportMonths>();

	static {
		for (PublicReportMonths months : values()) {
			stringToEnum.put(months.value(), months);
		}
	}
	
	public static PublicReportMonths fromValue(String value) {
		return stringToEnum.get(value);
	}
}