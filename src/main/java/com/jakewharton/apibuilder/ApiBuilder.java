package com.jakewharton.apibuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>Quickly and efficiently assemble URLs which contain both in-URL fields
 * and appended parameters.</p>
 * 
 * <p>Parts of the code for this class are from Nabeel Mukhtar's
 * github-java-sdk library.</p>
 * 
 * @author Jake Wharton <jakewharton@gmail>
 */
public class ApiBuilder {
	private static final String DEFAULT_FORMAT = "json";
	private static final String CONTENT_ENCODING = "UTF-8";
        
    /** Opening bracket of a field variable. */
    public static final char API_URL_PLACEHOLDER_START = '{';

    /** Closing bracket of a field variable. */
    public static final char API_URL_PLACEHOLDER_END = '}';
    
	/** The URL format. */
    private final String urlFormat;
    
	/** Map of parameters. */
    private Map<String, String> parametersMap = new HashMap<String, String>();
	
	/** Map of fields. */
	private Map<String, String> fieldsMap = new HashMap<String, String>();
    
	/**
	 * Instantiates a new API URL builder.
	 * 
	 * @param urlFormat The URL format.
	 */
    public ApiBuilder(String urlFormat) {
    	this(urlFormat, DEFAULT_FORMAT);
	}
	
	/**
	 * Instantiates a new API URL builder.
	 * 
	 * @param urlFormat The URL format.
	 * @param contentFormat The format.
	 */
    public ApiBuilder(String urlFormat, String contentFormat) {
		this.urlFormat = urlFormat;
	}
    
	/**
	 * With parameter.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * 
	 * @return Current instance for builder pattern.
	 */
    public ApiBuilder parameter(String name, String value) {
    	if ((value != null) && (value.length() > 0)) {
    		this.parametersMap.put(name, encodeUrl(value));
    	}
		
		return this;
	}
    
	/**
	 * With empty field.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder field(String name) {
		this.fieldsMap.put(name, "");

		return this;
	}

	/**
	 * With field.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * 
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder field(String name, String value) {
		return this.field(name, value, false);
	}

	/**
	 * With field.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param escape
	 *            the escape
	 * 
	 * @return Current instance for builder pattern.
	 */
	public ApiBuilder field(String name, String value, boolean escape) {
		if (escape) {
			this.fieldsMap.put(name, ApiBuilder.encodeUrl(value));
		} else {
			this.fieldsMap.put(name, value);
		}

		return this;
	}
    
	/**
	 * Test if a parameter key already exists.
	 * 
	 * @param name Name of key.
	 * @return Boolean.
	 */
	public boolean hasParameter(String name) {
		return this.parametersMap.containsKey(name);
	}
	
	/**
	 * Test if a field key already exists.
	 * 
	 * @param name Name of key.
	 * @return Boolean.
	 */
	public boolean hasField(String name) {
		return this.fieldsMap.containsKey(name);
	}
	
	/**
	 * Build the URL.
	 * 
	 * @return String representation of the URL.
	 */
	public String buildUrl() {
		return this.buildUrl(true);
	}
	
	/**
	 * Build the URL.
	 * 
	 * @param appendAllParameters Whether to append parameters that were not explicitly defined in the URI.
	 * @return String representation of the URL.
	 */
	public String buildUrl(boolean appendAllParameters) {
		StringBuilder urlBuilder = new StringBuilder();
		StringBuilder placeHolderBuilder = new StringBuilder();
		boolean placeHolderFlag = false;
		boolean firstParameter = true;
		List<String> usedParameters = new LinkedList<String>();
		for (int i = 0; i < this.urlFormat.length(); i++) {
			if (this.urlFormat.charAt(i) == API_URL_PLACEHOLDER_START) {
				placeHolderBuilder = new StringBuilder();
				placeHolderFlag = true;
			} else if (placeHolderFlag && this.urlFormat.charAt(i) == API_URL_PLACEHOLDER_END) {
				String placeHolder = placeHolderBuilder.toString();
				if (this.fieldsMap.containsKey(placeHolder)) {
					urlBuilder.append(this.fieldsMap.get(placeHolder));
				} else if (this.parametersMap.containsKey(placeHolder)) {
					if (firstParameter) {
						firstParameter = false;
						urlBuilder.append("?");
					} else {
						urlBuilder.append("&");
					}
					urlBuilder.append(placeHolder);
					urlBuilder.append("=");
					urlBuilder.append(this.parametersMap.get(placeHolder));
					usedParameters.add(placeHolder);
				} else {
					// we did not find a binding for the placeholder.
					// skip it.
					// urlBuilder.append(API_URLS_PLACEHOLDER_START);
					// urlBuilder.append(placeHolder);
					// urlBuilder.append(API_URLS_PLACEHOLDER_END);
				}
				placeHolderFlag = false;
			} else if (placeHolderFlag) {
				placeHolderBuilder.append(this.urlFormat.charAt(i));
			} else {
				urlBuilder.append(this.urlFormat.charAt(i));
			}
		}
		
		//Append all remaining parameters, if desired
		if (appendAllParameters && (this.parametersMap.size() > usedParameters.size())) {
			for (String parameterName : this.parametersMap.keySet()) {
				if (!usedParameters.contains(parameterName)) {
					if (firstParameter) {
						firstParameter = false;
						urlBuilder.append("?");
					} else {
						urlBuilder.append("&");
					}
					urlBuilder.append(parameterName);
					urlBuilder.append("=");
					urlBuilder.append(this.parametersMap.get(parameterName));
				}
			}
		}
		return urlBuilder.toString();
	}
	
    /**
	 * Encode URL.
	 * 
	 * @param original
	 *            the original
	 * 
	 * @return the string
	 */
    protected static String encodeUrl(String original) {
    	try {
			return URLEncoder.encode(original, CONTENT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
    }
}
