package com.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bean.Condition;
import com.bean.Parameter;
import com.bean.ParameterDAO;
import com.bean.Permissionservice;
import com.bean.RolePermission;
import com.bean.RoleSpecSer;
import com.bean.Runlog;
import com.bean.Service;
import com.bean.Serviceresult;
import com.bean.UserRole;
import com.bean.UserSpecSer;
import com.bean.Variable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ConditionService;
import com.service.ParameterService;
import com.service.PermissionServiceService;
import com.service.RolePermissionService;
import com.service.RoleSpecSerService;
import com.service.RunlogService;
import com.service.SerService;
import com.service.ServicerelationService;
import com.service.ServiceresultService;
import com.service.TempService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.UserSpecSerService;
import com.service.VariableService;
import com.util.CombineService;
import com.util.EnglishChineseUtil;
import com.util.GetRemoteService;
import com.util.IpUtil;
import com.util.ListSortUtil;
import com.util.MobileUtil;
import com.util.MoneyUtil;
import com.util.ParseJSONUtil;
import com.util.ServiceReliability;
import com.util.Shell;
import com.util.WeatherUtil;
import com.util.WebServiceUtil;
import com.util.ZipCodeUtil;

import com.calculater.ExpressionCalculater;

public class ParameterAction extends ActionSupport
{
	private static final Logger log = LoggerFactory.getLogger(ParameterAction.class);
	private   ServiceAction sa;
	
	private ParameterService parametersr = new ParameterService();
	private SerService  servicesr = new SerService();
	private ServiceresultService srresultsr = new ServiceresultService();
	private ConditionService conditionsr = new ConditionService();
	private VariableService variablesr = new VariableService();
	private RunlogService runlogsr = new RunlogService();
	private ServicerelationService srrelationsr = new ServicerelationService();
	
	
	private SerService srs = new SerService();
	private UserSpecSerService userSpecSr;
	private RoleSpecSerService roleSpecSr = new RoleSpecSerService();
	private UserRoleService userrolesr = new UserRoleService();
	private RolePermissionService rolepermissionsr = new RolePermissionService();
	private PermissionServiceService permissionservicesr = new PermissionServiceService();
	
	String default_maxload = "100";
	
	Parameter pr = new Parameter();
	String serviceid;
	String option1 = "11";
	String option2;
	String number;
	String pts;
	String vrs;
	String sid;
	String url;
	String userid;
	List<Parameter> ps = new ArrayList<Parameter>();
	List<Variable> vars = new ArrayList<Variable>();
	List<String> ss = new ArrayList<String>();
	
	String var1 = "NULL";
	String varName;
	String esp;
	String esp2;
	String sid1;
	String sid2;
	
	String isCombinedB;
	
	String soption;
	
	String accessaddress;
	String accessid;
	String clientuserid;
	
	int cursid = -1;
	int statusCode = 200;
	
