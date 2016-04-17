package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.bean.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SerService;

public class FormAction extends ActionSupport{
	private SerService ser;
	private String stringJson;
	private String stringState;
	private String serviceName;
	private String serviceDesc;
	private String serviceType;
	private String serviceLevel;
	private String serviceTarget;
	private String serviceRange;
	private String serviceAddress;
	private String serviceVersion;
	private String serviceMaker;
	private String serviceHost;
	private List<Service> listSer=new ArrayList<Service>();
	
	public String getAllServices(){
		listSer.clear();
	    listSer=ser.getAllService();
	    ConvertListToMap(listSer);
	    return SUCCESS;
	}
	
	public List<Service> getServiceList(){
		listSer.clear();
		if(serviceName!=null){
			listSer=ser.findyByServiceName(serviceName);
			return listSer;
		}else if(serviceType!=null){
			listSer=ser.findByProperty("serviceType", serviceType);
			return listSer;
		}else if(serviceMaker!=null){
			listSer=ser.findByProperty("serviceMaker", serviceMaker);
			return listSer;
		}else{
			listSer=null;
		}
		return listSer;
	}
	public String getService(){
		if(listSer!=null){
		ConvertListToMap(getServiceList());
		}
		return SUCCESS;
	}
	
	public String putService(){
		Service service=new Service();
		service.setServiceName(serviceName);
		service.setServiceDesc(serviceDesc);
		service.setServiceType(serviceType);
		service.setServiceLevel(serviceLevel);
		service.setServiceTarget(serviceTarget);
		service.setServiceRange(serviceRange);
		service.setServiceAddress(serviceAddress);
		service.setServiceVersion(serviceVersion);
		service.setServiceMaker(serviceMaker);
		service.setServiceHost(serviceHost);
		service.setServiceState("NO");
		service.setRunTimes(0);
		service.setFailTimes(0);
		try {
			ser.register(service);
			stringState="success";
		} catch (Exception e) {
			// TODO: handle exception
			stringState="failed";
		}
		
		return SUCCESS;
	}
	
	
	
	private void ConvertListToMap(List<Service> list){
		if(list!=null){
		 JSONArray jsArray=new JSONArray();
		  for(int i=0;i<list.size();i++){
			  Map<String,String> map=new HashMap<String, String>();
			  Service service=list.get(i);
			  map.put("serviceId",service.getServiceId().toString());
			  map.put("serviceName",service.getServiceName());
			  map.put("serviceDesc", service.getServiceDesc());
			  map.put("maxLoad", service.getMaxLoad()+"");
			  map.put("serviceType", service.getServiceType());
			  map.put("serviceLevel", service.getServiceLevel());
			  map.put("relateBusiness", service.getRelateBusiness());
			  map.put("serviceTarget", service.getServiceTarget());
			  map.put("serviceRange", service.getServiceRange());
			  map.put("serviceState", service.getServiceState());
			  map.put("serviceAddress", service.getServiceAddress());
			  map.put("serviceVersion", service.getServiceVersion());
			  map.put("serviceMaker", service.getServiceMaker());
			  map.put("serviceTime", service.getServiceTime());
			  map.put("serviceHost", service.getServiceHost());
			  map.put("serviceQuery", service.getServiceQuery());
			  jsArray.put(map);
		  }
		  stringJson=jsArray.toString();
		}else{
			stringJson=null;
		}
	}
	//get set method
	public String getStringState() {
		return stringState;
	}

	public void setStringState(String stringState) {
		this.stringState = stringState;
	}
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTarget() {
		return serviceTarget;
	}

	public void setServiceTarget(String serviceTarget) {
		this.serviceTarget = serviceTarget;
	}

	public String getServiceRange() {
		return serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceversion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getServiceMaker() {
		return serviceMaker;
	}

	public void setServicveMaker(String serviceMaker) {
		this.serviceMaker = serviceMaker;
	}

	public String getServiceHost() {
		return serviceHost;
	}

	public void setServiceHost(String serviceHost) {
		this.serviceHost = serviceHost;
	}

	public String getStringJson() {
		return stringJson;
	}

	public void setStringJson(String stringJson) {
		this.stringJson = stringJson;
	}

	public SerService getSer() {
		return ser;
	}

	public void setSer(SerService ser) {
		this.ser = ser;
	}
	
	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	
}
