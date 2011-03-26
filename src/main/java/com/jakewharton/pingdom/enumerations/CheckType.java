package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom check type enumeration.
 */
public enum CheckType implements PingdomEnumeration {
	Http("http"),
	HttpCustom("httpcustom"),
	Tcp("tcp"),
	Ping("ping"),
	Dns("dns"),
	Udp("udp"),
	Smtp("smtp"),
	Pop3("pop3"),
	Imap("imap");
	
	private final String value;
	
	private CheckType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, CheckType> STRING_MAPPING = new HashMap<String, CheckType>();

	static {
		for (CheckType status : CheckType.values()) {
			STRING_MAPPING.put(status.toString(), status);
		}
	}
	
	public static CheckType fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}