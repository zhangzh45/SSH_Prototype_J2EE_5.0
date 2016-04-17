package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Service;
import com.bean.ServiceDAO;
import com.util.MoneyUtil;
import com.util.WeatherUtil;

public class SerService 
{
	private ServiceDAO srDAO;
	
	public ServiceDAO getSrDAO() {
		return srDAO;
	}
	public void setSrDAO(ServiceDAO srDAO) {
		this.srDAO = srDAO;
	}
	
	public int register(Service sr)
	{
		//MoneyUtil.main();
		//WeatherUtil.main(271);
		this.srDAO.save(sr);
		return sr.getServiceId();
	}
	
	public void update(Service sr)
	{
		this.srDAO.attachDirty(sr);
	}
	
	public List<Service> getAllService()
	{
		return (List<Service>)this.srDAO.findAll();
	}
	
	public List<Service> getUnService()
	{
		return (List<Service>)this.srDAO.findByServiceState("NO");
	}
	
	public List<Service> getAcceptedService()
	{
		return (List<Service>)this.srDAO.findByServiceState("YES");
	}
	
	public Service getUniqueService(String id)
	{
		return (Service)this.srDAO.findById(Integer.valueOf(id));
	}
	
	public Service getParmById(int id){
		return this.srDAO.findParmById(id);
	}
	//根据服务的技术类型返回服务
	public List<Service> getServiceByType(String type)
	{
		return null;
	}
	
	public void deleteService(int id)
	{
		return;
	}
	
	public List<Service> getWebService()
	{
		return (List<Service>)this.srDAO.findByServiceType("Web");
	}
	
	public List<Service> getURLService()
	{
		return (List<Service>)this.srDAO.findByServiceType("url");
	}
	
	public List<Service> getCombinedService()
	{
		return (List<Service>)this.srDAO.findByServiceType("Combine");
	}
	
	public List<Service> getSearchService(String sch)
	{
		List<Service> re = new ArrayList<Service>();
		re.addAll(this.srDAO.findByRelateBusiness(sch));
		re.addAll(this.srDAO.findByServiceDesc(sch));
		re.addAll(this.srDAO.findByServiceName(sch));
		re.addAll(this.srDAO.findByServiceTarget(sch));
		re.addAll(this.srDAO.findByServiceType(sch));
		
		return re;
		
	}
	
	public String getServiceType(int sid)
	{
		return this.srDAO.findById(sid).getServiceType();
		
	}
	 
	public int getServiceNum()
	{
		return this.getAllService().size();
	}
	
	public int getRunTime()
	{
		List<Service> all = new ArrayList<Service>();
		all = this.getAllService();
		int sum = 0;
		for(int i = 0; i < all.size(); i++)
		{
			sum = sum + all.get(i).getRunTimes();
		}
		
		return sum;
	}
	
	public List<Service> findyByServiceName(String serviceName){
		return srDAO.findByServiceName(serviceName);
	}
	
	public List<Service> findByProperty(String name,String value){
		return srDAO.findByProperty(name, value);
	}
}
