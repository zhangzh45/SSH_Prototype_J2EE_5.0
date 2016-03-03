package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Permission;
import com.bean.Role;
import com.bean.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PermissionService;
import com.service.RoleService;
import com.service.SerService;


public class PermissionAction extends ActionSupport
{
	private PermissionService permissionsr = new PermissionService();
	Permission permission;
	
	private RoleService rolesr = new RoleService();
	private SerService srs = new SerService();
	
	List<Permission> permissions = new ArrayList<Permission>();
	List<Role> roles = new ArrayList<Role>();
	List<Service> services = new ArrayList<Service>();
	String option1;
	
	
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public SerService getSrs() {
		return srs;
	}
	public void setSrs(SerService srs) {
		this.srs = srs;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public RoleService getRolesr() {
		return rolesr;
	}
	public void setRolesr(RoleService rolesr) {
		this.rolesr = rolesr;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public PermissionService getPermissionsr() {
		return permissionsr;
	}
	public void setPermissionsr(PermissionService permissionsr) {
		this.permissionsr = permissionsr;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	public String addPermission()
	{
		try
		{
			this.permissionsr.addPermission(permission);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String deletePermission()
	{
		try
		{
			permission = this.permissionsr.getUniquePermission(Integer.valueOf(option1));
			if(permission != null)
			{
				this.permissionsr.deletePermission(permission);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listPermission()
	{
		try
		{
			permissions.clear();
			permissions = this.permissionsr.getAllPermission();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String choosePermissionRole()
	{
		try
		{
			permissions = this.permissionsr.getAllPermission();
			roles = this.rolesr.getAllRole();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String choosePermissionService()
	{
		try
		{
			permissions = this.permissionsr.getAllPermission();
			services = this.srs.getAllService();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
}