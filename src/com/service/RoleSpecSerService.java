package com.service;

import java.util.List;

import com.bean.RoleSpecSer;
import com.bean.RoleSpecSerDAO;

public class RoleSpecSerService {
	private RoleSpecSerDAO roleSpecSerDao;

	public RoleSpecSerDAO getRoleSpecSerDao() {
		return roleSpecSerDao;
	}

	public void setRoleSpecSerDao(RoleSpecSerDAO roleSpecSerDao) {
		this.roleSpecSerDao = roleSpecSerDao;
	}
	
	public List<RoleSpecSer> findSpecSerByRoleId(int roleId){
		return roleSpecSerDao.findSpecSerByRoleId(roleId);
	}
	
	@SuppressWarnings("unchecked")
	public List<RoleSpecSer> findAll(){
		return roleSpecSerDao.findAll();
	}
	
	public RoleSpecSer findById(int rssId){
		return roleSpecSerDao.findById(rssId);
	}
	
	public void delete(RoleSpecSer rss){
		roleSpecSerDao.delete(rss);
	}
	
	public void add(RoleSpecSer rss){
		roleSpecSerDao.save(rss);
	}

}
