package com.jakewharton.pingdom.entities;

import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;

/**
 * Represents a Pingdom probe object.
 */
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
	
	/**
	 * Unique probe id.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Country.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * City.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Is the probe currently active?.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getActive() {
		return this.active;
	}
	
	/**
	 * DNS name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getHostName() {
		return this.hostName;
	}
	
	/**
	 * IP address.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getIp() {
		return this.ip;
	}
	
	/**
	 * Country ISO code.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getCountryIso() {
		return this.countryIso;
	}
}
