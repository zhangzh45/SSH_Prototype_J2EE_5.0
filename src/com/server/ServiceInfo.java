package com.server;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.List;



import com.action.ServiceAction;
import com.bean.Condition;
import com.bean.Parameter;
import com.bean.Runlog;
import com.bean.Service;
import com.bean.SpecTaskRoleUser;
import com.bean.Specification;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserSpecSer;
import com.bean.Variable;
import com.mule.MuleConfig;
import com.opensymphony.xwork2.ActionContext;
import com.service.ConditionService;
import com.service.RunlogService;
import com.service.SerService;
import com.service.SpecTaskRoleUserService;
import com.service.SpecificationService;
import com.service.TempService;
import com.service.UserSpecSerService;
import com.util.GetRemoteService;
import com.util.MuleXMLParser;
import com.util.ParseYawlFile;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public  class ServiceInfo
{
	private  static ServiceAction sa;
    private  static SerService ser;
    private  static UserSpecSerService utiluss;
    private  static TempService tempser;
    private  static  ConditionService conditionsr;
    private  static  SpecificationService specsr;
    private  static  SpecTaskRoleUserService strusr;
    private  static  RunlogService runlogsr;

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
	
    public ConditionService getConditionsr() {
		return conditionsr;
	}

	public  void setConditionsr(ConditionService conditionsr) {
		this.conditionsr = conditionsr;
	}
	
	public SpecificationService getSpecsr() {
		return specsr;
	}

	public void setSpecsr(SpecificationService specsr) {
		this.specsr = specsr;
	}

	public SpecTaskRoleUserService getStrusr() {
		return strusr;
	}

	public void setStrusr(SpecTaskRoleUserService strusr) {
		this.strusr = strusr;
	}
	
	public RunlogService getRunlogsr() {
		return runlogsr;
	}

	public void setRunlogsr(RunlogService runlogsr) {
		this.runlogsr = runlogsr;
	}

	/* (non-Javadoc)
	 * @see com.util.SysuClientInter#getMyService(int)
	 * 获取用户服务
	 */
    public static String getMyService(int userId){
    	GetRemoteService grs = new GetRemoteService();
    	boolean isAdmin = grs.isAdmin(String.valueOf(userId));
    	List<Service> sl = new ArrayList<Service>();
    	if(isAdmin || userId == 0){
    		sl=ser.getAllService();  //不包括流程
    	}else{
    		sl=sa.getMyService(userId);
    	}
    	 JSONArray json=new JSONArray();
    	 
    	 List<Service> businesslist = new ArrayList<Service>();
    	 businesslist = ser.getBusinessService();
    	 sl.removeAll(businesslist);   //移除流程的情况
    	 List<Service> locallist = new ArrayList<Service>();
    	 locallist = ser.getLocalService();
    	 sl.removeAll(locallist);   //移除本地应用的情况
    	 
	   	  for(int i = 0; i < sl.size(); i++)
	   	  {
	   		  Map<String, String> map=new HashMap<String, String>();
	   		  map.put("appid", sl.get(i).getServiceId().toString());
	   		  map.put("appName", sl.get(i).getServiceName());
	   		  map.put("appType", sl.get(i).getServiceType());
	   		  map.put("appDesc", sl.get(i).getServiceDesc());
	   		  map.put("appURL", sl.get(i).getServiceAddress());
	   		  map.put("query", sl.get(i).getServiceQuery());
	   		  Set paramSet=sl.get(i).getParameters();
	   		  if(paramSet.size()!=0){
	   			  Map<String, String> paramsMap = new HashMap<String, String>();
				for(Object o : paramSet){
					Parameter param = (Parameter) o;
					paramsMap.put(param.getParametername(), param.getParametertype());
					String paramJson=new JSONObject(paramsMap).toString();
					map.put("params", paramJson);
	   		  	}
				System.out.print(map.toString()+"\n");
	   		  }
	   		  
	 		  
	 		  if(sl.get(i).getCombineType() != null && sl.get(i).getCombineType().equalsIgnoreCase("CombineB")){
	 			  Set varSet=sl.get(i).getVariables();    //获取组合服务中的控制变量
	 	 		  if(varSet.size() != 0){
	 	 			    Map<String, String> varMap = new HashMap<String, String>();
		 				for(Object o : varSet){
		 					Variable var = (Variable) o;
		 					varMap.put(var.getVariableName(), var.getVariableDesc());
		 					String varJson=new JSONObject(varMap).toString();
		 					map.put("vars", varJson);
		 	 		  	}
		 				System.out.print(map.toString()+"\n");
	 	 		  }
	 	 		  
	 	 		 Set cons=sl.get(i).getConditionsForServiceId();    //获取组合服务中的运行条件
	 			 //List<Condition> cons = new ArrayList<Condition>();
	 			 //cons = conditionsr.getConditionDao().findByServiceId(sl.get(i).getServiceId());
	 			 if(cons.size() != 0){
	 				Service subservice = new Service();
	 				for(Object o : cons){
	 					Condition con = (Condition) o;
	 					subservice = con.getServiceBySubServiceId();
	 					Set subparamSet = subservice.getParameters();    //获取组合服务中子服务的参数
	 	 	 	   		  if(subparamSet.size()!=0){
	 	 	 	   			  Map<String, String> subparamsMap = new HashMap<String, String>();
	 	 	 				for(Object o1 : subparamSet){
	 	 	 					Parameter para = (Parameter) o1;
	 	 	 					subparamsMap.put(para.getParametername(), para.getParametertype());
	 	 	 					String subparamsJson=new JSONObject(subparamsMap).toString();
	 	 	 					map.put("subparams", subparamsJson);
	 	 	 	   		  	}
	 	 	 	   		  }
	 	 	 	   		  break;
	 	 		  	}
	 			 }
	 			 
	 	   		System.out.print(map.toString()+"\n");
	 		  }
	   		  json.put(map);  
	   		  System.out.print(json.toString());
	   	  }
	   	  return json.toString();
   	
    }
    
    /**
     * 获取用户流程
     * @param userId
     * @return
     */
    public static String getMySpec(int userId){
    	GetRemoteService grs = new GetRemoteService();
    	boolean isAdmin = grs.isAdmin(String.valueOf(userId));
    	List<Service> sl = new ArrayList<Service>();
    	if(isAdmin || userId == 0){
    		sl=ser.getAllService();  //不包括流程
    	}else{
    		sl=sa.getMyService(userId);
    	}
    	 JSONArray json=new JSONArray();
    	 
    	 List<Service> businesslist = new ArrayList<Service>();
    	 businesslist = ser.getBusinessService();
    	 sl.retainAll(businesslist);   //只有流程的情况
    	 
	   	  for(int i = 0; i < sl.size(); i++)
	   	  {
	   		  List<Specification> spec = new ArrayList<Specification>();
	   		  spec = specsr.getSpecDao().findByFilepath(sl.get(i).getBusinessFile());
	   		  if(spec.size() > 0){
	   			  Map<String, String> map=new HashMap<String, String>();
		   		  map.put("appid", sl.get(i).getServiceId().toString());
		   		  map.put("appName", sl.get(i).getServiceName());
		   		  map.put("appType", sl.get(i).getServiceType());
		   		  map.put("appDesc", sl.get(i).getServiceDesc());
		   		  map.put("appURL", sl.get(i).getServiceAddress());
		   		  if(sl.get(i).getServiceProvider().equals(String.valueOf(userId))){
		   			 map.put("appProvider", sl.get(i).getServiceProvider());   //用户自己注册的流程
		   		  }
	   			  map.put("identifier", spec.get(0).getIdentifier());
		   		  map.put("name", spec.get(0).getName());
		   		  map.put("uri", spec.get(0).getUri());
		   		  map.put("version", spec.get(0).getVersion());
		   		  map.put("documentation", spec.get(0).getDescription());
		   		  
		   		  json.put(map);
	 		  }
	   	  }
	   	  System.out.print( "getMySpec.toString():"+ json.toString()+"\n");
	   	  return json.toString();
   	
    }
    
    /* (non-Javadoc)
	 * @see com.util.SysuClientInter#getAllService(int)
	 * 获取用户可以申请的服务
	 */
    public static String  getAllService(int userId){
    //	List<UserRole> urs = new ArrayList<UserRole>();
    	
        List<Service> speSerList=new ArrayList<Service>();
    	GetRemoteService grs = new GetRemoteService();
    	boolean isAdmin = grs.isAdmin(String.valueOf(userId));
    	if(isAdmin || userId == 0){
    		speSerList=ser.getAllService();
    	}else{
    		speSerList=sa.getMyService(userId);
    	}
    	
    	//List<Service> speSerList=sa.getMyService(userId);//get the mapping service by permission that user has;
    	JSONArray json=new JSONArray();
    	List<Service> allService=ser.getAcceptedService();//.getAllService();//get all Service;
    	List<Service> businesslist =ser.getBusinessService();
    	allService.removeAll(businesslist);   //暂时不考虑流程
    	speSerList.removeAll(businesslist);
    	
    	List<Service> locallist = ser.getLocalService();
    	allService.removeAll(locallist);   //暂时不考虑本地应用
    	speSerList.removeAll(locallist);
    	
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
	    					map.put("appURL", auditService.getServiceAddress());
	    					/*map.put("appURL", auditService.getServiceAddress());
	    					map.put("appQuery", auditService.getServiceQuery());*/
	    					
	    					Set paramSet=auditService.getParameters();
	    			   		if(paramSet.size()!=0){
	    			   			Map<String, String> paramsMap = new HashMap<String, String>();
	    						for(Object o : paramSet){
	    							Parameter param = (Parameter) o;
	    							paramsMap.put(param.getParametername(), param.getParametertype());
	    							String paramJson=new JSONObject(paramsMap).toString();
	    							map.put("params", paramJson);
	    			   		  	}
	    			   		}
	    					
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
				map.put("appURL", allService.get(i).getServiceAddress());
				/*map.put("appURL", allService.get(i).getServiceAddress());
				map.put("appQuery", allService.get(i).getServiceQuery());*/
				
				Set paramSet=allService.get(i).getParameters();
		   		if(paramSet.size()!=0){
		   			Map<String, String> paramsMap = new HashMap<String, String>();
					for(Object o : paramSet){
						Parameter param = (Parameter) o;
						paramsMap.put(param.getParametername(), param.getParametertype());
						String paramJson=new JSONObject(paramsMap).toString();
						map.put("params", paramJson);
		   		  	}
		   		}
				
				map.put("available", "false");
				json.put(map);
    		}
    	}
    	for(UserSpecSer uss:utiluss.findSpecSerByUserId(userId)){
    		if(uss.getService().getServiceType().equals("BUSINESS") == false){
    			Map<String,String> map1=new HashMap<String,String>();
    			map1.put("appid", uss.getService().getServiceId().toString());
    			map1.put("appName", uss.getService().getServiceName()); 
    			map1.put("appType", uss.getService().getServiceType());
    			map1.put("appDesc", uss.getService().getServiceDesc());
    			map1.put("appURL", uss.getService().getServiceAddress());
    			/*map1.put("appURL", uss.getService().getServiceAddress());
    			map1.put("appQuery", uss.getService().getServiceQuery());*/
    			
    			Set paramSet=uss.getService().getParameters();
    	   		if(paramSet.size()!=0){
    	   			Map<String, String> paramsMap = new HashMap<String, String>();
    				for(Object o : paramSet){
    					Parameter param = (Parameter) o;
    					paramsMap.put(param.getParametername(), param.getParametertype());
    					String paramJson=new JSONObject(paramsMap).toString();
    					map1.put("params", paramJson);
    	   		  	}
    	   		}
    			
    			map1.put("available", "true");
    			json.put(map1);
    		}
		}
  
    	return json.toString();
    }
    
    /**
     * 在sysuclient端用户可以申请的流程
     * @param userId
     * @return
     */
    public static String  getAllSpec(int userId){
        //	List<UserRole> urs = new ArrayList<UserRole>();
        	
            List<Service> speSerList=new ArrayList<Service>();
        	GetRemoteService grs = new GetRemoteService();
        	boolean isAdmin = grs.isAdmin(String.valueOf(userId));
        	if(isAdmin || userId == 0){
        		speSerList=ser.getAll();
        	}else{
        		speSerList=sa.getMyService(userId);
        	}
        	
        	//List<Service> speSerList=sa.getMyService(userId);//get the mapping service by permission that user has;
        	JSONArray json=new JSONArray();
        	List<Service> allService=ser.getAcceptedService();//.getAllService();//get all Service;
        	List<Service> businesslist =ser.getBusinessService();
        	allService.retainAll(businesslist);   //只考虑流程
        	
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
    	    					List<Specification> spec = new ArrayList<Specification>();
    	    					spec = specsr.getSpecDao().findByFilepath(auditService.getBusinessFile());
    	    					if(spec.size() > 0){
    	    						Map<String,String> map=new HashMap<String,String>();
        	    					map.put("appid", auditService.getServiceId().toString());
        	    					map.put("appName", auditService.getServiceName());
        	    					map.put("appType", auditService.getServiceType());
        	    					map.put("appDesc", auditService.getServiceDesc());
        	    					map.put("appURL", auditService.getServiceAddress());
    	    						map.put("identifier", spec.get(0).getIdentifier());
        	    					map.put("name", spec.get(0).getName());
        	    					map.put("uri", spec.get(0).getUri());
        	    					map.put("version", spec.get(0).getVersion());
        	    					map.put("documentation", spec.get(0).getDescription());
        	    					map.put("available", "audit");
        	    					json.put(map);
    	    					}
    	    					userSpeSer=true;
    	    					k=auditSerList.size();
    	    					j=speSerList.size();
    	    				}
    	    			}
    	    		}
        		}
        		
        		if(userSpeSer==false){//the service that not choose
	        		List<Specification> spec = new ArrayList<Specification>();
					spec = specsr.getSpecDao().findByFilepath(allService.get(i).getBusinessFile());
					if(spec.size() > 0){
						Map<String,String> map=new HashMap<String,String>();
		        		map.put("appid", allService.get(i).getServiceId().toString());
		    			map.put("appName", allService.get(i).getServiceName());
		    			map.put("appType", allService.get(i).getServiceType());
		    			map.put("appDesc", allService.get(i).getServiceDesc());
		    			map.put("appURL", allService.get(i).getServiceAddress());
						map.put("identifier", spec.get(0).getIdentifier());
    					map.put("name", spec.get(0).getName());
    					map.put("uri", spec.get(0).getUri());
    					map.put("version", spec.get(0).getVersion());
    					map.put("documentation", spec.get(0).getDescription());
    	    			map.put("available", "false");
    	    			json.put(map);
					}
        		}
        	}
        	for(UserSpecSer uss:utiluss.findSpecSerByUserId(userId)){
        		if(uss.getService().getServiceType().equals("BUSINESS")){
        			List<Specification> spec = new ArrayList<Specification>();
					spec = specsr.getSpecDao().findByFilepath(uss.getService().getBusinessFile());
					if(spec.size() > 0){
						Map<String,String> map1=new HashMap<String,String>();
	        			map1.put("appid", uss.getService().getServiceId().toString());
	        			map1.put("appName", uss.getService().getServiceName()); 
	        			map1.put("appType", uss.getService().getServiceType());
	        			map1.put("appDesc", uss.getService().getServiceDesc());
	        			map1.put("appURL", uss.getService().getServiceAddress());
						map1.put("identifier", spec.get(0).getIdentifier());
    					map1.put("name", spec.get(0).getName());
    					map1.put("uri", spec.get(0).getUri());
    					map1.put("version", spec.get(0).getVersion());
    					map1.put("documentation", spec.get(0).getDescription());
    					map1.put("available", "true");
            			json.put(map1);
					}
        		}
    		}
        	System.out.print( "getAllSpec.toString():"+ json.toString()+"\n");
        	return json.toString();
        }
    
    /**
     * 添加用户申请中的特有服务
     * @param serviceId
     * @param userId
     * @return
     */
    public static String add(int serviceId,int userId){
    	tempser.add(serviceId, userId);
    	return "success";
    }
    
    /**
     * 删除用户特有服务
     * @param serviceId
     * @param userId
     * @return
     */
    public static String deleteService(int serviceId,int userId){
    	
    	utiluss.deleteByServiceUserId(serviceId, userId);
    	return "success";
    }
    
    /**
     * 注册client端的引擎组件
     * @param userId
     * @param servicename
     * @param serviceaddress
     * @param servicdesc
     * @return
     */
	public static String registerService(int userId, String servicename,
			String serviceaddress, String servicdesc) {
		// TODO Auto-generated method stub
		Service s = new Service();
		s.setServiceName(servicename);
		s.setServiceAddress(serviceaddress);
		s.setServiceDesc(servicdesc);
		s.setServiceProvider(String.valueOf(userId));
		s.setServiceType("SERVICE"); //client 那边YAWL引擎注册的组件
		s.setServiceState("NO");
		s.setServiceLevel("1");
		s.setRunTimes(0);
		s.setFailTimes(0);
		ser.register(s);
		return "success";
	}

	/**
	 * 删除client注册的引擎组件
	 * @param sericeId
	 * @return
	 */
	public static String removeService(int sericeId) {
		// TODO Auto-generated method stub
		Service s = new Service();
		s = ser.getUniqueService(String.valueOf(sericeId));
		ser.getSrDAO().delete(s);
		return "success";
	}
	
	/**
	 * 获取用户注册的应用
	 * @param userid
	 * @return
	 */
	public static String getProvidedAppication(int userid) {
		List<Service> apps = new ArrayList<Service>();
		apps = ser.getProvidedService(String.valueOf(userid));
		List<Service> accepted = new ArrayList<Service>();
		accepted = ser.getAcceptedService();
		apps.retainAll(accepted);
		
		JSONArray json=new JSONArray();
		for(int i = 0; i < apps.size(); i++){
			Map<String,String> map=new HashMap<String,String>();
			Service s = new Service();
			s = apps.get(i);
			if(s.getServiceType().equalsIgnoreCase("APPLICATION")){
				map.put("appId", s.getServiceId().toString());
				map.put("appName", s.getServiceName());
				map.put("appURL", s.getServiceAddress());
				map.put("appDesc", s.getServiceDesc());
				json.put(map);
			}
		}
		System.out.print( "getProvidedAppication.toString():"+ json.toString()+"\n");
		return json.toString();
	}
	
	/**
	 * 加载所有审核通过的流程
	 * @return
	 */
	public static String loadAllSpec() {
		List<Service> apps = new ArrayList<Service>();
		apps = ser.getAcceptedService();
		
		JSONArray json=new JSONArray();
		for(int i = 0; i < apps.size(); i++){
			Service s = new Service();
			s = apps.get(i);
			if(s.getServiceType().equalsIgnoreCase("BUSINESS")){
				Map<String,String> map=new HashMap<String,String>();
				String businessfile = s.getBusinessFile();
				System.out.print( "businessfile:"+ businessfile+"\n");
				map.put("appid", s.getServiceId().toString());
				List<Specification> speclist = new ArrayList<Specification>();
				speclist = specsr.getSpecDao().findByFilepath(businessfile);
				
				System.out.print( "speclist.size():"+ speclist.size()+"\n");
				if(speclist.size() > 0){
					map.put("identifier", speclist.get(0).getIdentifier());
					map.put("name", speclist.get(0).getName());
					map.put("uri", speclist.get(0).getUri());
					map.put("version", speclist.get(0).getVersion());
					map.put("documentation", speclist.get(0).getDescription());
					//map.put("status", "loaded");
					json.put(map);
				}
			}
		}
		System.out.print( "loadAllSpec.toString():"+ json.toString()+"\n");
		return json.toString();
	}
	
	/**
	 * 根据角色获取其服务列表
	 * @param roleid
	 * @return
	 */
	public static String getServiceFromRole(int roleid) {
		List<Service> sers = new ArrayList<Service>();
		sers = sa.getServiceFromRole(roleid);
		JSONArray json=new JSONArray();
		for(int i = 0; i < sers.size(); i++){
			Map<String,String> map=new HashMap<String,String>();
			Service s = new Service();
			s = sers.get(i);
			map.put("appId", s.getServiceId().toString());
			map.put("appName", s.getServiceName());
			map.put("appURL", s.getServiceAddress());
			json.put(map);
		}
		System.out.print( "getServiceFromRole.toString():"+ json.toString()+"\n");
		return json.toString();
	}
	
	/**
	 * 获取用户所注册的应用和流程
	 * @param userid
	 * @return
	 */
	public static String getProvidedAppAndSpec(int userid) {
		List<Service> apps = new ArrayList<Service>();
		apps = ser.getProvidedService(String.valueOf(userid));
		List<Service> accepted = new ArrayList<Service>();
		accepted = ser.getAcceptedService();
		apps.retainAll(accepted);
		
		JSONArray json=new JSONArray();
		for(int i = 0; i < apps.size(); i++){
			Service s = new Service();
			s = apps.get(i);
			if(s.getServiceType().equalsIgnoreCase("APPLICATION")){
				Map<String,String> map=new HashMap<String,String>();
				map.put("id", s.getServiceId().toString());
				map.put("name", s.getServiceName());
				map.put("type", s.getServiceType());
				map.put("url", s.getAppRoleUrl());
				json.put(map);
			}
			
			else if(s.getServiceType().equalsIgnoreCase("BUSINESS")){
				Map<String,String> map=new HashMap<String,String>();
				String businessfile = s.getBusinessFile();
				String specid = "", specname = "";
				List<Specification> speclist = new ArrayList<Specification>();
				speclist = specsr.getSpecDao().findByFilepath(businessfile);
				
				//List<SpecTaskRoleUser> stru = new ArrayList<SpecTaskRoleUser>();
				//stru =  strusr.getStruDao().findByBusinessfile(businessfile);
				if(speclist.size() != 0){
					specid = speclist.get(0).getIdentifier();
					specname = speclist.get(0).getName();
					map.put("id", specid);
					map.put("name", specname);
					map.put("type", s.getServiceType());
					String ip = "localhost";
					try {
						InetAddress addr = InetAddress.getLocalHost();
						ip = addr.getHostAddress().toString();//获得本机IP
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String getSpecRoleURL = "http://"+ip+":8020/SSH_Prototype_J2EE_5.0/getSpecRoleFromSpec.action";
					map.put("url", getSpecRoleURL);
					json.put(map);
				}
				
			}
		}
		System.out.print( "getProvidedAppAndSpec.toString():"+ json.toString()+"\n");
		return json.toString();
	}
	
	/**
	 * 根据流程id获取流程的业务角色
	 * @param specid
	 * @return
	 */
	public static String getSpecRoleFromSpec(String specid){
		JSONObject specJson=new JSONObject();
		JSONArray json=new JSONArray();
		List<SpecTaskRoleUser> stru = new ArrayList<SpecTaskRoleUser>();
		stru =  strusr.getStruDao().findBySpecIdentifier(specid);
		List<String> tasks = new ArrayList<String>();
		for(int i = 0; i < stru.size(); i++){
			SpecTaskRoleUser s = new SpecTaskRoleUser();
			s = stru.get(i);
			String taskid = s.getTaskId();
			if(tasks.contains(taskid) == false){
				tasks.add(taskid);
				Map<String,String> map=new HashMap<String,String>();
				map.put("taskId", taskid);
				String rolestr = "{";
				List<String> roles = new ArrayList<String>();
				for(int j = i; j < stru.size(); j++){
					if(stru.get(j).getTaskId().equals(taskid) && stru.get(j).getRoleId() != null){
						if(roles.contains(stru.get(j).getRoleId()) == false){
							roles.add(stru.get(j).getRoleId());
							rolestr += stru.get(j).getRoleId() + ",";
						}
					}
				}
				if(rolestr.charAt(rolestr.length() - 1) == ','){
					rolestr = rolestr.substring(0, rolestr.length() - 1);
				}
				rolestr += "}";
				map.put("roles", rolestr);
				json.put(map);
			}
			
		}
		try {
			specJson.put("spec", json.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "error";
		}
		System.out.print( "specJson.toString():"+ specJson.toString()+"\n");
		return specJson.toString();
		//return "success";
	}

	/**
	 * 注册sysuclient端上传的流程
	 * @param userid
	 * @param servicename
	 * @param xml   流程文件的内容
	 * @return
	 */
	public static String registerSpec(String userid, String servicename, String xml) {
		JSONArray json=new JSONArray();
		Map<String,String> map=new HashMap<String,String>();
		try{
			String realpath = MuleConfig.getMuleAppPath() + "/" + servicename;
			realpath = realpath.replaceAll("\\\\", "/");
			System.out.println("\n!!!!!realpath: "+realpath+"\n");
	        String filename = servicename + ".yawl";
	        File savefile = new File(new File(realpath), filename);
	        if (!savefile.getParentFile().exists())
	        {
	        	savefile.getParentFile().mkdirs();
	   	    }
	        FileOutputStream fos = new FileOutputStream(savefile);   
	        OutputStreamWriter osw = new OutputStreamWriter(fos);   
	        BufferedWriter bw = new BufferedWriter(osw);   
	        bw.write(xml);   
	        bw.close();
	        MuleXMLParser.parse(savefile);
	        Service spec = new Service();
	        spec.setServiceName(servicename);
	        spec.setServiceProvider(userid);
	        spec.setFailTimes(0);
	        spec.setRunTimes(0);
	        spec.setServiceState("NO");
	        spec.setServiceType("BUSINESS");
	        spec.setServiceLevel("1");
	        spec.setBusinessFile(realpath + "/" + filename);
	        ser.register(spec);
	        
	        //解析流程文件
    		ParseYawlFile yawl = new ParseYawlFile();
    		yawl.getSpecRoleOrUser(spec.getBusinessFile());
    		/*List<SpecTaskRoleUser> strulist = new ArrayList<SpecTaskRoleUser>();
    		strulist = yawl.getSpecRoleOrUser(spec.getBusinessFile());
    		for(int i = 0; i < strulist.size(); i++){
    			strusr.addSpecTaskRoleUser(strulist.get(i));
    		}*/
    		
    		map.put("registerSpec", "success");
		}catch(Exception e){
			e.printStackTrace();
			map.put("registerSpec", "error");
		}
		json.put(map);
		System.out.print(json.toString());
		return json.toString();
	}

	/**
	 * 移除sysuclient端unload的流程
	 * @param specid
	 * @return
	 */
	public static String removeSpec(String specid) {
		JSONArray json=new JSONArray();
		Map<String,String> map=new HashMap<String,String>();
		try{
			List<SpecTaskRoleUser> strulist = new ArrayList<SpecTaskRoleUser>();
			strulist = strusr.getStruDao().findBySpecIdentifier(specid);
			for(int j = 0; j < strulist.size(); j++){
				strusr.deleteSpecTaskRoleUser(strulist.get(j));
			}
			
			List<Specification> speclist = new ArrayList<Specification>();
			speclist = specsr.getSpecDao().findByIdentifier(specid);
			String businessfile = "";
			if(speclist.size() > 0){
				businessfile = speclist.get(0).getFilepath();
				List<Service> slist = new ArrayList<Service>();
				slist = ser.getSrDAO().findByBusinessFile(businessfile);
				for(int i = 0; i < slist.size(); i++){
					ser.unregister(slist.get(i));
				}
			}
			for(int j = 0; j < speclist.size(); j++){
				specsr.deleteSpec(speclist.get(j));
			}
			
			map.put("removeSpec", "success");
		}catch(Exception e){
			e.printStackTrace();
			map.put("removeSpec", "error");
		}
		json.put(map);
		System.out.print(json.toString());
		return json.toString();
		
	}

	/**
	 * sysuclient端发起流程的日志记录
	 * @param userid
	 * @param identifier
	 * @param version
	 * @param uri
	 * @return
	 */
	public static String launchSpec(String userid, String identifier, String version, String uri, String result) {
		JSONArray json=new JSONArray();
		Map<String,String> map=new HashMap<String,String>();
		int serviceid = 0;
		try{
			List<Specification> speclist = new ArrayList<Specification>();
			speclist = specsr.getSpecDao().findByIdentifier(identifier);
			String businessfile = "";
			if(speclist.size() > 0){
				businessfile = speclist.get(0).getFilepath();
				List<Service> slist = new ArrayList<Service>();
				slist = ser.getSrDAO().findByBusinessFile(businessfile);
				if(slist.size() > 0){
					serviceid = slist.get(0).getServiceId();
				}
				Runlog rl = new Runlog();
				rl.setUserid(Integer.parseInt(userid));
				rl.setServiceid(serviceid);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String starttime = formatter.format(new Date());//格式化数
				rl.setStarttime(starttime);
				rl.setRunstate("launch");
				rl.setRundesc(result);
				runlogsr.addRunlog(rl);
			}
			Service s = ser.getUniqueService(String.valueOf(serviceid));
			s.setRunTimes(s.getRunTimes() + 1);
			ser.update(s);
			map.put("launchSpec", "success");
		}catch(Exception e){
			e.printStackTrace();
			map.put("launchSpec", "error");
		}
		json.put(map);
		System.out.print(json.toString());
		return json.toString();
	}

	/**
	 * 记录流程case cancel的日志
	 * @param userid
	 * @param identifier
	 * @param version
	 * @param uri
	 * @return
	 */
	public static String cancelSpec(String userid, String identifier,
			String version, String uri, String result) {
		JSONArray json=new JSONArray();
		Map<String,String> map=new HashMap<String,String>();
		int serviceid = 0;
		try{
			List<Specification> speclist = new ArrayList<Specification>();
			speclist = specsr.getSpecDao().findByIdentifier(identifier);
			String businessfile = "";
			if(speclist.size() > 0){
				businessfile = speclist.get(0).getFilepath();
				List<Service> slist = new ArrayList<Service>();
				slist = ser.getSrDAO().findByBusinessFile(businessfile);
				if(slist.size() > 0){
					serviceid = slist.get(0).getServiceId();
				}
				Runlog rl = new Runlog();
				rl.setUserid(Integer.parseInt(userid));
				rl.setServiceid(serviceid);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String finishtime = formatter.format(new Date());//格式化数
				rl.setFinishtime(finishtime);
				rl.setRunstate("cancel");
				rl.setRundesc(result);
				runlogsr.addRunlog(rl);
			}
			map.put("cancelSpec", "success");
		}catch(Exception e){
			e.printStackTrace();
			Service s = ser.getUniqueService(String.valueOf(serviceid));
			s.setFailTimes(s.getFailTimes() + 1);
			ser.update(s);
			map.put("cancelSpec", "error");
		}
		json.put(map);
		System.out.print(json.toString());
		return json.toString();
	}
}