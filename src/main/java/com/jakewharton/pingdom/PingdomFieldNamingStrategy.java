package com.jakewharton.pingdom;

import java.lang.reflect.Field;
import com.google.gson.FieldNamingStrategy;

/**
 * Custom GSON field naming strategy which simply converts the field to all
 * lowercase letters.
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
final class PingdomFieldNamingStrategy implements FieldNamingStrategy {
	@Override
	public String translateName(Field field) {
		return field.getName().toLowerCase();
	}
}
