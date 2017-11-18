package org.wingame.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTMeeting entity provides the base persistence definition of the
 * TMeeting entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTMeeting implements java.io.Serializable {

	// Fields

	private Integer MId;
	private String MTitle;
	private String MAddress;
	private Timestamp MDatetime;
	private Double MFee;
	private Date MDeadline;
	private Set TDocuments = new HashSet(0);
	private Set TMeetingStatuses = new HashSet(0);
	private Set TAnnounces = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTMeeting() {
	}

	/** minimal constructor */
	public AbstractTMeeting(String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline) {
		this.MTitle = MTitle;
		this.MAddress = MAddress;
		this.MDatetime = MDatetime;
		this.MFee = MFee;
		this.MDeadline = MDeadline;
	}

	/** full constructor */
	public AbstractTMeeting(String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline, Set TDocuments,
			Set TMeetingStatuses, Set TAnnounces) {
		this.MTitle = MTitle;
		this.MAddress = MAddress;
		this.MDatetime = MDatetime;
		this.MFee = MFee;
		this.MDeadline = MDeadline;
		this.TDocuments = TDocuments;
		this.TMeetingStatuses = TMeetingStatuses;
		this.TAnnounces = TAnnounces;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public String getMTitle() {
		return this.MTitle;
	}

	public void setMTitle(String MTitle) {
		this.MTitle = MTitle;
	}

	public String getMAddress() {
		return this.MAddress;
	}

	public void setMAddress(String MAddress) {
		this.MAddress = MAddress;
	}

	public Timestamp getMDatetime() {
		return this.MDatetime;
	}

	public void setMDatetime(Timestamp MDatetime) {
		this.MDatetime = MDatetime;
	}

	public Double getMFee() {
		return this.MFee;
	}

	public void setMFee(Double MFee) {
		this.MFee = MFee;
	}

	public Date getMDeadline() {
		return this.MDeadline;
	}

	public void setMDeadline(Date MDeadline) {
		this.MDeadline = MDeadline;
	}

	public Set getTDocuments() {
		return this.TDocuments;
	}

	public void setTDocuments(Set TDocuments) {
		this.TDocuments = TDocuments;
	}

	public Set getTMeetingStatuses() {
		return this.TMeetingStatuses;
	}

	public void setTMeetingStatuses(Set TMeetingStatuses) {
		this.TMeetingStatuses = TMeetingStatuses;
	}

	public Set getTAnnounces() {
		return this.TAnnounces;
	}

	public void setTAnnounces(Set TAnnounces) {
		this.TAnnounces = TAnnounces;
	}

}