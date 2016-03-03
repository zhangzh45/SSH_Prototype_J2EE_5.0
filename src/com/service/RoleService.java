package com.service;

import java.util.List;

import com.bean.Role;
import com.bean.RoleDAO;

public class RoleService
{
	private RoleDAO roleDao;

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}
	
	public void addRole(Role role)
	{
		this.roleDao.save(role);
	}
	public List<Role> getAllRole()
	{
		return this.roleDao.findAll();
	}
	public void deleteRole(Role role)
	{
		this.roleDao.delete(role);
	}
	public Role getUniqueRole(Integer id)
	{
		//System.out.println(Integer.valueOf(id));
		return this.roleDao.findById(id);
	}
	
	public int getRoleNum()
	{
		return this.getAllRole().size();
	}
	
	public List findUserSpecSerByRoleName(String roleName){
		return roleDao.findByRoleName("roleName", roleName);
	}
	
	public List findyByRoleName(String roleName){
		return roleDao.findByProperty("roleName", roleName);
	}
	
	public List findUserByRoleName(String roleName){
		return roleDao.findUserByRoleName("roleName", roleName);
	}
}