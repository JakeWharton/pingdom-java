package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum AlertStatus implements HasValue {
	Sent("send"),
	Delivered("delivered"),
	Error("error"),
	NotDelivered("not_delivered"),
	NoCredits("no_credits");
	
	private final String value;
	
	private AlertStatus(String value) {
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, AlertStatus> stringToEnum = new HashMap<String, AlertStatus>();

	static {
		for (AlertStatus via : values()) {
			stringToEnum.put(via.value(), via);
		}
	}
	
	public static AlertStatus fromValue(String value) {
		return stringToEnum.get(value);
	}
}