package com.jakewharton.pingdom.services;

import java.util.Date;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.SummaryOutage;

public class SummaryOutageService extends PingdomApiService {
	/**
	 * Get a list of status changes for a specified check and time period.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<SummaryOutage> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/summary.outage/{" + FIELD_CHECK_ID + "}";
		
		private GetBuilder(SummaryOutageService service, int checkId) {
			super(service, new TypeToken<SummaryOutage>() {}, URI);
			
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
	}
}
