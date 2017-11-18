package org.wingame.dao;

/**
 * TDocument entity. @author MyEclipse Persistence Tools
 */
public class TDocument extends AbstractTDocument implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TDocument() {
	}

	/** full constructor */
	public TDocument(TDocumentId id, String docFilename, String docStatus) {
		super(id, docFilename, docStatus);
	}

}
