package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Probe;

/**
 * Represents Pingdom's remote probe service.
 */
public class ProbeService extends PingdomApiService {
	/**
	 * Returns a list of all Pingdom probe servers.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ListBuilder list() {
		return new ListBuilder(this);
	}
	
	public static final class ListBuilder extends PingdomApiBuilder<List<Probe>> {
		private static final String URI = "/probes";
		
		private ListBuilder(ProbeService service) {
			super(service, new TypeToken<List<Probe>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("probes").getAsJsonArray();
		}
	}
}
