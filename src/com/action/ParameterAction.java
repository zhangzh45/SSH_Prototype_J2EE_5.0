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
import com.service.ServiceresultService;
import com.service.TempService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.UserSpecSerService;
import com.service.VariableService;
import com.util.CombineService;
import com.util.EnglishChineseUtil;
import com.util.IpUtil;
import com.util.MobileUtil;
import com.util.MoneyUtil;
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
		String ssid = option1;
		//System.out.println(soption + "!!!!!!!!!!!!");
		//option1="2";
		String combinetype = servicesr.getUniqueService(option1).getCombineType();
		if(combinetype != null && combinetype.equals("CombineB"))
		{
			vars = variablesr.getServiceVariable(Integer.parseInt(option1));
			isCombinedB = "yes";
			List<Condition> cons = new ArrayList<Condition>();
			cons = conditionsr.getServiceCondition(Integer.parseInt(option1));
			if(cons.size() != 0)
			{
				ssid = cons.get(0).getServiceBySubServiceId().getServiceId().toString();
			}
		}
		//List<Condition> cons = new ArrayList<Condition>();
		//cons = conditionsr.getServiceCondition(Integer.parseInt(option1));
		System.out.println(option1);
		
		
		List<String> varValue = new ArrayList<String>();
		varValue.add(var1);
		List<String> esps = new ArrayList<String>();
		esps.add(esp);
		esps.add(esp2);
		List<String> varNames = new ArrayList<String>();
		varNames.add(varName);
		List<String> sids = new ArrayList<String>();
		sids.add(sid1);
		sids.add(sid2);
		
		//System.out.println(ps.size());
		if(false == var1.equals("NULL"))
		{
			int index = ExpressionCalculater.getRightExpression(esps, varNames, varValue);
			
			ps = parametersr.getServiceParameter(Integer.valueOf(sids.get(index)));
			System.out.println(index);
			System.out.println(sids.get(0)+" "+sids.get(1));
			sid = sids.get(index);
			option1 = sids.get(index);
			System.out.println(sid+" "+option1);
			url = servicesr.getUniqueService(sid).getServiceAddress();
		}
		else
		{
			ps = parametersr.getServiceParameter(Integer.valueOf(ssid));
		}
		return SUCCESS;
	}
	
	public String runService()
	{
		//setLogfilePath();
		int sidInt = Integer.parseInt(sid);
		int uidInt = Integer.parseInt(userid);
		int pnumber; //   服务参数的个数
		Runlog rl = new Runlog();
		Runlog subrl = new Runlog();
		if(!havePermission(sidInt, uidInt)){
			log.info("Can't run service " + sid + " due to user " + uidInt + " has no permission!");
			Runlog temprl = new Runlog();
			temprl.setServiceid(sidInt);
			temprl.setUserid(uidInt);
			temprl.setRundesc("No permission");
			runlogsr.getRunlogDao().save(temprl);
			return ERROR;
		}
		if(exceedMaxload(sidInt)){
			log.info("Can't run service " + sid + " due to exceeding the maxload of the service!");
			Runlog temprl = new Runlog();
			temprl.setServiceid(sidInt);
			temprl.setUserid(uidInt);
			temprl.setRundesc("Exceed maxload");
			runlogsr.getRunlogDao().save(temprl);
			return ERROR;
		}
		try
		{
			//sidInt = Integer.parseInt(sid);
			//uidInt = Integer.parseInt(userid);
			String serviceType = servicesr.getServiceType(sidInt);
			
			if(serviceType.equals("BUSINESS")){ //暂时不考虑流程
				log.info("Can't run bussiness!");
				return ERROR;
			}
			if(serviceType.equals("LOCAL")){ //暂时不考虑本地应用
				log.info("Can't run local service!");
				return ERROR;
			}
			
			url = servicesr.getUniqueService(sid).getServiceAddress();
			if(url.length() != 0 && url.lastIndexOf("/") == url.length() - 1){
				url = url.substring(0, url.length() - 1);
			}
			
			System.out.println(serviceType);
			System.out.println(url);
			
			if(serviceType != null && !serviceType.equalsIgnoreCase("BUSINESS")){
				//运行application和service
				Service s = servicesr.getUniqueService(sid);
				log.info("User "+ uidInt + " begin to run service "+ sidInt + "!");
				rl.setServiceid(sidInt);
				rl.setUserid(Integer.parseInt(userid));
				rl.setStarttime(getTime());
				rl.setRunstate("running");
				runlogsr.getRunlogDao().save(rl);
				if(s.getRunTimes() == null){
					s.setRunTimes(0);
				}
				s.setRunTimes(s.getRunTimes() + 1);
				servicesr.update(s);
				
				String combineType = servicesr.getCombineType(sidInt);
				if(combineType != null){
					if(combineType.equalsIgnoreCase("CombineA"))
					{
						ss.clear();
						ss.add(CombineService.main("hello"));
						System.out.print(ss);
					}
					else if(combineType.equalsIgnoreCase("CombineB"))
					{
						List<Condition> cons = new ArrayList<Condition>();
						cons = conditionsr.getServiceCondition(sidInt);
						vars = variablesr.getServiceVariable(Integer.parseInt(option1));
						
						List<String> constring = new ArrayList<String>();
						List<String> varstring = new ArrayList<String>();
						List<String> valuestring = new ArrayList<String>();
						for(int i = 0; i < cons.size(); i++)
						{
							constring.add(cons.get(i).getCondtionExpression());
						}
						for(int i = 0; i < vars.size(); i++)
						{
							varstring.add(vars.get(i).getVariableName());
						}
						String[] v = vrs.split(",");
						for(int i = 0; i < v.length; i++)
						{
							valuestring.add(v[i]);
						}
						int subsid = ExpressionCalculater.getRightExpression(constring, varstring, valuestring);
						//System.out.println(subsid + "!!!!!!!!!!!");
						
						cursid = cons.get(subsid).getServiceBySubServiceId().getServiceId();
						System.out.println(cursid + "!!!!!!!!!!!");
						log.info("User "+ uidInt + " begin to run service "+ cursid + "!");
						subrl.setServiceid(cursid);
						subrl.setUserid(Integer.parseInt(userid));
						subrl.setStarttime(getTime());
						subrl.setRunstate("running");
						runlogsr.getRunlogDao().save(subrl);//.attachDirty(subrl);
						url = servicesr.getUniqueService(String.valueOf(cursid)).getServiceAddress();
						if(url.lastIndexOf("/") == url.length() - 1){
							url = url.substring(0, url.length() - 1);
						}
						System.out.println(url + "!!!!!!!!!!!");
						String stype = servicesr.getUniqueService(String.valueOf(cursid)).getServiceType();
						
						List<Parameter> vv = parametersr.getServiceParameter(cursid);
						String ptvalue = ""; 
						if(vv.size() > 0){
								ptvalue = "?"; 
						}
						String[] values = pts.split(",");
						for(int i = 0; i < vv.size(); i++)
						{
							ptvalue += vv.get(i).getParametername();
							ptvalue += "=";
							if(values[i].equals(";") == false)
							{
								ptvalue += values[i];
							}
							else
							{
								ptvalue += "";
							}
							if(i != values.length - 1)
							{
								ptvalue += "&";
							}
						}
						String query = srs.getUniqueService(String.valueOf(cursid)).getServiceQuery();
						if(query != null){
							url = url + "/" + query;
						}
						url = url + ptvalue;
							
					}
					saverunlog(rl);
					saverunlog(subrl);
					return SUCCESS;
				}
				else{
					ss.clear();
					List<Parameter> vv = parametersr.getServiceParameter(sidInt);
					String ptvalue = ""; 
					if(vv.size() > 0){
						 ptvalue = "?"; 
					}
					String[] values = pts.split(",");
					for(int i = 0; i < vv.size(); i++)
					{
						ptvalue += vv.get(i).getParametername();
						ptvalue += "=";
						if(values[i].equals(";") == false)
						{
							ptvalue += values[i];
						}
						else
						{
							ptvalue += "";
						}
						if(i != values.length - 1)
						{
							ptvalue += "&";
						}
					}
					String query = srs.getUniqueService(String.valueOf(sidInt)).getServiceQuery();
					if(query != null){
						url = url + "/" + query;
					}
					url = url + ptvalue;
					
					//暂时保留特殊服务的
					if(Integer.valueOf(sid) == 23)
					{
						ss = EnglishChineseUtil.main(pts);
						System.out.println(ss.size());
						saverunlog(rl);
						return SUCCESS;	
					}
					else if(Integer.valueOf(sid) == 26)
					{
						ss.clear();
						ss.add(CombineService.main(pts));
						saverunlog(rl);
						return SUCCESS;	
					}
					else if(Integer.valueOf(sid) == 27)
					{
						ss.clear();
						ss.add(CombineService.main(pts));
						saverunlog(rl);
						return SUCCESS;	
					}
					else if(Integer.valueOf(sid) == 28)
					{
						ss.clear();
						ss.add("on,No!");
						saverunlog(rl);
						return SUCCESS;
					}
					saverunlog(rl);
					return SUCCESS;
				}
			}
			else{   //暂时不执行流程
				return ERROR;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			Service s = servicesr.getUniqueService(sid);
			if(s.getFailTimes() == null){
				s.setFailTimes(0);
			}
			s.setFailTimes(s.getFailTimes() + 1);
			servicesr.update(s);//.getSrDAO().attachDirty(s);
			
			saverunlog(rl, e);
			if(subrl.getServiceid() != null){
				saverunlog(subrl, e);
			}
			return ERROR;
		}
	}
	
	/**
	 * 保存运行服务成功的日志信息与连接URL
	 * @param rl
	 */
	public void saverunlog(Runlog rl){
		int responsecode = connecturl(url);
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
			else{
				rl.setRundesc("http" + responsecode);
			}
			Service ser = servicesr.getUniqueService(String.valueOf(rl.getServiceid()));
			ser.setFailTimes(ser.getFailTimes() + 1);
			servicesr.update(ser);
		}
		runlogsr.update(rl);
	}
	
	/**
	 * 保存运行服务失败的日志信息
	 * @param rl
	 * @param e
	 */
	public void saverunlog(Runlog rl, Exception e){
		log.error("User "+ rl.getUserid() + " run service "+ rl.getServiceid() + " failed!");
		//rl.setFinishtime(new Date());
		rl.setFinishtime(getTime());
		rl.setRunstate("failed");
		rl.setRundesc(e.toString());
		//rl.setRundesc(e.getStackTrace().toString());
		runlogsr.update(rl);//.getRunlogDao().attachDirty(rl);
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
			List<Service> servicelist = sa.getMyService(userid);//getMyService(userid);
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
		List<Service> servicelist = new ArrayList<Service>();
		servicelist = srs.getAllService();
		for(int  i = 0; i < servicelist.size(); i++){
			Service ser = new Service();
			ser = servicelist.get(i);
			Service subser = new Service();
			if(ser.getServiceId() != null && ser.getServiceId() == Integer.parseInt(accessid)){
				
				if(exceedMaxload(ser.getServiceId())){
					log.info("Can't run service " + ser.getServiceId() + " due to exceeding the maxload of the service!");
					Runlog temprl = new Runlog();
					temprl.setServiceid(ser.getServiceId());
					temprl.setUserid(Integer.parseInt(clientuserid));
					temprl.setRundesc("Exceed maxload");
					runlogsr.getRunlogDao().save(temprl);
					return ERROR;
				}
				
				System.out.print(ser.getRunTimes()+"!!!!\n");
				Runlog rl = new Runlog();
				rl.setServiceid(ser.getServiceId());
				rl.setUserid(Integer.parseInt(clientuserid));
				log.info("User "+ clientuserid + " begin to run service "+ ser.getServiceId() + "!");
				rl.setStarttime(getTime());
				rl.setRunstate("running");
				runlogsr.getRunlogDao().save(rl);
				ser.setRunTimes(ser.getRunTimes() + 1);
				System.out.print(ser.getRunTimes()+"!!!!\n");
				
				int subserviceid = 0;
				Runlog subrl = new Runlog();
				if(ser.getCombineType() != null && ser.getCombineType().equalsIgnoreCase("CombineB")){
					accessaddress = accessaddress.substring(accessaddress.indexOf("?")+1);
					String[] params = accessaddress.split("&");
					Map<String, String> paramMap = new HashMap<String, String>();
					for(int j = 0; j < params.length; j++){
						paramMap.put(params[j].substring(0, params[j].indexOf("=")), params[j].substring(params[j].indexOf("=")+1, params[j].length()));
					}
					System.out.print(paramMap.toString());
					
					int sidInt = ser.getServiceId();
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
						if(paramMap.get(vs.get(j).getVariableName()) != null){
							valuestring.add(paramMap.get(vs.get(j).getVariableName()));
						}
						
					}
					System.out.print(constring+";"+varstring+";"+valuestring+";"+"\n");
					int subsid = ExpressionCalculater.getRightExpression(constring, varstring, valuestring);
					//System.out.println(subsid + "!!!!!!!!!!!");
					
					subserviceid = cons.get(subsid).getServiceBySubServiceId().getServiceId();
					System.out.println(subserviceid + "!!!!!!!!!!!");
					subser = srs.getUniqueService(String.valueOf(subserviceid));
					subser.setRunTimes(subser.getRunTimes() + 1);
					log.info("User "+ clientuserid + " begin to run service "+ subserviceid + "!");
					
					subrl.setServiceid(subserviceid);
					subrl.setUserid(Integer.parseInt(clientuserid));
					subrl.setStarttime(getTime());
					subrl.setRunstate("running");
					runlogsr.getRunlogDao().save(subrl);//.attachDirty(subrl);
					accessaddress = servicesr.getUniqueService(String.valueOf(subserviceid)).getServiceAddress();
					if(accessaddress.lastIndexOf("/") == accessaddress.length() - 1){
						accessaddress = accessaddress.substring(0, accessaddress.length() - 1);
					}
					System.out.println(accessaddress + "!!!!!!!!!!!");
					String stype = servicesr.getUniqueService(String.valueOf(subserviceid)).getServiceType();
					
					List<Parameter> vv = parametersr.getServiceParameter(subserviceid);
					String ptvalue = ""; 
					if(vv.size() > 0){
							ptvalue = "?"; 
					}
					for(int j = 0; j < vv.size(); j++)
					{
						ptvalue += vv.get(j).getParametername();
						ptvalue += "=";
						if(paramMap.get(vv.get(j).getParametername()) != null){
							ptvalue += paramMap.get(vv.get(j).getParametername());
						}
						if(j != vv.size() - 1)
						{
							ptvalue += "&";
						}
					}
					String query = srs.getUniqueService(String.valueOf(subserviceid)).getServiceQuery();
					if(query != null){
						accessaddress = accessaddress + "/" + query;
					}
					accessaddress = accessaddress + ptvalue;
					System.out.println(accessaddress + "!!!!!!!!!!!");
				}
				//else{
				int responsecode = connecturl(accessaddress);
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
					else{
						rl.setRundesc("http" + responsecode);
					}
					ser.setFailTimes(ser.getFailTimes() + 1);
				}
				runlogsr.getRunlogDao().attachDirty(rl);
				servicesr.update(ser);
				
				if(subserviceid != 0){
					subrl.setFinishtime(getTime());
					if(responsecode == 200){
						subrl.setRunstate("success");
						log.info("User "+ subrl.getUserid() + " run service "+ subrl.getServiceid() + " success!");
					}else{
						subrl.setRunstate("failed");
						log.info("User "+ subrl.getUserid() + " run service "+ subrl.getServiceid() + " failed!");
						if(responsecode == -1){
							subrl.setRundesc("Exception occurred while connecting");
						}
						else{
							subrl.setRundesc("http" + responsecode);
						}
						subser.setFailTimes(ser.getFailTimes() + 1);
					}
					runlogsr.getRunlogDao().attachDirty(subrl);
					servicesr.update(subser);
				}
				break;
			}
		}
		return SUCCESS;
	}
	
	/**   
    * 程序中访问url  
	 * 
    */    
   public int connecturl(String urlStr){  
	   try{
	       URL url = new URL(urlStr);
           HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
           urlcon.connect();         //获取连接
           InputStream is = urlcon.getInputStream();
           System.out.print(urlcon.getResponseCode()+"!!!!\n");
           return urlcon.getResponseCode();
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   return -1;
	   }
   }
	
	
}