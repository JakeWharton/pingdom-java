package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Contact;
import com.jakewharton.pingdom.entities.Message;

/**
 * Represents Pingdom's remote contact service.
 */
public class ContactService extends PingdomApiService {
	/**
	 * Returns a list of all contacts.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public ListBuilder list() {
		return new ListBuilder(this);
	}
	
	/**
	 * Request builder for {@link ContactService#list()}.
	 */
	public static final class ListBuilder extends PingdomApiBuilder<List<Contact>> {
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		
		private static final String URI = "/contacts";
		
		private ListBuilder(ContactService service) {
			super(service, new TypeToken<List<Contact>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("contacts").getAsJsonArray();
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
			if (!this.hasParameter(PARAM_LIMIT)) {
				throw new IllegalArgumentException("Requires that a limit be set.");
			}
			
			this.parameter(PARAM_OFFSET, offset);
			return this;
		}
	}

	/**
	 * Create a new contact.
	 * 
	 * @param name Name.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public CreateBuilder create(String name) {
		return new CreateBuilder(this, name);
	}
	
	/**
	 * Request builder for {@link ContactService#create(String)}.
	 */
	public static final class CreateBuilder extends PingdomApiBuilder<Contact> {
		private static final String POST_NAME = "name";
		private static final String POST_EMAIL = "email";
		private static final String POST_CELL_PHONE = "cellphone";
		private static final String POST_COUNTRY_CODE = "countrycode";
		private static final String POST_COUNTRY_ISO = "countryiso";
		private static final String POST_DEFAULT_SMS_PROVIDER = "defaultsmsprovider";
		private static final String POST_DIRECT_TWITTER = "directtwitter";
		private static final String POST_TWITTER_USER = "twitteruser";
		
		private static final String URI = "/contacts";
		
		private CreateBuilder(ContactService service, String name) {
			super(service, new TypeToken<Contact>() {}, URI, HttpMethod.Post);
			
			this.postParameter(POST_NAME, name);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("contact");
		}
		
		/**
		 * Email.
		 * 
		 * @param email Value.
		 * @return Builder instance.
		 */
		public CreateBuilder email(String email) {
			this.postParameter(POST_EMAIL, email);
			return this;
		}
		
		/**
		 * Cellphone number, without the country code part. In some countries
		 * you are supposed to exclude leading zeroes. (Requires countrycode
		 * and countryiso).
		 * 
		 * @param cellPhone Value.
		 * @return Builder instance.
		 */
		public CreateBuilder cellPhone(String cellPhone) {
			this.postParameter(POST_CELL_PHONE, cellPhone);
			return this;
		}
		
		/**
		 * Cellphone country code (Requires cellphone and countryiso).
		 * 
		 * @param countryCode Value.
		 * @return Builder instance.
		 */
		public CreateBuilder countryCode(String countryCode) {
			this.postParameter(POST_COUNTRY_CODE, countryCode);
			return this;
		}
		
		/**
		 * Cellphone country ISO code. (Requires cellphone and countrycode).
		 * 
		 * @param countryIso Value (example: US (USA), GB (Britain) or SE (Sweden)).
		 * @return Builder instance.
		 */
		public CreateBuilder countryIso(String countryIso) {
			this.postParameter(POST_COUNTRY_ISO, countryIso);
			return this;
		}
		
		/**
		 * Default SMS provider.
		 * 
		 * @param defaultSmsProvider Value.
		 * @return Builder instance.
		 */
		public CreateBuilder defaultSmsProvider(String defaultSmsProvider) {
			this.postParameter(POST_DEFAULT_SMS_PROVIDER, defaultSmsProvider);
			return this;
		}
		
		/**
		 * Send twitter messages as Direct Messages.
		 * 
		 * @param directTwitter Value.
		 * @return Builder instance.
		 */
		public CreateBuilder directTwitter(boolean directTwitter) {
			this.postParameter(POST_DIRECT_TWITTER, directTwitter);
			return this;
		}
		
