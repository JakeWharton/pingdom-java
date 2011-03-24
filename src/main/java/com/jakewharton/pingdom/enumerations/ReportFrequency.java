package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum ReportFrequency implements HasValue {
	Daily("daily"),
	Weekly("weekly"),
	Monthly("monthly");
	
	private final String value;
	
	private ReportFrequency(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, ReportFrequency> stringToEnum = new HashMap<String, ReportFrequency>();

	static {
		for (ReportFrequency frequency : values()) {
			stringToEnum.put(frequency.value(), frequency);
		}
	}
	
	public static ReportFrequency fromValue(String value) {
		return stringToEnum.get(value);
	}
}
