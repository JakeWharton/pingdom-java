package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Message;
import com.jakewharton.pingdom.entities.ReportPublic;

/**
 * Represents Pingdom's remote public reports service.
 */
public class ReportsPublicService extends PingdomApiService {
	/**
	 * Returns a list of public (web-based) reports.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ListBuilder list() {
		return new ListBuilder(this);
	}
	
	/**
	 * Request builder for {@link ReportsPublicService#list()}.
	 */
	public static final class ListBuilder extends PingdomApiBuilder<List<ReportPublic>> {
		private static final String URI = "/reports.public";
		
		private ListBuilder(ReportsPublicService service) {
			super(service, new TypeToken<List<ReportPublic>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("public").getAsJsonArray();
		}
	}
	
	/**
	 * Activate public report for a specified check.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ActivateBuilder activate(int checkId) {
		return new ActivateBuilder(this, checkId);
	}
	
	/**
	 * Request builder for {@link ReportsPublicService#activate(int)}.
	 */
	public static final class ActivateBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/reports.public/{" + FIELD_CHECK_ID + "}";
		
		private ActivateBuilder(ReportsPublicService service, int checkId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Put);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
	}
	
	/**
	 * Deactivate public report for a specified check.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public DeactivateBuilder deactivate(int checkId) {
		return new DeactivateBuilder(this, checkId);
	}
	
	/**
	 * Request builder for {@link ReportsPublicService#deactivate(int)}.
	 */
	public static final class DeactivateBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/reports.public/{" + FIELD_CHECK_ID + "}";
		
		private DeactivateBuilder(ReportsPublicService service, int checkId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Delete);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
	}
}
