package com.jakewharton.pingdom;

import java.lang.reflect.Field;
import com.google.gson.FieldNamingStrategy;

final class PingdomFieldNamingStrategy implements FieldNamingStrategy {
	public static final PingdomFieldNamingStrategy INSTANCE = new PingdomFieldNamingStrategy();
	
	private PingdomFieldNamingStrategy() {} //No instances
	
	@Override
	public String translateName(Field field) {
		return field.getName().toLowerCase();
	}
}
