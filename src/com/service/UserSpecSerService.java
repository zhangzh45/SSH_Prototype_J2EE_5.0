package com.service;

import java.util.List;


import com.bean.Service;
import com.bean.User;
import com.bean.UserSpecSer;
import com.bean.UserSpecSerDAO;

public class UserSpecSerService {
	private UserSpecSerDAO userSpecSerDao;

	public UserSpecSerDAO getUserSpecSerDao() {
		return userSpecSerDao;
	}

	public void setUserSpecSerDao(UserSpecSerDAO userSpecSerDao) {
		this.userSpecSerDao = userSpecSerDao;
	}
	
	public List<UserSpecSer> findSpecSerByUserId(int userId){
		//System.out.print(userId+"!!!!!\n");
		return userSpecSerDao.findSpecSerByUserId(userId);
	}
	
	public void add(UserSpecSer uss){
		userSpecSerDao.save(uss);
	}
	
	public void deleteByServiceUserId(int serviceId,int userId){
		userSpecSerDao.deleteByServiceUserId(serviceId, userId);
	}
}
