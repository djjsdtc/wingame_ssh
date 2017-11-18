package org.wingame.dao;

/**
 * AbstractVMailsending entity provides the base persistence definition of the
 * VMailsending entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMailsending implements java.io.Serializable {

	// Fields

	private VMailsendingId id;

	// Constructors

	/** default constructor */
	public AbstractVMailsending() {
	}

	/** full constructor */
	public AbstractVMailsending(VMailsendingId id) {
		this.id = id;
	}

	// Property accessors

	public VMailsendingId getId() {
		return this.id;
	}

	public void setId(VMailsendingId id) {
		this.id = id;
	}

}