package com.jakewharton.pingdom;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiBuilder;

public abstract class PingdomApiBuilder<T> extends ApiBuilder {
	private static final String FIELD_VERSION = "version";
	
	private static final String BASE_URL = "https://api.pingdom.com";
	private static final String BASE_URI = "/api/{" + FIELD_VERSION + "}";
	
	private static final String DEFAULT_VERSION = "2.0";
	private static final int MILLISECONDS_IN_SECOND = 1000;
	private static final char SEPERATOR = ',';
	
	public enum HttpMethod {
		Get, Post, Delete
	}
	
	private final PingdomApiService service;
	private final TypeToken<T> token;
	private final HttpMethod method;
	private final Map<String, String> postParameters;
	
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat) {
		this(service, token, urlFormat, HttpMethod.Get, DEFAULT_VERSION);
	}
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, HttpMethod method) {
		this(service, token, urlFormat, method, DEFAULT_VERSION);
	}
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, String apiVersion) {
		this(service, token, urlFormat, HttpMethod.Get, apiVersion);
	}
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, HttpMethod method, String apiVersion) {
		super(BASE_URL + BASE_URI + urlFormat);
		
		this.service = service;
		this.token = token;
		this.method = method;
		this.postParameters = new HashMap<String, String>();
		
		this.field(FIELD_VERSION, apiVersion);
	}

	
	/**
	 * Execute remote API method and unmarshall the result to its native type.
	 * 
	 * @return Instance of result type.
	 */
	public final T fire() {
		return this.service.unmarshall(this.token, this.execute());
	}
	
	/**
	 * <p>Execute the remote API method and return the JSON object result.<p>
	 * 
	 * <p>This method can be overridden to select a specific subset of the JSON
	 * object. The overriding implementation should still call 'super.execute()'
	 * and then perform the filtering from there.</p> 
	 * 
	 * @return JSON object instance.
	 */
	protected JsonElement execute() {
		final String url = this.buildUrl();
		switch (this.method) {
			case Get:
				return this.service.get(url);
			case Post:
				return this.service.post(url, this.postParameters);
			case Delete:
				return this.service.delete(url);
			default:
				throw new IllegalArgumentException("Unknown HttpMethod type " + this.method.toString());
		}
	}
	
	
	public ApiBuilder parameter(String name, Date value) {
		return this.parameter(name, Long.toString(value.getTime() / MILLISECONDS_IN_SECOND));
	}
	public ApiBuilder parameter(String name, Integer value) {
		return this.parameter(name, Integer.toString(value));
	}
    public ApiBuilder parameter(String name, HasValue value) {
    	return this.parameter(name, value.value());
	}
    public <K extends Object> ApiBuilder parameter(String name, List<K> valueList) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = valueList.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().toString()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	return this.parameter(name, builder.toString());
    }
    public <K extends HasValue> ApiBuilder parameter(String name, Set<K> valueSet) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = valueSet.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().value()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	
    	return this.parameter(name, builder.toString());
	}
    
    public ApiBuilder field(String name, Integer value) {
    	return this.field(name, Integer.toString(value));
    }
	public ApiBuilder field(String name, HasValue value) {
		if (value.value() == null || value.value().length() == 0) {
			return this.field(name);
		} else {
			return this.field(name, value.value());
		}
	}
	
	public PingdomApiBuilder<T> postParameter(String name, String value) {
		this.postParameters.put(name, value);
		return this;
	}
	public PingdomApiBuilder<T> postParameter(String name, Boolean value) {
		this.postParameters.put(name, Boolean.toString(value));
		return this;
	}
	public PingdomApiBuilder<T> postParameter(String name, Integer value) {
		this.postParameters.put(name, Integer.toString(value));
		return this;
	}
    public <K extends Object> PingdomApiBuilder<T> postParameter(String name, List<K> valueList) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = valueList.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().toString()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	this.postParameters.put(name, builder.toString());
    	return this;
    }
}
