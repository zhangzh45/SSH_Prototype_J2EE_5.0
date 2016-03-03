package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Permission;
import com.bean.Role;
import com.bean.RolePermission;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RolePermissionService;


public class RolePermissionAction extends ActionSupport
{
	private RolePermissionService rolepermissionsr = new RolePermissionService();
	RolePermission rolepermission;
	
	String option1;
	String option2;
	
	List<RolePermission> rolepermissions = new ArrayList<RolePermission>();
	
	public RolePermissionService getRolepermissionsr() {
		return rolepermissionsr;
	}

	public void setRolepermissionsr(RolePermissionService rolepermissionsr) {
		this.rolepermissionsr = rolepermissionsr;
	}

	public RolePermission getRolepermission() {
		return rolepermission;
	}

	public void setRolepermission(RolePermission rolepermission) {
		this.rolepermission = rolepermission;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public List<RolePermission> getRolepermissions() {
		return rolepermissions;
	}

	public void setRolepermissions(List<RolePermission> rolepermissions) {
		this.rolepermissions = rolepermissions;
	}

	public String addPermissionRole()
	{
		try
		{
			rolepermission = new RolePermission();
			Permission per=new Permission();
			per.setPermissionId(Integer.valueOf(option1));
			rolepermission.setPermission(per);
			Role role=new Role();
			role.setRoleId(Integer.valueOf(option2));
			rolepermission.setRole(role);
			this.rolepermissionsr.addPermission(rolepermission);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
}