package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom check status enumeration.
 */
public enum CheckStatus implements PingdomEnumeration {
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
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, CheckStatus> STRING_MAPPING = new HashMap<String, CheckStatus>();

	static {
		for (CheckStatus status : CheckStatus.values()) {
			STRING_MAPPING.put(status.toString(), status);
		}
	}
	
	public static CheckStatus fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}