package com.service;

import java.util.List;

import com.bean.Searchsite;
import com.bean.SearchsiteDAO;


public class SearchsiteService
{
	SearchsiteDAO searchsiteDao;

	public SearchsiteDAO getSearchsiteDao() {
		return searchsiteDao;
	}

	public void setSearchsiteDao(SearchsiteDAO searchsiteDao) {
		this.searchsiteDao = searchsiteDao;
	}

	public void addSearchsite(Searchsite l)
	{
		this.searchsiteDao.save(l);
	}
	
	public List<Searchsite> getALL()
	{
		return this.searchsiteDao.findAll();
	}
}