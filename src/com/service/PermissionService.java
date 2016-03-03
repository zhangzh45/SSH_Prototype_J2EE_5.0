package com.service;

import java.util.List;

import com.bean.Permission;
import com.bean.PermissionDAO;


public class PermissionService
{
	PermissionDAO permissionDao;

	public PermissionDAO getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDAO permissionDao) {
		this.permissionDao = permissionDao;
	}
	
	public void addPermission(Permission p)
	{
		this.permissionDao.save(p);
	}
	
	public void deletePermission(Permission p)
	{
		this.permissionDao.delete(p);
	}
	
	public Permission getUniquePermission(int i)
	{
		return this.permissionDao.findById(i);
	}
	
	public List<Permission> getAllPermission()
	{
		return this.permissionDao.findAll();
	}
	
}