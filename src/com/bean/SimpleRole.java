package com.bean;

public class SimpleRole implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String roleId;
	private String roleName;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
