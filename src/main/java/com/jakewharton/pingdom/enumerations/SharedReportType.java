package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum SharedReportType implements HasValue {
	Banner("banner");
	
	private final String value;
	
	private SharedReportType(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, SharedReportType> stringToEnum = new HashMap<String, SharedReportType>();

	static {
		for (SharedReportType months : values()) {
			stringToEnum.put(months.value(), months);
		}
	}
	
	public static SharedReportType fromValue(String value) {
		return stringToEnum.get(value);
	}
}
