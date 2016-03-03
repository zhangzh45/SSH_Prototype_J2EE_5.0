package com.service;

import java.util.List;

import com.bean.RolePermission;
import com.bean.RolePermissionDAO;


public class RolePermissionService
{
	RolePermissionDAO rolepermissionDao ;
	
	public RolePermissionDAO getRolepermissionDao() {
		return rolepermissionDao;
	}

	public void setRolepermissionDao(RolePermissionDAO rolepermissionDao) {
		this.rolepermissionDao = rolepermissionDao;
	}

	public void addPermission(RolePermission p)
	{
		this.rolepermissionDao.save(p);
	}
	
	public List<RolePermission> getAllPermission()
	{
		return this.rolepermissionDao.findAll();
	}
	
	public List<RolePermission> getRolePermission(int roleid)
	{
		return this.rolepermissionDao.findByRoleId(roleid);
	}
	
}