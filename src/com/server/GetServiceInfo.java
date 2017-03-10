package com.server;


public class GetServiceInfo {
	public  String getMyService(int userId){
		return ServiceInfo.getMyService(userId);
	}
	
	public String getAllService(int userId){
		return ServiceInfo.getAllService(userId);
	}

	public String add(int serviceId,int userId){
		return ServiceInfo.add(serviceId, userId);
	}
	
	public String delete(int serviceId,int userId){
		return ServiceInfo.deleteService(serviceId, userId);
	}

	public String registerService(int userId, String servicename,
			String serviceaddress, String servicdesc) {
		return ServiceInfo.registerService(userId, servicename, serviceaddress, servicdesc);
		
	}

	public String removeService(int sericeId) {
		// TODO Auto-generated method stub
		return ServiceInfo.removeService(sericeId);
	}

	public String getProvidedAppication(int userid) {
		// TODO Auto-generated method stub
		return ServiceInfo.getProvidedAppication(userid);
	}

	public String getServiceFromRole(int roleid) {
		// TODO Auto-generated method stub
		return ServiceInfo.getServiceFromRole(roleid);
	}

	public String loadAllSpec() {
		return ServiceInfo.loadAllSpec();
	}
	
	/*public String getProvidedAppAndSpec(int userid) {
		return ServiceInfo.getProvidedAppAndSpec(userid);
	}*/

	public String registerSpec(String userid, String password, String servicename, String xml) {
		return ServiceInfo.registerSpec(userid, password, servicename, xml);
	}

	public String removeSpec(String specid) {
		return ServiceInfo.removeSpec(specid);
	}

	public String getAllSpec(int userid) {
		return ServiceInfo.getAllSpec(userid);
	}

	public String getMySpec(int userid) {
		return ServiceInfo.getMySpec(userid);
	}

	public String launchSpec(String userid, String identifier, String version,
			String uri, String result) {
		return ServiceInfo.launchSpec(userid, identifier, version, uri, result);
	}

	public String cancelSpec(String userid, String identifier, String version,
			String uri, String result) {
		return ServiceInfo.cancelSpec(userid, identifier, version, uri, result);
	}
}
