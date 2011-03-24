package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum CheckStatus implements HasValue {
	Up("up"),
	Down("down"),
	UnconfirmedDown("unconfirmed_down"),
	Unknown("unknown"),
	Paused("paused");
	
	private final String value;
	
	private CheckStatus(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, CheckStatus> stringToEnum = new HashMap<String, CheckStatus>();

	static {
		for (CheckStatus status : values()) {
			stringToEnum.put(status.value(), status);
		}
	}
	
	public static CheckStatus fromValue(String value) {
		return stringToEnum.get(value);
	}
}