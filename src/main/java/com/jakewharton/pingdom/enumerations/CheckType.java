package com.jakewharton.pingdom.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;

public enum CheckType implements HasValue {
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
	public String value() {
		return this.value;
	}
	
	private static final Map<String, CheckType> stringToEnum = new HashMap<String, CheckType>();

	static {
		for (CheckType status : values()) {
			stringToEnum.put(status.value(), status);
		}
	}
	
	public static CheckType fromValue(String value) {
		return stringToEnum.get(value);
	}
}