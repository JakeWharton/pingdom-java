package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum SmsProvider implements HasValue {
	Clickatell("clickatell"),
	BulkSms("bulksms"),
	Esendex("esendex"),
	CellSynt("cellsynt");
	
	private final String value;
	
	private SmsProvider(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	private static final Map<String, SmsProvider> stringToEnum = new HashMap<String, SmsProvider>();

	static {
		for (SmsProvider defaultSmsProvider : values()) {
			stringToEnum.put(defaultSmsProvider.value(), defaultSmsProvider);
		}
	}
	
	public static SmsProvider fromValue(String value) {
		return stringToEnum.get(value);
	}
}