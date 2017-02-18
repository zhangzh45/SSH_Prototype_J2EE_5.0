package com.bean;

import java.util.Date;

/**
 * UserSpecSer entity. @author MyEclipse Persistence Tools
 */

public class UserSpecSer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ussId;
	private Service service;
	private Integer userId;
	private String operaterName;
	private Date applyTime;
	private Date agreeTime;
	private String descrip;

	// Constructors

	/** default constructor */
	public UserSpecSer() {
	}

	/** minimal constructor */
	public UserSpecSer(Integer ussId, Service service, Integer user) {
		this.ussId = ussId;
		this.service = service;
		this.userId = user;
	}

	/** full constructor */
	public UserSpecSer( Service service, Integer user,
			String operaterName, Date applyTime, Date agreeTime, String descrip) {
	//	this.ussId = ussId;
		this.service = service;
		this.userId = user;
		this.operaterName = operaterName;
		this.applyTime = applyTime;
		this.agreeTime = agreeTime;
		this.descrip = descrip;
	}

	// Property accessors

	public Integer getUssId() {
		return this.ussId;
	}

	public void setUssId(Integer ussId) {
		this.ussId = ussId;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOperaterName() {
		return this.operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getAgreeTime() {
		return this.agreeTime;
	}

	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

}