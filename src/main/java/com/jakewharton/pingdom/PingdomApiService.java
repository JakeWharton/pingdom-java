package com.jakewharton.pingdom;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Since;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiService;
import com.jakewharton.apibuilder.ApiException;
import com.jakewharton.pingdom.entities.Check.CheckTypeBase;
import com.jakewharton.pingdom.entities.Check.CheckTypeWrapper;
import com.jakewharton.pingdom.entities.SummaryAverage.ResponseTime.AvgResponseWrapper;
import com.jakewharton.pingdom.entities.SummaryAverage.ResponseTime.ProbeResponseTime;
import com.jakewharton.pingdom.enumerations.AlertStatus;
import com.jakewharton.pingdom.enumerations.AlertVia;
import com.jakewharton.pingdom.enumerations.BannerType;
import com.jakewharton.pingdom.enumerations.CheckStatus;
import com.jakewharton.pingdom.enumerations.CheckType;
import com.jakewharton.pingdom.enumerations.PerformanceResolution;
import com.jakewharton.pingdom.enumerations.PublicReportMonths;
import com.jakewharton.pingdom.enumerations.ReportFrequency;
import com.jakewharton.pingdom.enumerations.SharedReportType;
import com.jakewharton.pingdom.enumerations.SmsProvider;
import com.jakewharton.pingdom.enumerations.StateStatus;
import com.jakewharton.pingdom.util.Base64;

