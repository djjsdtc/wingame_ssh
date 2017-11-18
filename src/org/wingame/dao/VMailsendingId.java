package org.wingame.dao;

/**
 * VMailsendingId entity. @author MyEclipse Persistence Tools
 */
public class VMailsendingId extends AbstractVMailsendingId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VMailsendingId() {
	}

	/** full constructor */
	public VMailsendingId(String username, Integer MId, String email,
			String MTitle) {
		super(username, MId, email, MTitle);
	}

}
