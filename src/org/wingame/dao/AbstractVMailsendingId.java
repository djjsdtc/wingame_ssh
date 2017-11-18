package org.wingame.dao;

/**
 * AbstractVMailsendingId entity provides the base persistence definition of the
 * VMailsendingId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMailsendingId implements java.io.Serializable {

	// Fields

	private String username;
	private Integer MId;
	private String email;
	private String MTitle;

	// Constructors

	/** default constructor */
	public AbstractVMailsendingId() {
	}

	/** full constructor */
	public AbstractVMailsendingId(String username, Integer MId, String email,
			String MTitle) {
		this.username = username;
		this.MId = MId;
		this.email = email;
		this.MTitle = MTitle;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMTitle() {
		return this.MTitle;
	}

	public void setMTitle(String MTitle) {
		this.MTitle = MTitle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractVMailsendingId))
			return false;
		AbstractVMailsendingId castOther = (AbstractVMailsendingId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getMId() == castOther.getMId()) || (this.getMId() != null
						&& castOther.getMId() != null && this.getMId().equals(
						castOther.getMId())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getMTitle() == castOther.getMTitle()) || (this
						.getMTitle() != null && castOther.getMTitle() != null && this
						.getMTitle().equals(castOther.getMTitle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getMId() == null ? 0 : this.getMId().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getMTitle() == null ? 0 : this.getMTitle().hashCode());
		return result;
	}

}