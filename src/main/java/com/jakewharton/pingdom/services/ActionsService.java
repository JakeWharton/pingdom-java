package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Actions;

public final class ActionsService extends PingdomApiService {
	/**
	 * Returns a list of actions (alerts) that have been generated for your account.
	 * 
	 * @since 2.0
	 * @return Builder instance.
	 */
	public final ListBuilder list() {
		return new ListBuilder(this);
	}
	
	public static final class ListBuilder extends PingdomApiBuilder<Actions> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		private static final String PARAM_CHECK_IDS = "checkids";
		private static final String PARAM_CONTACT_IDS = "contactids";
		private static final String PARAM_STATUS = "status";
		private static final String PARAM_VIA = "via";
		
		private static final String URI = "/actions";
		
		private ListBuilder(PingdomApiService service) {
			super(service, new TypeToken<Actions>() {}, URI);
		}
		
		/**
		 * Only include actions generated later than this timestamp. (Optional)
		 * 
		 * @param from Starting timestamp.
		 * @return Builder instance.
		 */
		public ListBuilder from(Date from) {
			this.parameter(PARAM_FROM, from);
			return this;
		}
		
		/**
		 * Only include actions generated prior to this timestamp. (Optional)
		 * 
		 * @param to Ending timestamp.
		 * @return Builder instance.
		 */
		public ListBuilder to(Date to) {
			this.parameter(PARAM_TO, to);
			return this;
		}
		
		/**
		 * Limits the number of returned results to the specified quantity. (Optional).
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
		
		/**
		 * Limit results to actions generated from these checks. (Optional)
		 * 
		 * @param checkIds List of IDs.
		 * @return Builder instance.
		 */
		public ListBuilder checkIds(List<Integer> checkIds) {
			this.parameter(PARAM_CHECK_IDS, checkIds);
			return this;
		}
		
		/**
		 * Limit results to actions sent to these contacts. (Optional)
		 * 
		 * @param contactIds List of IDs.
		 * @return Builder instance.
		 */
		public ListBuilder contactIds(List<Integer> contactIds) {
			this.parameter(PARAM_CONTACT_IDS, contactIds);
			return this;
		}
		
		/**
		 * Limit results to actions with these statuses. (Optional)
		 * 
		 * @param status Status to limit with.
		 * @return Builder instance.
		 */
		public ListBuilder status(Actions.Alert.Status status) {
			this.parameter(PARAM_STATUS, status);
			return this;
		}
		
		/**
		 * Limit results to actions with these mediums. (Optional)
		 * 
		 * @param via Via to limit with.
		 * @return Builder instance.
		 */
		public ListBuilder via(Actions.Alert.Via via) {
			this.parameter(PARAM_VIA, via);
			return this;
		}
		
		@Override
		protected JsonObject execute() {
			return super.execute().get("actions").getAsJsonObject();
		}
	}
}
