package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Condition entity. @author MyEclipse Persistence Tools
 */

public class Condition implements java.io.Serializable {

	// Fields

	private Integer conditionId;
	//private Integer serviceId;
	//private Integer subServiceId;
	private Service serviceByServiceId;
	private Service serviceBySubServiceId;
	private String condtionExpression;
	private Set servicerelations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Condition() {
	}

	/** minimal constructor */
	public Condition(Integer conditionId, Service serviceByServiceId,
			Service serviceBySubServiceId) {
		this.conditionId = conditionId;
		this.serviceByServiceId = serviceByServiceId;
		this.serviceBySubServiceId = serviceBySubServiceId;
	}

	/** full constructor */
	public Condition(Service serviceByServiceId,
			Service serviceBySubServiceId, String condtionExpression,
			Set servicerelations) {
		this.serviceByServiceId = serviceByServiceId;
		this.serviceBySubServiceId = serviceBySubServiceId;
		this.condtionExpression = condtionExpression;
		this.servicerelations = servicerelations;
	}

	// Property accessors

	public Integer getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
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

	public String getCondtionExpression() {
		return this.condtionExpression;
	}

	public void setCondtionExpression(String condtionExpression) {
		this.condtionExpression = condtionExpression;
	}

	public Set getServicerelations() {
		return this.servicerelations;
	}

	public void setServicerelations(Set servicerelations) {
		this.servicerelations = servicerelations;
	}

}