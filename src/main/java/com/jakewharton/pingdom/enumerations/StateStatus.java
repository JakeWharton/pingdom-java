package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom state status enumeration.
 */
public enum StateStatus implements PingdomEnumeration {
	Up("up"),
	Down("down"),
	Unknown("unknown"),
	Unconfirmed("unconfirmed");
	
	private final String value;
	
	private StateStatus(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, StateStatus> stringToEnum = new HashMap<String, StateStatus>();

	static {
		for (StateStatus status : StateStatus.values()) {
			stringToEnum.put(status.toString(), status);
		}
	}
	
	public static StateStatus fromValue(String value) {
		return stringToEnum.get(value);
	}
}