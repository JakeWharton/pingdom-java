package com.jakewharton.pingdom;

import com.jakewharton.pingdom.services.ActionsService;
import com.jakewharton.pingdom.services.AnalysisService;
import com.jakewharton.pingdom.services.CheckService;

public class ServiceManager {
	private String appKeyValue;
	private String email;
	private String password;
	
	public ServiceManager() {}
	
	public void setAuthentication(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public void setAppKey(String value) {
		this.appKeyValue = value;
	}
	
	private void setupService(PingdomApiService service) {
		if (this.appKeyValue != null) {
			service.setAppKey(this.appKeyValue);
		}
		if ((this.email != null) && (this.password != null)) {
			service.setAuthentication(this.email, this.password);
		}
	}
	
	public ActionsService actionsService() {
		ActionsService service = ServiceManager.newActionsService();
		this.setupService(service);
		return service;
	}
	public AnalysisService analysisService() {
		AnalysisService service = ServiceManager.newAnalysisService();
		this.setupService(service);
		return service;
	}
	public CheckService checkService() {
		CheckService service = ServiceManager.newCheckService();
		this.setupService(service);
		return service;
	}
	
	public static final ActionsService newActionsService() {
		return new ActionsService();
	}
	public static final AnalysisService newAnalysisService() {
		return new AnalysisService();
	}
	public static final CheckService newCheckService() {
		return new CheckService();
	}
}
