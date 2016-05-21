package com.tsystems.si.aviation.img.imgXssReceiver.bean;

// Generated Jun 19, 2015 10:35:39 AM by Hibernate Tools 4.3.1

/**
 * RefAirport generated by hbm2java
 */
public class RefAirport implements java.io.Serializable {

	private String rapCode;
	private String rapIata3lc;
	private String rapIcao4lc;
	private String rapCity;
	private String rapFlytime;

	public RefAirport() {
	}

	public RefAirport(String rapCode) {
		this.rapCode = rapCode;
	}

	public RefAirport(String rapCode, String rapIata3lc, String rapIcao4lc,
			String rapCity, String rapFlytime) {
		this.rapCode = rapCode;
		this.rapIata3lc = rapIata3lc;
		this.rapIcao4lc = rapIcao4lc;
		this.rapCity = rapCity;
		this.rapFlytime = rapFlytime;
	}

	public String getRapCode() {
		return this.rapCode;
	}

	public void setRapCode(String rapCode) {
		this.rapCode = rapCode;
	}

	public String getRapIata3lc() {
		return this.rapIata3lc;
	}

	public void setRapIata3lc(String rapIata3lc) {
		this.rapIata3lc = rapIata3lc;
	}

	public String getRapIcao4lc() {
		return this.rapIcao4lc;
	}

	public void setRapIcao4lc(String rapIcao4lc) {
		this.rapIcao4lc = rapIcao4lc;
	}

	public String getRapCity() {
		return this.rapCity;
	}

	public void setRapCity(String rapCity) {
		this.rapCity = rapCity;
	}

	public String getRapFlytime() {
		return this.rapFlytime;
	}

	public void setRapFlytime(String rapFlytime) {
		this.rapFlytime = rapFlytime;
	}

	@Override
	public String toString() {
		return String
				.format("RefAirport [rapCode=%s, rapIata3lc=%s, rapIcao4lc=%s, rapCity=%s, rapFlytime=%s]",
						rapCode, rapIata3lc, rapIcao4lc, rapCity, rapFlytime);
	}

}
