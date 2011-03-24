package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum StateStatus implements HasValue {
	Up("up"),
	Down("down"),
	Unknown("unknown"),
	Unconfirmed("unconfirmed");
	
	private final String value;
	
	private StateStatus(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, StateStatus> stringToEnum = new HashMap<String, StateStatus>();

	static {
		for (StateStatus status : values()) {
			stringToEnum.put(status.value(), status);
		}
	}
	
	public static StateStatus fromValue(String value) {
		return stringToEnum.get(value);
	}
}