package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

public final class Probe implements PingdomEntity {
	private static final long serialVersionUID = 8109107446632814955L;

	@Since(2.0) private Integer id;
	@Since(2.0) private String country;
	@Since(2.0) private String city;
	@Since(2.0) private String name;
	@Since(2.0) private Boolean active;
	@Since(2.0) private String hostName;
	@Since(2.0) private String ip;
	@Since(2.0) private String countryIso;
	
	public Integer getId() {
		return this.id;
	}
	public String getCountry() {
		return this.country;
	}
	public String getCity() {
		return this.city;
	}
	public String getName() {
		return this.name;
	}
	public Boolean getActive() {
		return this.active;
	}
	public String getHostName() {
		return this.hostName;
	}
	public String getIp() {
		return this.ip;
	}
	public String getCountryIso() {
		return this.countryIso;
	}
}
