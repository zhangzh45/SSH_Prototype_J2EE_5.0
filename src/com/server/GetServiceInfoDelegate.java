package com.server;

@javax.jws.WebService(targetNamespace = "http://server.com/", serviceName = "GetServiceInfoService", portName = "GetServiceInfoPort", wsdlLocation = "WEB-INF/wsdl/GetServiceInfoService.wsdl")
public class GetServiceInfoDelegate {

	com.server.GetServiceInfo getServiceInfo = new com.server.GetServiceInfo();

	public String getMyService(int userId) {
		return getServiceInfo.getMyService(userId);
	}

	public String getAllService(int userId) {
		return getServiceInfo.getAllService(userId);
	}

	public String add(int serviceId, int userId) {
		return getServiceInfo.add(serviceId, userId);
	}

	public String delete(int serviceId, int userId) {
		return getServiceInfo.delete(serviceId, userId);
	}

	public String registerService(int userId, String servicename,
			String serviceaddress, String servicdesc) {
		return getServiceInfo.registerService(userId, servicename,
				serviceaddress, servicdesc);
	}

	public String removeService(int sericeId) {
		return getServiceInfo.removeService(sericeId);
	}

	public String getProvidedAppication(int userid) {
		return getServiceInfo.getProvidedAppication(userid);
	}

	public String getServiceFromRole(int roleid) {
		return getServiceInfo.getServiceFromRole(roleid);
	}

	public String loadAllSpec() {
		return getServiceInfo.loadAllSpec();
	}

	/*public String getProvidedAppAndSpec(int userid) {
		return getServiceInfo.getProvidedAppAndSpec(userid);
	}*/

	public String registerSpec(String userid, String servicename, String xml) {
		return getServiceInfo.registerSpec(userid, servicename, xml);
	}

	public String removeSpec(String specid) {
		return getServiceInfo.removeSpec(specid);
	}

	public String getAllSpec(int userid) {
		return getServiceInfo.getAllSpec(userid);
	}

	public String getMySpec(int userid) {
		return getServiceInfo.getMySpec(userid);
	}

	public String launchSpec(String userid, String identifier, String version,
			String uri, String result) {
		return getServiceInfo.launchSpec(userid, identifier, version, uri,
				result);
	}

	public String cancelSpec(String userid, String identifier, String version,
			String uri, String result) {
		return getServiceInfo.cancelSpec(userid, identifier, version, uri,
				result);
	}

}