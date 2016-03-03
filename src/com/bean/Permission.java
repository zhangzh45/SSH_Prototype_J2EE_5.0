package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	// Fields

	private Integer permissionId;
	private String createTime;
	private String permissionDesc;
	private String permissionName;
	private Set rolePermissions = new HashSet(0);
	private Set permissionServices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/** full constructor */
	public Permission(Integer permissionId, String createTime,
			String permissionDesc, String permissionName, Set rolePermissions,
			Set permissionServices) {
		this.permissionId = permissionId;
		this.createTime = createTime;
		this.permissionDesc = permissionDesc;
		this.permissionName = permissionName;
		this.rolePermissions = rolePermissions;
		this.permissionServices = permissionServices;
	}

	// Property accessors

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPermissionDesc() {
		return this.permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Set getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public Set getPermissionServices() {
		return this.permissionServices;
	}

	public void setPermissionServices(Set permissionServices) {
		this.permissionServices = permissionServices;
	}

}