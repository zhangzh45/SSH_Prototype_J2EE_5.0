package com.service;

import java.util.List;

import com.bean.Specification;
import com.bean.SpecificationDAO;


public class SpecificationService
{
	private SpecificationDAO specDao;

	public SpecificationDAO getSpecDao() {
		return specDao;
	}

	public void setSpecDao(SpecificationDAO specDao) {
		this.specDao = specDao;
	}

	public void addSpec(Specification spec)
	{
		System.out.print("spec:"+spec.getIdentifier());
		System.out.print("specDao:"+specDao);
		this.specDao.save(spec);
	}
	
	public List<Specification> getAllSpec()
	{
		return (List<Specification>)this.specDao.findAll();
	}
	
	public void deleteSpec(Specification spec)
	{
		this.specDao.delete(spec);
	}

	public void getSpecByIndentifier(String identifier)
	{
		this.specDao.findByIdentifier(identifier);
	}
}