package com.service;


import java.util.List;

import com.bean.Servicelinks;
import com.bean.ServicelinksDAO;


public class ServicelinksService
{
	ServicelinksDAO srlinksDao;

	public ServicelinksDAO getSrlinksDao() {
		return srlinksDao;
	}

	public void setSrlinksDao(ServicelinksDAO srlinksDao) {
		this.srlinksDao = srlinksDao;
	}

	public void save(Servicelinks servicelinks) {
		srlinksDao.save(servicelinks);
    }
    
	public void delete(Servicelinks servicelinks) {
		srlinksDao.delete(servicelinks);
    }
	
	public void update(Servicelinks servicelinks) {
		srlinksDao.attachDirty(servicelinks);
    }
    
    public Servicelinks findById(int id) {
        return srlinksDao.findById(id);
    }

	public List findByServiceId(int serviceId) {
		return srlinksDao.findByServiceId(serviceId);
	}
	
	public List findBySubServiceId(int subServiceId) {
		return srlinksDao.findBySubServiceId(subServiceId);
	}
	
	public List findByParentAppId(int parentAppId) {
		return srlinksDao.findByParentAppId(parentAppId);
	}
	

	public List findAll() {
		return srlinksDao.findAll();
	}
	
}