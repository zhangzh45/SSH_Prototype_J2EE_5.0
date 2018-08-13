package com.bean;

/**
 * Servicerelation entity. @author MyEclipse Persistence Tools
 */

public class Servicerelation implements java.io.Serializable {

	// Fields

	private Integer relationId;
	private Condition condition;
	private Service serviceByServiceId;
	private Service serviceBySubServiceId;
	private Integer linkServiceId;

	// Constructors

	/** default constructor */
	public Servicerelation() {
	}

	/** full constructor */
	public Servicerelation(Condition condition, Service serviceByServiceId,
			Service serviceBySubServiceId, Integer linkServiceId) {
		this.condition = condition;
		this.serviceByServiceId = serviceByServiceId;
		this.serviceBySubServiceId = serviceBySubServiceId;
		this.linkServiceId = linkServiceId;
	}

	// Property accessors

	public Integer getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Condition getCondition() {
		return this.condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Service getServiceByServiceId() {
		return this.serviceByServiceId;
	}

	public void setServiceByServiceId(Service serviceByServiceId) {
		this.serviceByServiceId = serviceByServiceId;
	}

	public Service getServiceBySubServiceId() {
		return this.serviceBySubServiceId;
	}

	public void setServiceBySubServiceId(Service serviceBySubServiceId) {
		this.serviceBySubServiceId = serviceBySubServiceId;
	}

	public Integer getLinkServiceId() {
		return this.linkServiceId;
	}

	public void setLinkServiceId(Integer linkServiceId) {
		this.linkServiceId = linkServiceId;
	}

}