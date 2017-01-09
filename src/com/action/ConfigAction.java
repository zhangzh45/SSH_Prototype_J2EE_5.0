package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bean.Licence;
import com.bean.Parameter;
import com.bean.Service;
import com.bean.Serviceresult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LicenceService;
import com.service.ParameterService;
import com.service.SerService;
import com.service.ServiceresultService;


public class ConfigAction extends ActionSupport
{
	private static final Logger log = LoggerFactory.getLogger(ConfigAction.class);
	
	private SerService srs;
	private LicenceService licencesr = new LicenceService();
	private ParameterService parametersr = new ParameterService();
	private ServiceresultService srresultsr = new ServiceresultService();
	
	String serviceid;
	List<Service> services = new ArrayList<Service>();
	List<Licence> licences = new ArrayList<Licence>();
	List<Parameter> paras = new ArrayList<Parameter>();
	List<Serviceresult> serviceresults = new ArrayList<Serviceresult>();
	
	String conftype;
	String confid;
	String removeConfigResult;
	String queryConfigResult;
	
	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	public LicenceService getLicencesr() {
		return licencesr;
	}

	public void setLicencesr(LicenceService licencesr) {
		this.licencesr = licencesr;
	}
	

	public ParameterService getParametersr() {
		return parametersr;
	}

	public void setParametersr(ParameterService parametersr) {
		this.parametersr = parametersr;
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Licence> getLicences() {
		return licences;
	}

	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}


	public List<Parameter> getParas() {
		return paras;
	}

	public void setParas(List<Parameter> paras) {
		this.paras = paras;
	}

	public List<Serviceresult> getServiceresults() {
		return serviceresults;
	}

	public void setServiceresults(List<Serviceresult> serviceresults) {
		this.serviceresults = serviceresults;
	}

	
	public String getConftype() {
		return conftype;
	}

	public void setConftype(String conftype) {
		this.conftype = conftype;
	}

	public String getConfid() {
		return confid;
	}

	public void setConfid(String confid) {
		this.confid = confid;
	}
	
	
	public String getRemoveConfigResult() {
		return removeConfigResult;
	}

	public void setRemoveConfigResult(String removeConfigResult) {
		this.removeConfigResult = removeConfigResult;
	}

	public String getQueryConfigResult() {
		return queryConfigResult;
	}

	public void setQueryConfigResult(String queryConfigResult) {
		this.queryConfigResult = queryConfigResult;
	}

	String lid;
	String ltype;
	String ltime;
	String lcode;
	String llocation;
	String pid;
	String pname;
	String ptype;
	String pdesc;
	String rid;
	String rname;
	String rtype;
	String rdesc;
	
	
	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getLlocation() {
		return llocation;
	}

