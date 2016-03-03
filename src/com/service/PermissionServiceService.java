package com.service;

import java.util.List;

import com.bean.PermissionServiceDAO;


public class PermissionServiceService
{
	PermissionServiceDAO permissionserviceDao ;
	
	public PermissionServiceDAO getPermissionserviceDao() {
		return permissionserviceDao;
	}

	public void setPermissionserviceDao(PermissionServiceDAO permissionserviceDao) {
		this.permissionserviceDao = permissionserviceDao;
	}

	public void addPermissionService(com.bean.PermissionService p)
	{
		this.permissionserviceDao.save(p);
	}
	
	public List<com.bean.PermissionService> getAllPermission()
	{
		return this.permissionserviceDao.findAll();
	}
	
	public List<com.bean.PermissionService> getPermissionService(int p)
	{
		return this.permissionserviceDao.findByPermissionId(p);
	}
	
}