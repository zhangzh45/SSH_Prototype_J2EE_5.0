package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Service;
import com.bean.ServiceDAO;
import com.bean.ServicerelationDAO;
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
	
	public int unregister(Service sr)
	{
		//MoneyUtil.main();
		//WeatherUtil.main(271);
		this.srDAO.delete(sr);
		return sr.getServiceId();
	}
	
	
	
	public void update(Service sr)
	{
		this.srDAO.attachDirty(sr);
	}
	
	public List<Service> getAllService()
	{
		//return (List<Service>)this.srDAO.findAll();    //暂时不考虑流程和本地应用
		List<Service> re = new ArrayList<Service>();
		re.addAll(this.srDAO.findByServiceType("APPLICATION"));
		re.addAll(this.srDAO.findByServiceType("SERVICE"));
		return re;
	}
	
	public List<Service> getAll()   //获取所有的服务，包括流程
	{
		return (List<Service>)this.srDAO.findAll();  
	}
	
	public List<Service> getExceptedService()   //获取除服务类型为service（微服务）以外的所有服务,包括流程
	{
		List<Service> all = (List<Service>)this.srDAO.findAll();  
		List<Service> mservceis = (List<Service>)this.srDAO.findByServiceType("SERVICE");
		all.removeAll(mservceis);
		return all;
	}
	
	public List<Service> getInternalService()
	{
		List<Service> re = new ArrayList<Service>();
		re.addAll(this.srDAO.findByIsExternal(0));
		return re;
	}
	
	public List<Service> getExternalService()
	{
		List<Service> re = new ArrayList<Service>();
		re.addAll(this.srDAO.findByIsExternal(1));
		return re;
	}
	
	
	public List<Service> getUnService()
	{
		return (List<Service>)this.srDAO.findByServiceState("NO");
	}
	
	public List<Service> getAcceptedService()
	{
		return (List<Service>)this.srDAO.findByServiceState("YES");
	}
	
	public List<Service> getProvidedService(String userId)
	{
		return (List<Service>)this.srDAO.findByServiceProvider(userId);
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
		return this.srDAO.findByServiceType(type);
	}
	
	//根据服务的业务类型返回服务
	public List<Service> getServiceByBusiness(String business)
	{
		return this.srDAO.findByRelateBusiness(business);
	}
	
	public void deleteService(int id)
	{
		return;
	}
	
	public List<Service> getApplicationService()
	{
		return (List<Service>)this.srDAO.findByServiceType("APPLICATION");
	}
	
	public List<Service> getServiceService()
	{
		return (List<Service>)this.srDAO.findByServiceType("SERVICE");
	}
	
	public List<Service> getBusinessService()
	{
		return (List<Service>)this.srDAO.findByServiceType("BUSINESS");
	}
	
	public List<Service> getLocalService()
	{
		return (List<Service>)this.srDAO.findByServiceType("LOCAL");
	}
	
	public List<Service> getCombinedService()
	{
		List<Service> re = new ArrayList<Service>();
		re.addAll(this.srDAO.findByCombineType("Combine"));
		re.addAll(this.srDAO.findByCombineType("CombineA"));
		re.addAll(this.srDAO.findByCombineType("CombineB"));
		return re;
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
	
	public int getIsExternal(int sid)
	{
		return this.srDAO.findById(sid).getIsExternal();
		
	}
	
	public String getCombineType(int sid)
	{
		return this.srDAO.findById(sid).getCombineType();
		
	}
	 
	public int getServiceNum()
	{
		return this.getAll().size();
	}
	
	public int getRunTime()
	{
		List<Service> all = new ArrayList<Service>();
		all = this.getAllService();
		int sum = 0;
		for(int i = 0; i < all.size(); i++)
		{
			if(all.get(i).getRunTimes() == null){
				all.get(i).setRunTimes(0);
			}
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
	
	public List<String> getServiceType(){
		return srDAO.findServiceType();
	}
	
	public List<String> getRelateBusiness(){
		return srDAO.findRelateBusiness();
	}
	
	public Service getServiceidByServiename(String serviceName){
		return srDAO.findServiceidByServiecename(serviceName);
	}
	
	/**
	 * 获取所有服务的最大可靠性值
	 * @return
	 */
	public double getMaxServiceReliability(){
		return srDAO.findMaxServiceReliability();
	}
	
	/**
	 * 获取所有服务的最小可靠性值
	 * @return
	 */
	public double getMinServiceReliability(){
		return srDAO.findMinServiceReliability();
	}
	
	/**
	 * 获取所有服务的最大运行时间值
	 * @return
	 */
	public double getMaxServiceTime(){
		return srDAO.findMaxServiceTime();
	}
	
	/**
	 * 获取所有服务的最小运行时间值
	 * @return
	 */
	public double getMinServiceTime(){
		return srDAO.findMinServiceTime();
	}
	
	/**
	 * 获取所有服务的最大成本值
	 * @return
	 */
	public double getMaxServiceCost(){
		return srDAO.findMaxServiceCost();
	}
	
	/**
	 * 获取所有服务的最小成本值
	 * @return
	 */
	public double getMinServiceCost(){
		return srDAO.findMinServiceCost();
	}
	
	/**
	 * 获取所有服务的最大QoS值
	 * @return
	 */
	public double getMaxServiceQos(){
		return srDAO.findMaxServiceQos();
	}
	
	/**
	 * 获取所有服务的最小QoS值
	 * @return
	 */
	public double getMinServiceQos(){
		return srDAO.findMinServiceQos();
	}
}
