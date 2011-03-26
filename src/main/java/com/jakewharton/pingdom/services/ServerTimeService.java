package com.jakewharton.pingdom.services;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.ServerTime;

/**
 * Represents Pingdom's remote server time service.
 */
public class ServerTimeService extends PingdomApiService {
	/**
	 * Get the current time of the API server.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get() {
		return new GetBuilder(this);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<ServerTime> {
		private static final String URI = "/servertime";
		
		private GetBuilder(ServerTimeService service) {
			super(service, new TypeToken<ServerTime>() {}, URI);
		}
	}
}
