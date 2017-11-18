package org.wingame.dao;

/**
 * TMeetingStatusId entity. @author MyEclipse Persistence Tools
 */
public class TMeetingStatusId extends AbstractTMeetingStatusId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMeetingStatusId() {
	}

	/** full constructor */
	public TMeetingStatusId(TUser TUser, TMeeting TMeeting) {
		super(TUser, TMeeting);
	}

}
