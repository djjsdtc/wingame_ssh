package org.wingame.dao;

/**
 * TMeetingStatus entity. @author MyEclipse Persistence Tools
 */
public class TMeetingStatus extends AbstractTMeetingStatus implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMeetingStatus() {
	}

	/** full constructor */
	public TMeetingStatus(TMeetingStatusId id, String payway) {
		super(id, payway);
	}

}
