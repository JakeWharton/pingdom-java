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
	
	/** Number of milliseconds in a single second. */
	static final int MILLISECONDS_IN_SECOND = 1000;
	
	/** Default API version. */
	private static final String DEFAULT_VERSION = "2.0";
	
	/** Valued-list seperator. */
	private static final char SEPERATOR = ',';
	
	/** Valid HTTP request methods. */
	public enum HttpMethod {
		Get, Post, Delete, Put
	}
	
	/** Service instance. */
	private final PingdomApiService service;
	/** Type token of return type. */
	private final TypeToken<T> token;
	/** HTTP request method to use. */
	private final HttpMethod method;
	/** Parameters to send in body of request. */
	private final Map<String, String> postParameters;
	
	
	/**
	 * Initialize a new builder for an HTTP GET call.
	 * 
	 * @param service Service to bind to.
	 * @param token Return type token.
	 * @param urlFormat URL format string.
	 */
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat) {
		this(service, token, urlFormat, HttpMethod.Get, DEFAULT_VERSION);
	}
	
	/**
	 * Initialize a new builder for the specified HTTP method call.
	 * 
	 * @param service Service to bind to.
	 * @param token Return type token.
	 * @param urlFormat URL format string.
	 * @param method HTTP method.
	 */
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, HttpMethod method) {
		this(service, token, urlFormat, method, DEFAULT_VERSION);
	}
	
	/**
	 * Initalize a new builder for an HTTP GET call with specified API version.
	 * 
	 * @param service Service to bind to.
	 * @param token Return type token.
	 * @param urlFormat URL format string.
	 * @param apiVersion API version.
	 */
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, String apiVersion) {
		this(service, token, urlFormat, HttpMethod.Get, apiVersion);
	}
	
	/**
	 * Initialize a new builder for the specified HTTP method and API version.
	 * 
	 * @param service Service to bind to.
	 * @param token Return type token.
	 * @param urlFormat URL format string.
	 * @param method HTTP method.
	 * @param apiVersion API version.
	 */
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
			case Put:
				return this.service.put(url, this.postParameters);
			default:
				throw new IllegalArgumentException("Unknown HttpMethod type " + this.method.toString());
		}
	}
	
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param value Value.
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder parameter(String name, Date value) {
		return this.parameter(name, Long.toString(value.getTime() / MILLISECONDS_IN_SECOND));
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param value Value.
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder parameter(String name, int value) {
		return this.parameter(name, Integer.toString(value));
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param value Value.
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder parameter(String name, boolean value) {
		return this.parameter(name, Boolean.toString(value));
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param value Value.
	 * @return Current instance for builder pattern.
	 */
    public ApiBuilder parameter(String name, HasValue value) {
    	return this.parameter(name, value.value());
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param valueList List of values.
	 * @return Current instance for builder pattern.
	 */
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
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param valueSet Set of values.
	 * @return Current instance for builder pattern.
	 */
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
    
    /**
     * Add a URL field value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    public ApiBuilder field(String name, int value) {
    	return this.field(name, Integer.toString(value));
    }
    
    /**
     * Add a URL field value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    public ApiBuilder field(String name, boolean value) {
    	return this.field(name, Boolean.toString(value));
    }
    
    /**
     * Add a URL field value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	public ApiBuilder field(String name, HasValue value) {
		if (value.value() == null || value.value().length() == 0) {
			return this.field(name);
		} else {
			return this.field(name, value.value());
		}
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	public PingdomApiBuilder<T> postParameter(String name, String value) {
		this.postParameters.put(name, value);
		return this;
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	public PingdomApiBuilder<T> postParameter(String name, boolean value) {
		return this.postParameter(name, Boolean.toString(value));
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	public PingdomApiBuilder<T> postParameter(String name, int value) {
		return this.postParameter(name, Integer.toString(value));
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param valueList List of value.
     * @return Current instance for builder pattern.
     */
    public <K extends Object> PingdomApiBuilder<T> postParameter(String name, List<K> valueList) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = valueList.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().toString()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	return this.postParameter(name, builder.toString());
    }
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    public <K extends HasValue> PingdomApiBuilder<T> postParameter(String name, K hasValue) {
    	return this.postParameter(name, hasValue.value());
    }
}