	public void setLlocation(String llocation) {
		this.llocation = llocation;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getRdesc() {
		return rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	public String listLicense()
	{
		licences.clear();
		try
		{
			System.out.print(serviceid+"ddddddd");
			if(serviceid != null){
				licences = this.licencesr.getServiceLicence(Integer.parseInt(serviceid));
			}
			System.out.print(licences.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listParameter()
	{
		paras.clear();
		try
		{
			//System.out.print(serviceid);
			if(serviceid != null){
				paras = this.parametersr.getServiceParameter(Integer.parseInt(serviceid));
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listServiceresult()
	{
		serviceresults.clear();
		try
		{
			//System.out.print(serviceid);
			if(serviceid != null){
				serviceresults = this.srresultsr.getServiceresult(Integer.parseInt(serviceid));
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listconfig(){
		System.out.print("ddddd");
		services.clear();
		services = srs.getAllService();
		try{
			listLicense();
			listParameter();
			listServiceresult();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String editlicence(){
		try{
			
			if(checkpermission() == ERROR){
				return ERROR;
			}
			
			Licence l = new Licence();
			l = licencesr.getLicenceDao().findById(Integer.parseInt(lid));
			l.setLicenceCode(lcode);
			l.setLicenceLocation(llocation);
			l.setLicenceTime(ltime);
			l.setLicenceType(ltype);
			licencesr.getLicenceDao().attachDirty(l);
			
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			
			
			listconfig();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String editparameter(){
		try{
			if(checkpermission() == ERROR){
				return ERROR;
			}
			System.out.print("!!!!!!!!!!");
			Parameter p = new Parameter();
			p = parametersr.getParameterDao().findById(Integer.parseInt(pid));
			p.setParameterdesc(pdesc);
			p.setParametername(pname);
			p.setParametertype(ptype);
			parametersr.getParameterDao().attachDirty(p);
			
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			
			listconfig();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String editresult(){
		try{
			if(checkpermission() == ERROR){
				return ERROR;
			}
			
			Serviceresult r = new Serviceresult();
			r = srresultsr.getSrresultDao().findById(Integer.parseInt(rid));
			r.setResultDesc(rdesc);
			r.setResultName(rname);
			r.setResultType(rtype);
			srresultsr.getSrresultDao().attachDirty(r);
			
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			
			listconfig();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String removeConfig(){
		try{
			Map<String, Object> session = ActionContext.getContext().getSession();
			String userid = (String) session.get("user");
			
			List<Service> providedservices = new ArrayList<Service>();
			providedservices = srs.getSrDAO().findByServiceProvider(userid);
			if(providedservices.size() == 0){
				log.info("User "+ userid + " hadn't permission to remove the configuration of service " + serviceid + "!");
				removeConfigResult = "failed";
				return ERROR;
			}else {
				int i;
				for(i = 0; i < providedservices.size(); i++){
					if(providedservices.get(i).getServiceId() == Integer.parseInt(serviceid)){
						break;
					}
				}
				if(i == providedservices.size()){
					log.info("User "+ userid + " hadn't permission to remove the configuration of service " + serviceid + "!");
					removeConfigResult = "failed";
					return ERROR;
				}
			}
			
			
			if(conftype.equalsIgnoreCase("licence")){
				Licence lic = new Licence();
				lic = this.licencesr.getLicenceDao().findById(Integer.parseInt(confid));
				licencesr.deleteLocalConfig(lic);
			}
			else if(conftype.equalsIgnoreCase("parameter")){
				Parameter para = new Parameter();
				para = this.parametersr.getParameterDao().findById(Integer.parseInt(confid));
				parametersr.deleteParamater(para);
			}
			else if(conftype.equalsIgnoreCase("serviceresult")){
				Serviceresult sr = new Serviceresult();
				sr = this.srresultsr.getSrresultDao().findById(Integer.parseInt(confid));
				srresultsr.deleteServiceresult(sr);
			}

			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			removeConfigResult = "failed";
			return ERROR;
		}
		removeConfigResult = "success";
		return SUCCESS;
	}
	
	public String queryConfig(){
		JSONArray json = new JSONArray();
		Map<String ,String> mp=new HashMap<String,String>();
		try{
			
			if(conftype.equalsIgnoreCase("licence")){
				Licence lic = new Licence();
				lic = this.licencesr.getLicenceDao().findById(Integer.parseInt(confid));
				mp.put("licenceid", lic.getLicenceId().toString());
			    mp.put("licencetime", lic.getLicenceTime());
			    mp.put("licencetype", lic.getLicenceType());
			    mp.put("licencecode", lic.getLicenceCode());
			    mp.put("licencelocation", lic.getLicenceLocation());
			}
			else if(conftype.equalsIgnoreCase("parameter")){
				Parameter para = new Parameter();
				para = this.parametersr.getParameterDao().findById(Integer.parseInt(confid));
				mp.put("parameterid", para.getParameterid().toString());
			    mp.put("parametername", para.getParametername());
			    mp.put("parametertype", para.getParametertype());
			    mp.put("parameterdesc", para.getParameterdesc());
			}
			else if(conftype.equalsIgnoreCase("serviceresult")){
				Serviceresult sr = new Serviceresult();
				sr = this.srresultsr.getSrresultDao().findById(Integer.parseInt(confid));
				mp.put("srid", sr.getResultid().toString());
			    mp.put("srname",sr.getResultName());
			    mp.put("srtype", sr.getResultType());
			    mp.put("srdesc", sr.getResultDesc());
			}
			json.add(mp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			queryConfigResult = "failed";
			return ERROR;
		}
		queryConfigResult = json.toString();
		return SUCCESS;
	}
	
	
	public String checkpermission(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String userid = (String) session.get("user");
		
		List<Service> providedservices = new ArrayList<Service>();
		providedservices = srs.getSrDAO().findByServiceProvider(userid);
		if(providedservices.size() == 0){
			log.info("User "+ userid + " hadn't permission to edit the configuration of service " + serviceid + "!");
			return ERROR;
		}else {
			int i;
			for(i = 0; i < providedservices.size(); i++){
				if(providedservices.get(i).getServiceId() == Integer.parseInt(serviceid)){
					break;
				}
			}
			if(i == providedservices.size()){
				log.info("User "+ userid + " hadn't permission to edit the configuration of service " + serviceid + "!");
				return ERROR;
			}
		}
		return SUCCESS;
	}
}