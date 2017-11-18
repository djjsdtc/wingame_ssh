package org.wingame.dao;

/**
 * TAnnounce entity. @author MyEclipse Persistence Tools
 */
public class TAnnounce extends AbstractTAnnounce implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TAnnounce() {
	}

	/** full constructor */
	public TAnnounce(TMeeting TMeeting, String annTitle, String annText) {
		super(TMeeting, annTitle, annText);
	}

}
