package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Analysis;

/**
 * Represents Pingdom's remote analysis service.
 */
public final class AnalysisService extends PingdomApiService {
	/**
	 * Returns a list of the latest error analysis results for a specified check.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ListBuilder list(int checkId) {
		return new ListBuilder(this, checkId);
	}
	
	public static final class ListBuilder extends PingdomApiBuilder<List<Analysis>> {
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		
		private static final String URI = "/analysis/{" + FIELD_CHECK_ID + "}";
		
		private ListBuilder(AnalysisService service, int checkId) {
			super(service, new TypeToken<List<Analysis>>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		/**
		 * Limits the number of returned results to the specified quantity. (Optional)
		 * 
		 * @param limit Result limit.
		 * @return Builder instance.
		 */
		public ListBuilder limit(int limit) {
			this.parameter(PARAM_LIMIT, limit);
			return this;
		}

		/**
		 * Offset for listing. (Optional)
		 * 
		 * @param offset Offset amount.
		 * @return Builder instance.
		 */
		public ListBuilder offset(int offset) {
			this.parameter(PARAM_OFFSET, offset);
			return this;
		}
	}
}
