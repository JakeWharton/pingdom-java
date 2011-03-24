package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class Probe implements PingdomEntity {
	/**
	 * Serial Version UID.
	 */
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
	public Probe setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getCountry() {
		return this.country;
	}
	public Probe setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getCity() {
		return this.city;
	}
	public Probe setCity(String city) {
		this.city = city;
		return this;
	}
	public String getName() {
		return this.name;
	}
	public Probe setName(String name) {
		this.name = name;
		return this;
	}
	public Boolean getActive() {
		return this.active;
	}
	public Probe setActive(Boolean active) {
		this.active = active;
		return this;
	}
	public String getHostName() {
		return this.hostName;
	}
	public Probe setHostName(String hostName) {
		this.hostName = hostName;
		return this;
	}
	public String getIp() {
		return this.ip;
	}
	public Probe setIp(String ip) {
		this.ip = ip;
		return this;
	}
	public String getCountryIso() {
		return this.countryIso;
	}
	public Probe setCountryIso(String countryIso) {
		this.countryIso = countryIso;
		return this;
	}
}
