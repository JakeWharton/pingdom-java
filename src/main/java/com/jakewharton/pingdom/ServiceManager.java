package com.jakewharton.pingdom;

import com.jakewharton.pingdom.services.ActionsService;
import com.jakewharton.pingdom.services.AnalysisService;
import com.jakewharton.pingdom.services.CheckService;
import com.jakewharton.pingdom.services.ProbeService;
import com.jakewharton.pingdom.services.ReferenceService;
import com.jakewharton.pingdom.services.ServerTimeService;
import com.jakewharton.pingdom.services.SettingsService;
import com.jakewharton.pingdom.services.TraceRouteService;

/**
 * Class to manage service creation with default settings.
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public class ServiceManager {
	/** API key. */
	private String appKeyValue;
	/** User email. */
	private String email;
	/** User password. */
	private String password;
	/** Connection timeout (in milliseconds). */
	private Integer connectionTimeout;
	/** Read timeout (in milliseconds). */
	private Integer readTimeout;
	
	
	/** Create a new manager instance. */
	public ServiceManager() {}
	
	
	/**
	 * Set default authentication credentials.
	 * 
	 * @param email User email.
	 * @param password User password.
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setAuthentication(String email, String password) {
		this.email = email;
		this.password = password;
		return this;
	}
	
	/**
	 * Set default API key.
	 * 
	 * @param value API key value.
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setAppKey(String value) {
		this.appKeyValue = value;
		return this;
	}
	
	/**
	 * Set default connection timeout.
	 * 
	 * @param connectionTimeout Timeout (in milliseconds).
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}
	
	/**
	 * Set default read timeout.
	 * 
	 * @param readTimeout Timeout (in milliseconds).
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}
	
	/**
	 * Set up a new service with the defaults.
	 * 
	 * @param service Service to set up.
	 */
	private void setupService(PingdomApiService service) {
		if (this.appKeyValue != null) {
			service.setAppKey(this.appKeyValue);
		}
		if ((this.email != null) && (this.password != null)) {
			service.setAuthentication(this.email, this.password);
		}
		if (this.connectionTimeout != null) {
			service.setConnectTimeout(this.connectionTimeout);
		}
		if (this.readTimeout != null) {
			service.setReadTimeout(this.readTimeout);
		}
	}
	
	/**
	 * Get actions service instance.
	 * 
	 * @return Instance.
	 */
	public ActionsService actionsService() {
		ActionsService service = ServiceManager.newActionsService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get analysis service instance.
	 * 
	 * @return Instance.
	 */
	public AnalysisService analysisService() {
		AnalysisService service = ServiceManager.newAnalysisService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get check service instance.
	 * 
	 * @return Instance.
	 */
	public CheckService checkService() {
		CheckService service = ServiceManager.newCheckService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get probe service instance.
	 * 
	 * @return Instance.
	 */
	public ProbeService probeService() {
		ProbeService service = ServiceManager.newProbeService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get reference service instance.
	 * 
	 * @return Instance.
	 */
	public ReferenceService referenceService() {
		ReferenceService service = ServiceManager.newReferenceService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get server time service instance.
	 * 
	 * @return Instance.
	 */
	public ServerTimeService serverTimeService() {
		ServerTimeService service = ServiceManager.newServerTimeService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get settings service instance.
	 * 
	 * @return Instance.
	 */
	public SettingsService settingsService() {
		SettingsService service = ServiceManager.newSettingsService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get trace route service instance.
	 * 
	 * @return Instance.
	 */
	public TraceRouteService traceRouteService() {
		TraceRouteService service = ServiceManager.newTraceRouteService();
		this.setupService(service);
		return service;
	}
	
	
	/**
	 * Create new actions service instance.
	 * 
	 * @return Instance.
	 */
	public static final ActionsService newActionsService() {
		return new ActionsService();
	}
	
	/**
	 * Create new analysis service instance.
	 * 
	 * @return Instance.
	 */
	public static final AnalysisService newAnalysisService() {
		return new AnalysisService();
	}
	
	/**
	 * Create new check service instance.
	 * 
	 * @return Instance.
	 */
	public static final CheckService newCheckService() {
		return new CheckService();
	}
	
	/**
	 * Create new probe service instance.
	 * 
	 * @return Instance.
	 */
	public static final ProbeService newProbeService() {
		return new ProbeService();
	}
	
	/**
	 * Create new reference service instance.
	 * 
	 * @return Instance.
	 */
	public static final ReferenceService newReferenceService() {
		return new ReferenceService();
	}
	
	/**
	 * Create new server time service instance.
	 * 
	 * @return Instance.
	 */
	public static final ServerTimeService newServerTimeService() {
		return new ServerTimeService();
	}
	
	/**
	 * Create new settings service instance.
	 * 
	 * @return Instance.
	 */
	public static final SettingsService newSettingsService() {
		return new SettingsService();
	}
	
	/**
	 * Create new trace route service instance.
	 * 
	 * @return Instance.
	 */
	public static final TraceRouteService newTraceRouteService() {
		return new TraceRouteService();
	}
}
