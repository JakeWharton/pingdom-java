package com.jakewharton.pingdom;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiService;
import com.jakewharton.apibuilder.AsyncResponseHandler;
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

public abstract class PingdomApiService extends ApiService {
	/** Default connection timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_CONNECT = 60 * 1000;
	/** Default read timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_READ = 60 * 1000;
	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String HEADER_AUTHORIZATION_TYPE = "Basic";
	private static final String HEADER_APP_KEY = "App-Key";
	private static final Charset UTF_8_CHAR_SET = Charset.forName(ApiService.CONTENT_ENCODING);
	private static final String HTTP_METHOD_PUT = "PUT";
	
    private final JsonParser parser;
    private final List<AsyncResponseHandler<List<? extends PingdomEntity>>> handlers;
    
    private double apiVersion;
	
	public PingdomApiService() {
		this.parser = new JsonParser();
		this.handlers = new ArrayList<AsyncResponseHandler<List<? extends PingdomEntity>>>();
		
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

	@SuppressWarnings("unchecked")
	protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		Gson gson = PingdomApiService.getGsonBuilder().setVersion(this.apiVersion).create();
		return (T)gson.fromJson(response, typeToken.getType());
	}
	
	protected JsonObject unmarshall(InputStream jsonContent) {
        try {
        	JsonElement element = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
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
	
	protected <T extends PingdomEntity> void notifyObservers(List<T> response) {
		for(AsyncResponseHandler<List<? extends PingdomEntity>> handler : this.handlers) {
			handler.handleResponse(response);
		}
	}

	public void addResonseHandler(AsyncResponseHandler<List<? extends PingdomEntity>> handler) {
		this.handlers.add(handler);
	}

	static GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingStrategy(new PingdomFieldNamingStrategy());

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
					throw new JsonParseException("Unknown average reponse JSON: " + json.toString());
				}
			}
		});
		
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
}
