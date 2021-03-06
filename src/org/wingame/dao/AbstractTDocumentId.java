package org.wingame.dao;

/**
 * AbstractTDocumentId entity provides the base persistence definition of the
 * TDocumentId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTDocumentId implements java.io.Serializable {

	// Fields

	private TUser TUser;
	private TMeeting TMeeting;

	// Constructors

	/** default constructor */
	public AbstractTDocumentId() {
	}

	/** full constructor */
	public AbstractTDocumentId(TUser TUser, TMeeting TMeeting) {
		this.TUser = TUser;
		this.TMeeting = TMeeting;
	}

	// Property accessors

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TMeeting getTMeeting() {
		return this.TMeeting;
	}

	public void setTMeeting(TMeeting TMeeting) {
		this.TMeeting = TMeeting;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractTDocumentId))
			return false;
		AbstractTDocumentId castOther = (AbstractTDocumentId) other;

		return ((this.getTUser() == castOther.getTUser()) || (this.getTUser() != null
				&& castOther.getTUser() != null && this.getTUser().equals(
				castOther.getTUser())))
				&& ((this.getTMeeting() == castOther.getTMeeting()) || (this
						.getTMeeting() != null
						&& castOther.getTMeeting() != null && this
						.getTMeeting().equals(castOther.getTMeeting())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTUser() == null ? 0 : this.getTUser().hashCode());
		result = 37 * result
				+ (getTMeeting() == null ? 0 : this.getTMeeting().hashCode());
		return result;
	}

}