	public  ServiceAction getSa() {
		return sa;
	}
	public  void setSa(ServiceAction sa) {
		this.sa = sa;
	}
	public String getSoption() {
		return soption;
	}
	public void setSoption(String soption) {
		this.soption = soption;
	}
	public int getCursid() {
		return cursid;
	}
	public void setCursid(int cursid) {
		this.cursid = cursid;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getVrs() {
		return vrs;
	}
	public void setVrs(String vrs) {
		this.vrs = vrs;
	}
	public String getIsCombinedB() {
		return isCombinedB;
	}
	public void setIsCombinedB(String isCombinedB) {
		this.isCombinedB = isCombinedB;
	}
	public List<Variable> getVars() {
		return vars;
	}
	public void setVars(List<Variable> vars) {
		this.vars = vars;
	}
	public ConditionService getConditionsr() {
		return conditionsr;
	}
	public void setConditionsr(ConditionService conditionsr) {
		this.conditionsr = conditionsr;
	}
	public VariableService getVariablesr() {
		return variablesr;
	}
	public void setVariablesr(VariableService variablesr) {
		this.variablesr = variablesr;
	}
	public RunlogService getRunlogsr() {
		return runlogsr;
	}
	public void setRunlogsr(RunlogService runlogsr) {
		this.runlogsr = runlogsr;
	}
	public ServicerelationService getSrrelationsr() {
		return srrelationsr;
	}
	public void setSrrelationsr(ServicerelationService srrelationsr) {
		this.srrelationsr = srrelationsr;
	}
	public ServiceresultService getSrresultsr() {
		return srresultsr;
	}
	public void setSrresultsr(ServiceresultService srresultsr) {
		this.srresultsr = srresultsr;
	}
	public String getServiceid() {
		return serviceid;
	}
	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	public Parameter getPr() {
		return pr;
	}
	public void setPr(Parameter pr) {
		this.pr = pr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public SerService getServicesr() {
		return servicesr;
	}
	public void setServicesr(SerService servicesr) {
		this.servicesr = servicesr;
	}
	public String getSid1() {
		return sid1;
	}
	public void setSid1(String sid1) {
		this.sid1 = sid1;
	}
	public String getSid2() {
		return sid2;
	}
	public void setSid2(String sid2) {
		this.sid2 = sid2;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getEsp() {
		return esp;
	}
	public void setEsp(String esp) {
		this.esp = esp;
	}
	public String getEsp2() {
		return esp2;
	}
	public void setEsp2(String esp2) {
		this.esp2 = esp2;
	}
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public ParameterService getParametersr() {
		return parametersr;
	}
	public void setParametersr(ParameterService parametersr) {
		this.parametersr = parametersr;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	public List<Parameter> getPs() {
		return ps;
	}
	public void setPs(List<Parameter> ps) {
		this.ps = ps;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPts() {
		return pts;
	}
	public void setPts(String pts) {
		this.pts = pts;
	}
	public List<String> getSs() {
		return ss;
	}
	public void setSs(List<String> ss) {
		this.ss = ss;
	}
	public SerService getSrs() {
		return srs;
	}
	public void setSrs(SerService srs) {
		this.srs = srs;
	}
	public UserSpecSerService getUserSpecSr() {
		return userSpecSr;
	}
	public void setUserSpecSr(UserSpecSerService userSpecSr) {
		this.userSpecSr = userSpecSr;
	}
	public RoleSpecSerService getRoleSpecSr() {
		return roleSpecSr;
	}
	public void setRoleSpecSr(RoleSpecSerService roleSpecSr) {
		this.roleSpecSr = roleSpecSr;
	}
	public UserRoleService getUserrolesr() {
		return userrolesr;
	}
	public void setUserrolesr(UserRoleService userrolesr) {
		this.userrolesr = userrolesr;
	}
	public RolePermissionService getRolepermissionsr() {
		return rolepermissionsr;
	}
	public void setRolepermissionsr(RolePermissionService rolepermissionsr) {
		this.rolepermissionsr = rolepermissionsr;
	}
	public PermissionServiceService getPermissionservicesr() {
		return permissionservicesr;
	}
	public void setPermissionservicesr(PermissionServiceService permissionservicesr) {
		this.permissionservicesr = permissionservicesr;
	}
	
	public String getAccessaddress() {
		return accessaddress;
	}
	public void setAccessaddress(String accessaddress) {
		this.accessaddress = accessaddress;
	}
	
	public String getAccessid() {
		return accessid;
	}
	public void setAccessid(String accessid) {
		this.accessid = accessid;
	}
	public String getClientuserid() {
		return clientuserid;
	}
	public void setClientuserid(String clientuserid) {
		this.clientuserid = clientuserid;
	}
	
	public String addParameter()
	{
		try
		{
			Service service=new Service();
			service.setServiceId(Integer.parseInt(serviceid));
			pr.setService(service);
			this.parametersr.addParamater(pr);
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			return ERROR;
		}
	}
	
	public String inputParameter()
	{
		vars.clear();
		ps.clear();
		String ssid = option1;
		List<String> callSids = new ArrayList<String>();
		callSids = getCallServiceByFid(ssid);
		List<Parameter> tempParameter = new ArrayList<Parameter>();
		List<Variable> tempVariable = new ArrayList<Variable>();
		for(int i = 0; i < callSids.size(); i++){
			tempVariable = variablesr.getServiceVariable(Integer.parseInt(callSids.get(i)));
			if(!tempVariable.isEmpty()){
				tempVariable.removeAll(vars);
				vars.addAll(tempVariable);
			}
			tempParameter = parametersr.getServiceParameter(Integer.valueOf(callSids.get(i)));
			if(!tempParameter.isEmpty()){
				tempParameter.removeAll(ps);
				ps.addAll(tempParameter);
			}
		}
		sid = option1;
		url = servicesr.getUniqueService(sid).getServiceAddress();
		return SUCCESS;
	}
	
	/**
	 * 获取一个服务的调用服务列表
	 * @param fatherSid
	 * @return
	 */
	public List<String> getCallServiceByFid(String fatherSid){
		List<String> callSids = new ArrayList<String>();
		callSids.add(fatherSid);
		for(int i = 0 ; i < callSids.size(); i++){
			Service ser = new Service();
			ser = srs.getUniqueService(callSids.get(i));
			String callSers = ser.getCallService();
			if(callSers != null){
				String[] sers = callSers.split(",");
				for(int j = 0; j < sers.length; j++){
					if(sers[j].length() > 0 && callSids.contains(sers[j]) == false){
						callSids.add(sers[j]);
					}
				}
			}
		}
		return callSids;
	}
	
	/**
	 * 系统内部页面上运行服务
	 * @return
	 */
	public String runService()
	{
		int sidInt = Integer.parseInt(sid);
		int uidInt = Integer.parseInt(userid);
		return internalCallService(sidInt, uidInt);
	}
	
	/**
	 * 系统内部调用服务
	 * @param sidInt 服务编号
	 * @param uidInt 用户id
	 * @return 调用结果字符串
	 */
	public String internalCallService(int sidInt, int uidInt){
		Service s = servicesr.getUniqueService(sidInt+"");
		int isExternal = servicesr.getIsExternal(sidInt);
		
		Runlog rl = new Runlog();
		
		if(!havePermission(sidInt, uidInt)){
			log.info("Can't run service " + sidInt + " due to user " + uidInt + " has no permission!");
			Runlog temprl = new Runlog();
			temprl.setServiceid(sidInt);
			temprl.setUserid(uidInt);
			temprl.setRundesc("No permission");
			runlogsr.getRunlogDao().save(temprl);
			return ERROR;
		}
		if(exceedMaxload(sidInt) && isExternal == 1){   //针对外部服务的超负载调用
			log.info("Can't run service " + sidInt + " due to exceeding the maxload of the service!");
			Runlog temprl = new Runlog();
			temprl.setServiceid(sidInt);
			temprl.setUserid(uidInt);
			temprl.setRundesc("Exceed maxload");
			runlogsr.getRunlogDao().save(temprl);
			return ERROR;
		}
		try
		{
			String serviceType = servicesr.getServiceType(sidInt);
			System.out.println(serviceType);
			if(serviceType.equals("BUSINESS")){ //暂时不考虑流程
				log.info("Can't run bussiness!");
				return ERROR;
			}
			if(serviceType.equals("LOCAL")){ //暂时不考虑本地应用
				log.info("Can't run local service!");
				return ERROR;
			}
			if(serviceType != null && !serviceType.equalsIgnoreCase("BUSINESS")){
				//运行application和service
				log.info("User "+ uidInt + " begin to run service "+ sidInt + "!");
				rl.setServiceid(sidInt);
				rl.setUserid(uidInt);
				rl.setStarttime(getTime());
				rl.setRunstate("running");
				runlogsr.getRunlogDao().save(rl);
				s.setRunTimes(s.getRunTimes() + 1);
				servicesr.update(s);
				String combineType = servicesr.getCombineType(sidInt);
				if(combineType != null){
					if(combineType.equalsIgnoreCase("CombineA"))
					{
						List<Condition> cons = new ArrayList<Condition>();
						cons = conditionsr.getServiceCondition(sidInt);
						
						List<ServiceReliability> subSerReliabilities = new ArrayList<ServiceReliability>();
						for(int i = 0; i < cons.size(); i++)
						{
							Service sub = new Service();
							sub = cons.get(i).getServiceBySubServiceId();
							Double successRate = 0.0;
							if(sub.getRunTimes() != 0){
								successRate = (double) ((sub.getRunTimes() - sub.getFailTimes()) /sub.getRunTimes());
							}
							ServiceReliability serReliability = new ServiceReliability(sub.getServiceId(), sub.getServiceName(), sub.getServiceAddress(), successRate);
							subSerReliabilities.add(serReliability);
						}
						//按照服务可靠性降序排序
						ListSortUtil<ServiceReliability> sortList = new ListSortUtil<ServiceReliability>();  
				        sortList.sort(subSerReliabilities, "successRate", "desc");
				        for(int j = 0; j < subSerReliabilities.size(); j++){
				        	cursid = subSerReliabilities.get(j).getServiceId();
							System.out.println(cursid + "!!!!!!!!!!!");
							String callres = internalCallService(cursid, uidInt);
							if(callres.equalsIgnoreCase("success")) break;
				        }
					}
					else if(combineType.equalsIgnoreCase("CombineB"))
					{
						List<Condition> cons = new ArrayList<Condition>();
						cons = conditionsr.getServiceCondition(sidInt);
						vars = variablesr.getServiceVariable(sidInt);
						
						List<String> constring = new ArrayList<String>();
						List<String> varstring = new ArrayList<String>();
						List<String> valuestring = new ArrayList<String>();
						for(int i = 0; i < cons.size(); i++)
						{
							constring.add(cons.get(i).getCondtionExpression());
						}
						String[] v = vrs.split(",");
						for(int i = 0; i < vars.size(); i++)
						{
							varstring.add(vars.get(i).getVariableName());
							for(int j = 0; j < v.length; j++)
							{
								String var_sid = v[j].substring(0, v[j].indexOf("_"));
								String var_name = v[j].substring(v[j].indexOf("_") + 1, v[j].indexOf("="));
								if(Integer.parseInt(var_sid) == sidInt && var_name.equals(vars.get(i).getVariableName())){  //是该调用服务的控制变量
									String var_value = v[j].substring(v[j].indexOf("=") + 1);
									valuestring.add(var_value);
									break;
								}
							}
						}
						
						int subsid = ExpressionCalculater.getRightExpression(constring, varstring, valuestring);
						cursid = cons.get(subsid).getServiceBySubServiceId().getServiceId();
						System.out.println(cursid + "!!!!!!!!!!!");
						internalCallService(cursid, uidInt);
					}
				}
				else{        //调用普通服务（不是组合服务）
					url = getCallURL(sidInt);
					cursid = sidInt;
				}
				saverunlog(rl, sidInt);
				return SUCCESS;
			}
			else{   //暂时不执行流程
				return ERROR;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			s.setFailTimes(s.getFailTimes() + 1);
			servicesr.update(s);
			saverunlog(rl, e);
			return ERROR;
		}
	}
	
	/**
	 * 系统内部获取调用服务的URL
	 * @param sidInt
	 * @return
	 */
	public String getCallURL(int sidInt){
		String serviceURL = servicesr.getUniqueService(String.valueOf(sidInt)).getServiceAddress();
		if(serviceURL.length() != 0 && serviceURL.lastIndexOf("/") == serviceURL.length() - 1){
			serviceURL = serviceURL.substring(0, serviceURL.length() - 1);
		}
		List<Parameter> vv = parametersr.getServiceParameter(sidInt);
		String ptvalue = ""; 
		if(vv.size() > 0){
			 ptvalue = "?"; 
		}
		String[] values = pts.split(",");
		for(int i = 0; i < values.length; i++){
			if(values[i].length() > 0){
				String para_sid = values[i].substring(0, values[i].indexOf("_"));
				if(Integer.parseInt(para_sid) == sidInt){  //是该调用服务的参数
					if(values[i].charAt(values[i].length() - 1) == ';'){  //该参数没被赋值
						ptvalue += "";
					}
					else{
						ptvalue += values[i].substring(values[i].indexOf("_") + 1);  //name=value的格式字符串
					}
					ptvalue += "&";
				}
			}
		}
		if(ptvalue != "" && ptvalue.charAt(ptvalue.length() - 1) == '&'){
			ptvalue = ptvalue.substring(0, ptvalue.length() - 1);
		}
		String query = srs.getUniqueService(String.valueOf(sidInt)).getServiceQuery();
		if(query != null && query != ""){
			serviceURL = serviceURL + "/" + query;
		}
		serviceURL = serviceURL + ptvalue;
		System.out.println("serviceURL:"+serviceURL);
		return serviceURL;
	}
	
	/**
	 * 保存运行服务成功的日志信息与连接URL
	 * @param rl  当前对应的调用日志记录
	 * @param cursid 实际调用的服务编号
	 */
	public int saverunlog(Runlog rl, int callsid){
		if(callsid == cursid){
			statusCode = connecturl(url, callsid);
			System.out.println("url:"+url+" statusCode:"+statusCode);
		}
		int responsecode = statusCode;
		rl.setFinishtime(getTime());
		if(responsecode == 200){
			rl.setRunstate("success");
			log.info("User "+ rl.getUserid() + " run service "+ rl.getServiceid() + " success!");
		}else{
			rl.setRunstate("failed");
			log.info("User "+ rl.getUserid() + " run service "+ rl.getServiceid() + " failed!");
			if(responsecode == -1){
				rl.setRundesc("Exception occurred while connecting");
			}
			else if(responsecode == -2){
				rl.setRundesc("Can't find the service or service error occurred");
			}
			else{
				rl.setRundesc("http " + responsecode);
			}
			Service ser = servicesr.getUniqueService(String.valueOf(rl.getServiceid()));
			ser.setFailTimes(ser.getFailTimes() + 1);
			servicesr.update(ser);
		}
		runlogsr.update(rl);
		return responsecode;
	}
	
	/**
	 * 保存运行服务失败的日志信息
	 * @param rl
	 * @param e
	 */
	public void saverunlog(Runlog rl, Exception e){
		log.error("User "+ rl.getUserid() + " run service "+ rl.getServiceid() + " failed!");
		rl.setFinishtime(getTime());
		rl.setRunstate("failed");
		rl.setRundesc(e.toString());
		runlogsr.update(rl);
	}
	
	/**
	 * 将日期转换成日期字符串的形式
	 * @return
	 */
	public String getTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(new Date());//格式化数据
		return date;
	}
	
	/**
	 * 判断服务是否超过最大负载运行
	 * @param serviceId
	 * @return
	 */
	public boolean exceedMaxload(int serviceId){
		List list1 = runlogsr.findByServiceid(serviceId);
		List list2 = runlogsr.findByRunstate("running");
		list1.retainAll(list2);    //交集
		int runningnum = list1.size();
		int maxload = Integer.valueOf(default_maxload);
		if(servicesr.getUniqueService(serviceId+"").getMaxLoad() != null){
			maxload = servicesr.getUniqueService(serviceId+"").getMaxLoad();
		}
		if(runningnum < maxload){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断用户是否有权限运行该服务
	 * @param serviceId
	 * @param userid
	 * @return
	 */
	public boolean havePermission(int serviceId, int userid){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("admin").equals("true")){//管理员拥有所有的服务
			List<Service> servicelist = srs.getAllService();
			return true;
		}else{
			List<Service> servicelist = sa.getMyService(userid);
			for(int i = 0; i < servicelist.size(); i++){
				if(servicelist.get(i).getServiceId() == serviceId){
					return true;
				}
			}
			return false;
		}
	}
	
	
	public String accessService(){
		System.out.print(accessaddress+"!!!!"+accessid+"!!!"+clientuserid+"\n");
		int sidInt = Integer.parseInt(accessid);
		int uidInt = Integer.parseInt(clientuserid);
		List<Service> servicelist = new ArrayList<Service>();
		servicelist = srs.getAllService();
		for(int  i = 0; i < servicelist.size(); i++){
			Service ser = new Service();
			ser = servicelist.get(i);
			if(ser.getServiceId() != null && ser.getServiceId() == sidInt){
				return externalCallService(sidInt,  uidInt, accessaddress);
			}
		}
		return ERROR;
	}
	
	/**
	 * 外部客户端调用服务
	 * @param sidInt
	 * @param uidInt
	 * @return 服务调用结果
	 */
	public String externalCallService(int sidInt, int uidInt, String serAddress){
		Service ser = new Service();
		ser = srs.getUniqueService(String.valueOf(sidInt));
		int isExternal = srs.getIsExternal(sidInt);
		if(exceedMaxload(sidInt)  && isExternal == 1){
			log.info("Can't run service " + sidInt + " due to exceeding the maxload of the service!");
			Runlog temprl = new Runlog();
			temprl.setServiceid(sidInt);
			temprl.setUserid(uidInt);
			temprl.setRundesc("Exceed maxload");
			runlogsr.getRunlogDao().save(temprl);
			return ERROR;
		}
		Runlog rl = new Runlog();
		rl.setServiceid(sidInt);
		rl.setUserid(uidInt);
		log.info("User "+ uidInt + " begin to run service "+ sidInt + "!");
		rl.setStarttime(getTime());
		rl.setRunstate("running");
		runlogsr.getRunlogDao().save(rl);
		ser.setRunTimes(ser.getRunTimes() + 1);
		System.out.print(ser.getRunTimes()+"!!!!\n");
				
		String paraString = "";
		if(serAddress.indexOf("?") > -1){
			paraString = serAddress.substring(serAddress.indexOf("?")+1, serAddress.length());
		}
		String[] params = paraString.split("&");
		Map<String, String> paramMap = new HashMap<String, String>();
		for(int j = 0; j < params.length; j++){
			if(params[j].length() > 0){
				paramMap.put(params[j].substring(0, params[j].indexOf("=")), params[j].substring(params[j].indexOf("=")+1, params[j].length()));
			}
		}
		System.out.print(paramMap.toString());
		
		try
		{
			String serviceType = servicesr.getServiceType(sidInt);
			System.out.println(serviceType);
			if(serviceType.equals("BUSINESS")){ //暂时不考虑流程
				log.info("Can't run bussiness!");
				return ERROR;
			}
			if(serviceType.equals("LOCAL")){ //暂时不考虑本地应用
				log.info("Can't run local service!");
				return ERROR;
			}
			if(serviceType != null && !serviceType.equalsIgnoreCase("BUSINESS")){
				String combineType = servicesr.getCombineType(sidInt);
				if(combineType != null){
					if(combineType.equalsIgnoreCase("CombineA"))
					{
						List<Condition> cons = new ArrayList<Condition>();
						cons = conditionsr.getServiceCondition(sidInt);
								
						List<ServiceReliability> subSerReliabilities = new ArrayList<ServiceReliability>();
						for(int j = 0; j < cons.size(); j++)
						{
							Service sub = new Service();
							sub = cons.get(j).getServiceBySubServiceId();
							Double successRate = 0.0;
							if(sub.getRunTimes() != 0){
								successRate = (double) ((sub.getRunTimes() - sub.getFailTimes()) /sub.getRunTimes());
							}
							ServiceReliability serReliability = new ServiceReliability(sub.getServiceId(), sub.getServiceName(), sub.getServiceAddress(), successRate);
							subSerReliabilities.add(serReliability);
						}
						//按照服务可靠性降序排序
						ListSortUtil<ServiceReliability> sortList = new ListSortUtil<ServiceReliability>();  
						sortList.sort(subSerReliabilities, "successRate", "desc");
						for(int j = 0; j < subSerReliabilities.size(); j++){
							cursid = subSerReliabilities.get(j).getServiceId();
							System.out.println(cursid + "!!!!!!!!!!!");
							String callres = externalCallService(cursid, uidInt, serAddress);
							if(callres.equalsIgnoreCase("success")) break;
						}
					}
					else if(combineType.equalsIgnoreCase("CombineB"))
					{
						List<Condition> cons = new ArrayList<Condition>();
						List<Variable> vs = new ArrayList<Variable>();
						cons = conditionsr.getServiceCondition(sidInt);
						vs = variablesr.getServiceVariable(sidInt);
								
						List<String> constring = new ArrayList<String>();
						List<String> varstring = new ArrayList<String>();
						List<String> valuestring = new ArrayList<String>();
						for(int j = 0; j < cons.size(); j++)
						{
							constring.add(cons.get(j).getCondtionExpression());
						}
						for(int j = 0; j < vs.size(); j++)
						{
							varstring.add(vs.get(j).getVariableName());
							if(paramMap.get(sidInt+"_"+vs.get(j).getVariableName()) != null){
								valuestring.add(paramMap.get(sidInt+"_"+vs.get(j).getVariableName()));
							}
									
						}
						System.out.print(constring+";"+varstring+";"+valuestring+";"+"\n");
						int subsid = ExpressionCalculater.getRightExpression(constring, varstring, valuestring);
								
						cursid = cons.get(subsid).getServiceBySubServiceId().getServiceId();
						System.out.println(cursid + "!!!!!!!!!!!");
						externalCallService(cursid, uidInt, serAddress);
					}
				}
				else{        //调用普通服务（不是组合服务）
					url = getExternalcallURL(sidInt, paramMap);
					cursid = sidInt;
				}
				saverunlog(rl, sidInt);
			}
			else{   //暂时不执行流程
				return ERROR;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Service s = servicesr.getUniqueService(sidInt+"");
			s.setFailTimes(s.getFailTimes() + 1);
			servicesr.update(s);
			saverunlog(rl, e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 外部获取调用服务的URL
	 * @param sidInt
	 * @param paramMap 参数对
	 * @return
	 */
	public String getExternalcallURL(int sidInt, Map<String, String> paramMap){
		String serviceURL = servicesr.getUniqueService(String.valueOf(sidInt)).getServiceAddress();
		if(serviceURL.length() != 0 && serviceURL.lastIndexOf("/") == serviceURL.length() - 1){
			serviceURL = serviceURL.substring(0, serviceURL.length() - 1);
		}
		String query = srs.getUniqueService(String.valueOf(sidInt)).getServiceQuery();
		if(query != null && query != ""){
			serviceURL = serviceURL + "/" + query;
		}
		ps = parametersr.getServiceParameter(sidInt);
		String ptvalue = ""; 
		if(ps.size() > 0){
			 ptvalue = "?"; 
		}
		for(int j = 0; j < ps.size(); j++)
		{
			if(paramMap.get(sidInt+"_"+ps.get(j).getParametername()) != null){
				ptvalue += ps.get(j).getParametername() + "=" + paramMap.get(sidInt+"_"+ps.get(j).getParametername());
				ptvalue += "&";
			}		
		}
		if(ptvalue != "" && ptvalue.charAt(ptvalue.length() - 1) == '&'){
			ptvalue = ptvalue.substring(0, ptvalue.length() - 1);
		}
		serviceURL += ptvalue;
		System.out.println("serviceURL:"+serviceURL);
		return serviceURL;
	}
	
	/**
	 * 程序中访问服务url    
	 * @param urlStr  服务地址
	 * @param callsid 调用的服务编号
	 * @return
	 */
   public int connecturl(String urlStr, int callsid){  
	   try{
		   int isExternal = srs.getIsExternal(callsid);
		   if(isExternal == 0){
			   if(loadInternalService(callsid) == false){
				   return -2;      //部署内部服务的服务器出现错误
			   }
		   }
	       URL callURL = new URL(urlStr);
           HttpURLConnection urlcon = (HttpURLConnection)callURL.openConnection();
           urlcon.connect();         //获取连接
           InputStream is = urlcon.getInputStream();
           System.out.print(urlcon.getResponseCode()+"!!!!\n");
           return urlcon.getResponseCode();
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   return -1;     //连接服务地址出现错误
	   }
   }

   /**
    * 对企业内部服务的负载调用
    * @param serviceId
    */
   public boolean loadInternalService(int serviceId){
	   String servicename = servicesr.getUniqueService(serviceId+"").getServiceName();
	   List list1 = runlogsr.findByServiceid(serviceId);
	   List list2 = runlogsr.findByRunstate("running");
	   list1.retainAll(list2);    //交集
	   int runningnum = list1.size();
	   int maxload = Integer.valueOf(default_maxload);
	   if(servicesr.getUniqueService(serviceId+"").getMaxLoad() != null){
		   maxload = servicesr.getUniqueService(serviceId+"").getMaxLoad();
	   }
	   GetRemoteService grs = new GetRemoteService();
	   String getInternalServiceURL = "http://172.18.216.86:8080/v2-beta/projects/1a5/services";
	   String servicesresult = grs.sendToRancher(getInternalServiceURL, null, "GET", false);
	   System.out.println("servicesresult:"+servicesresult+"\n");
	   ParseJSONUtil pju = new ParseJSONUtil();
	   String scaleStr = pju.getServiceScale(servicesresult, servicename);
	   int currentScale = 1, scale = 1;
	   String service_id = null, state = null;
	   if(scaleStr != null){
		   JSONObject scaleObj = JSONObject.fromObject(scaleStr);
		   currentScale = scaleObj.getInt("currentScale");
		   scale = scaleObj.getInt("scale");
		   service_id = scaleObj.getString("serviceid");
		   state = scaleObj.getString("state");
	   }
	   else{
		   log.info("服务" + serviceId + "不存在！");
		   return false;
	   }
	   int canload = maxload * currentScale;
	   int old_scale = scale;
	   if(runningnum > canload * 2 / 3){
		   if(runningnum > canload){
			   scale = scale + (runningnum - canload) / maxload + 1;
		   }
		   else scale = scale + 1;
	   }
	   else if(runningnum < canload / 3){
		   if(scale > currentScale)
		   {
			   scale = scale - (scale - currentScale);
		   }
		   if(scale > (canload - runningnum) / maxload){
			   scale = scale - (canload - runningnum) / maxload;
		   }
	   }
	   System.out.println("scale:"+scale+"\n");
	   String editServiceURL = getInternalServiceURL + "/" + service_id;
	   if(state.equals("inactive")){  //重启服务
		   String activateURL = editServiceURL + "/?action=activate";
		   String activateResult = grs.sendToRancher(activateURL, null, "POST", false);
		   if(activateResult != null){
			   log.info("服务" + serviceId + "重启成功！");
		   }
		   else{
				log.info("服务" + serviceId + "重启失败，不能提供该服务！");
				return false;
			}
	   }
	   while(pullServiceState(editServiceURL).equalsIgnoreCase("active") == false){  //轮询服务是否重启完成
		   try {
			   Thread.sleep(3000);
		   } catch (InterruptedException e) {
			   e.printStackTrace();
		   }
	   }
	   if(old_scale != scale || (old_scale == scale && scale != currentScale)){  //需要改动实例数量,put请求
			JSONObject paramObj = new JSONObject();
			paramObj.put("scale", scale);
			String editResult = grs.sendToRancher(editServiceURL, paramObj, "PUT", false);
			if(editResult != null){
				log.info("修改服务" + serviceId + "的实例数量成功！");
			}
			else{
				log.info("修改服务" + serviceId + "的实例数量失败，不能提供该服务！");
				return false;
			}
	   }
	   return true;
   }
   
   
   /**
    * 轮询指定内部服务的state
    * @param serviceAPI 查询该服务的api
    * @return
    */
   public String pullServiceState(String serviceAPI){
	   String state = null;
	   GetRemoteService grs = new GetRemoteService();
	   String servicesresult = grs.sendToRancher(serviceAPI, null, "GET", false);
	   JSONObject obj = JSONObject.fromObject(servicesresult);
	   if(obj.containsKey("state")){
		   state = obj.getString("state");
	   }
	   return state;
   }
}