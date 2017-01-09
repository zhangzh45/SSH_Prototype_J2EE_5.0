package com.service;

import java.util.List;

import com.bean.PermissionserviceDAO;


public class PermissionServiceService
{
	PermissionserviceDAO permissionserviceDao ;
	
	public PermissionserviceDAO getPermissionserviceDao() {
		return permissionserviceDao;
	}

	public void setPermissionserviceDao(PermissionserviceDAO permissionserviceDao) {
		this.permissionserviceDao = permissionserviceDao;
	}

	public void addPermissionService(com.bean.Permissionservice p)
	{
		this.permissionserviceDao.save(p);
	}
	
	public List<com.bean.Permissionservice> getAllPermission()
	{
		return this.permissionserviceDao.findAll();
	}
	
	public List<com.bean.Permissionservice> getPermissionService(int p)
	{
		return this.permissionserviceDao.findByPermissionId(p);
	}
	
}