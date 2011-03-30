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

/**
 * Pingdom-specific API builder extension which provides helper methods for
 * adding fields, parameters, and post-parameters commonly used in the API.
 * 
 * @param <T> Native class type of the HTTP method call result.
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public abstract class PingdomApiBuilder<T> extends ApiBuilder {
	/** URI field name for API version. */
	private static final String FIELD_VERSION = "version";
	
	/** Pingdom API URL base. */
	private static final String BASE_URL = "https://api.pingdom.com";
	
	/** Pingdom API URI base. */
	private static final String BASE_URI = "/api/{" + FIELD_VERSION + "}";
	
	/** Number of milliseconds in a single second. */
	/*package*/ static final long MILLISECONDS_IN_SECOND = 1000;
	
	/** Default API version. */
	private static final double DEFAULT_VERSION = 2.0;
	
	/** Valued-list seperator. */
	private static final char SEPERATOR = ',';
	
	
	/** Valid HTTP request methods. */
	protected enum HttpMethod {
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
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, double apiVersion) {
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
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, HttpMethod method, double apiVersion) {
		super(BASE_URL + BASE_URI + urlFormat);
		
		this.service = service;
		this.service.setApiVersion(apiVersion);
		
		this.token = token;
		this.method = method;
		this.postParameters = new HashMap<String, String>();
		
		this.field(FIELD_VERSION, Double.toString(apiVersion));
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
	protected ApiBuilder parameter(String name, Date value) {
		return this.parameter(name, Long.toString(value.getTime() / MILLISECONDS_IN_SECOND));
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param value Value.
	 * @return Current instance for builder pattern.
	 */
	protected <K extends PingdomEnumeration> ApiBuilder parameter(String name, K value) {
		if ((value == null) || (value.toString() == null) || (value.toString().length() == 0)) {
			return this.parameter(name, "");
		} else {
			return this.parameter(name, value.toString());
		}
	}
	
	/**
	 * Add a URL parameter value.
	 * 
	 * @param name Name.
	 * @param valueList List of values.
	 * @return Current instance for builder pattern.
	 */
	protected <K extends Object> ApiBuilder parameter(String name, List<K> valueList) {
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
	protected <K extends PingdomEnumeration> ApiBuilder parameter(String name, Set<K> valueSet) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = valueSet.iterator();
    	while (iterator.hasNext()) {
    		builder.append(ApiBuilder.encodeUrl(iterator.next().toString()));
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
	protected <K extends PingdomEnumeration> ApiBuilder field(String name, K value) {
		if ((value == null) || (value.toString() == null) || (value.toString().length() == 0)) {
			return this.field(name);
		} else {
			return this.field(name, value.toString());
		}
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	protected PingdomApiBuilder<T> postParameter(String name, String value) {
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
	protected PingdomApiBuilder<T> postParameter(String name, boolean value) {
		return this.postParameter(name, Boolean.toString(value));
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
	protected PingdomApiBuilder<T> postParameter(String name, int value) {
		return this.postParameter(name, Integer.toString(value));
	}
    
    /**
     * Add a request body parameter value.
     * 
     * @param name Name.
     * @param valueList List of value.
     * @return Current instance for builder pattern.
     */
	protected <K extends Object> PingdomApiBuilder<T> postParameter(String name, List<K> valueList) {
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
	protected <K extends PingdomEnumeration> PingdomApiBuilder<T> postParameter(String name, K value) {
    	return this.postParameter(name, value.toString());
    }
}
