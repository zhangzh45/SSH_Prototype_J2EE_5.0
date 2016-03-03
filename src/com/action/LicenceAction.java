package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Licence;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LicenceService;


public class LicenceAction extends ActionSupport
{
	private LicenceService licencesr = new LicenceService();
	Licence licence;
	
	public LicenceService getLicencesr() {
		return licencesr;
	}

	public void setLicencesr(LicenceService licencesr) {
		this.licencesr = licencesr;
	}

	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}
	
	public String addConfig()
	{
		try
		{
			this.licencesr.addLocalConfig(licence);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
}