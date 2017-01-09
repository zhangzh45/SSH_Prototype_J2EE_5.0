package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Licence;
import com.bean.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LicenceService;
import com.service.SerService;


public class LicenceAction extends ActionSupport
{
	private LicenceService licencesr = new LicenceService();
	private SerService srs;
	Licence licence;
	
	String serviceId;
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

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
			//System.out.print(serviceId);
			licence.setService(srs.getUniqueService(serviceId));
			this.licencesr.addLocalConfig(licence);
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceId);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
}