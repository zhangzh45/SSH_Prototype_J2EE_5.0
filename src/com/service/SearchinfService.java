package com.service;

import java.util.List;

import com.bean.Searchinf;
import com.bean.SearchinfDAO;;


public class SearchinfService
{
	SearchinfDAO sinfDao;

	public SearchinfDAO getSinfDao() {
		return sinfDao;
	}

	public void setSinfDao(SearchinfDAO sinfDao) {
		this.sinfDao = sinfDao;
	}

	public void addSearchkeyword(Searchinf l)
	{
		this.sinfDao.save(l);
	}
	
	public List<Searchinf> getALL()
	{
		return this.sinfDao.findAll();
	}
}