package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public final class Probe implements PingdomEntity {
	private static final long serialVersionUID = 8109107446632814955L;

	private Integer id;
	private String country;
	private String city;
	private String name;
	private Boolean active;
	private String hostName;
	private String ip;
	private String countryIso;
	
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
