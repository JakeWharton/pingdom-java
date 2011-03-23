package com.jakewharton.pingdom;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiBuilder;
import com.jakewharton.pingdom.entities.Entity;
import com.jakewharton.pingdom.entities.HasValue;

public abstract class PingdomApiBuilder<T extends Entity> extends ApiBuilder {
	private static final String FIELD_VERSION = "version";
	
	private static final String BASE_URL = "https://api.pingdom.com";
	private static final String BASE_URI = "/api/{" + FIELD_VERSION + "}";
	
	private static final String DEFAULT_VERSION = "2.0";
	private static final int MILLISECONDS_IN_SECOND = 1000;
	private static final char SEPERATOR = ',';
	
	private final PingdomApiService service;
	private final TypeToken<T> token;
	
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat) {
		this(service, token, urlFormat, DEFAULT_VERSION);
	}
	public PingdomApiBuilder(PingdomApiService service, TypeToken<T> token, String urlFormat, String apiVersion) {
		super(BASE_URL + BASE_URI + urlFormat);
		this.service = service;
		this.token = token;
		
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
	protected JsonObject execute() {
		return this.service.get(this.buildUrl());
	}
	
	
	public ApiBuilder parameter(String name, Date from) {
		return this.parameter(name, Long.toString(from.getTime() / MILLISECONDS_IN_SECOND));
	}
	public ApiBuilder parameter(String name, Integer value) {
		return this.parameter(name, Integer.toString(value));
	}
    public ApiBuilder parameter(String name, HasValue value) {
    	return this.parameter(name, value.value());
	}
    public <K extends Object> ApiBuilder parameter(String name, List<K> objectList) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = objectList.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().toString()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	return this.parameter(name, builder.toString());
    }
    public <K extends HasValue> ApiBuilder parameter(String name, Set<K> enumSet) {
    	StringBuilder builder = new StringBuilder();
    	Iterator<K> iterator = enumSet.iterator();
    	while (iterator.hasNext()) {
    		builder.append(encodeUrl(iterator.next().value()));
    		if (iterator.hasNext()) {
    			builder.append(SEPERATOR);
    		}
		}
    	
    	return this.parameter(name, builder.toString());
	}
	public ApiBuilder field(String name, HasValue value) {
		if (value.value() == null || value.value().length() == 0) {
			return this.field(name);
		} else {
			return this.field(name, value.value());
		}
	}
}
