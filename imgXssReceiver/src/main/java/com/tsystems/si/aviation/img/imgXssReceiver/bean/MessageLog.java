package com.tsystems.si.aviation.img.imgXssReceiver.bean;

// Generated Jun 19, 2015 10:35:39 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * MessageLog generated by hbm2java
 */
public class MessageLog implements java.io.Serializable {

	private Integer id;
	private String msgserial;
	private Date messagetime;
	private Integer bytelength;
	private Integer line;
	private Date sendtime;
	private Integer difftime;
	private String filename;
	private Date createtime;
	private String orgtime;
	private String msgtype;
	private String msg;
	private String xmlmsg;
	private String flightnumber;
	private String flightreg;
	private String takeoffAirport;
	private String takeofftime;
	private String landAirport;
	private String landtime;

	public MessageLog() {
	}

	public MessageLog(String msgserial, Date messagetime, Integer bytelength,
			Integer line, Date sendtime, Integer difftime, String filename,
			Date createtime, String orgtime, String msgtype, String msg,
			String xmlmsg, String flightnumber, String flightreg,
			String takeoffAirport, String takeofftime, String landAirport,
			String landtime) {
		this.msgserial = msgserial;
		this.messagetime = messagetime;
		this.bytelength = bytelength;
		this.line = line;
		this.sendtime = sendtime;
		this.difftime = difftime;
		this.filename = filename;
		this.createtime = createtime;
		this.orgtime = orgtime;
		this.msgtype = msgtype;
		this.msg = msg;
		this.xmlmsg = xmlmsg;
		this.flightnumber = flightnumber;
		this.flightreg = flightreg;
		this.takeoffAirport = takeoffAirport;
		this.takeofftime = takeofftime;
		this.landAirport = landAirport;
		this.landtime = landtime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsgserial() {
		return this.msgserial;
	}

	public void setMsgserial(String msgserial) {
		this.msgserial = msgserial;
	}

	public Date getMessagetime() {
		return this.messagetime;
	}

	public void setMessagetime(Date messagetime) {
		this.messagetime = messagetime;
	}

	public Integer getBytelength() {
		return this.bytelength;
	}

	public void setBytelength(Integer bytelength) {
		this.bytelength = bytelength;
	}

	public Integer getLine() {
		return this.line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getDifftime() {
		return this.difftime;
	}

	public void setDifftime(Integer difftime) {
		this.difftime = difftime;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getOrgtime() {
		return this.orgtime;
	}

	public void setOrgtime(String orgtime) {
		this.orgtime = orgtime;
	}

	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getXmlmsg() {
		return this.xmlmsg;
	}

	public void setXmlmsg(String xmlmsg) {
		this.xmlmsg = xmlmsg;
	}

	public String getFlightnumber() {
		return this.flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getFlightreg() {
		return this.flightreg;
	}

	public void setFlightreg(String flightreg) {
		this.flightreg = flightreg;
	}

	public String getTakeoffAirport() {
		return this.takeoffAirport;
	}

	public void setTakeoffAirport(String takeoffAirport) {
		this.takeoffAirport = takeoffAirport;
	}

	public String getTakeofftime() {
		return this.takeofftime;
	}

	public void setTakeofftime(String takeofftime) {
		this.takeofftime = takeofftime;
	}

	public String getLandAirport() {
		return this.landAirport;
	}

	public void setLandAirport(String landAirport) {
		this.landAirport = landAirport;
	}

	public String getLandtime() {
		return this.landtime;
	}

	public void setLandtime(String landtime) {
		this.landtime = landtime;
	}

	@Override
	public String toString() {
		return String
				.format("MessageLog [id=%s, msgserial=%s, msgtype=%s, messagetime=%s, flightnumber=%s, filename=%s, msg=\n%s]",
						id, msgserial, msgtype, messagetime, flightnumber,
						filename, msg);
	}

}
