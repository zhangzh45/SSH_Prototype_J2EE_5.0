package com.service;

import java.util.List;

import com.bean.Licence;
import com.bean.LicenceDAO;
import com.bean.Role;


public class LicenceService
{
	LicenceDAO licenceDao ;

	public LicenceDAO getLicenceDao() {
		return licenceDao;
	}

	public void setLicenceDao(LicenceDAO licenceDao) {
		this.licenceDao = licenceDao;
	}

	public void addLocalConfig(Licence l)
	{
		this.licenceDao.save(l);
	}
	
	//删除本地许可证配置
	public void deleteLocalConfig(Licence l)
	{
		this.licenceDao.delete(l);
		return;
	}
	
	//获取全部已配置的本地许可证
	public List getLocalLicence(Licence l)
	{
		return this.licenceDao.findAll();
	}
	
	//获得一项服务的许可证配置
	public List getServiceLicence(int serviceId)
	{
		return this.licenceDao.findByServiceId(serviceId);
	}
}