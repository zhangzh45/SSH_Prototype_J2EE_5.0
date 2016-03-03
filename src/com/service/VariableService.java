package com.service;

import java.util.List;

import com.bean.Variable;
import com.bean.VariableDAO;

public class VariableService
{
	VariableDAO variableDao;

	public VariableDAO getVariableDao() {
		return variableDao;
	}

	public void setVariableDao(VariableDAO variableDao) {
		this.variableDao = variableDao;
	}

	public void addVariable(Variable e)
	{
		this.variableDao.save(e);
	}
	
	public List<Variable> getVariable()
	{
		return this.variableDao.findAll();
	}
	
	public List<Variable> getServiceVariable(int id)
	{
		return this.variableDao.findByServiceId(id);
	}
	
}