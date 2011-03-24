package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum BannerType implements HasValue {
	Response("response"),
	Uptime("uptime");
	
	private final String value;
	
	private BannerType(String value) {
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, BannerType> stringToEnum = new HashMap<String, BannerType>();

	static {
		for (BannerType via : values()) {
			stringToEnum.put(via.value(), via);
		}
	}
	
	public static BannerType fromValue(String value) {
		return stringToEnum.get(value);
	}
}