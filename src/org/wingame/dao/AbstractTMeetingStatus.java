package org.wingame.dao;

/**
 * AbstractTMeetingStatus entity provides the base persistence definition of the
 * TMeetingStatus entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTMeetingStatus implements java.io.Serializable {

	// Fields

	private TMeetingStatusId id;
	private String payway;

	// Constructors

	/** default constructor */
	public AbstractTMeetingStatus() {
	}

	/** full constructor */
	public AbstractTMeetingStatus(TMeetingStatusId id, String payway) {
		this.id = id;
		this.payway = payway;
	}

	// Property accessors

	public TMeetingStatusId getId() {
		return this.id;
	}

	public void setId(TMeetingStatusId id) {
		this.id = id;
	}

	public String getPayway() {
		return this.payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

}