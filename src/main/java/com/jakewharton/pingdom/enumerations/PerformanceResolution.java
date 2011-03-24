package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum PerformanceResolution implements HasValue {
	Hour("hour"),
	Day("day"),
	Week("week");
	
	private final String value;
	
	private PerformanceResolution(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, PerformanceResolution> stringToEnum = new HashMap<String, PerformanceResolution>();

	static {
		for (PerformanceResolution resolution : values()) {
			stringToEnum.put(resolution.value(), resolution);
		}
	}
	
	public static PerformanceResolution fromValue(String value) {
		return stringToEnum.get(value);
	}
}