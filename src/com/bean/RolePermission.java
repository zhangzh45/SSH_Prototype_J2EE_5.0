package com.bean;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission implements java.io.Serializable {

	// Fields

	private Integer rolePermissionId;
	private Role role;
	private Permission permission;
	private String rolePermissionDesc;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	/** minimal constructor */
	public RolePermission(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	/** full constructor */
	public RolePermission(Integer rolePermissionId, Role role,
			Permission permission, String rolePermissionDesc) {
		this.rolePermissionId = rolePermissionId;
		this.role = role;
		this.permission = permission;
		this.rolePermissionDesc = rolePermissionDesc;
	}

	// Property accessors

	public Integer getRolePermissionId() {
		return this.rolePermissionId;
	}

	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String getRolePermissionDesc() {
		return this.rolePermissionDesc;
	}

	public void setRolePermissionDesc(String rolePermissionDesc) {
		this.rolePermissionDesc = rolePermissionDesc;
	}

}