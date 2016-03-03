package com.server;


public class GetServiceInfo {
	public  String getMyService(int userId){
		return ServiceInfo.getMyService(userId);
	}
	
	public String getAllService(int userId){
		return ServiceInfo.getAllService(userId);
	}

	public void add(int serviceId,int userId){
		ServiceInfo.add(serviceId, userId);
	}
	
	public void delete(int serviceId,int userId){
		ServiceInfo.deleteService(serviceId, userId);
	}
}
