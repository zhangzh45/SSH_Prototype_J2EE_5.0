package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Licence;
import com.bean.Searchkeyword;
import com.bean.Searchsite;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LicenceService;
import com.service.SearchkeywordService;
import com.service.SearchsiteService;


public class SearchsiteAction extends ActionSupport
{
	private SearchsiteService searchsitesr = new SearchsiteService();
	Searchsite searchsite;
	String option1;
	
	List<Searchsite> searchsites = new ArrayList<Searchsite>();
	
	public SearchsiteService getSearchsitesr() {
		return searchsitesr;
	}

	public void setSearchsitesr(SearchsiteService searchsitesr) {
		this.searchsitesr = searchsitesr;
	}

	public Searchsite getSearchsite() {
		return searchsite;
	}

	public void setSearchsite(Searchsite searchsite) {
		this.searchsite = searchsite;
	}
	
	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public List<Searchsite> getSearchsites() {
		return searchsites;
	}

	public void setSearchsites(List<Searchsite> searchsites) {
		this.searchsites = searchsites;
	}

	public String addSearchsite()
	{
		try
		{
			this.searchsitesr.addSearchsite(searchsite);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listSearchsite()
	{
		try
		{
			searchsites = this.searchsitesr.getALL();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String deleteSite(){
		try
		{
			searchsite = searchsitesr.getSearchsiteDao().findById(Integer.valueOf(option1));
			if(searchsite != null){
				searchsitesr.getSearchsiteDao().delete(searchsite);
			}
			 
			listSearchsite();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
}