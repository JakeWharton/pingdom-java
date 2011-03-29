package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;

/**
 * Represents Pingdom's remote summary probe service.
 */
public class SummaryProbeService extends PingdomApiService {
	/**
	 * Get a list of probes that performed tests for a specified check during a
	 * specified period.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}

	/**
	 * Request builder for {@link SummaryProbeService#get(int)}.
	 */
	public static final class GetBuilder extends PingdomApiBuilder<List<Integer>> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/summary.probes/{" + FIELD_CHECK_ID + "}";
		
		private GetBuilder(SummaryProbeService service, int checkId) {
			super(service, new TypeToken<List<Integer>>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("probes").getAsJsonArray();
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
	}
}
