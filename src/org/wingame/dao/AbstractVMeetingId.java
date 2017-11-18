package org.wingame.dao;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractVMeetingId entity provides the base persistence definition of the
 * VMeetingId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMeetingId implements java.io.Serializable {

	// Fields

	private Integer MId;
	private String MTitle;
	private String MAddress;
	private Timestamp MDatetime;
	private Double MFee;
	private Date MDeadline;
	private Long MAttend;

	// Constructors

	/** default constructor */
	public AbstractVMeetingId() {
	}

	/** minimal constructor */
	public AbstractVMeetingId(Integer MId, String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline) {
		this.MId = MId;
		this.MTitle = MTitle;
		this.MAddress = MAddress;
		this.MDatetime = MDatetime;
		this.MFee = MFee;
		this.MDeadline = MDeadline;
	}

	/** full constructor */
	public AbstractVMeetingId(Integer MId, String MTitle, String MAddress,
			Timestamp MDatetime, Double MFee, Date MDeadline, Long MAttend) {
		this.MId = MId;
		this.MTitle = MTitle;
		this.MAddress = MAddress;
		this.MDatetime = MDatetime;
		this.MFee = MFee;
		this.MDeadline = MDeadline;
		this.MAttend = MAttend;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public String getMTitle() {
		return this.MTitle;
	}

	public void setMTitle(String MTitle) {
		this.MTitle = MTitle;
	}

	public String getMAddress() {
		return this.MAddress;
	}

	public void setMAddress(String MAddress) {
		this.MAddress = MAddress;
	}

	public Timestamp getMDatetime() {
		return this.MDatetime;
	}

	public void setMDatetime(Timestamp MDatetime) {
		this.MDatetime = MDatetime;
	}

	public Double getMFee() {
		return this.MFee;
	}

	public void setMFee(Double MFee) {
		this.MFee = MFee;
	}

	public Date getMDeadline() {
		return this.MDeadline;
	}

	public void setMDeadline(Date MDeadline) {
		this.MDeadline = MDeadline;
	}

	public Long getMAttend() {
		return this.MAttend;
	}

	public void setMAttend(Long MAttend) {
		this.MAttend = MAttend;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractVMeetingId))
			return false;
		AbstractVMeetingId castOther = (AbstractVMeetingId) other;

		return ((this.getMId() == castOther.getMId()) || (this.getMId() != null
				&& castOther.getMId() != null && this.getMId().equals(
				castOther.getMId())))
				&& ((this.getMTitle() == castOther.getMTitle()) || (this
						.getMTitle() != null && castOther.getMTitle() != null && this
						.getMTitle().equals(castOther.getMTitle())))
				&& ((this.getMAddress() == castOther.getMAddress()) || (this
						.getMAddress() != null
						&& castOther.getMAddress() != null && this
						.getMAddress().equals(castOther.getMAddress())))
				&& ((this.getMDatetime() == castOther.getMDatetime()) || (this
						.getMDatetime() != null
						&& castOther.getMDatetime() != null && this
						.getMDatetime().equals(castOther.getMDatetime())))
				&& ((this.getMFee() == castOther.getMFee()) || (this.getMFee() != null
						&& castOther.getMFee() != null && this.getMFee()
						.equals(castOther.getMFee())))
				&& ((this.getMDeadline() == castOther.getMDeadline()) || (this
						.getMDeadline() != null
						&& castOther.getMDeadline() != null && this
						.getMDeadline().equals(castOther.getMDeadline())))
				&& ((this.getMAttend() == castOther.getMAttend()) || (this
						.getMAttend() != null && castOther.getMAttend() != null && this
						.getMAttend().equals(castOther.getMAttend())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMId() == null ? 0 : this.getMId().hashCode());
		result = 37 * result
				+ (getMTitle() == null ? 0 : this.getMTitle().hashCode());
		result = 37 * result
				+ (getMAddress() == null ? 0 : this.getMAddress().hashCode());
		result = 37 * result
				+ (getMDatetime() == null ? 0 : this.getMDatetime().hashCode());
		result = 37 * result
				+ (getMFee() == null ? 0 : this.getMFee().hashCode());
		result = 37 * result
				+ (getMDeadline() == null ? 0 : this.getMDeadline().hashCode());
		result = 37 * result
				+ (getMAttend() == null ? 0 : this.getMAttend().hashCode());
		return result;
	}

}