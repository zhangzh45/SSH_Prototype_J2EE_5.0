package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Role;
import com.bean.SpecTaskRoleUser;
import com.bean.SpecTaskRoleUserDAO;
import com.bean.User;
import com.bean.UserDAO;


public class SpecTaskRoleUserService
{
	private SpecTaskRoleUserDAO struDao;

	
	
	public SpecTaskRoleUserDAO getStruDao() {
		return struDao;
	}

	public void setStruDao(SpecTaskRoleUserDAO struDao) {
		this.struDao = struDao;
	}

	public void addSpecTaskRoleUser(SpecTaskRoleUser specTaskRoleUser)
	{
		this.struDao.save(specTaskRoleUser);
	}
	
	public List<SpecTaskRoleUser> getAllSpecTaskRoleUsers()
	{
		return (List<SpecTaskRoleUser>)this.struDao.findAll();
	}
	
	public void deleteSpecTaskRoleUser(SpecTaskRoleUser specTaskRoleUser)
	{
		this.struDao.delete(specTaskRoleUser);
	}
	
	public List<Integer> getRoleFromSpec(String specIdentifier){
		List<Integer> roles = new ArrayList<Integer>();
		List<SpecTaskRoleUser> strus = this.struDao.findBySpecIdentifier(specIdentifier);
		for(int i = 0; i < strus.size(); i++){
			SpecTaskRoleUser s = strus.get(i);
			roles.add(Integer.parseInt(s.getRoleId()));
		}
		return roles;
	}
	
	public List<Integer> getUserFromSpec(String specIdentifier){
		List<Integer> users = new ArrayList<Integer>();
		List<SpecTaskRoleUser> strus = this.struDao.findBySpecIdentifier(specIdentifier);
		for(int i = 0; i < strus.size(); i++){
			SpecTaskRoleUser s = strus.get(i);
			users.add(Integer.parseInt(s.getParticipantId()));
		}
		return users;
	}

}