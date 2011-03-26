package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Message;
import com.jakewharton.pingdom.entities.ReportSubscription;
import com.jakewharton.pingdom.enumerations.ReportFrequency;

/**
 * Represents Pingdom's remote email reports service.
 */
public class ReportsEmailService extends PingdomApiService {
	/**
	 * Returns a list of email report subscriptions.
	 * 
	 * @return Builder instance.
	 */
	public ListBuilder list() {
		return new ListBuilder(this);
	}
	
	public static final class ListBuilder extends PingdomApiBuilder<List<ReportSubscription>> {
		private static final String URI = "/reports.email";
		
		private ListBuilder(ReportsEmailService service) {
			super(service, new TypeToken<List<ReportSubscription>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("subscription").getAsJsonArray();
		}
	}
	
	/**
	 * Creates a new email report.
	 * 
	 * @param name Name.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public CreateBuilder create(String name) {
		return new CreateBuilder(this, name);
	}
	
	public static final class CreateBuilder extends PingdomApiBuilder<Message> {
		private static final String POST_NAME = "name";
		private static final String POST_CHECK_ID = "checkid";
		private static final String POST_FREQUENCY = "frequency";
		private static final String POST_CONTACT_IDS = "contactids";
		private static final String POST_ADDITIONAL_EMAILS = "additionalemails";
		
		private static final String URI = "/reports.email";
		
		private CreateBuilder(ReportsEmailService service, String name) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Post);
			
			this.postParameter(POST_NAME, name);
		}
		
		/**
		 * Check identifier. If omitted, this will be an overview report.
		 * 
		 * @param checkId Value.
		 * @return Builder instance.
		 */
		public CreateBuilder checkId(int checkId) {
			this.postParameter(POST_CHECK_ID, checkId);
			return this;
		}
		
		/**
		 * Report frequency.
		 * 
		 * @param frequency Value.
		 * @return Builder instance.
		 */
		public CreateBuilder frequency(ReportFrequency frequency) {
			this.postParameter(POST_FREQUENCY, frequency);
			return this;
		}
		
		/**
		 * Receiving contact identifiers.
		 * 
		 * @param contactIds List of contact IDs.
		 * @return Builder instance.
		 */
		public CreateBuilder contactIds(List<Integer> contactIds) {
			this.postParameter(POST_CONTACT_IDS, contactIds);
			return this;
		}
		
		/**
		 * Additional receiving emails.
		 * 
		 * @param additionalEmails List of emails.
		 * @return Builder instance.
		 */
		public CreateBuilder additionalEmails(List<String> additionalEmails) {
			this.postParameter(POST_ADDITIONAL_EMAILS, additionalEmails);
			return this;
		}
	}

	/**
	 * Modify an email report.
	 * 
	 * @param reportId Report ID. 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ModifyBuilder modify(int reportId) {
		return new ModifyBuilder(this, reportId);
	}
	
	public static final class ModifyBuilder extends PingdomApiBuilder<Message> {
		private static final String POST_NAME = "name";
		private static final String POST_CHECK_ID = "checkid";
		private static final String POST_FREQUENCY = "frequency";
		private static final String POST_CONTACT_IDS = "contactids";
		private static final String POST_ADDITIONAL_EMAILS = "additionalemails";
		
		private static final String FIELD_REPORT_ID = "reportid";
		
		private static final String URI = "/reports.email/{" + FIELD_REPORT_ID + "}";
		
		private ModifyBuilder(ReportsEmailService service, int reportId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Put);
			
			this.field(FIELD_REPORT_ID, reportId);
		}
		
		/**
		 * Name.
		 * 
		 * @param name Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder name(String name) {
			this.postParameter(POST_NAME, name);
			return this;
		}
		
		/**
		 * Check identifier. If omitted, this will be an overview report.
		 * 
		 * @param checkId Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder checkId(int checkId) {
			this.postParameter(POST_CHECK_ID, checkId);
			return this;
		}
		
		/**
		 * Report frequency.
		 * 
		 * @param frequency Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder frequency(ReportFrequency frequency) {
			this.postParameter(POST_FREQUENCY, frequency);
			return this;
		}
		
		/**
		 * Receiving contact identifiers.
		 * 
		 * @param contactIds List of contact IDs.
		 * @return Builder instance.
		 */
		public ModifyBuilder contactIds(List<Integer> contactIds) {
			this.postParameter(POST_CONTACT_IDS, contactIds);
			return this;
		}
		
		/**
		 * Additional receiving emails.
		 * 
		 * @param additionalEmails List of emails.
		 * @return Builder instance.
		 */
		public ModifyBuilder additionalEmails(List<String> additionalEmails) {
			this.postParameter(POST_ADDITIONAL_EMAILS, additionalEmails);
			return this;
		}
	}

	/**
	 * Delete an email report.
	 * 
	 * @param reportId Report ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public DeleteBuilder delete(int reportId) {
		return new DeleteBuilder(this, reportId);
	}
	
	public static final class DeleteBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_REPORT_ID = "reportid";
		
		private static final String URI = "/reports.emamil/{" + FIELD_REPORT_ID + "}";
		
		private DeleteBuilder(ReportsEmailService service, int reportId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Delete);
			
			this.field(FIELD_REPORT_ID, reportId);
		}
	}
}
