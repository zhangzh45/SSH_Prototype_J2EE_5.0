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
	private User user;
	private String operaterName;
	private Date applyTime;
	private Date agreeTime;
	private String descrip;

	// Constructors

	/** default constructor */
	public UserSpecSer() {
	}

	/** minimal constructor */
	public UserSpecSer(Integer ussId, Service service, User user) {
		this.ussId = ussId;
		this.service = service;
		this.user = user;
	}

	/** full constructor */
	public UserSpecSer( Service service, User user,
			String operaterName, Date applyTime, Date agreeTime, String descrip) {
	//	this.ussId = ussId;
		this.service = service;
		this.user = user;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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