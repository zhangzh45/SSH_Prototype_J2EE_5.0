package com.service;

import java.util.List;

import com.bean.UserRole;
import com.bean.UserRoleDAO;


public class UserRoleService
{
	UserRoleDAO userroleDao;
	
	

	public UserRoleDAO getUserroleDao() {
		return userroleDao;
	}

	public void setUserroleDao(UserRoleDAO userroleDao) {
		this.userroleDao = userroleDao;
	}

	public void addRole(UserRole p)
	{
		this.userroleDao.save(p);
	}
	
	public void delUserrole(UserRole p)
	{
		this.userroleDao.delete(p);
	}
	
	public UserRole getUniquerole(String a, String b)
	{
		 List<UserRole> urs = userroleDao.findByRoleid(Integer.parseInt(b));
		 for(int i = 0; i < urs.size(); i++)
		 {
			 if(urs.get(i).getUser().getUserId()== Integer.parseInt(a))
			 {
				 return urs.get(i);
			 }
		 }
		 return urs.get(0);
	}
	
	public List<UserRole> getUserRole(int userid)
	{
		return this.userroleDao.findByUserid(userid);
	}
	
	public List<UserRole> getAllRole()
	{
		return this.userroleDao.findAll();
	}
	
}