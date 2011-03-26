package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.PingdomEnumeration;

/**
 * Represents a Pingdom SMS provider enumeration.
 */
public enum SmsProvider implements PingdomEnumeration {
	Clickatell("clickatell"),
	BulkSms("bulksms"),
	Esendex("esendex"),
	CellSynt("cellsynt");
	
	private final String value;
	
	private SmsProvider(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, SmsProvider> STRING_MAPPING = new HashMap<String, SmsProvider>();

	static {
		for (SmsProvider defaultSmsProvider : SmsProvider.values()) {
			STRING_MAPPING.put(defaultSmsProvider.toString(), defaultSmsProvider);
		}
	}
	
	public static SmsProvider fromValue(String value) {
		return STRING_MAPPING.get(value);
	}
}