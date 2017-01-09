package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Licence;
import com.bean.Searchinf;
import com.bean.Searchkeyword;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LicenceService;
import com.service.SearchinfService;
import com.service.SearchkeywordService;


public class SearchkeywordAction extends ActionSupport
{
	private SearchkeywordService skeywordsr = new SearchkeywordService();
	private SearchinfService sinfsr = new SearchinfService();
	Searchkeyword skeyword;
	Searchinf sinf;
	String option1;
	
	List<Searchkeyword> keywords = new ArrayList<Searchkeyword>();
	List<Searchinf> infs = new ArrayList<Searchinf>();
	
	public SearchinfService getSinfsr() {
		return sinfsr;
	}

	public void setSinfsr(SearchinfService sinfsr) {
		this.sinfsr = sinfsr;
	}

	public List<Searchinf> getInfs() {
		return infs;
	}

	public void setInfs(List<Searchinf> infs) {
		this.infs = infs;
	}

	public List<Searchkeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Searchkeyword> keywords) {
		this.keywords = keywords;
	}
	
	public Searchinf getSinf() {
		return sinf;
	}

	public void setSinf(Searchinf sinf) {
		this.sinf = sinf;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public SearchkeywordService getSkeywordsr() {
		return skeywordsr;
	}

	public void setSkeywordsr(SearchkeywordService skeywordsr) {
		this.skeywordsr = skeywordsr;
	}


	public Searchkeyword getSkeyword() {
		return skeyword;
	}

	public void setSkeyword(Searchkeyword skeyword) {
		this.skeyword = skeyword;
	}

	public String addKeyword()
	{
		try
		{
			this.skeywordsr.addSearchkeyword(skeyword);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listKey()
	{
		try
		{
			keywords = this.skeywordsr.getALL();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String deleteKeyword(){
		try
		{
			skeyword = skeywordsr.getSkeywordDao().findById(Integer.valueOf(option1));
			if(skeyword != null){
				skeywordsr.getSkeywordDao().delete(skeyword);
			}
			 
			listKey();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listResult()
	{
		try
		{
			infs = this.getSinfsr().getALL();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String deleteResult(){
		try
		{
			sinf = sinfsr.getSinfDao().findById(Integer.valueOf(option1));
			if(sinf != null){
				sinfsr.getSinfDao().delete(sinf);
			}
			 
			listResult();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
}