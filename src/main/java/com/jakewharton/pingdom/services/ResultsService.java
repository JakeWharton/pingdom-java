package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.RawResults;
import com.jakewharton.pingdom.enumerations.StateStatus;

/**
 * Represents Pingdom's remote results service.
 */
public class ResultsService extends PingdomApiService {
	/**
	 * Return raw test results for a specified check.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<RawResults> {
		private static final String PARAM_TO = "to";
		private static final String PARAM_FROM = "from";
		private static final String PARAM_PROBES = "probes";
		private static final String PARAM_STATUS = "status";
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		private static final String PARAM_INCLUDE_ANALYSIS = "includeanalysis";
		
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/results/{" + FIELD_CHECK_ID + "}";
		
		private static final int MAX_OFFSET = 432000;
		
		private GetBuilder(ResultsService service, int checkId) {
			super(service, new TypeToken<RawResults>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		/**
		 * End of period.
		 * 
		 * @param to Value.
		 * @return Builder instance.
		 */
		public GetBuilder to(Date to) {
			this.parameter(PARAM_TO, to);
			return this;
		}
		
		/**
		 * Start of period.
		 * 
		 * @param from Value.
		 * @return Builder instance.
		 */
		public GetBuilder from(Date from) {
			this.parameter(PARAM_FROM, from);
			return this;
		}
		
		/**
		 * Filter to only show results from a list of probes.
		 * 
		 * @param probes List of probe IDs.
		 * @return Builder instance.
		 */
		public GetBuilder probes(List<Integer> probes) {
			this.parameter(PARAM_PROBES, probes);
			return this;
		}
		
		/**
		 * Filter to only show results with specified statuses.
		 * 
		 * @param statuses List of statuses.
		 * @return Builder instance.
		 */
		public GetBuilder status(List<StateStatus> statuses) {
			this.parameter(PARAM_STATUS, statuses);
			return this;
		}
		
		/**
		 * Number of results to show (Will be set to 100 if the provided value
		 * is greater than 100).
		 * 
		 * @param limit Value.
		 * @return Builder instance.
		 */
		public GetBuilder limit(int limit) {
			this.parameter(PARAM_LIMIT, limit);
			return this;
		}
		
		/**
		 * Number of results to skip (max value is 43200).
		 * 
		 * @param offset Value.
		 * @return Builder instance.
		 */
		public GetBuilder offset(int offset) {
			if (offset > MAX_OFFSET) {
				throw new IllegalArgumentException("Offset must be less than or equal to " + MAX_OFFSET);
			}
			
			this.parameter(PARAM_OFFSET, offset);
			return this;
		}
		
		/**
		 * Attach available error analysis identifiers to corresponding results.
		 * 
		 * @param includeAnalysis Value.
		 * @return Builder instance.
		 */
		public GetBuilder includeAnalysis(boolean includeAnalysis) {
			this.parameter(PARAM_INCLUDE_ANALYSIS, includeAnalysis);
			return this;
		}
	}
}
