package com.service;

import java.util.List;

import com.bean.Searchkeyword;
import com.bean.SearchkeywordDAO;


public class SearchkeywordService
{
	SearchkeywordDAO skeywordDao;

	public SearchkeywordDAO getSkeywordDao() {
		return skeywordDao;
	}
	public void setSkeywordDao(SearchkeywordDAO skeywordDao) {
		this.skeywordDao = skeywordDao;
	}

	public void addSearchkeyword(Searchkeyword l)
	{
		this.skeywordDao.save(l);
	}
	
	public List<Searchkeyword> getALL()
	{
		return this.skeywordDao.findAll();
	}
}