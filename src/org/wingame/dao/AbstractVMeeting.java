package org.wingame.dao;

/**
 * AbstractVMeeting entity provides the base persistence definition of the
 * VMeeting entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMeeting implements java.io.Serializable {

	// Fields

	private VMeetingId id;

	// Constructors

	/** default constructor */
	public AbstractVMeeting() {
	}

	/** full constructor */
	public AbstractVMeeting(VMeetingId id) {
		this.id = id;
	}

	// Property accessors

	public VMeetingId getId() {
		return this.id;
	}

	public void setId(VMeetingId id) {
		this.id = id;
	}

}