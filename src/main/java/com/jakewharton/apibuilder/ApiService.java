package com.jakewharton.apibuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

public abstract class ApiService {
	private static final int DEFAULT_TIMEOUT_CONNECT = 60 * 1000;
	private static final int DEFAULT_TIMEOUT_READ = 60 * 1000;
	private static final String GZIP = "gzip";
	private static final String HTTP_METHOD_POST = "POST";
	private static final String HTTP_METHOD_DELETE = "DELETE";
	private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	protected static final String CONTENT_ENCODING = "UTF-8";
	
	private final Map<String, String> requestHeaders;
	private final Map<String, String> requestParameters;
	private int connectTimeout;
	private int readTimeout;
	
	protected ApiService() {
		this.requestHeaders = new HashMap<String, String>();
		this.requestParameters = new HashMap<String, String>();
		
		this.setConnectTimeout(DEFAULT_TIMEOUT_CONNECT);
		this.setReadTimeout(DEFAULT_TIMEOUT_READ);

	}
	
	public void acceptGzip() {
		this.addRequestHeader(HEADER_ACCEPT_ENCODING, GZIP);
	}
	public void addRequestHeader(String name, String value) {
		this.requestHeaders.put(name, value);
	}
	public void removeRequestHeader(String name) {
		this.requestHeaders.remove(name);
	}
	public int getConnectTimeout() {
		return this.connectTimeout;
	}
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public int getReadTimeout() {
		return this.readTimeout;
	}
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	protected InputStream executeGet(String apiUrl) {
		return this.executeGet(apiUrl, HttpURLConnection.HTTP_OK);
	}
	protected InputStream executeGet(String apiUrl, int expected) {
	    try {
	        URL url = new URL(apiUrl);
	        if (!this.requestParameters.isEmpty()) {
	        	if (url.getQuery() == null) {
	        		url = new URL(apiUrl + "?" + ApiService.getParametersString(this.requestParameters));
	        	} else {
	        		url = new URL(apiUrl + "&" + ApiService.getParametersString(this.requestParameters));
	        	}
	        }

	        HttpURLConnection request = (HttpURLConnection)url.openConnection();

	        if (this.connectTimeout > -1) {
	            request.setConnectTimeout(this.connectTimeout);
	        }
	        if (this.readTimeout > -1) {
	            request.setReadTimeout(this.readTimeout);
	        }

	        for (String headerName : this.requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, this.requestHeaders.get(headerName));
	        }

	        request.connect();

	        if (request.getResponseCode() != expected) {
	            throw new ApiException(convertStreamToString(getWrappedInputStream(request.getErrorStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()))));
	        } else {
	            return getWrappedInputStream(request.getInputStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new ApiException(e);
	    }
	}
	protected InputStream executePost(String apiUrl, Map<String, String> parameters) {
		return this.executePost(apiUrl, parameters, HttpURLConnection.HTTP_OK);
	}
	protected InputStream executePost(String apiUrl, Map<String, String> parameters, int expected) {
		try {
            URL url = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection)url.openConnection();

            if (this.connectTimeout > -1) {
                request.setConnectTimeout(this.connectTimeout);
            }
            if (this.readTimeout > -1) {
                request.setReadTimeout(this.readTimeout);
            }
            
            for (String headerName : this.requestHeaders.keySet()) {
                request.setRequestProperty(headerName, this.requestHeaders.get(headerName));
            }
            
            parameters.putAll(this.requestParameters);

            request.setRequestMethod(HTTP_METHOD_POST);
            request.setDoOutput(true);

            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
            
            out.print(getParametersString(parameters));
            out.flush();
            out.close();

            request.connect();
            
            if (request.getResponseCode() != expected) {
            	throw new ApiException(convertStreamToString(getWrappedInputStream(request.getErrorStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()))));
            } else {
                return getWrappedInputStream(request.getInputStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()));
            }
		} catch (IOException e) {
			throw new ApiException(e);
		}
	}
	protected InputStream executeDelete(String apiUrl) {
		return this.executeDelete(apiUrl, HttpURLConnection.HTTP_OK);
	}
	protected InputStream executeDelete(String apiUrl, int expected) {
	    try {
	        URL url = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection)url.openConnection();

	        if (this.connectTimeout > -1) {
	            request.setConnectTimeout(this.connectTimeout);
	        }
	        if (this.readTimeout > -1) {
	            request.setReadTimeout(this.readTimeout);
	        }

	        for (String headerName : this.requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, this.requestHeaders.get(headerName));
	        }

            request.setRequestMethod(HTTP_METHOD_DELETE);
            
	        request.connect();

	        if (request.getResponseCode() != expected) {
	            throw new ApiException(convertStreamToString(getWrappedInputStream(request.getErrorStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()))));
	        } else {
	            return getWrappedInputStream(request.getInputStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new ApiException(e);
	    }
	}
	protected InputStream executeMethod(String apiUrl, String xmlContent, String contentType, String method, int expected) {
	    try {
	        URL url = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();

	        if (this.connectTimeout > -1) {
	            request.setConnectTimeout(this.connectTimeout);
	        }
	        if (this.readTimeout > -1) {
	            request.setReadTimeout(this.readTimeout);
	        }

	        for (String headerName : this.requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, this.requestHeaders.get(headerName));
	        }

	        request.setRequestMethod(method);
	        request.setDoOutput(true);

	        if (contentType != null) {
	            request.setRequestProperty(HEADER_CONTENT_TYPE, contentType);
	        }

	        if (xmlContent != null) {
	            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));

	            out.print(xmlContent);
	            out.flush();
	            out.close();
	        }

	        request.connect();

	        if (request.getResponseCode() != expected) {
	            throw new ApiException(convertStreamToString(getWrappedInputStream(request.getErrorStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()))));
	        } else {
	            return getWrappedInputStream(request.getInputStream(), GZIP.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new ApiException(e);
	    }
	}
	protected static String getParametersString(Map<String, String> parameters) {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, String> entry : parameters.entrySet()) {
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(encodeUrl(entry.getValue()));
			builder.append("&");
		}
		
		//Remove last '&'
		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}
	protected static void closeStream(InputStream is) {
	    try {
	    	if (is != null) {
		        is.close();
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	protected static void closeConnection(HttpURLConnection connection) {
	    try {
	    	if (connection != null) {
	    		connection.disconnect();
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	protected static InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
	    if (gzip) {
	        return new BufferedInputStream(new GZIPInputStream(is));
	    } else {
	        return new BufferedInputStream(is);
	    }
	}
    private static String encodeUrl(String original) {
    	try {
			return URLEncoder.encode(original, CONTENT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
    }
	
	protected static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return sb.toString();
	}
}
