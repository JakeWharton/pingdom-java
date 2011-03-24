package com.jakewharton.pingdom.services;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Settings;

public class SettingsService extends PingdomApiService {
	/**
	 * Returns all account-specific settings.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get() {
		return new GetBuilder(this);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<Settings> {
		private static final String URI = "/settings";
		
		private GetBuilder(SettingsService service) {
			super(service, new TypeToken<Settings>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("settings");
		}
	}
}
