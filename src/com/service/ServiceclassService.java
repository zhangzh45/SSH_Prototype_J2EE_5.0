package com.service;


import java.util.List;

import com.bean.Serviceclass;
import com.bean.ServiceclassDAO;
import com.bean.ServiceclassId;



public class ServiceclassService
{
	ServiceclassDAO srclassDao;

	public ServiceclassDAO getSrclassDao() {
		return srclassDao;
	}

	public void setSrclassDao(ServiceclassDAO srclassDao) {
		this.srclassDao = srclassDao;
	}

	public void save(Serviceclass serviceclass) {
		srclassDao.save(serviceclass);
    }
    
	public void delete(Serviceclass serviceclass) {
		srclassDao.delete(serviceclass);
    }
	
	public void update(Serviceclass serviceclass) {
		srclassDao.attachDirty(serviceclass);
    }
    
    public Serviceclass findById(ServiceclassId id) {
        return srclassDao.findById(id);
    }
    
    /**
	 * 获取服务类的数目种类
	 * @return
	 */
	public int getServiceclassesNum() {
		return srclassDao.findServiceclassesNum();
	}
	
	public boolean isExisted(ServiceclassId id) {
		return srclassDao.isExisted(id);
	}
	
	public List findAll() {
		return srclassDao.findAll();
	}
	
}