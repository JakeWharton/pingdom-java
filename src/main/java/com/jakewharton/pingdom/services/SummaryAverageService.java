package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.SummaryAverage;

public class SummaryAverageService extends PingdomApiService {
	/**
	 * Get a summarized response time / uptime value for a specified check and
	 * time period.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<SummaryAverage> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		private static final String PARAM_PROBES = "probes";
		private static final String PARAM_INCLUDE_UPTIME = "includeuptime";
		private static final String PARAM_BY_COUNTRY = "bycountry";
		private static final String PARAM_BY_PROBE = "byprobe";
		
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/summary.average/{" + FIELD_CHECK_ID + "}";
		
		private GetBuilder(SummaryAverageService service, int checkId) {
			super(service, new TypeToken<SummaryAverage>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("summary");
		}
		
		/**
		 * Start time of period.
		 * 
		 * @param from Value.
		 * @return Builder instance.
		 */
		public GetBuilder from(Date from) {
			this.parameter(PARAM_FROM, from);
			return this;
		}
		
		/**
		 * End time of period.
		 * 
		 * @param to Value.
		 * @return Builder instance.
		 */
		public GetBuilder to(Date to) {
			this.parameter(PARAM_TO, to);
			return this;
		}
		
		/**
		 * Filter to only use results from a list of probes.
		 * 
		 * @param probes List of probe IDs.
		 * @return Builder instance.
		 */
		public GetBuilder probes(List<Integer> probes) {
			this.parameter(PARAM_PROBES, probes);
			return this;
		}
		
		/**
		 * Include uptime information.
		 * 
		 * @param includeUptime Value.
		 * @return Builder instance.
		 */
		public GetBuilder includeUptime(boolean includeUptime) {
			this.parameter(PARAM_INCLUDE_UPTIME, includeUptime);
			return this;
		}
		
		/**
		 * Split response times into country groups.
		 * 
		 * @param byCountry Value.
		 * @return Builder instance.
		 */
		public GetBuilder byCountry(boolean byCountry) {
			this.parameter(PARAM_BY_COUNTRY, byCountry);
			return this;
		}
		
		/**
		 * Split response times into probe groups
		 * 
		 * @param byProbe Value.
		 * @return Builder instance.
		 */
		public GetBuilder byProbe(boolean byProbe) {
			this.parameter(PARAM_BY_PROBE, byProbe);
			return this;
		}
	}
}
