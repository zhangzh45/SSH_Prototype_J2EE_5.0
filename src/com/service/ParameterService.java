package com.service;

import java.util.List;

import com.bean.Parameter;
import com.bean.ParameterDAO;

public class ParameterService
{
	ParameterDAO parameterDao ;

	public ParameterDAO getParameterDao() {
		return parameterDao;
	}
	
	public int addParamater(Parameter p)
	{
		this.parameterDao.save(p);
		return p.getParameterid();
	}

	public void setParameterDao(ParameterDAO parameterDao) {
		this.parameterDao = parameterDao;
	}
	
	public List<Parameter> getServiceParameter(int id)
	{
		return (List<Parameter>)this.parameterDao.findByServiceid(id);
	}
	
	//返回服务参数类型
	public String getParameterType(int pid)
	{
		return null;
	}
}