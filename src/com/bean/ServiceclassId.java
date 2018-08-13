package com.bean;

/**
 * ServiceclassId entity. @author MyEclipse Persistence Tools
 */

public class ServiceclassId implements java.io.Serializable {

	//服务类的组合id，以服务类型、目标和范围相同的服务标记为功能相同的服务类
	// Fields

	private String serviceType;
	private String serviceTarget;
	private String serviceRange;

	// Constructors

	/** default constructor */
	public ServiceclassId() {
	}

	/** full constructor */
	public ServiceclassId(String serviceType, String serviceTarget,
			String serviceRange) {
		this.serviceType = serviceType;
		this.serviceTarget = serviceTarget;
		this.serviceRange = serviceRange;
	}

	// Property accessors

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTarget() {
		return this.serviceTarget;
	}

	public void setServiceTarget(String serviceTarget) {
		this.serviceTarget = serviceTarget;
	}

	public String getServiceRange() {
		return this.serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ServiceclassId))
			return false;
		ServiceclassId castOther = (ServiceclassId) other;

		return ((this.getServiceType() == castOther.getServiceType()) || (this
				.getServiceType() != null && castOther.getServiceType() != null && this
				.getServiceType().equals(castOther.getServiceType())))
				&& ((this.getServiceTarget() == castOther.getServiceTarget()) || (this
						.getServiceTarget() != null
						&& castOther.getServiceTarget() != null && this
						.getServiceTarget()
						.equals(castOther.getServiceTarget())))
				&& ((this.getServiceRange() == castOther.getServiceRange()) || (this
						.getServiceRange() != null
						&& castOther.getServiceRange() != null && this
						.getServiceRange().equals(castOther.getServiceRange())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getServiceType() == null ? 0 : this.getServiceType()
						.hashCode());
		result = 37
				* result
				+ (getServiceTarget() == null ? 0 : this.getServiceTarget()
						.hashCode());
		result = 37
				* result
				+ (getServiceRange() == null ? 0 : this.getServiceRange()
						.hashCode());
		return result;
	}

}