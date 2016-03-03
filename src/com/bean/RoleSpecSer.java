package com.bean;

import java.util.Date;

/**
 * RoleSpecSer entity. @author MyEclipse Persistence Tools
 */

public class RoleSpecSer implements java.io.Serializable {

	// Fields

	private Integer rssId;
	private Service service;
	private Role role;
	private String operatorName;
	private Date addTime;
	private String descrip;

	// Constructors

	/** default constructor */
	public RoleSpecSer() {
	}

	/** minimal constructor */
	public RoleSpecSer(Integer rssId, Service service, Role role) {
		this.rssId = rssId;
		this.service = service;
		this.role = role;
	}

	/** full constructor */
	public RoleSpecSer( Service service, Role role,
			String operatorName, Date addTime, String descrip) {
		//this.rssId = rssId;
		this.service = service;
		this.role = role;
		this.operatorName = operatorName;
		this.addTime = addTime;
		this.descrip = descrip;
	}

	// Property accessors

	public Integer getRssId() {
		return this.rssId;
	}

	public void setRssId(Integer rssId) {
		this.rssId = rssId;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

}