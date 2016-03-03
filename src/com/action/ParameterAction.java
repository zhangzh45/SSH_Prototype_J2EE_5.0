package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Condition;
import com.bean.Parameter;
import com.bean.Service;
import com.bean.Serviceresult;
import com.bean.Variable;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ConditionService;
import com.service.ParameterService;
import com.service.SerService;
import com.service.ServiceresultService;
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
	private ParameterService parametersr = new ParameterService();
	private SerService  servicesr = new SerService();
	private ServiceresultService srresultsr = new ServiceresultService();
	private ConditionService conditionsr = new ConditionService();
	private VariableService variablesr = new VariableService();
	
	Parameter pr = new Parameter();
	String serviceid;
	String option1 = "11";
	String option2;
	String number;
	String pts;
	String vrs;
	String sid;
	String url;
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
	
	int cursid = -1;
	
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
	
	
	public String addParameter()
	{
		try
		{
			Service service=new Service();
			service.setServiceId(Integer.parseInt(serviceid));
			pr.setService(service);
			this.parametersr.addParamater(pr);
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String inputParameter()
	{
		vars.clear();
		String ssid = option1;
		//System.out.println(soption + "!!!!!!!!!!!!");
		//option1="2";
		if(servicesr.getUniqueService(option1).getServiceType().equals("CombineB"))
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
		int sidInt;
		int pnumber; //   服务参数的个数
		try
		{
			sidInt = Integer.parseInt(sid);
			String serviceType = servicesr.getServiceType(sidInt);
			url = servicesr.getUniqueService(sid).getServiceAddress();
			Service s = servicesr.getUniqueService(sid);
			s.setRunTimes(s.getRunTimes() + 1);
			servicesr.getSrDAO().attachDirty(s);
			
			System.out.println(serviceType);
			System.out.println(url);
			if(serviceType.equals("CombineA"))
			{
				ss.clear();
				ss.add(CombineService.main("hello"));
				System.out.print(ss);
			}
			else if(serviceType.equals("CombineB"))
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
				//System.out.println(cursid + "!!!!!!!!!!!");
				
				url = servicesr.getUniqueService(String.valueOf(cursid)).getServiceAddress();
				System.out.println(url + "!!!!!!!!!!!");
				String stype = servicesr.getUniqueService(String.valueOf(cursid)).getServiceType();
				if(stype.equals("URL"))
				{
					
				}
				else if(stype.equals("muleHTTP"))
				{
					String vv = parametersr.getServiceParameter(cursid).get(0).getParametername();
					url = url + "?" + vv + "=" + pts;
				}
				return SUCCESS;
			}
			else if(serviceType.equals("URL"))
			{
				ss.clear();
				return SUCCESS;
			}
			else if(serviceType.equals("muleHTTP"))
			{
				String v = parametersr.getServiceParameter(sidInt).get(0).getParametername();
				url = url + "?" + v + "=" + pts;
			}
			else if(serviceType.equals("Web"))
			{
				List<Parameter> ps = new ArrayList<Parameter>();
				ps = parametersr.getServiceParameter(Integer.valueOf(sid));
				// getMobileCodeInfo?userID=&mobileCode=
				String ptvalue = "?"; 
				String[] values = pts.split(",");
				for(int i = 0; i < ps.size(); i++)
				{
					ptvalue += ps.get(i).getParametername();
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
				System.out.println(pts);
		
				System.out.println(ptvalue);
				
				List<String> sl = new ArrayList();
				
				List<Serviceresult> srrsr = new ArrayList<Serviceresult>();
				srrsr =	srresultsr.getServiceresult(Integer.valueOf(sid));
				for(int i = 0; i < srrsr.size(); i++)
				{
					sl.add(srrsr.get(i).getResultName());
				}
				Service soap = servicesr.getUniqueService(sid);
				String host = soap.getServiceHost();
				String method = soap.getServiceQuery();
				String url = soap.getServiceAddress();
				//ss = WebServiceUtil.main(host, url, method, pts, sl);
				ss = WebServiceUtil.main(host, url, method, ptvalue, sl);
				System.out.println(ss.size());
				return SUCCESS;	
			}
			//else if(Integer.valueOf(sid) == 22)
			//{
			//	ss = MobileUtil.main(pts);
			//	System.out.println(ss.size());
			//	return SUCCESS;	
			//}
			else if(Integer.valueOf(sid) == 23)
			{
				ss = EnglishChineseUtil.main(pts);
				System.out.println(ss.size());
				return SUCCESS;	
			}
			//else if(Integer.valueOf(sid) == 24)
			//{
			//	ss = ZipCodeUtil.main(pts);
			//	System.out.println(ss.size());
			//	return SUCCESS;	
			//}
			//else if(Integer.valueOf(sid) == 25)
			//{
			//	ss = IpUtil.main(pts);
			//	System.out.println(ss.size());
			//	return SUCCESS;	
			//}
			else if(Integer.valueOf(sid) == 26)
			{
				ss.clear();
				ss.add(CombineService.main(pts));
				return SUCCESS;	
			}
			else if(Integer.valueOf(sid) == 27)
			{
				ss.clear();
				ss.add(CombineService.main(pts));
				return SUCCESS;	
			}
			else if(Integer.valueOf(sid) == 28)
			{
				ss.clear();
				ss.add("on,No!");
				return SUCCESS;
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			Service s = servicesr.getUniqueService(sid);
			s.setFailTimes(s.getFailTimes() + 1);
			servicesr.getSrDAO().attachDirty(s);
			return ERROR;
		}
	}
}