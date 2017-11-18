package org.wingame.dao;

import java.sql.Timestamp;
import java.util.Date;

/**
 * VMeetingId entity. @author MyEclipse Persistence Tools
 */
public class VMeetingId extends AbstractVMeetingId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VMeetingId() {
	}

	/** minimal constructor */
	public VMeetingId(Integer MId, String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline) {
		super(MId, MTitle, MAddress, MDatetime, MFee, MDeadline);
	}

	/** full constructor */
	public VMeetingId(Integer MId, String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline, Long MAttend) {
		super(MId, MTitle, MAddress, MDatetime, MFee, MDeadline, MAttend);
	}

}