		/**
		 * Twitter user.
		 * 
		 * @param twitterUser Value.
		 * @return Builder instance.
		 */
		public CreateBuilder twitterUser(String twitterUser) {
			this.postParameter(POST_TWITTER_USER, twitterUser);
			return this;
		}
	}

	/**
	 * Modify a contact.
	 * 
	 * @param contactId Contact ID.
	 * @return Builder instance.
	 */
	public ModifyBuilder modify(int contactId) {
		return new ModifyBuilder(this, contactId);
	}
	
	/**
	 * Request builder for {@link ContactService#modify(int)}.
	 */
	public static final class ModifyBuilder extends PingdomApiBuilder<Message> {
		private static final String POST_NAME = "name";
		private static final String POST_EMAIL = "email";
		private static final String POST_CELL_PHONE = "cellphone";
		private static final String POST_COUNTRY_CODE = "countrycode";
		private static final String POST_COUNTRY_ISO = "countryiso";
		private static final String POST_DEFAULT_SMS_PROVIDER = "defaultsmsprovider";
		private static final String POST_DIRECT_TWITTER = "directtwitter";
		private static final String POST_TWITTER_USER = "twitteruser";
		
		private static final String FIELD_CONTACT_ID = "contactid";
		
		private static final String URI = "/contacts/{" + FIELD_CONTACT_ID + "}";
		
		private ModifyBuilder(ContactService service, int contactId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Put);
			
			this.field(FIELD_CONTACT_ID, contactId);
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
		 * Email.
		 * 
		 * @param email Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder email(String email) {
			this.postParameter(POST_EMAIL, email);
			return this;
		}
		
		/**
		 * Cellphone number, without the country code part. In some countries
		 * you are supposed to exclude leading zeroes. (Requires countrycode
		 * and countryiso).
		 * 
		 * @param cellPhone Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder cellPhone(String cellPhone) {
			this.postParameter(POST_CELL_PHONE, cellPhone);
			return this;
		}
		
		/**
		 * Cellphone country code (Requires cellphone and countryiso).
		 * 
		 * @param countryCode Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder countryCode(String countryCode) {
			this.postParameter(POST_COUNTRY_CODE, countryCode);
			return this;
		}
		
		/**
		 * Cellphone country ISO code. (Requires cellphone and countrycode).
		 * 
		 * @param countryIso Value (example: US (USA), GB (Britain) or SE (Sweden)).
		 * @return Builder instance.
		 */
		public ModifyBuilder countryIso(String countryIso) {
			this.postParameter(POST_COUNTRY_ISO, countryIso);
			return this;
		}
		
		/**
		 * Default SMS provider.
		 * 
		 * @param defaultSmsProvider Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder defaultSmsProvider(String defaultSmsProvider) {
			this.postParameter(POST_DEFAULT_SMS_PROVIDER, defaultSmsProvider);
			return this;
		}
		
		/**
		 * Send twitter messages as Direct Messages.
		 * 
		 * @param directTwitter Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder directTwitter(boolean directTwitter) {
			this.postParameter(POST_DIRECT_TWITTER, directTwitter);
			return this;
		}
		
		/**
		 * Twitter user.
		 * 
		 * @param twitterUser Value.
		 * @return Builder instance.
		 */
		public ModifyBuilder twitterUser(String twitterUser) {
			this.postParameter(POST_TWITTER_USER, twitterUser);
			return this;
		}
	}

	/**
	 * Deletes a contact.
	 * 
	 * @param contactId Contact ID.
	 * @return Builder instance.
	 */
	public DeleteBuilder delete(int contactId) {
		return new DeleteBuilder(this, contactId);
	}
	
	/**
	 * Request builder for {@link ContactService#delete(int)}.
	 */
	public static final class DeleteBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_CONTACT_ID = "contactid";
		
		private static final String URI = "/contacts/{" + FIELD_CONTACT_ID + "}";
		
		private DeleteBuilder(ContactService service, int contactId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Delete);
			
			this.field(FIELD_CONTACT_ID, contactId);
		}
	}
}
