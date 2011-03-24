package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.SummaryPerformance;
import com.jakewharton.pingdom.enumerations.PerformanceResolution;

public class SummaryPerformanceService extends PingdomApiService {
	/**
	 * Get the average response time and uptime for a list of intervals. Useful
	 * for generating graphs.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<SummaryPerformance> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		private static final String PARAM_RESOLUTION = "resolution";
		private static final String PARAM_INCLUDE_UPTIME = "includeuptime";
		private static final String PARAM_PROBES = "probes";
		
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/summary.performance/{" + FIELD_CHECK_ID + "}";
		
		private GetBuilder(SummaryPerformanceService service, int checkId) {
			super(service, new TypeToken<SummaryPerformance>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("summary");
		}
		
		/**
		 * Start time of period.
		 * 
		 * @param from value.
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
		 * Interval size.
		 * 
		 * @param resolution Value.
		 * @return Builder instance.
		 */
		public GetBuilder resolution(PerformanceResolution resolution) {
			this.parameter(PARAM_RESOLUTION, resolution);
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
		 * Filter to only use results from a list of probes. Can not be used if
		 * includeuptime is set to true. Also note that this can cause intervals
		 * to be omitted, since there may be no results from the desired probes
		 * in them.
		 * 
		 * @param probes List of probe IDs.
		 * @return Builder instance.
		 */
		public GetBuilder probes(List<Integer> probes) {
			this.parameter(PARAM_PROBES, probes);
			return this;
		}
	}
}
