package com.jakewharton.pingdom;

import com.jakewharton.pingdom.services.ActionsService;

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
	//TODO: other services...
	
	public static final ActionsService newActionsService() {
		return new ActionsService();
	}
	//TODO: other services...
}
