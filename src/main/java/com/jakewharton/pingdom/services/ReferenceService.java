package com.jakewharton.pingdom.services;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Reference;

/**
 * Represents Pingdom's remote reference service.
 */
public class ReferenceService extends PingdomApiService {
	/**
	 * Get a reference of regions, timezones and date/time/number formats and
	 * their identifiers.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get() {
		return new GetBuilder(this);
	}

	/**
	 * Request builder for {@link ReferenceService#get()}.
	 */
	public static final class GetBuilder extends PingdomApiBuilder<Reference> {
		private static final String URI = "/reference";
		
		private GetBuilder(ReferenceService service) {
			super(service, new TypeToken<Reference>() {}, URI);
		}
	}
}
