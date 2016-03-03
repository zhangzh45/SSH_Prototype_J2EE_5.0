package com.server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.List;



import com.action.ServiceAction;
import com.bean.Parameter;
import com.bean.Service;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserSpecSer;
import com.service.SerService;
import com.service.TempService;
import com.service.UserSpecSerService;

import org.json.JSONArray;
import org.json.JSONObject;


public  class ServiceInfo
{
	
   
    private  static ServiceAction sa;
    private  static SerService ser;
    private  static UserSpecSerService utiluss;
    private  static TempService tempser;
 

	public TempService getTempser() {
		return tempser;
	}

	public  void setTempser(TempService tempser) {
		ServiceInfo.tempser = tempser;
	}

	public UserSpecSerService getUtiluss() {
		return utiluss;
	}

	public void setUtiluss(UserSpecSerService utiluss) {
		this.utiluss = utiluss;
	}

	public  SerService getSer() {
		return ser;
	}

	public  void setSer(SerService ser) {
		this.ser = ser;
	}

	public ServiceAction getSa() {
		return sa;
	}

	public void setSa(ServiceAction sa) {
		this.sa = sa;
	}
    /* (non-Javadoc)
	 * @see com.util.SysuClientInter#getMyService(int)
	 */
    public static String getMyService(int userId){
    	//sl = new ArrayList<Service>();
    	List<Service> sl=sa.getMyService(userId);
    	//List<Map<String,String>> li=new ArrayList<Map<String,String>>();
    //	 String result="";
    	 JSONArray json=new JSONArray();
    	
   	  for(int i = 0; i < sl.size(); i++)
   	  {
   		  Map<String, String> map=new HashMap<String, String>();
   		  map.put("appid", sl.get(i).getServiceId().toString());
   		  map.put("appName", sl.get(i).getServiceName());
   		  map.put("type", sl.get(i).getServiceType());
   		  map.put("desc", sl.get(i).getServiceDesc());
   		  map.put("url", sl.get(i).getServiceAddress());
   		  Set paramSet=sl.get(i).getParameters();
   		  if(paramSet.size()!=0){
   			  Map<String, String> paramsMap = new HashMap<String, String>();
			for(Object o : paramSet){
				Parameter param = (Parameter) o;
				paramsMap.put(param.getParametername(), param.getParametertype());
				String paramJson=new JSONObject(paramsMap).toString();
				map.put("params", paramJson);
   		  	}
   		  }
   		  json.put(map);  
   	  }
   	  return json.toString();
   	
    }
    
    /* (non-Javadoc)
	 * @see com.util.SysuClientInter#getAllService(int)
	 */
    public static String  getAllService(int userId){
    //	List<UserRole> urs = new ArrayList<UserRole>();
    	
    //	List<Service> other=new ArrayList<Service>();
    	List<Service> speSerList=sa.getMyService(userId);//get the mapping service by permission that user has;
    	JSONArray json=new JSONArray();
    	List<Service> allService=ser.getAllService();//get all Service;
    	List<Temp> auditSerList=tempser.findyByUserId(userId);//the service waiting for agree
    	boolean userSpeSer;
		for(int i=0;i<allService.size();i++){
			userSpeSer=false;
			int allSerId=allService.get(i).getServiceId();
    		for(int j=0;j<speSerList.size();j++){
    			int prServiceId=speSerList.get(j).getServiceId();
    		if(allSerId==prServiceId){//if this service belongs to  the user's special service
    				userSpeSer=true;
    				j=speSerList.size();
    			}
    		else{
    			for(int k=0;k<auditSerList.size();k++){//if this service  belongs to the audit service
    				int auditSerId=auditSerList.get(k).getServiceId();
    				Service auditService=ser.getUniqueService(String.valueOf(auditSerId));
    				if(allSerId==auditSerId){
    					Map<String,String> map=new HashMap<String,String>();
    					map.put("appid", auditService.getServiceId().toString());
    					map.put("appName", auditService.getServiceName());
    					map.put("appType", auditService.getServiceType());
    					map.put("appDesc", auditService.getServiceDesc());
    					map.put("available", "audit");
    					json.put(map);
    					userSpeSer=true;
    					k=auditSerList.size();
    					j=speSerList.size();
    				}
    			}
    		}
    		}
    		
    		if(userSpeSer==false){//the service that not choose
    		Map<String,String> map=new HashMap<String,String>();
    		map.put("appid", allService.get(i).getServiceId().toString());
			map.put("appName", allService.get(i).getServiceName());
			map.put("appType", allService.get(i).getServiceType());
			map.put("appDesc", allService.get(i).getServiceDesc());
			map.put("available", "false");
			json.put(map);
    		}
    	}
    	for(UserSpecSer uss:utiluss.findSpecSerByUserId(userId)){
    		Map<String,String> map1=new HashMap<String,String>();
			map1.put("appid", uss.getService().getServiceId().toString());
			map1.put("appName", uss.getService().getServiceName()); 
			map1.put("appType", uss.getService().getServiceType());
			map1.put("appDesc", uss.getService().getServiceDesc());
			map1.put("available", "true");
			json.put(map1);
		}
  
    	return json.toString();
    }
    
    public static void add(int serviceId,int userId){
    	tempser.add(serviceId, userId);
    }
    
    public static void deleteService(int serviceId,int userId){
    	
    	utiluss.deleteByServiceUserId(serviceId, userId);
    }
    
    
}