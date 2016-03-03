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
		return;
	}
	//获取全部已配置的本地许可证
	public void getLocalLicence(Licence l)
	{
		return;
	}
	//
	public void getServiceLicence(Licence l)
	{
		return;
	}
}