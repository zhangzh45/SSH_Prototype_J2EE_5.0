package com.bean;

/**
 * Permissionservice entity. @author MyEclipse Persistence Tools
 */

public class Permissionservice implements java.io.Serializable {

	// Fields

	private Integer permissionServiceId;
	private Service service;
	private Permission permission;
	private String permisionServiceDesc;

	// Constructors

	/** default constructor */
	public Permissionservice() {
	}

	/** minimal constructor */
	public Permissionservice(Service service, Permission permission) {
		this.service = service;
		this.permission = permission;
	}

	/** full constructor */
	public Permissionservice(Service service, Permission permission,
			String permisionServiceDesc) {
		this.service = service;
		this.permission = permission;
		this.permisionServiceDesc = permisionServiceDesc;
	}

	// Property accessors

	public Integer getPermissionServiceId() {
		return this.permissionServiceId;
	}

	public void setPermissionServiceId(Integer permissionServiceId) {
		this.permissionServiceId = permissionServiceId;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String getPermisionServiceDesc() {
		return this.permisionServiceDesc;
	}

	public void setPermisionServiceDesc(String permisionServiceDesc) {
		this.permisionServiceDesc = permisionServiceDesc;
	}

}