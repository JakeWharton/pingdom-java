package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Check;
import com.jakewharton.pingdom.entities.Message;
import com.jakewharton.pingdom.enumerations.CheckType;

/**
 * Represents Pingdom's remote check service.
 */
public class CheckService extends PingdomApiService {
	/**
	 * Returns a list overview of all checks.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ListBuilder list() {
		return new ListBuilder(this);
	}
	
	public static final class ListBuilder extends PingdomApiBuilder<List<Check>> {
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		
		private static final String URI = "/checks";
		
		private static final int MAX_LIMIT = 250000;

		private ListBuilder(CheckService service) {
			super(service, new TypeToken<List<Check>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("checks").getAsJsonArray();
		}
		
		/**
		 * Limits the number of returned results to the specified quantity. Maximum value is 250,000. (Optional)
		 * 
		 * @param limit Result limit.
		 * @return Builder instance.
		 */
		public ListBuilder limit(int limit) {
			if (limit > MAX_LIMIT) {
				throw new IllegalArgumentException("Value must be less than or equal to " + MAX_LIMIT);
			}
			
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
			if (!this.hasParameter(PARAM_LIMIT)) {
				throw new IllegalArgumentException("Requires that a limit be set.");
			}
			
			this.parameter(PARAM_OFFSET, offset);
			return this;
		}
	}
	
	/**
	 * Returns a detailed description of a specified check.
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get(int checkId) {
		return new GetBuilder(this, checkId);
	}
	
	public static final class GetBuilder extends PingdomApiBuilder<Check> {
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/checks/{" + FIELD_CHECK_ID + "}";
		
		private GetBuilder(CheckService service, int checkId) {
			super(service, new TypeToken<Check>() {}, URI);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("check");
		}
	}
	
	/**
	 * Creates a new check with settings specified by provided parameters.
	 * 
	 * @param name Check name.
	 * @param host Target host.
	 * @param type Type of check.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public CreateBuilder create(String name, String host, CheckType type) {
		return new CreateBuilder(this, name, host, type);
	}
	
	public static final class CreateBuilder extends PingdomApiBuilder<Check> {
		private static final String POST_NAME = "name";
		private static final String POST_HOST = "host";
		private static final String POST_TYPE = "type";
		private static final String POST_PAUSED = "paused";
		private static final String POST_RESOLUTION = "resolution";
		private static final String POST_CONTACT_IDS = "contactids";
		private static final String POST_SEND_TO_EMAIL = "sendtoemail";
		private static final String POST_SEND_TO_SMS = "sendtosms";
		private static final String POST_SEND_TO_TWITTER = "sendtotwitter";
		private static final String POST_SEND_TO_IPHONE = "sendtoiphone";
		private static final String POST_SEND_NOTIFICATION_WHEN_DOWN = "sendnotificationwhendown";
		private static final String POST_NOTIFY_AGAIN_EVERY = "notifyagainevery";
		private static final String POST_NOTIFY_WHEN_BACK_UP = "notifywhenbackup";
		
		private static final String URI = "/checks";
		
		private CreateBuilder(CheckService service, String name, String host, CheckType type) {
			super(service, new TypeToken<Check>() {}, URI, HttpMethod.Post);
			
			this.postParameter(POST_NAME, name);
			this.postParameter(POST_HOST, host);
			this.postParameter(POST_TYPE, type);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("check");
		}
		
		/**
		 * Paused.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder paused(boolean value) {
			this.postParameter(POST_PAUSED, value);
			return this;
		}
		
		/**
		 * Check resolution.
		 * 
		 * @param minutes Value (in minutes).
		 * @return Builder instance.
		 */
		public CreateBuilder resolution(int minutes) {
			//TODO: check if 1, 5, 15, 30, or 60
			this.postParameter(POST_RESOLUTION, minutes);
			return this;
		}
		
		/**
		 * Contact identifiers.
		 * 
		 * @param list List of integers.
		 * @return Builder instance.
		 */
		public CreateBuilder contactIds(List<Integer> list) {
			this.postParameter(POST_CONTACT_IDS, list);
			return this;
		}
		
		/**
		 * Send alerts as email.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder sendToEmail(boolean value) {
			this.postParameter(POST_SEND_TO_EMAIL, value);
			return this;
		}
		
		/**
		 * Send alerts as SMS.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder sendToSms(boolean value) {
			this.postParameter(POST_SEND_TO_SMS, value);
			return this;
		}
		
		/**
		 * Send alerts through Twitter.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder sendToTwitter(boolean value) {
			this.postParameter(POST_SEND_TO_TWITTER, value);
			return this;
		}
		
		/**
		 * Send alerts to iPhone.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder sendToIPhone(boolean value) {
			this.postParameter(POST_SEND_TO_IPHONE, value);
			return this;
		}
		
		/**
		 * Send notification when down n times.
		 * 
		 * @param count Count.
		 * @return Builder instance.
		 */
		public CreateBuilder sendNotificationWhenDown(int count) {
			this.postParameter(POST_SEND_NOTIFICATION_WHEN_DOWN, count);
			return this;
		}
		
		/**
		 * Notify again every n result. 0 means that no extra notifications will be sent.
		 * 
		 * @param count Count.
		 * @return Builder instance.
		 */
		public CreateBuilder notifyAgainEvery(int count) {
			this.postParameter(POST_NOTIFY_AGAIN_EVERY, count);
			return this;
		}
		
		/**
		 * Notify when back up again.
		 * 
		 * @param value Value.
		 * @return Builder instance.
		 */
		public CreateBuilder notifyWhenBackUp(boolean value) {
			this.postParameter(POST_NOTIFY_WHEN_BACK_UP, value);
			return this;
		}
	}

	/**
	 * Deletes a check. THIS METHOD IS IRREVERSIBLE! You will lose all collected
	 * data. Be careful!
	 * 
	 * @param checkId Check ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public DeleteBuilder delete(int checkId) {
		return new DeleteBuilder(this, checkId);
	}
	
	public static final class DeleteBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_CHECK_ID = "checkid";
		
		private static final String URI = "/checks/{" + FIELD_CHECK_ID + "}";
		
		private DeleteBuilder(CheckService service, int checkId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Delete);
			
			this.field(FIELD_CHECK_ID, checkId);
		}
	}
}
