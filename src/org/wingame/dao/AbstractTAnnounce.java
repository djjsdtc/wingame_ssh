package org.wingame.dao;

/**
 * AbstractTAnnounce entity provides the base persistence definition of the
 * TAnnounce entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTAnnounce implements java.io.Serializable {

	// Fields

	private Integer annId;
	private TMeeting TMeeting;
	private String annTitle;
	private String annText;

	// Constructors

	/** default constructor */
	public AbstractTAnnounce() {
	}

	/** full constructor */
	public AbstractTAnnounce(TMeeting TMeeting, String annTitle, String annText) {
		this.TMeeting = TMeeting;
		this.annTitle = annTitle;
		this.annText = annText;
	}

	// Property accessors

	public Integer getAnnId() {
		return this.annId;
	}

	public void setAnnId(Integer annId) {
		this.annId = annId;
	}

	public TMeeting getTMeeting() {
		return this.TMeeting;
	}

	public void setTMeeting(TMeeting TMeeting) {
		this.TMeeting = TMeeting;
	}

	public String getAnnTitle() {
		return this.annTitle;
	}

	public void setAnnTitle(String annTitle) {
		this.annTitle = annTitle;
	}

	public String getAnnText() {
		return this.annText;
	}

	public void setAnnText(String annText) {
		this.annText = annText;
	}

}