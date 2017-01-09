package com.service;


import java.util.List;

import com.bean.Condition;
import com.bean.ConditionDAO;
import com.bean.ServicerelationDAO;

public class ConditionService
{
	ConditionDAO conditionDao;

	public ConditionDAO getConditionDao() {
		return conditionDao;
	}

	public void setConditionDao(ConditionDAO conditionDao) {
		this.conditionDao = conditionDao;
	}

	public void addCondition(Condition e)
	{
		this.conditionDao.save(e);
	}
	
	public List<Condition> getAllCondition()
	{
		return this.conditionDao.findAll();
	}
	
	public List<Condition> getServiceCondition(Integer id)
	{
		return (List<Condition>)this.conditionDao.findByServiceId(id);
	}
	
}