/**
 * Pingdom-specific API service extension which facilitates provides helper
 * methods for performing remote method calls as well as deserializing the
 * corresponding JSON responses.
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public abstract class PingdomApiService extends ApiService {
	/** Default connection timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_CONNECT = 60 * 1000;
	
	/** Default read timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_READ = 60 * 1000;
	
	/** HTTP header name for authorization. */
	private static final String HEADER_AUTHORIZATION = "Authorization";
	
	/** HTTP authorization type. */
	private static final String HEADER_AUTHORIZATION_TYPE = "Basic";
	
	/** HTTP header name for the Pingdom API KEY */
	private static final String HEADER_APP_KEY = "App-Key";
	
	/** Character set used for encoding and decoding transmitted values. */
	private static final Charset UTF_8_CHAR_SET = Charset.forName(ApiService.CONTENT_ENCODING);
	
	/** REST HTTP method name used when modifying values. */
	private static final String HTTP_METHOD_PUT = "PUT";
	
	
	/** JSON parser for reading the content stream. */
    private final JsonParser parser;

    /**
     * Optional API version level to limit the deserialization to only class
     * fields annotated with a {@link Since} annotation equal to or less than
     * this value.
     */
    private Double apiVersion;
	
    
    /**
     * Create a new Pingdom service with our proper default values.
     */
	public PingdomApiService() {
		this.parser = new JsonParser();
		
		this.setConnectTimeout(DEFAULT_TIMEOUT_CONNECT);
		this.setReadTimeout(DEFAULT_TIMEOUT_READ);
		this.acceptGzip();
	}
	
	
	/**
	 * Execute request using HTTP GET.
	 * 
	 * @param url URL to request.
	 * @return JSON object.
	 */
	public JsonObject get(String url) {
		return this.unmarshall(this.executeGet(url));
	}
	
	/**
	 * Execute request using HTTP POST.
	 * 
	 * @param url URL to request.
	 * @param parameters Parameters to place in the request body.
	 * @return JSON object.
	 */
	public JsonObject post(String url, Map<String, String> parameters) {
		return this.unmarshall(this.executePost(url, parameters));
	}
	
	/**
	 * Execute request using HTTP DELETE.
	 * 
	 * @param url URL to request.
	 * @return JSON object.
	 */
	public JsonObject delete(String url) {
		return this.unmarshall(this.executeDelete(url));
	}
	
	/**
	 * Execute request using HTTP PUT.
	 * 
	 * @param url URL to request.
	 * @param parameters Parameters to place in request body.
	 * @return JSON object.
	 */
	public JsonObject put(String url, Map<String, String> parameters) {
		String content = ApiService.getParametersString(parameters);
		return this.unmarshall(this.executeMethod(url, content, null, HTTP_METHOD_PUT, HttpURLConnection.HTTP_OK));
	}
	
	/**
	 * Set email and password to use for HTTP basic authentication.
	 * 
	 * @param email Email.
	 * @param password Password.
	 */
	public void setAuthentication(String email, String password) {
		if ((email == null) || (email.length() == 0)) {
			throw new IllegalArgumentException("Email must not be empty.");
		}
		if ((password == null) || (password.length() == 0)) {
			throw new IllegalArgumentException("Password must not be empty.");
		}
		
		String source = email + ":" + password;
		String authentication = HEADER_AUTHORIZATION_TYPE + " " + Base64.encodeBytes(source.getBytes());
		
		this.addRequestHeader(HEADER_AUTHORIZATION, authentication);
	}
	
	/**
	 * Set API key to use for client authentication by Pingdom.
	 * 
	 * @param value API key.
	 */
	public void setAppKey(String value) {
		this.addRequestHeader(HEADER_APP_KEY, value);
	}
	
	/**
	 * Set the API version.
	 * 
	 * @param apiVersion API version.
	 */
	public void setApiVersion(double apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Use GSON to deserialize a JSON object to a native class representation.
	 * 
	 * @param <T> Native class type.
	 * @param typeToken Native class type wrapper.
	 * @param response Serialized JSON object.
	 * @return Deserialized native instance.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		GsonBuilder gsonBuilder = PingdomApiService.getGsonBuilder();
		if (this.apiVersion != null) {
			gsonBuilder.setVersion(this.apiVersion);
		}
		
		return (T)gsonBuilder.create().fromJson(response, typeToken.getType());
	}
	
	/**
	 * Read the entirety of an input stream and parse to a JSON object.
	 * 
	 * @param jsonContent JSON content input stream.
	 * @return Parsed JSON object.
	 */
	protected JsonObject unmarshall(InputStream jsonContent) {
        try {
        	JsonElement element = this.parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (element.isJsonObject()) {
        		return element.getAsJsonObject();
        	} else {
        		throw new ApiException("Unknown content found in response." + element);
        	}
        } catch (Exception e) {
            throw new ApiException(e);
        } finally {
	        ApiService.closeStream(jsonContent);
	    }
	}

	/**
	 * Create a {@link GsonBuilder} and register all of the custom types needed
	 * in order to properly deserialize complex Pingdom-specific type.
	 * 
	 * @return Assembled GSON builder instance.
	 */
	static GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingStrategy(new PingdomFieldNamingStrategy());

		//CLASS types
		builder.registerTypeAdapter(CheckTypeWrapper.class, new JsonDeserializer<CheckTypeWrapper>() {
			@Override
			public CheckTypeWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				CheckType typeNative = null;
				CheckTypeBase typeObject = null;
				
				if (json.isJsonPrimitive()) {
					//Get the type from the string
					typeNative = CheckType.fromValue(json.getAsString());	
				} else {
					//Get the first key/value pair (should be the only one)
					Entry<String, JsonElement> entry = json.getAsJsonObject().entrySet().iterator().next();
					//Get the type from the key string
					typeNative = CheckType.fromValue(entry.getKey());
					//De-serialize to the proper class
					typeObject = context.deserialize(entry.getValue(), CheckTypeBase.class);
				}
				
				return new CheckTypeWrapper(typeNative, typeObject);
			}
		});
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return new Date(json.getAsLong() * PingdomApiBuilder.MILLISECONDS_IN_SECOND); //S to MS
			}
		});
		builder.registerTypeAdapter(AvgResponseWrapper.class, new JsonDeserializer<AvgResponseWrapper>() {
			@Override
			public AvgResponseWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				if (json.isJsonPrimitive()) {
					return new AvgResponseWrapper(json.getAsInt());
				} else if (json.isJsonArray()) {
					Type type = (new TypeToken<List<ProbeResponseTime>>() {}).getType();
					return new AvgResponseWrapper(context.<List<ProbeResponseTime>>deserialize(json.getAsJsonArray(), type));
				} else {
					throw new JsonParseException("Unknown 'average reponse' JSON: " + json.toString());
				}
			}
		});
		
		//ENUM types
		builder.registerTypeAdapter(AlertStatus.class, new JsonDeserializer<AlertStatus>() {
			@Override
			public AlertStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return AlertStatus.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(AlertVia.class, new JsonDeserializer<AlertVia>() {
			@Override
			public AlertVia deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return AlertVia.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(BannerType.class, new JsonDeserializer<BannerType>() {
			@Override
			public BannerType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return BannerType.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(CheckStatus.class, new JsonDeserializer<CheckStatus>() {
			@Override
			public CheckStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return CheckStatus.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(CheckType.class, new JsonDeserializer<CheckType>() {
			@Override
			public CheckType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return CheckType.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(PerformanceResolution.class, new JsonDeserializer<PerformanceResolution>() {
			@Override
			public PerformanceResolution deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return PerformanceResolution.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(PublicReportMonths.class, new JsonDeserializer<PublicReportMonths>() {
			@Override
			public PublicReportMonths deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return PublicReportMonths.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(ReportFrequency.class, new JsonDeserializer<ReportFrequency>() {
			@Override
			public ReportFrequency deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return ReportFrequency.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(SharedReportType.class, new JsonDeserializer<SharedReportType>() {
			@Override
			public SharedReportType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return SharedReportType.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(SmsProvider.class, new JsonDeserializer<SmsProvider>() {
			@Override
			public SmsProvider deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return SmsProvider.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(StateStatus.class, new JsonDeserializer<StateStatus>() {
			@Override
			public StateStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return StateStatus.fromValue(json.getAsString());
			}
		});
		
		return builder;
	}
	
	/**
	 * Custom GSON field naming strategy which simply converts the field to all
	 * lowercase letters.
	 */
	private static final class PingdomFieldNamingStrategy implements FieldNamingStrategy {
		@Override
		public String translateName(Field field) {
			return field.getName().toLowerCase();
		}
	}
}
