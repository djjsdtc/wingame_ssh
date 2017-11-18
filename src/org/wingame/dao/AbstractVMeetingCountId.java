package org.wingame.dao;

/**
 * AbstractVMeetingCountId entity provides the base persistence definition of
 * the VMeetingCountId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVMeetingCountId implements java.io.Serializable {

	// Fields

	private Integer MId;
	private Long MCount;

	// Constructors

	/** default constructor */
	public AbstractVMeetingCountId() {
	}

	/** full constructor */
	public AbstractVMeetingCountId(Integer MId, Long MCount) {
		this.MId = MId;
		this.MCount = MCount;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public Long getMCount() {
		return this.MCount;
	}

	public void setMCount(Long MCount) {
		this.MCount = MCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractVMeetingCountId))
			return false;
		AbstractVMeetingCountId castOther = (AbstractVMeetingCountId) other;

		return ((this.getMId() == castOther.getMId()) || (this.getMId() != null
				&& castOther.getMId() != null && this.getMId().equals(
				castOther.getMId())))
				&& ((this.getMCount() == castOther.getMCount()) || (this
						.getMCount() != null && castOther.getMCount() != null && this
						.getMCount().equals(castOther.getMCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMId() == null ? 0 : this.getMId().hashCode());
		result = 37 * result
				+ (getMCount() == null ? 0 : this.getMCount().hashCode());
		return result;
	}

}