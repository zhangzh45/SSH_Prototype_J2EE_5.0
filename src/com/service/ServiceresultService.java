package com.service;

import java.util.List;

import com.bean.Serviceresult;
import com.bean.ServiceresultDAO;


public class ServiceresultService
{
	ServiceresultDAO srresultDao;

	public ServiceresultDAO getSrresultDao() {
		return srresultDao;
	}

	public void setSrresultDao(ServiceresultDAO srresultDao) {
		this.srresultDao = srresultDao;
	}

	public void addServiceresult(Serviceresult e)
	{
		this.srresultDao.save(e);
	}
	
	public void deleteServiceresult(Serviceresult e)
	{
		this.srresultDao.delete(e);
	}
	
	public List<Serviceresult> getAllServiceresult()
	{
		return this.srresultDao.findAll();
	}
	
	public List<Serviceresult> getServiceresult(int id)
	{
		return this.srresultDao.findByServiceid(id);
	}
	
}