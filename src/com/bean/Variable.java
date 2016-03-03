package com.bean;

/**
 * Variable entity. @author MyEclipse Persistence Tools
 */

public class Variable implements java.io.Serializable {

	// Fields

	private Integer variableId;
	private Service service;
	private String variableName;
	private String variableDesc;

	// Constructors

	/** default constructor */
	public Variable() {
	}

	/** minimal constructor */
	public Variable(Integer variableId) {
		this.variableId = variableId;
	}

	/** full constructor */
	public Variable(Integer variableId, Service service, String variableName,
			String variableDesc) {
		this.variableId = variableId;
		this.service = service;
		this.variableName = variableName;
		this.variableDesc = variableDesc;
	}

	// Property accessors

	public Integer getVariableId() {
		return this.variableId;
	}

	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableDesc() {
		return this.variableDesc;
	}

	public void setVariableDesc(String variableDesc) {
		this.variableDesc = variableDesc;
	}

}