package com.jakewharton.pingdom.services;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.TraceRoute;

public class TraceRouteService extends PingdomApiService {
	/**
	 * Perform a traceroute to a specified target from a specified Pingdom
	 * probe.
	 * 
	 * @param host Target host.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public TraceBuilder trace(String host) {
		return new TraceBuilder(this, host);
	}
	
	public static final class TraceBuilder extends PingdomApiBuilder<TraceRoute> {
		private static final String PARAM_HOST = "host";
		private static final String PARAM_PROBE_ID = "probeid";
		
		private static final String URI = "/traceroute";
		
		private TraceBuilder(TraceRouteService service, String host) {
			super(service, new TypeToken<TraceRoute>() {}, URI);
			
			this.parameter(PARAM_HOST, host);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("traceroute");
		}
		
		/**
		 * Probe identifier.
		 * 
		 * @param probeId Value.
		 * @return Builder instance.
		 */
		public TraceBuilder probeId(int probeId) {
			this.parameter(PARAM_PROBE_ID, probeId);
			return this;
		}
	}
}
