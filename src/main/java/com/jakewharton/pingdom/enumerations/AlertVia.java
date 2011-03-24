package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum AlertVia implements HasValue {
	Email("email"),
	Sms("sms"),
	Twitter("twitter"),
	iPhone("iphone");
	
	private final String value;
	
	private AlertVia(String value) {
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, AlertVia> stringToEnum = new HashMap<String, AlertVia>();

	static {
		for (AlertVia via : values()) {
			stringToEnum.put(via.value(), via);
		}
	}
	
	public static AlertVia fromValue(String value) {
		return stringToEnum.get(value);
	}
}