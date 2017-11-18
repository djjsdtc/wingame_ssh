package org.wingame.dao;

/**
 * AbstractVMeetingCount entity provides the base persistence definition of the
 * VMeetingCount entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMeetingCount implements java.io.Serializable {

	// Fields

	private VMeetingCountId id;

	// Constructors

	/** default constructor */
	public AbstractVMeetingCount() {
	}

	/** full constructor */
	public AbstractVMeetingCount(VMeetingCountId id) {
		this.id = id;
	}

	// Property accessors

	public VMeetingCountId getId() {
		return this.id;
	}

	public void setId(VMeetingCountId id) {
		this.id = id;
	}

}