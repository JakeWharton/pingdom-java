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
import com.jakewharton.pingdom.entities.Actions;
import com.jakewharton.pingdom.entities.Check;
import com.jakewharton.pingdom.entities.Settings;
import com.jakewharton.pingdom.util.Base64;

public abstract class PingdomApiService extends ApiService {
	private static final int DEFAULT_TIMEOUT_CONNECT = 60 * 1000;
	private static final int DEFAULT_TIMEOUT_READ = 60 * 1000;
	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String HEADER_AUTHORIZATION_TYPE = "Basic";
	private static final String HEADER_APP_KEY = "App-Key";
	private static final Charset UTF_8_CHAR_SET = Charset.forName(ApiService.CONTENT_ENCODING);
	private static final String HTTP_METHOD_PUT = "PUT";
	
    private final JsonParser parser;
    private final List<AsyncResponseHandler<List<? extends PingdomEntity>>> handlers;
	
	public PingdomApiService() {
		this.parser = new JsonParser();
		this.handlers = new ArrayList<AsyncResponseHandler<List<? extends PingdomEntity>>>();
		
		this.setConnectTimeout(DEFAULT_TIMEOUT_CONNECT);
		this.setReadTimeout(DEFAULT_TIMEOUT_READ);
		this.acceptGzip();
	}
	
	public JsonObject get(String url) {
		return this.unmarshall(this.executeGet(url));
	}
	public JsonObject post(String url, Map<String, String> parameters) {
		return this.unmarshall(this.executePost(url, parameters));
	}
	public JsonObject delete(String url) {
		return this.unmarshall(this.executeDelete(url));
	}
	public JsonObject put(String url, Map<String, String> parameters) {
		return this.unmarshall(this.executeMethod(url, getParametersString(parameters), null, HTTP_METHOD_PUT, HttpURLConnection.HTTP_OK));
	}
	
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
	public void setAppKey(String value) {
		this.addRequestHeader(HEADER_APP_KEY, value);
	}

	@SuppressWarnings("unchecked")
	protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		Gson gson = this.getGsonBuilder().create();
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
	        closeStream(jsonContent);
	    }
	}
	
	protected void notifyObservers(List<? extends PingdomEntity> response) {
		for(AsyncResponseHandler<List<? extends PingdomEntity>> handler : this.handlers) {
			handler.handleResponse(response);
		}
	}

	public void addResonseHandler(AsyncResponseHandler<List<? extends PingdomEntity>> handler) {
		this.handlers.add(handler);
	}

	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		
		builder.setFieldNamingStrategy(PingdomFieldNamingStrategy.INSTANCE);
		
		builder.registerTypeAdapter(Actions.Alert.Status.class, new JsonDeserializer<Actions.Alert.Status>() {
			@Override
			public Actions.Alert.Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return Actions.Alert.Status.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(Actions.Alert.Via.class, new JsonDeserializer<Actions.Alert.Via>() {
			@Override
			public Actions.Alert.Via deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return Actions.Alert.Via.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return new Date(json.getAsInt() * PingdomApiBuilder.MILLISECONDS_IN_SECOND); //S to MS
			}
		});
		builder.registerTypeAdapter(Check.Status.class, new JsonDeserializer<Check.Status>() {
			@Override
			public Check.Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return Check.Status.fromValue(json.getAsString());
			}
		});
		builder.registerTypeAdapter(Settings.PublicReports.Months.class, new JsonDeserializer<Settings.PublicReports.Months>() {
			@Override
			public Settings.PublicReports.Months deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return Settings.PublicReports.Months.fromValue(json.getAsString());
			}
		});
		
		return builder;
	}
}
