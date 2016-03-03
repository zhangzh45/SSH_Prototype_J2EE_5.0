package com.server;


@javax.jws.WebService(targetNamespace = "http://server.com/", serviceName = "GetServiceInfoService", portName = "GetServiceInfoPort")
public class GetServiceInfoDelegate {

	com.server.GetServiceInfo getServiceInfo = new com.server.GetServiceInfo();

	public String getMyService(int userId) {
		return getServiceInfo.getMyService(userId);
	}

	public String getAllService(int userId) {
		return getServiceInfo.getAllService(userId);
	}

	public void add(int serviceId, int userId) {
		getServiceInfo.add(serviceId, userId);
	}

	public void delete(int serviceId, int userId) {
		getServiceInfo.delete(serviceId, userId);
	}

}