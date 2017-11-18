package org.wingame.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * TMeeting entity. @author MyEclipse Persistence Tools
 */
public class TMeeting extends AbstractTMeeting implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMeeting() {
	}

	/** minimal constructor */
	public TMeeting(String MTitle, String MAddress, Timestamp MDatetime,
			Double MFee, Date MDeadline) {
		super(MTitle, MAddress, MDatetime, MFee, MDeadline);
	}

	/** full constructor */
	public TMeeting(String MTitle, String MAddress, Timestamp MDatetime,
			Double MFee, Date MDeadline, Set TDocuments, Set TMeetingStatuses,
			Set TAnnounces) {
		super(MTitle, MAddress, MDatetime, MFee, MDeadline, TDocuments,
				TMeetingStatuses, TAnnounces);
	}

}
