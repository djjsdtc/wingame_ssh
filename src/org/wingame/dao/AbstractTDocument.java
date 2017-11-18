package org.wingame.dao;

/**
 * AbstractTDocument entity provides the base persistence definition of the
 * TDocument entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTDocument implements java.io.Serializable {

	// Fields

	private TDocumentId id;
	private String docFilename;
	private String docStatus;

	// Constructors

	/** default constructor */
	public AbstractTDocument() {
	}

	/** full constructor */
	public AbstractTDocument(TDocumentId id, String docFilename,
			String docStatus) {
		this.id = id;
		this.docFilename = docFilename;
		this.docStatus = docStatus;
	}

	// Property accessors

	public TDocumentId getId() {
		return this.id;
	}

	public void setId(TDocumentId id) {
		this.id = id;
	}

	public String getDocFilename() {
		return this.docFilename;
	}

	public void setDocFilename(String docFilename) {
		this.docFilename = docFilename;
	}

	public String getDocStatus() {
		return this.docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

}