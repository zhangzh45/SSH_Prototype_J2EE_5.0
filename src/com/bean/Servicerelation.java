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
	private Integer seqNum;

	// Constructors

	/** default constructor */
	public Servicerelation() {
	}

	/** minimal constructor */
	public Servicerelation(Integer relationId) {
		this.relationId = relationId;
	}

	/** full constructor */
	public Servicerelation(Service serviceByServiceId, Service serviceBySubServiceId) {
		this.serviceByServiceId = serviceByServiceId;
		this.serviceBySubServiceId = serviceBySubServiceId;
	}
	
	
	/** full constructor */
	public Servicerelation(Integer relationId, Condition condition,
			Service serviceByServiceId, Service serviceBySubServiceId,
			Integer seqNum) {
		this.relationId = relationId;
		this.condition = condition;
		this.serviceByServiceId = serviceByServiceId;
		this.serviceBySubServiceId = serviceBySubServiceId;
		this.seqNum = seqNum;
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

	public Integer getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

}