package com.service.interfce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.action.ServiceAction;
import com.bean.Service;
import com.bean.SimpleService;
import com.opensymphony.xwork2.ActionSupport;
import com.server.ServiceInfo;


/**
 * 
 * @author yuzaizai
 * 获取服务资源的接口
 *
 */
public class ServiceInterface extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,List<SimpleService>> serMap = new HashMap<String, List<SimpleService>>();  // 返回给映射中心的map
	private ServiceAction serviceAction;
	private int userId;
	
	/**
	 * 根据用户id获取该用户所有的可用服务
	 * @return
	 */
	public String getAllSimpleService(){
		//List<Service> listService = serviceAction.getMyService(userId);
		ServiceInfo si = new ServiceInfo();
		serMap.put("services",si.getProvidedAppAndSpec(userId));
		//serMap.put("services", BatcheService2SimService(listService));
		return SUCCESS;
		
	}
	
	/**
	 * 批量将Service转成SimpleService
	 * @return List<SimpleService> 
	 */
	public List<SimpleService> BatcheService2SimService ( List<Service> listService) {
		Iterator<Service> itService = listService.iterator();
		List<SimpleService> listSimSer = new ArrayList<SimpleService>();
		while ( itService.hasNext() ) {
			Service ser = itService.next();
			SimpleService simSer = new SimpleService();
			simSer.setId(ser.getServiceId().toString());
			simSer.setName(ser.getServiceName());
			simSer.setType(simSer.getType());
			simSer.setAppRoleUrl(simSer.getAppRoleUrl());
			listSimSer.add( simSer);
		}
		return listSimSer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ServiceAction getServiceAction() {
		return serviceAction;
	}

	public void setServiceAction(ServiceAction serviceAction) {
		this.serviceAction = serviceAction;
	}

	public Map<String, List<SimpleService>> getSerMap() {
		return serMap;
	}

	public void setSerMap(Map<String, List<SimpleService>> serMap) {
		this.serMap = serMap;
	}

}
