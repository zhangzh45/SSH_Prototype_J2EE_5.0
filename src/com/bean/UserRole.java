package com.bean;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole implements java.io.Serializable {

	// Fields

	private Integer userroleid;
	private User user;
	private Role role;
	private String userroledesc;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(Integer userroleid) {
		this.userroleid = userroleid;
	}

	/** full constructor */
	public UserRole(Integer userroleid, User user, Role role,
			String userroledesc) {
		this.userroleid = userroleid;
		this.user = user;
		this.role = role;
		this.userroledesc = userroledesc;
	}

	// Property accessors

	public Integer getUserroleid() {
		return this.userroleid;
	}

	public void setUserroleid(Integer userroleid) {
		this.userroleid = userroleid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserroledesc() {
		return this.userroledesc;
	}

	public void setUserroledesc(String userroledesc) {
		this.userroledesc = userroledesc;
	}

}