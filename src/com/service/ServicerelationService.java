package com.service;


import java.util.List;

import com.bean.Condition;
import com.bean.ConditionDAO;
import com.bean.Servicerelation;
import com.bean.ServicerelationDAO;

public class ServicerelationService
{
	ServicerelationDAO srrelationDao;

	public ServicerelationDAO getSrrelationDao() {
		return srrelationDao;
	}

	public void setSrrelationDao(ServicerelationDAO srrelationDao) {
		this.srrelationDao = srrelationDao;
	}

	public void addServicerelation(Servicerelation srr)
	{
		this.srrelationDao.save(srr);
	}
	
	public List<Servicerelation> getAllServicerelation()
	{
		return this.srrelationDao.findAll();
	}
	
	public List<Servicerelation> getServicerelation(Integer id)
	{
		return (List<Servicerelation>)this.srrelationDao.findById(id);
	}
	
	public List<Servicerelation> getServicerelationBySid(Integer id)
	{
		return (List<Servicerelation>)this.srrelationDao.findByServiceId(id);
	}
}