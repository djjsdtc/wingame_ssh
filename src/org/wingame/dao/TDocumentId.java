package org.wingame.dao;

/**
 * TDocumentId entity. @author MyEclipse Persistence Tools
 */
public class TDocumentId extends AbstractTDocumentId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TDocumentId() {
	}

	/** full constructor */
	public TDocumentId(TUser TUser, TMeeting TMeeting) {
		super(TUser, TMeeting);
	}

}
