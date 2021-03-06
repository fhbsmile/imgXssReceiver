package com.tsystems.si.aviation.img.imgXssReceiver.bean;

// Generated Jun 19, 2015 10:35:39 AM by Hibernate Tools 4.3.1

/**
 * RefAirline generated by hbm2java
 */
public class RefAirline implements java.io.Serializable {

	private Integer id;
	private String ral2lc;
	private String ralName;
	private String ral3lc;

	public RefAirline() {
	}

	public RefAirline(String ral2lc, String ralName, String ral3lc) {
		this.ral2lc = ral2lc;
		this.ralName = ralName;
		this.ral3lc = ral3lc;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRal2lc() {
		return this.ral2lc;
	}

	public void setRal2lc(String ral2lc) {
		this.ral2lc = ral2lc;
	}

	public String getRalName() {
		return this.ralName;
	}

	public void setRalName(String ralName) {
		this.ralName = ralName;
	}

	public String getRal3lc() {
		return this.ral3lc;
	}

	public void setRal3lc(String ral3lc) {
		this.ral3lc = ral3lc;
	}

	@Override
	public String toString() {
		return String.format(
				"RefAirline [id=%s, ral2lc=%s, ralName=%s, ral3lc=%s]", id,
				ral2lc, ralName, ral3lc);
	}

}
