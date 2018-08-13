package com.bean;

/**
 * Serviceclass entity. @author MyEclipse Persistence Tools
 */

public class Serviceclass implements java.io.Serializable {

	// Fields

	private ServiceclassId id;
	private Integer servicesnum;
	private String services;

	// Constructors

	/** default constructor */
	public Serviceclass() {
	}

	/** minimal constructor */
	public Serviceclass(ServiceclassId id) {
		this.id = id;
	}

	/** full constructor */
	public Serviceclass(ServiceclassId id, Integer servicesnum, String services) {
		this.id = id;
		this.servicesnum = servicesnum;
		this.services = services;
	}

	// Property accessors

	public ServiceclassId getId() {
		return this.id;
	}

	public void setId(ServiceclassId id) {
		this.id = id;
	}

	public Integer getServicesnum() {
		return this.servicesnum;
	}

	public void setServicesnum(Integer servicesnum) {
		this.servicesnum = servicesnum;
	}

	public String getServices() {
		return this.services;
	}

	public void setServices(String services) {
		this.services = services;
	}

}