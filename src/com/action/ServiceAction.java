package com.action;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import com.util.*;
import com.util.Matrix.Matrix;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.mule.MuleConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bean.Attachment;
import com.bean.Condition;
import com.bean.Evaluation;
import com.bean.Licence;
import com.bean.Parameter;
import com.bean.Permissionservice;
import com.bean.Role;
import com.bean.RolePermission;
import com.bean.RoleSpecSer;
import com.bean.Runlog;
import com.bean.Service;
import com.bean.Serviceclass;
import com.bean.ServiceclassId;
import com.bean.Servicelinks;
import com.bean.Servicerelation;
import com.bean.Serviceresult;
import com.bean.SpecTaskRoleUser;
import com.bean.Specification;
import com.bean.Temp;
import com.bean.UserRole;
import com.bean.UserSpecSer;
import com.bean.Variable;
import com.service.AttachmentService;
import com.service.ConditionService;
import com.service.EvaluationService;
import com.service.LicenceService;
import com.service.ParameterService;
import com.service.PermissionServiceService;
import com.service.RolePermissionService;
import com.service.RoleService;
import com.service.RoleSpecSerService;
import com.service.RunlogService;
import com.service.SerService;
import com.service.ServiceclassService;
import com.service.ServicelinksService;
import com.service.ServicerelationService;
import com.service.ServiceresultService;
import com.service.SpecTaskRoleUserService;
import com.service.SpecificationService;
import com.service.TempService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.UserSpecSerService;
import com.service.VariableService;
import com.util.graph.CycleDetector;
import com.util.graph.DirectedGraph;

import javax.swing.text.html.HTMLDocument;


public class ServiceAction extends ActionSupport{

	private static final Logger log = LoggerFactory.getLogger(ServiceAction.class);

	private Service sr=new Service();
	private SerService srs;
	private RoleService rolesr;
	private ConditionService conditionsr;
	private VariableService variablesr;
	private ParameterService parametersr;
	private UserSpecSerService userSpecSr;
	private TempService tempSr;
	private RoleSpecSerService roleSpecSr;
	private UserService userSr;
	private String applyString;


	String default_maxload = "100";
	InteractWithRancherUtil iwrUtil = new InteractWithRancherUtil();

	private UserRoleService userrolesr;
	private RolePermissionService rolepermissionsr;
	private PermissionServiceService permissionservicesr;
	private ServiceresultService srresultsr;
	private Serviceresult srt;
	private ServicerelationService srrelationsr;

	String serviceCost;
	String serviceReliability;
	String maxLoad;
	String isExternal;
	String option1;
	String option2;
	String servicePort;
	String serviceScale;
	String dockerImage;
	String accessRule;
	String team;

	File myFile;
	File uploadFile;
	File specificationFile;

	String sch;
	String nowuser;

	List<Service> services = new ArrayList<Service>();
	List<Service> allsers = new ArrayList<Service>();
	List<Service> acceptedservices = new ArrayList<Service>();
	List<Service> appliedservices = new ArrayList<Service>();
	List<Service> selected = new ArrayList<Service>();
	List<Service> ranklistByRuntimes = new ArrayList<Service>();
	List<Service> providedservices = new ArrayList<Service>();
	List<Service> calledservices = new ArrayList<Service>();
	List<ServiceQos> allQos = new ArrayList<ServiceQos>();

	List<Condition> conditions = new ArrayList<Condition>();
	List<Variable> variables = new ArrayList<Variable>();

	List<Condition> c = new ArrayList<Condition>();
	List<Variable> v = new ArrayList<Variable>();
	List<Role> roles = new ArrayList<Role>();

	List<DTreeNode> dtnodes = new ArrayList<DTreeNode>();

	List<Parameter> prts = new ArrayList<Parameter>();

	private JFreeChart chart;//这里变量名必须是chart，不能是其他变量名
	private List<String> interest; //struts会自动类型转换，将页面传递过来的值存到List中去

	private String userviceid;

	private String inname;
	private String intt;
	private String inadd;
	private String indesc;
	private String intype;
	private String inlevel;
	private String inpts;
	private String inrange;
	private String inbusiness;

	private String inctns;
	private String invars;

	private String serviceQoSOptimizationTarget;

	String serviceid = "";

	private String queryserviceid = "";
	private String queryServiceresult = "";

	EvaluationService evaluationsr = new EvaluationService();
	LicenceService licencesr = new LicenceService();
	RunlogService runlogsr = new RunlogService();
	SpecificationService specsr;
	SpecTaskRoleUserService strusr = new SpecTaskRoleUserService();
	AttachmentService attachmentsr = new AttachmentService();
	ServicelinksService serlinkssr = new ServicelinksService();
	ServiceclassService serclasssr = new ServiceclassService();

	String specJson = "";


	String selectedtype = "null";
	String selectedbusiness = "null";
	List<String> servicetypes = new ArrayList<String>();
	List<String> servicebusinesses = new ArrayList<String>();



	public String queryservice(){
		System.out.print(queryserviceid+";;;;");
		Service ser = new Service();
		ser = srs.getUniqueService(queryserviceid);
		JSONArray json = new JSONArray();
		Map<String, String> m = new HashMap<String, String>();
		m.put("serviceid", queryserviceid);
		m.put("servicename", ser.getServiceName());
		m.put("servicetype", ser.getServiceType());
		m.put("servicetarget", ser.getServiceTarget());
		m.put("servicerange", ser.getServiceRange());
		m.put("relatedbusiness", ser.getRelateBusiness());
		m.put("serviceaddress", ser.getServiceAddress());
		m.put("servicedesc", ser.getServiceDesc());
		System.out.print(m.toString()+";;;;");
		json.add(m);
		queryServiceresult= json.toString();
		System.out.print(queryServiceresult+";;;;");
		return SUCCESS;
	}


	public String addOutput()
	{
		try
		{
			srt.setServiceid(Integer.parseInt(serviceid));
			srt.setService(srs.getUniqueService(serviceid));
			this.srresultsr.addServiceresult(srt);
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
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 服务注册
	 * @return
	 */
	public String register() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String loginUser = (String) session.get("user");
		String loginPassword = (String) session.get("password");

		if (maxLoad.isEmpty() || maxLoad == null) maxLoad = default_maxload;
		sr.setMaxLoad(Integer.valueOf(maxLoad));
		sr.setIsExternal(Integer.parseInt(isExternal));
		sr.setServiceState("NO");
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		sr.setTeam(team);
		sr.setAccessRule(accessRule);
		//sr.setServiceTime(0.1);   //设置默认的服务最大请求时间，以秒为单位
		sr.setServiceProvider(loginUser);
		if (serviceReliability.isEmpty()) {
			sr.setServiceReliability(0.9); //设置服务可靠性的默认初始值
		} else {
			sr.setServiceReliability(Double.parseDouble(serviceReliability));
		}
		if (serviceCost.isEmpty()) {
			sr.setServiceCost(1000); //设置服务成本，以人民币（元）为单位
		} else {
			sr.setServiceCost(Double.parseDouble(serviceCost));
		}
		try {    //处理注册服务所需上传的文件
			String realpath = MuleConfig.getMuleAppPath() + "/" + sr.getServiceName();
			realpath = realpath.replaceAll("\\\\", "/");
			System.out.println("\n!!!!!realpath: " + realpath + "\n");
			if (myFile != null && myFile.length() != 0) {    //上传的myFile为业务流程文件
				String filename = sr.getServiceName() + ".yawl";
				File savefile = new File(new File(realpath), filename);
				if (!savefile.getParentFile().exists()) {
					savefile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(myFile, savefile);
				MuleXMLParser.parse(savefile);
				ActionContext.getContext().put("message", "文件上传成功");
				sr.setBusinessFile(realpath + "/" + filename);
			} else {
				sr.setBusinessFile(null);
			}
			if (uploadFile != null && uploadFile.length() != 0) {     //上传的uploadFile为服务附件文件，可能是本地应用的EXE文件等
				String filename = uploadFile.getName();
				File savefile = new File(new File(realpath), filename);
				if (!savefile.getParentFile().exists()) {
					savefile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(uploadFile, savefile);
				MuleXMLParser.parse(savefile);
				ActionContext.getContext().put("message", "文件上传成功");
				sr.setAttachments(realpath + "/" + filename);
			} else {
				sr.setAttachments(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//删除保存该服务的文件夹
			File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
			if (appdir.exists()) {
				try {
					FileUtils.deleteDirectory(appdir);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return ERROR;
		}

		this.srs.register(sr);//注册保存到数据库内
		boolean callfail = false;
		if (sr.getCallService() != null || (!sr.getCallService().isEmpty())) {
			if (!callVaild()) {
				callfail = true;
				this.srs.unregister(sr);
				//删除保存该服务的文件夹
				File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
				if (appdir.exists()) {
					try {
						FileUtils.deleteDirectory(appdir);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return ERROR;
			}
		}
		if (callfail == false) {
			//saveCallrelation();
			System.out.println("ok!");
			if (myFile != null) {
				try {
					ParseYawlFile yawl = new ParseYawlFile();   //解析流程，保存到数据库中
					yawl.getSpecRoleOrUser(loginUser, loginPassword, sr.getBusinessFile());
					//删除本次上传的文件
					myFile = null;
				} catch (Exception e) {
					e.printStackTrace();
					this.srs.unregister(sr);
					//删除保存该服务的文件夹
					File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
					if (appdir.exists()) {
						try {
							FileUtils.deleteDirectory(appdir);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					return ERROR;
				}
			}
			if (uploadFile != null) {
				String filepath = sr.getAttachments();
				ParseYawlFile yawl = new ParseYawlFile();
				String filecontent = yawl.readfile(filepath);
				Attachment attachment = new Attachment(filepath, filecontent);
				attachmentsr.addAttachment(attachment);
				//删除本次上传的文件
				uploadFile = null;
			}
		}


		//搁置以下两部分的代码，需要按新方案重写
        //1、对注册服务中的服务指定调用关系，以及原rancher中应用注册捎带其内部微服务注册的代码
        //2、以及服务之间的这两种关系的保存

        if (sr.getIsExternal() == 0) {   //注册的是内部服务
		  /*  if (sr.getServiceType().equalsIgnoreCase("SERVICE")) { //实现服务注册即部署
		        String namespace = team + "-" + accessRule;
		        String serviceResult = iwrUtil.deployService(sr.getServiceName(), namespace, serviceScale, dockerImage, servicePort);
		        if (serviceResult == null) {
		            return ERROR;
		        } else {
		            String serviceAddress = iwrUtil.getServiceAddress(serviceResult);
		            if (serviceAddress != null) {
		                sr.setServiceAddress(serviceAddress);
		            } else {
		                return ERROR;
		            }
		        }
		        srs.update(sr);
		    }

		    if (sr.getServiceType().equalsIgnoreCase("APPLICATION")) {//若注册的是应用，其后端的微服务也要进行注册
		        String servicesOfStack = iwrUtil.getServicesOfStack(sr.getServiceName());
		        String containedServices = ",";
		        if (servicesOfStack != null) {
		            JSONArray services_arr = JSONArray.fromObject(servicesOfStack);
		            for (int i = 0; i < services_arr.size(); i++) {
		                JSONObject serviceobj = new JSONObject();
		                serviceobj = services_arr.getJSONObject(i);
		                String servicename = serviceobj.getString("servicename");
		                if (srs.getServiceidByServiename(servicename) == null) { //存在同名的微服务不再重复注册
		                    Service microSer = new Service();
		                    microSer.setFailTimes(0);
		                    microSer.setIsExternal(0);
		                    microSer.setRunTimes(0);
		                    microSer.setServiceDesc(serviceobj.getString("servicedes"));
		                    microSer.setServiceName(servicename);
		                    //microSer.setServiceState("NO");
                            microSer.setServiceType("SERVICE");
                            srs.register(microSer);
		                }
		                containedServices += srs.getServiceidByServiename(servicename).getServiceId() + ",";
		            }

		            System.out.println(containedServices);
		            sr.setCallService(containedServices);
		            srs.update(sr);
		            saveRelationInStack(sr.getServiceName());//保存应用内的服务关联关系
                    saveRelationBetweenStacks(sr.getServiceName());//保存应用间的服务关联关系
                }
		    }*/

		    //如果是注册内部开发的应用，还需要保存应用内部的服务调用关系
			//默认其内部服务已经注册到系统中，且保存在callservices字段中
		    if(sr.getServiceType().equalsIgnoreCase("APPLICATION") && sr.getIsExternal() == 0){
				saveLinksInApplication(sr.getServiceName());
			}

		}

		//将注册成功的服务归入相应的服务类内
        ServiceclassId sclassId = new ServiceclassId(sr.getServiceType(), sr.getServiceTarget(), sr.getServiceRange());
		if (serclasssr.isExisted(sclassId)) {
		    Serviceclass serclass = serclasssr.findById(sclassId);
		    serclass.setServicesnum(serclass.getServicesnum() + 1);
		    serclass.setServices(serclass.getServices() + "," + sr.getServiceId());
		    serclasssr.update(serclass);
		} else {
		    Serviceclass serclass = new Serviceclass(sclassId, 1, "," + sr.getServiceId());
		    serclasssr.save(serclass);
		}
		return SUCCESS;
	}

	/**
	 * 服务注册
	 * @return
	 */
	/*public String register(){

		Map<String, Object> session = ActionContext.getContext().getSession();
		String loginUser = (String) session.get("user");
		String loginPassword = (String) session.get("password");

		if(maxLoad.isEmpty() || maxLoad == null) maxLoad = default_maxload;
		sr.setMaxLoad(Integer.valueOf(maxLoad));
		sr.setIsExternal(Integer.valueOf(isExternal));
		sr.setServiceState("NO");
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		if(sr.getServiceTime() == null){
			sr.setServiceTime("1");   //设置默认的服务最大请求时间，以秒为单位
		}
		sr.setServiceProvider(loginUser);
		if(serviceReliability == null){
			sr.setServiceReliability(0.5); //设置服务可靠性的默认值
		}
		else{
			sr.setServiceReliability(Double.parseDouble(serviceReliability));
		}
		if(serviceCost == null){
			sr.setServiceCost(1000); //设置服务成本的默认值
		}
		else{
			sr.setServiceCost(Double.parseDouble(serviceCost));
		}
		try{
    		String realpath = MuleConfig.getMuleAppPath() + "/" + sr.getServiceName();
			realpath = realpath.replaceAll("\\\\", "/");

            if (myFile != null && myFile.length() != 0) {
            	System.out.println("\n!!!!!realpath: "+realpath+"\n");

            	String filename = sr.getServiceName() + ".yawl";
                File savefile = new File(new File(realpath), filename);
                if (!savefile.getParentFile().exists())
                {
                    savefile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(myFile, savefile);
                MuleXMLParser.parse(savefile);
                ActionContext.getContext().put("message", "文件上传成功");
                sr.setBusinessFile(realpath + "/" + filename);
            }
            else{
            	sr.setBusinessFile(null);
            }
            if (uploadFile != null && uploadFile.length() != 0) {
            	System.out.println("\n!!!!!realpath: "+realpath+"\n");
            	String filename = uploadFile.getName();
                File savefile = new File(new File(realpath), filename);
                if (!savefile.getParentFile().exists())
                {
                    savefile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(uploadFile, savefile);
                MuleXMLParser.parse(savefile);
                ActionContext.getContext().put("message", "文件上传成功");
                sr.setAttachments(realpath + "/" + filename);
            }
            else{
            	sr.setAttachments(null);
            }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		//删除保存该服务的文件夹
			File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
			if(appdir.exists()){
				try {
					FileUtils.deleteDirectory(appdir);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
    		return ERROR;
    	}

    	this.srs.register(sr);
		boolean callfail = false;
		if(sr.getCallService() != null || (!sr.getCallService().isEmpty())){
			if(!callVaild()){
				callfail = true;
				this.srs.unregister(sr);
				//删除保存该服务的文件夹
				File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
				if(appdir.exists()){
					try {
						FileUtils.deleteDirectory(appdir);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return ERROR;
			}
		}
		if(callfail == false){
			saveCallrelation();
	    	System.out.println("ok!");
	    	if(myFile != null){
	    		try{
	    			ParseYawlFile yawl = new ParseYawlFile();
	    			yawl.getSpecRoleOrUser(loginUser, loginPassword, sr.getBusinessFile());
	    			//删除本次上传的文件
	    			myFile = null;
	    		}
	    		catch(Exception e)
	        	{
	        		e.printStackTrace();
	        		this.srs.unregister(sr);
	        		//删除保存该服务的文件夹
					File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
					if(appdir.exists()){
						try {
							FileUtils.deleteDirectory(appdir);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
	        		return ERROR;
	        	}
	    	}
	    	if(uploadFile != null){
	    		String filepath = sr.getAttachments();
	    		ParseYawlFile yawl = new ParseYawlFile();
	    		String filecontent = yawl.readfile(filepath);
	    		Attachment attachment = new Attachment(filepath, filecontent);
	    		attachmentsr.addAttachment(attachment);
	    		//删除本次上传的文件
	    		uploadFile = null;
	    	}
	    	if(sr.getServiceType().equalsIgnoreCase("APPLICATION") && sr.getIsExternal() == 0){//若注册的是应用，其后端的微服务也要进行注册
	    		String servicesOfStack = iwrUtil.getServicesOfStack(sr.getServiceName());
	    		String containedServices = ",";
	    		if(servicesOfStack != null){
	    			JSONArray services_arr = JSONArray.fromObject(servicesOfStack);
		    		for(int i = 0; i < services_arr.size(); i++){
		    			JSONObject serviceobj = new JSONObject();
		    			serviceobj = services_arr.getJSONObject(i);
		    			String servicename = serviceobj.getString("servicename");
		    			if(srs.getServiceidByServiename(servicename) == null){ //存在同名的微服务不再重复注册
		    				Service microSer = new Service();
			    			microSer.setFailTimes(0);
			    			microSer.setIsExternal(0);
			    			microSer.setRunTimes(0);
			    			microSer.setServiceDesc(serviceobj.getString("servicedes"));
			    			microSer.setServiceName(servicename);
			    			//microSer.setServiceState("NO");
			    			microSer.setServiceType("SERVICE");
			    			srs.register(microSer);
		    			}
		    			containedServices += srs.getServiceidByServiename(servicename).getServiceId() + ",";
		    		}

		    		System.out.println(containedServices);
		    		sr.setCallService(containedServices);
		    		srs.update(sr);
		    		saveRelationInStack(sr.getServiceName());//保存应用内的服务关联关系
		    		saveRelationBetweenStacks(sr.getServiceName());//保存应用间的服务关联关系
	    		}
	    	}
	    	//将注册成功的服务归入相应的服务类内
	    	ServiceclassId sclassId = new ServiceclassId(sr.getServiceType(), sr.getServiceTarget(), sr.getServiceRange());
	    	if(serclasssr.isExisted(sclassId)){
	    		Serviceclass serclass = serclasssr.findById(sclassId);
	    		serclass.setServicesnum(serclass.getServicesnum() + 1);
	    		serclass.setServices(serclass.getServices() + "," + sr.getServiceId());
	    		serclasssr.update(serclass);
	    	}
	    	else{
	    		Serviceclass serclass = new Serviceclass(sclassId, 1, "," + sr.getServiceId());
	    		serclasssr.save(serclass);
	    	}
	    	return SUCCESS;
		}
		return ERROR;
	}*/

	public void saveLinksInApplication(String serName){
		Service s = srs.getServiceidByServiename(serName);
		List<String> serviceNames = new ArrayList<String>();
		String callservices = s.getCallService();
		if(callservices.length() > 0){
			String[] sers = callservices.split(",");
			for(int i = 0; i < sers.length; i++){
				if(sers[i].length() > 0){//这是id
					String serviceName = srs.getUniqueService(sers[i]).getServiceName();
					serviceNames.add(serviceName);
					System.out.println(serviceName);
				}
			}
		}
		MonitorDataFromIstio monotor = new MonitorDataFromIstio();
		List<String> links = monotor.getServicelinksInApplication(serviceNames);
		for(int i = 0 ; i < links.size(); i++){
			String aService = links.get(i).split("&")[0];
			String bService = links.get(i).split("&")[1];
			Servicelinks link = new Servicelinks(srs.getServiceidByServiename(aService).getServiceId(), srs.getServiceidByServiename(bService).getServiceId(), s.getServiceId());
			serlinkssr.save(link);
		}
	}

	public String allService()
	{
		services.clear();
		try
		{
			services = srs.getAll();
			System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String approveService(){
		List<Temp> tempList=tempSr.getAll();
		JSONArray json=new JSONArray();
		for(int i=0;i<tempList.size();i++){
			Map<String,String> map=new HashMap<String,String>();
			Temp temp=tempList.get(i);
			//User user=userSr.getUniqueUser(temp.getUserId());
			Service service=srs.getUniqueService(temp.getServiceId().toString());
			map.put("tempId", temp.getTempId().toString());
			//map.put("applyId", user.getUserId().toString());
			//map.put("applyName", user.getUserName());
			//map.put("applyType", user.getUserType());
			map.put("userId", temp.getUserId().toString());
			map.put("serviceId", service.getServiceId().toString());
			map.put("serviceName", service.getServiceName());
			map.put("serviceType", service.getServiceType());
			map.put("serviceDesc", service.getServiceDesc());
			map.put("serviceLevel", service.getServiceLevel());
			json.add(map);
		}
		applyString=json.toString();
		return SUCCESS;
	}

	public String auditService()
	{
		try
		{
			services = srs.getUnService();

			//以下两行代码是保留应用内部的微服务，目前暂不适用与rancher2.0
			//List<Service> exceptedServices = srs.getExceptedService();
			//services.retainAll(exceptedServices);

			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String removeService()
	{
		services.clear();
		try
		{
			Map<String, Object> session = ActionContext.getContext().getSession();
			if(session.get("admin").equals("true")){//管理员拥有所有的服务
				services = srs.getAll();   //Service();
			}else{
				services = srs.getProvidedService(nowuser);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String serviceDetail()
	{
		try
		{
			sr = srs.getUniqueService(userviceid);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String acceptedService()
	{
		acceptedservices.clear();
		services.clear();
		try
		{
			acceptedservices = srs.getAcceptedService();
			services = srs.getAll();
			System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String calledservices()
	{
		calledservices.clear();
		services.clear();
		try
		{
			services = srs.getAll();

			calledservices = srs.getAcceptedService();
			List<Service> cancalled = new ArrayList<Service>();
			cancalled = srs.getAllService();
			calledservices.retainAll(cancalled);
			System.out.println(calledservices.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String acceptService()
	{
		try
		{
			sr = srs.getUniqueService(option1);
			System.out.println(option1);
			if(option2.equals("Accept"))
			{
				sr.setServiceState("YES");
			}
			else if(option2.equals("Refuse"))
			{
				sr.setServiceState("NO");
			}
			srs.update(sr);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}


	public String deleteService()
	{
		try
		{
			sr = srs.getUniqueService(option1);
			System.out.println(option1);

			List<Service> allser = new ArrayList<Service>();
			allser = srs.getAll();
			for(int i = 0; i < allser.size(); i++){
				Service s = new Service();
				s = allser.get(i);
				if(s.getCallService() != null){
					String[] callservices = s.getCallService().split(",");
					for(int j = 0; j < callservices.length; j++){
						if(callservices[j].length() > 0){
							if(callservices[j].equals(option1)){
								log.info("Can't remove service " + option1 + " due to it's been called by other service!");
								return ERROR;
							}
						}
					}
				}
			}

			List<Servicerelation> servicerelations = new ArrayList<Servicerelation>();
			servicerelations = srrelationsr.getSrrelationDao().findByServiceId(Integer.parseInt(option1));
			for(int i = 0; i < servicerelations.size(); i++){
				srrelationsr.getSrrelationDao().delete(servicerelations.get(i));
			}

			//针对同时部署在rancher上的服务deployment
            if(sr.getIsExternal() == 0 && sr.getServiceType().equalsIgnoreCase("SERVICE")){
                String serviceid = "deployment:" + sr.getTeam() + "-" + sr.getAccessRule() + ":" + sr.getServiceName();
                boolean deleteResult = iwrUtil.deleteService(serviceid);
                if(deleteResult == false){
                    return ERROR;
                }
            }


			//针对组合服务
			if(sr.getCombineType() != null && sr.getCallService() != null){
				List<Condition> conditions = new ArrayList<Condition>();
				conditions = conditionsr.getConditionDao().findByServiceId(Integer.parseInt(option1));
				for(int i = 0; i < conditions.size(); i++){
					conditionsr.getConditionDao().delete(conditions.get(i));
				}
				List<Variable> variables = new ArrayList<Variable>();
				variables = variablesr.getVariableDao().findByServiceId(Integer.parseInt(option1));
				for(int i = 0; i < variables.size(); i++){
					variablesr.getVariableDao().delete(variables.get(i));
				}
			}

			//针对流程
			if(sr.getServiceType().equalsIgnoreCase("BUSINESS")){
				String businessfile = sr.getBusinessFile();
				List<Specification> speclist = new ArrayList<Specification>();
				speclist = specsr.getSpecDao().findByFilepath(businessfile);
				for(int i = 0; i < speclist.size(); i++){
					String specIdentifier = speclist.get(i).getIdentifier();
					List<SpecTaskRoleUser> strulist = new ArrayList<SpecTaskRoleUser>();
					strulist = strusr.getStruDao().findBySpecIdentifier(specIdentifier);
					for(int j = 0; j < strulist.size(); j++){
						strusr.deleteSpecTaskRoleUser(strulist.get(j));
					}
					specsr.deleteSpec(speclist.get(i));
				}
			}
			//针对一般服务和应用

			List<Evaluation> evaluations = new ArrayList<Evaluation>();
			evaluations = evaluationsr.getEvaluationDao().findByEvaluationService(Integer.parseInt(option1));
			for(int i = 0; i < evaluations.size(); i++){
				evaluationsr.getEvaluationDao().delete(evaluations.get(i));
			}

			List<Licence> licences = new ArrayList<Licence>();
			licences = licencesr.getServiceLicence(Integer.parseInt(option1));
			for(int i = 0; i < licences.size(); i++){
				licencesr.getLicenceDao().delete(licences.get(i));
			}

			List<Parameter> parameters = new ArrayList<Parameter>();
			parameters = parametersr.getServiceParameter(Integer.parseInt(option1));
			for(int i = 0; i < parameters.size(); i++){
				parametersr.deleteParamater(parameters.get(i));
			}

			List<Permissionservice> pss = new ArrayList<Permissionservice>();
			pss = permissionservicesr.getPermissionserviceDao().findByServiceid(Integer.parseInt(option1));
			for(int i = 0; i < pss.size(); i++){
				permissionservicesr.getPermissionserviceDao().delete(pss.get(i));
			}

			List<RoleSpecSer> roleSpecSers = new ArrayList<RoleSpecSer>();
			roleSpecSers = roleSpecSr.getRoleSpecSerDao().findSpecSerByServiceId(Integer.parseInt(option1));
			for(int i = 0; i < roleSpecSers.size(); i++){
				roleSpecSr.getRoleSpecSerDao().delete(roleSpecSers.get(i));
			}

			List<Runlog> runlogs = new ArrayList<Runlog>();
			runlogs = runlogsr.getRunlogDao().findByServiceid(Integer.parseInt(option1));
			for(int i = 0; i < runlogs.size(); i++){
				runlogsr.deleteRunlog(runlogs.get(i));
			}


			List<Serviceresult> serviceresults = new ArrayList<Serviceresult>();
			serviceresults = srresultsr.getSrresultDao().findByServiceid(Integer.parseInt(option1));
			for(int i = 0; i < serviceresults.size(); i++){
				srresultsr.getSrresultDao().delete(serviceresults.get(i));
			}

			List<Temp> temps = new ArrayList<Temp>();
			temps = tempSr.findByServiceId(Integer.parseInt(option1));
			for(int i = 0; i < temps.size(); i++){
				tempSr.delete(temps.get(i));
			}

			List<UserSpecSer> userSpecSers = new ArrayList<UserSpecSer>();
			userSpecSers = userSpecSr.getUserSpecSerDao().findSpecSerByServiceId(Integer.parseInt(option1));
			for(int i = 0; i < userSpecSers.size(); i++){
				userSpecSr.getUserSpecSerDao().delete(userSpecSers.get(i));
			}

			List<Servicelinks> serlinksSers = new ArrayList<Servicelinks>();
			serlinksSers = serlinkssr.findByParentAppId(Integer.parseInt(option1));
			for(int i = 0; i < serlinksSers.size(); i++){
				serlinkssr.delete(serlinksSers.get(i));
			}

			ServiceclassId sclassId = new ServiceclassId(sr.getServiceType(), sr.getServiceTarget(), sr.getServiceRange());
			Serviceclass serclass = serclasssr.findById(sclassId);
			if(serclass != null){
				if(serclass.getServicesnum() == 1){
					serclasssr.delete(serclass);
				}
				else{
					serclass.setServicesnum(serclass.getServicesnum() - 1);
					String[] services = serclass.getServices().split(",");
					for(int i = 0 ; i < services.length; i++){
						if(services[i] != null && services[i].equals(String.valueOf(option1))){
							services[i] = "";
							break;
						}
					}
					String new_services = "";
					for(int i = 0 ; i < services.length; i++){
						if(services[i] != ""){
							new_services += "," + services[i];
						}
					}
					serclass.setServices(new_services);
					serclasssr.update(serclass);
				}
			}

			String filepath = sr.getAttachments();
			if(filepath != null){
				List<Attachment> attaches = new ArrayList<Attachment>();
				attaches = attachmentsr.findByFilepath(filepath);
				for(int i = 0; i < attaches.size(); i++){
					attachmentsr.deleteAttachment(attaches.get(i));
				}
			}

			//若为rancher平台上部署的应用，也要把其内部的lb删除
			if(sr.getServiceType().equalsIgnoreCase("application")){
				String appname = sr.getServiceName();
				Service lb_service = srs.getServiceidByServiename("lb-" + appname);
				if(lb_service != null){
					srs.deleteService(lb_service.getServiceId());
				}
			}

			//删除保存该服务的文件夹
			File appdir = new File(MuleConfig.getMuleAppPath() + "/" + sr.getServiceName());
			if(appdir.exists()){
				FileUtils.deleteDirectory(appdir);
			}

			srs.unregister(sr);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getApplicationService()
	{
		try
		{
			services = srs.getApplicationService();
			System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getAllService()
	{
		try
		{
			services = srs.getAllService();
			System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getServcieService()
	{
		try
		{
			services = srs.getServiceService();
			System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getPicture()
	{
		try
		{
			services = srs.getAll();
			System.out.println(services.size());

			JFreeChart chart=ChartFactory.createPieChart("Service Type",getDataset(),true,true,false);
			//chart.setTitle(new TextTitle("某公司组织结构图",new Font("宋体",Font.BOLD+Font.ITALIC,20)));
			System.out.println("rrrr");
			LegendTitle legend=chart.getLegend(0);//设置Legend
			//legend.setItemFont(new Font("宋体",Font.BOLD,14));
			PiePlot plot=(PiePlot) chart.getPlot();//设置Plot
			//plot.setLabelFont(new Font("隶书",Font.BOLD,16));
			String picturePath = ConstantUtil.getStatisticspicture();
			OutputStream os = new FileOutputStream(picturePath);//图片是文件格式的，故要用到FileOutputStream用来输出。
			//OutputStream os = new FileOutputStream("E:\\workspace\\myeclipse_projects\\SSH_Prototype_J2EE_5.0\\WebRoot\\images\\company.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
			ChartUtilities.writeChartAsJPEG(os, chart, 500, 400);
			//使用一个面向application的工具类，将chart转换成JPEG格式的图片。第3个参数是宽度，第4个参数是高度。

			os.close();//关闭输出流
			System.out.println("");
			//return chart;

			rankByRuntimes();

			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public void rankByRuntimes(){
		ranklistByRuntimes.clear();
		List<Service> ss = new ArrayList<Service>();
		ss = srs.getSrDAO().orderByRuntimes();
		System.out.println(ss.size()+"...");
		if(ss.size() > 10){
			for(int i = 0; i < 10; i++){    //取前十名
				System.out.println(ss.get(i).getServiceId()+"...");
				ranklistByRuntimes.add(ss.get(i));
			}
		}
		else{
			for(int i = 0; i < ss.size(); i++){    //取前十名
				System.out.println(ss.get(i).getServiceId()+"...");
				ranklistByRuntimes.add(ss.get(i));
			}
		}

	}

	private DefaultPieDataset getDataset()
	{
		DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
		int counter[] = {0,0,0,0};
		services = srs.getAll();
		for(int i = 0; i < services.size(); i++)
		{
			String servicetype = services.get(i).getServiceType();
			if(servicetype.toLowerCase().contains("application"))
			{
				counter[0]++;
			}
			else if(servicetype.toLowerCase().contains("service"))
			{
				counter[1]++;
			}
			else if(servicetype.toLowerCase().contains("business"))
			{
				counter[2]++;
			}
			else if(servicetype.toLowerCase().contains("local"))
			{
				counter[3]++;
			}
		}
		if(services.size() != 0){
			dpd.setValue("APPLICATION " + counter[0], counter[0] * 100 / services.size());  //输入数据
			dpd.setValue("SERVICE " + counter[1], counter[1] * 100 / services.size());
			dpd.setValue("BUSINESS " + counter[2], counter[2] * 100 / services.size());
			dpd.setValue("LOCAL " + counter[3], counter[3] * 100 / services.size());
		}
		else{
			dpd.setValue("APPLICATION " + counter[0], counter[0]);  //输入数据
			dpd.setValue("SERVICE " + counter[1], counter[1]);
			dpd.setValue("BUSINESS " + counter[2], counter[2]);
			dpd.setValue("LOCAL " + counter[3], counter[3]);
		}
		System.out.println("APPLICATION " + counter[0]+"SERVICE " + counter[1]+"BUSINESS " + counter[2]+"LOCAL " + counter[3]);
		return dpd;
	}

	public String conbineService()
	{
		try
		{
			services = srs.getAllService();
			//selected.addAll(services);
			List<Integer> num = new ArrayList<Integer>();
			for(int i = 0; i < services.size(); i++)
			{
				num.add(0);
			}
			for(int i = 0; i < services.size() - 1; i++)
			{
				for(int j = i + 1; j < services.size(); j++)
				{
					if(services.get(i).getServiceType().equals(services.get(j).getServiceType())
							&&	services.get(i).getServiceTarget().equals(services.get(j).getServiceTarget())
							&&	services.get(i).getServiceRange().equals(services.get(j).getServiceRange())
							)
					{
						num.set(i, num.get(i) + 1);
						num.set(j, num.get(j) + 1);
					}
				}
			}
			selected.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(num.get(i) > 0)
				{
					selected.add(services.get(i));
				}
			}

			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String combinedService()
	{
		try
		{
			services = srs.getCombinedService();
			conditions.clear();
			variables.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(services.get(i).getCombineType() != null)
				{
					Integer id = services.get(i).getServiceId();
					c = conditionsr.getServiceCondition(id);
					conditions.addAll(c);

					v =	variablesr.getServiceVariable(services.get(i).getServiceId());
					variables.addAll(v);
				}
			}


			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}


	public String searchService()
	{
		services = srs.getSearchService(sch);

		return SUCCESS;
	}
	public String myService(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("admin").equals("true")){//管理员拥有所有的服务
			//services = srs.getExceptedService();
            services = srs.getAll();
		}else{
			services = getMyService(Integer.parseInt(nowuser));
		}
		return SUCCESS;
	}

	public List<Service> getMyService(int userid)
	{
		services.clear();

		nowuser = String.valueOf(userid);

		List<Integer> rs = new ArrayList<Integer>();
		List<UserRole> urs = new ArrayList<UserRole>();
		for(UserSpecSer uss:userSpecSr.findSpecSerByUserId(userid)){
			services.add(uss.getService());
		}
		//services=userSpecSr.findSpecSerByUserId(userid);
		urs = userrolesr.getUserRole(userid);

		rs.clear();
		/*for(int i = 0; i < urs.size(); i++)
		{
			rs.add(urs.get(i).getRole().getRoleId());
		}*/

		rs = getApplicationRoles();

		List<Integer> ps = new ArrayList<Integer>();
		List<Integer> ss = new ArrayList<Integer>();
		ps.clear();
		ss.clear();

		for(int i = 0; i < rs.size(); i++)
		{
			//services=roleSpecSr.findSpecSerByRoleId(rs.get(i));
			for(RoleSpecSer rss:roleSpecSr.findSpecSerByRoleId(rs.get(i))){
				services.add(rss.getService());
			}
			List<RolePermission> rps = new ArrayList<RolePermission>();
			rps = rolepermissionsr.getRolePermission(rs.get(i));
			for(int j = 0; j < rps.size(); j++)
			{
				ps.add(rps.get(j).getPermission().getPermissionId());
				List<Permissionservice> pss = new ArrayList<Permissionservice>();
				pss = permissionservicesr.getPermissionService(rps.get(j).getPermission().getPermissionId());
				for(int k = 0; k < pss.size(); k++)
				{
					if(ss.contains(pss.get(k).getService().getServiceId()) == false)
					{
						ss.add(pss.get(k).getService().getServiceId());
					}
				}
			}
		}
		for(int i = 0; i < ss.size(); i++)
		{
			services.add(srs.getParmById(ss.get(i)));
			System.out.println(ss.get(i));
		}
		System.out.println(services.size());

		/*
		//包括自己注册的服务
		List<Service> provided = new ArrayList<Service>();
		provided = srs.getProvidedService(String.valueOf(userid));
		provided.removeAll(services);
		services.addAll(provided);

		//同时要是审核通过的服务
		List<Service> accepted = new ArrayList<Service>();
		accepted = srs.getAcceptedService();
		services.retainAll(accepted);*/

		System.out.println("services.size():"+services.size());

		return services;
	}

	public List<Service> getServiceFromRole(int roleid)
	{
		List<Service> sers = new ArrayList<Service>();
		List<Integer> ps = new ArrayList<Integer>();
		List<Integer> ss = new ArrayList<Integer>();
		sers.clear();
		ps.clear();
		ss.clear();
		for(RoleSpecSer rss:roleSpecSr.findSpecSerByRoleId(roleid)){
			sers.add(rss.getService());
		}
		List<RolePermission> rps = new ArrayList<RolePermission>();
		rps = rolepermissionsr.getRolePermission(roleid);
		for(int j = 0; j < rps.size(); j++)
		{
			ps.add(rps.get(j).getPermission().getPermissionId());
			List<Permissionservice> pss = new ArrayList<Permissionservice>();
			pss = permissionservicesr.getPermissionService(rps.get(j).getPermission().getPermissionId());
			for(int k = 0; k < pss.size(); k++)
			{
				if(ss.contains(pss.get(k).getService().getServiceId()) == false)
				{
					ss.add(pss.get(k).getService().getServiceId());
				}
			}
		}
		for(int i = 0; i < ss.size(); i++)
		{
			sers.add(srs.getParmById(ss.get(i)));
			System.out.println(ss.get(i));
		}
		System.out.println(sers.size());
		return sers;
	}


	/**
	 * 可靠性组合
	 * @return
	 */
	public String combineAService()
	{
		acceptedservices = srs.getAcceptedService();
		List<Service> ser = srs.getAll();
		acceptedservices.retainAll(ser);
		List<Service> internalServices = new ArrayList<Service>();
		internalServices = srs.getInternalService();
		acceptedservices.retainAll(internalServices);
		allsers.clear();
		allsers = srs.getAll();
		dtnodes.clear();
		prts.clear();
		try
		{
			services = srs.getAll();
			services.retainAll(internalServices);      //服务组合只针对内部服务

			List<Integer> num = new ArrayList<Integer>();
			for(int i = 0; i < services.size(); i++)
			{
				num.add(0);
			}
			for(int i = 0; i < services.size() - 1; i++)
			{
				for(int j = i + 1; j < services.size(); j++)
				{
					if(services.get(i).getServiceType().equals(services.get(j).getServiceType())){
						if((services.get(i).getServiceTarget() != null && services.get(j).getServiceTarget() != null && services.get(i).getServiceTarget().equals(services.get(j).getServiceTarget()))
								|| (services.get(i).getServiceTarget() == null && services.get(j).getServiceTarget() == null)){
							if((services.get(i).getServiceRange() != null && services.get(j).getServiceRange() != null && services.get(i).getServiceRange().equals(services.get(j).getServiceRange()))
									|| (services.get(i).getServiceRange() == null && services.get(j).getServiceRange() == null)){
								num.set(i, num.get(i) + 1);
								num.set(j, num.get(j) + 1);
							}
						}
					}
				}
			}
			selected.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(num.get(i) > 0)
				{
					selected.add(services.get(i));
				}
			}

			for(int i = 0; i < selected.size(); i++)
			{
				List<Parameter> ps = parametersr.getServiceParameter(selected.get(i).getServiceId());
				for(int j = 0; j < ps.size(); j++)
				{
					prts.add(ps.get(j));
				}
			}

			System.out.println(selected.size());
			List<String> nodeContent = new ArrayList<String>();
			List<Integer> nodeid = new ArrayList<Integer>();
			List<String> content = new ArrayList<String>();
			nodeContent.clear();
			nodeid.clear();
			content.clear();
			for(int i = 0; i < selected.size(); i++)
			{
				String ct = selected.get(i).getServiceType();
				if(content.contains(ct) == false)
				{
					nodeid.add(0);
					nodeContent.add(ct);
					content.add(ct);
				}
				int pos = content.indexOf(ct);
				String ct2 = ct + " " + selected.get(i).getServiceTarget();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(selected.get(i).getServiceTarget());
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				String ct3 = ct2 + " " +  selected.get(i).getServiceRange();
				nodeid.add(pos2 + 1);
				nodeContent.add(selected.get(i).getServiceRange() + " use " + selected.get(i).getServiceId());
				content.add(ct3);
			}

			for(int i = 0; i < nodeid.size(); i++)
			{
				DTreeNode dn = new DTreeNode();
				dn.setSelf(i + 1);
				dn.setFather(nodeid.get(i));
				dn.setContent(nodeContent.get(i));
				dtnodes.add(dn);
			}

			for(int i = 0; i < dtnodes.size(); i++)
			{
				System.out.print(dtnodes.get(i).getSelf() + " ");
				System.out.print(dtnodes.get(i).getFather() + " ");
				System.out.print(dtnodes.get(i).getContent() + "\n");
			}

			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	public String combineBService()
	{
		acceptedservices = srs.getAcceptedService();
		List<Service> ser = srs.getAll();
		acceptedservices.retainAll(ser);
		List<Service> internalServices = new ArrayList<Service>();
		internalServices = srs.getInternalService();
		acceptedservices.retainAll(internalServices);

		allsers.clear();
		allsers = srs.getAll();
		try
		{
			services = srs.getAll();
			services.retainAll(internalServices);
			dtnodes.clear();
			List<Integer> num = new ArrayList<Integer>();
			for(int i = 0; i < services.size(); i++)
			{
				num.add(0);
			}
			for(int i = 0; i < services.size() - 1; i++)
			{
				for(int j = i + 1; j < services.size(); j++)
				{
					if(services.get(i).getServiceType().equals(services.get(j).getServiceType())){
						if((services.get(i).getServiceTarget() != null && services.get(j).getServiceTarget() != null && services.get(i).getServiceTarget().equals(services.get(j).getServiceTarget()))
								|| (services.get(i).getServiceTarget() == null && services.get(j).getServiceTarget() == null)){
							if((services.get(i).getServiceRange() != null && services.get(j).getServiceRange() != null && services.get(i).getServiceRange().equals(services.get(j).getServiceRange()) == false)
									|| (services.get(i).getServiceRange() == null && services.get(j).getServiceRange() == null)){
								num.set(i, num.get(i) + 1);
								num.set(j, num.get(j) + 1);
							}
						}
					}
				}
			}

			selected.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(num.get(i) > 0)
				{
					selected.add(services.get(i));
				}
			}

			List<String> nodeContent = new ArrayList<String>();
			List<Integer> nodeid = new ArrayList<Integer>();
			List<String> content = new ArrayList<String>();
			nodeContent.clear();
			nodeid.clear();
			content.clear();
			for(int i = 0; i < selected.size(); i++)
			{
				String ct = selected.get(i).getServiceType();
				if(content.contains(ct) == false)
				{
					nodeid.add(0);
					nodeContent.add(ct);
					content.add(ct);
				}
				int pos = content.indexOf(ct);
				String ct2 = ct + " " + selected.get(i).getServiceTarget();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(selected.get(i).getServiceTarget());
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				String ct3 = ct2 + " " + selected.get(i).getServiceRange();
				nodeid.add(pos2 + 1);
				nodeContent.add(selected.get(i).getServiceRange() + " use " + selected.get(i).getServiceId());
				content.add(ct3);
			}

			for(int i = 0; i < nodeid.size(); i++)
			{
				DTreeNode dn = new DTreeNode();
				dn.setSelf(i + 1);
				dn.setFather(nodeid.get(i));
				dn.setContent(nodeContent.get(i));
				dtnodes.add(dn);
			}

			for(int i = 0; i < dtnodes.size(); i++)
			{
				System.out.print(dtnodes.get(i).getSelf() + " ");
				System.out.print(dtnodes.get(i).getFather() + " ");
				System.out.print(dtnodes.get(i).getContent() + "\n");
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 流程式组合
	 * @return
	 */
	public String combineCService()
	{
		services = srs.getAll();
		return SUCCESS;
	}

	/**
	 * 添加可靠性组合服务
	 * @return
	 */
	public String addCombineA()
	{
		String callservice = inpts.replaceAll("s", ",");
		combineAService();
		if(checkCombine(callservice) == false){
			log.info("The selected subservices don't satisfy the combine condition!");
			return ERROR;
		}

		sr = new Service();
		sr.setServiceAddress(inadd);
		sr.setServiceTarget(intt);
		sr.setServiceDesc(indesc);
		sr.setServiceName(inname);
		sr.setServiceType(intype);
		sr.setServiceLevel(inlevel);
		sr.setServiceRange(inrange);
		sr.setRelateBusiness(inbusiness);
		sr.setServiceState("NO");
		Map<String, Object> session = ActionContext.getContext().getSession();
		String loginUser = (String) session.get("user");
		String loginPassword = (String) session.get("password");
		sr.setServiceProvider(loginUser);
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		sr.setPreferredTarget("ServiceReliability"); //可靠性组合，偏好指标为可靠性
		sr.setCombineType("CombineA");
		sr.setIsExternal(0);

		sr.setCallService(callservice);

		//创建组合服务也是注册服务，调用子服务，所以也要判断注册服务是否违反调用规则
		this.srs.register(sr);
		if(sr.getCallService() != null || (!sr.getCallService().isEmpty())){
			if(!callVaild()){
				this.srs.unregister(sr);
				return ERROR;
			}
			else{
				int sid = sr.getServiceId();

				String[] ss = inpts.split("s");
				for(int i = 0; i < ss.length; i++)
				{
					if(ss[i].length() > 0)
					{
						int ptsid = Integer.valueOf(ss[i]);
						Condition cc = new Condition();
						Service service=new Service();
						service.setServiceId(sid);
						cc.setServiceByServiceId(service);
						Service subService=new Service();
						subService.setServiceId(Integer.valueOf(ss[i]));
						cc.setServiceBySubServiceId(subService);
						conditionsr.getConditionDao().save(cc);

						Servicerelation srrealation = new Servicerelation();
						srrealation.setServiceByServiceId(service);
						srrealation.setServiceBySubServiceId(subService);
						srrealation.setCondition(cc);
						srrelationsr.getSrrelationDao().save(srrealation);  //保存服务关系
					}
				}

				System.out.print(BuiltInVar.getVarValue("year"));
				return SUCCESS;
			}
		}
		else{
			this.srs.unregister(sr);
			log.info("Can't create this combined service because it didn't call any subservice!");
			return ERROR;
		}
	}

	/**
	 * 添加适用性组合服务
	 * @return
	 */
	public String addCombineB()
	{
		String callservice = inpts.replaceAll("s", ",");
		combineBService();
		if(checkCombine(callservice) == false){
			log.info("The selected subservices don't satisfy the combine condition!");
			return ERROR;
		}

		sr = new Service();
		sr.setServiceAddress(inadd);
		sr.setServiceTarget(intt);
		sr.setServiceDesc(indesc);
		sr.setServiceName(inname);
		sr.setServiceType(intype);
		sr.setServiceLevel(inlevel);
		sr.setServiceRange(inrange);
		sr.setRelateBusiness(inbusiness);
		sr.setServiceState("NO");
		Map<String, Object> session = ActionContext.getContext().getSession();
		String loginUser = (String) session.get("user");
		String loginPassword = (String) session.get("password");
		sr.setServiceProvider(loginUser);
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		//适用性组合，无偏好指标
		sr.setCombineType("CombineB");
		sr.setIsExternal(0);
		sr.setCallService(callservice);

		//创建组合服务也是注册服务，调用子服务，所以也要判断注册服务是否违反调用规则
		this.srs.register(sr);
		if(sr.getCallService() != null || (!sr.getCallService().isEmpty())){
			if(!callVaild()){
				this.srs.unregister(sr);
				return ERROR;
			}
			else{
				try{
					int sid = sr.getServiceId();

					String[] ss = inpts.split("s");      //添加的子服务
					String[] vars = invars.split(";");
					String[] ctns = inctns.split(";");
					for(int i = 0; i < ss.length; i++)
					{
						if(ss[i].length() > 0)
						{
							int ptsid = Integer.valueOf(ss[i]);
							Condition cc = new Condition();
							Service service=new Service();
							service.setServiceId(sid);
							cc.setServiceByServiceId(service);
							Service subService=new Service();
							subService.setServiceId(Integer.valueOf(ss[i]));
							cc.setServiceBySubServiceId(subService);
							cc.setCondtionExpression(ctns[i]);
							conditionsr.getConditionDao().save(cc);     //保存运行条件

							Servicerelation srrealation = new Servicerelation();
							srrealation.setServiceByServiceId(service);
							srrealation.setServiceBySubServiceId(subService);
							srrealation.setCondition(cc);
							srrelationsr.getSrrelationDao().save(srrealation);  //保存服务关系

						}
					}

					for(int i = 0; i < vars.length; i++)
					{
						if(vars[i].length() > 0)
						{
							Variable vv = new Variable();
							vv.setVariableName(vars[i]);
							Service service=new Service();
							service.setServiceId(sid);
							vv.setService(service);
							variablesr.getVariableDao().save(vv);
						}
					}
					return SUCCESS;
				}catch(Exception e){
					e.printStackTrace();
					this.srs.unregister(sr);
					return ERROR;
				}
			}
		}
		else{
			this.srs.unregister(sr);
			log.info("Can't create this combined service because it didn't call any subservice!");
			return ERROR;
		}
	}

	/**
	 * 添加（用editor定义的）流程式组合服务
	 * @return
	 */
	public String addCombineC(){
		try{
			//用editor定义流程，保存流程文件时会自动分析验证工作流结构合理性
            System.out.println("\n!!!!!in: ");
			Map<String, Object> session = ActionContext.getContext().getSession();
			String loginUser = (String) session.get("user");
			String loginPassword = (String) session.get("password");
			Service combineprocess = new Service();
			if (specificationFile != null && specificationFile.length() != 0) {
				combineprocess.setServiceName(inname);
				combineprocess.setServiceRange(inrange);
				combineprocess.setServiceTarget(intt);
				combineprocess.setServiceDesc(indesc);
				combineprocess.setServiceLevel(inlevel);
				combineprocess.setCombineType("CombineC");
				combineprocess.setRunTimes(0);
				combineprocess.setFailTimes(0);
				combineprocess.setPreferredTarget(serviceQoSOptimizationTarget); //流程式组合，偏好指标为用户所选指标
				combineprocess.setServiceProvider(loginUser);
				combineprocess.setIsExternal(0);
				combineprocess.setMaxLoad(Integer.parseInt(default_maxload));
				combineprocess.setRelateBusiness(inbusiness);
				combineprocess.setServiceState("NO");
				combineprocess.setServiceType("BUSINESS");

				String realpath = MuleConfig.getMuleAppPath() + "/" + inname;
				System.out.println("\n!!!!!realpath: "+realpath+"\n");

				String filename = inname + ".yawl";
				File savefile = new File(new File(realpath), filename);
				if (!savefile.getParentFile().exists())
				{
					savefile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(specificationFile, savefile);
				MuleXMLParser.parse(savefile);
				ActionContext.getContext().put("message", "文件上传成功");
				combineprocess.setBusinessFile(realpath + "/" + filename);
			}
			else{
				combineprocess.setBusinessFile(null);
				return ERROR;
			}

            //分析组合流程中所调用的服务，并计算其QoS属性（目前按顺序结构来计算），保存到数据库中
            Double reliability = 1.0;
            Double servicecost = 0.0;
            Double servicetime = 0.0;
            ParseYawlFile yawl = new ParseYawlFile();
            Map<Service, Integer> invokedServices = yawl.analyseCombinedBusiness(combineprocess.getBusinessFile());
            Set<Service> services = invokedServices.keySet();
            Iterator it = services.iterator();
            while(it.hasNext()){
                Service s = (Service)it.next();
                int times = invokedServices.get(s);
                System.out.println("invoke:"+s.getServiceId()+" " + times);
                reliability *= Math.pow(s.getServiceReliability(),times);
                servicecost += s.getServiceCost();
                servicetime += s.getServiceTime() * times;
            }
            combineprocess.setServiceReliability(reliability);
            combineprocess.setServiceCost(servicecost);
            combineprocess.setServiceTime(servicetime);
            srs.register(combineprocess);

			//同时保存到流程表中
			yawl.getSpecRoleOrUser(loginUser, loginPassword, combineprocess.getBusinessFile());

			//保存流程式组合中父流程与调用服务的关系到condition表中
            saveCombineCCondition(combineprocess, invokedServices);

			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}

    /**
     * 保存流程式组合中父流程与调用服务的关系到condition表中
     * @param combineprocess
     * @param invokedServices
     */
	public void saveCombineCCondition(Service combineprocess, Map<Service, Integer> invokedServices){
        Set<Service> services = invokedServices.keySet();
        Iterator it = services.iterator();
		Service currentService = new Service();
        if(it.hasNext()){ //保存流程调用第一个服务的调用关系
			currentService = (Service)it.next();
			Condition condition = new Condition(combineprocess, currentService);
			conditionsr.getConditionDao().save(condition);
		}
        while(it.hasNext()){
			//并将其内部的服务之间的调用关系保存到servicelinks表中,暂按顺序结构的逻辑，即当前服务调用下一服务
			Service nextService = (Service)it.next();
			Condition condition = new Condition(combineprocess, nextService);
			conditionsr.getConditionDao().save(condition);
			Servicelinks serLink = new Servicelinks(currentService.getServiceId(), nextService.getServiceId(),combineprocess.getServiceId());
			serlinkssr.save(serLink);
			currentService = nextService;
		}
    }

		/**
		 * 判断要注册服务的调用关系是否符合规则
		 */
		public boolean callVaild(){
		//String callservices = sr.getCallService();
		String[] callservices = sr.getCallService().split(",");
		System.out.print("callservices.length：" +callservices.length+"\n");
		for(int i = 0; i < callservices.length; i++){              //从服务级别判断是否符合调用规则
			if(callservices[i].length() > 0){
				Service callsr = new Service();
				callsr = srs.getUniqueService(callservices[i]);
				if(sr.getServiceLevel() == null){
					sr.setServiceLevel("1");
				}
				if(callsr.getServiceLevel() == null){
					callsr.setServiceLevel("1");
				}
				if(Integer.parseInt(callsr.getServiceLevel()) > Integer.parseInt(sr.getServiceLevel())){
					log.info("Register service " + sr.getServiceName() + " failed because it called service whose level higher than its!");
					return false;
				}
			}
		}

		DirectedGraph<Integer> dg = getServiceGraph();     //判断服务调用图是否有环，以解决服务循环调用
		dg.addNode(sr.getServiceId());                 //要注册的服务已临时存到服务列表里了
		for(int i = 0; i < callservices.length; i++){
			if(callservices[i].length() > 0){
				dg.addNode(Integer.parseInt(callservices[i]));
				dg.addEdge(sr.getServiceId(), Integer.parseInt(callservices[i]));
			}
		}
		CycleDetector<Integer> cd = new CycleDetector<Integer>(dg);
		if(cd.containsCycle()){
			log.info("Register service " + sr.getServiceName() + " failed because it called service circularly!");
			return false;
		}
		return true;
	}



	/**
	 * 给所有服务建立有向图，表示服务之间的调用关系
	 * @return
	 */
	public DirectedGraph<Integer> getServiceGraph(){
		DirectedGraph<Integer> dg = new DirectedGraph<Integer>();
		List<Service> allservices = srs.getAll();
		for(int i = 0; i < allservices.size(); i++){
			Service service = new Service();
			service = allservices.get(i);
			dg.addNode(service.getServiceId());
			if(service.getCallService() != null){
				String[] callservices = service.getCallService().split(",");
				for(int j = 0; j < callservices.length; j++){
					if(callservices[j].length() > 0){
						dg.addNode(Integer.parseInt(callservices[j]));
						dg.addEdge(service.getServiceId(), Integer.parseInt(callservices[j]));
					}
				}
			}
		}
		return dg;
	}


	/**
	 * 将注册服务的服务调用关系保存到数据库
	 */
	public void saveCallrelation(){
		if(sr.getCallService() != null){
			String[] callservices = sr.getCallService().split(",");
			for(int i = 0; i < callservices.length; i++){
				if(callservices[i].length() > 0){
					Servicerelation srrel = new Servicerelation();
					srrel.setServiceByServiceId(sr);
					srrel.setServiceBySubServiceId(srs.getUniqueService(callservices[i]));
					srrelationsr.getSrrelationDao().save(srrel);
				}
			}
		}
	}


	public String providedService(){
		providedservices.clear();
		//if(nowuser == "6")     管理员也没有权限去改
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("admin") == "true"){
			providedservices = srs.getAllService();
		}else{
			providedservices = srs.getProvidedService(nowuser);
			List<Service> businesslist = new ArrayList<Service>();
			businesslist = srs.getBusinessService();
			providedservices.removeAll(businesslist);  //暂时不考虑流程
		}

		if(providedservices.size() == 0){
			log.info("User "+ nowuser + " hadn't registered any service!");
			return ERROR;
		}
		System.out.print(providedservices.size());
		return SUCCESS;
	}

	public List<Integer> getApplicationRoles(){
		GetRemoteService grs = new GetRemoteService();
		String positionresult = grs.getPosition(nowuser);
		String positions = "";
		if(positionresult != null){
			JSONArray json = JSONArray.fromObject(positionresult );
			System.out.println(json.toString()+"="+positionresult+"\n");
			if(json.size()>0){
				for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
					JSONObject job = json.getJSONObject(i);
					System.out.print("positions:"+json.toString());
					positions = job.getString("positions");
					break;
				}
			}
		}

		List<Integer> myroles = new ArrayList<Integer>();
		List<Role> allroles = new ArrayList<Role>();
		allroles = rolesr.getAllRole();

		//String url = "http://localhost:3000/rolemap/getBusiRoleByOrganRole/" + nowuser + "&测试1组织系统&服务管理中心&" + positions;
		//String rolesresult = grs.httpGet("http://localhost:3000/rolemap/getBusiRoleByOrganRole/");
		//String url = "http://localhost:3000/rolemap/getBusiRoleByOrganRole/";
		String url = ConstantUtil.getGetbusirolebyorganroleurl();
		String rolesresult = grs.postForm(url, nowuser, "测试1组织系统", "服务管理中心", positions);
		//String rolesresult = "God";
		System.out.println("rolesresult="+rolesresult+"\n") ;
		String[] roles = rolesresult.split(",");
		for(int i = 0; i < roles.length; i++){
			if(roles[i].isEmpty() == false){
				for(int j = 0; j < allroles.size(); j++){
					if(roles[i].equals(allroles.get(j).getRoleName())){
						Role role = new Role();
						role = allroles.get(j);
						if(myroles.contains(role.getRoleId()) == false){
							myroles.add(role.getRoleId());
						}

					}
				}
			}

		}
		return myroles;
	}

	public String serviceByType(){
		try{
			services.clear();
			services = srs.getAll();

			servicetypes.clear();
			servicetypes = srs.getServiceType();

			selectedtype = "null";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String ServiceOfSelectedType(){
		try{
			servicetypes.clear();
			servicetypes = srs.getServiceType();

			services.clear();
			if(selectedtype.equalsIgnoreCase("ALL")){
				services = srs.getAll();
			}
			else{
				services = srs.getServiceByType(selectedtype);
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String serviceByBusiness(){
		try{
			services.clear();
			services = srs.getAll();

			servicebusinesses.clear();
			servicebusinesses = srs.getRelateBusiness();

			selectedbusiness = "null";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String ServiceOfSelectedBusiness(){
		try{
			System.out.print(selectedbusiness+"\n");

			servicebusinesses.clear();
			servicebusinesses = srs.getRelateBusiness();

			services.clear();

			if(selectedbusiness.equalsIgnoreCase("ALL")){
				services = srs.getAll();
			}
			else{
				services = srs.getServiceByBusiness(selectedbusiness);
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public boolean checkCombine(String callservices){
		List<String> subsers = new ArrayList<String>();
		List<Integer> fathers = new ArrayList<Integer>();
		subsers.clear();
		fathers.clear();
		String[] sers = callservices.split(",");
		for(int i = 0; i < sers.length; i++){
			if(sers[i].length() > 0){
				subsers.add(sers[i]);
			}
		}

		for(int j = 0; j < subsers.size(); j++){
			for(int i = 0; i < dtnodes.size(); i++){
				int father = dtnodes.get(i).getFather();
				String content = dtnodes.get(i).getContent();
				String sid = content.substring(content.lastIndexOf(" ")+1, content.length());
				if(subsers.get(j).equalsIgnoreCase(sid)){
					if(fathers.contains(father) == false){
						fathers.add(father);
					}
					subsers.remove(j);
					j--;
					break;
				}
			}
		}

		if(subsers.size() == 0 && fathers.size() == 1){
			return true;
		}
		else{
			for(int i = 0; i < subsers.size(); i++){
				System.out.print("subsers:"+subsers.get(i)+"\n");
			}
			for(int i = 0; i < fathers.size(); i++){
				System.out.print("fathers:"+fathers.get(i)+"\n");
			}
			return false;
		}
	}

	public String chooseRoleService(){
		try{
			services.clear();
			services = srs.getAll();

			roles.clear();
			roles = rolesr.getAllRole();
			return SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}

	}



	/**
	 * 保存应用内的微服务调用关系
	 * @param stackname
	 */
	public void saveRelationInStack(String stackname){
		Service stack = srs.getServiceidByServiename(stackname);
		int appid = stack.getServiceId();
		iwrUtil.getConfigOfStack(stackname);
		try {
			Yaml yaml = new Yaml();
			File dockerfile = new File(MuleConfig.getMuleAppPath() + "/" + stackname + "/docker-compose.yml");
			if (dockerfile != null) {
				//获取文件中的配置数据，将值转换为Map
				Map map =(Map)yaml.load(new FileInputStream(dockerfile));
				String services = map.get("services").toString();
				Map servicesMap = (Map)map.get("services");
				Iterator it = servicesMap.entrySet().iterator();
				while(it.hasNext()){
					String ser = it.next().toString();
					String sername = ser.substring(0, ser.indexOf("="));
					Map serMap = (Map)servicesMap.get(sername);
					if(serMap.containsKey("links") || serMap.containsKey("depends_on")){
						String links = "";
						if(serMap.containsKey("links")){
							links = serMap.get("links").toString();
						}
						else if(serMap.containsKey("depends_on")){
							links = serMap.get("depends_on").toString();
						}
						if(links.contains("[")){
							links = links.substring(1, links.lastIndexOf("]"));
						}
						if(links.contains(":")){
							links = links.substring(0, links.lastIndexOf(":"));
						}
						Servicelinks serlinks = new Servicelinks();
						serlinks.setParentAppId(appid);
						Service service = new Service();
						service = srs.getServiceidByServiename(sername);
						serlinks.setServiceId(service.getServiceId());
						Service subservice = new Service();
						subservice = srs.getServiceidByServiename(links);
						serlinks.setSubServiceId(subservice.getServiceId());
						serlinkssr.save(serlinks);
						System.out.println(links);
					}
				}
			}

			File rancherfile = new File(MuleConfig.getMuleAppPath() + "/" + stackname + "/rancher-compose.yml");
			if (rancherfile != null) {
				InputStream inputStream = new FileInputStream(rancherfile);
				//获取文件中的配置数据，将值转换为Map
				Map map =(Map)yaml.load(inputStream);
				String services = map.get("services").toString();
				Map servicesMap = (Map)map.get("services");
				Iterator it = servicesMap.entrySet().iterator();
				String lbservicename = "lb-" + stackname;
				while(it.hasNext()){
					String ser = it.next().toString();
					String sername = ser.substring(0, ser.indexOf("="));
					if(sername.equals(lbservicename)){
						Map serMap = (Map)servicesMap.get(lbservicename);
						if(serMap.containsKey("lb_config")){
							String linkservice = "";
							Map lbMap = (Map)serMap.get("lb_config");
							if(lbMap.containsKey("port_rules")){
								List portList = (List) lbMap.get("port_rules");
								for(int i = 0 ; i < portList.size(); i++){
									String port = portList.get(i).toString();
									if(port.contains("service=")){
										port = port.replaceAll("[\\[\\]]", "");
										String[] rules = port.split(",");
										for(int j = 0; j < rules.length; j++){
											if(rules[j].contains("service=")){
												linkservice = rules[j].substring(rules[j].indexOf("=") + 1);
												System.out.println(linkservice);
												Servicelinks serlinks = new Servicelinks();
												serlinks.setParentAppId(appid);
												Service service = new Service();
												service = srs.getServiceidByServiename(sername);
												serlinks.setServiceId(service.getServiceId());
												Service subservice = new Service();
												subservice = srs.getServiceidByServiename(linkservice);
												serlinks.setSubServiceId(subservice.getServiceId());
												serlinkssr.save(serlinks);
												break;
											}
										}
										break;
									}
								}
							}
						}
					}

				}
				inputStream.close();//关闭读取rancher-compose.yml的文件流
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存应用间的关联关系，通过共同的微服务产生关联
	 * @param stackname
	 */
	public void saveRelationBetweenStacks(String stackname){
		Service stack = srs.getServiceidByServiename(stackname);
		int appid = stack.getServiceId();
		String containedServicesStr = stack.getCallService();
		List<Service> apps = srs.getServiceByType("APPLICATION");
		apps.remove(stack);
		String[] containedServices = containedServicesStr.split(",");
		for(int i = 0; i < containedServices.length; i++){
			if(containedServices[i].length() > 0){
				String regex = "," + containedServices[i] + ",";
				for(int j = 0; j < apps.size(); j++){
					Service ser = apps.get(j);
					String subservices = ser.getCallService();
					if(subservices != null && subservices.contains(regex)){  //包含相同的微服务
						Servicerelation relBetweenApps = new Servicerelation();
						relBetweenApps.setLinkServiceId(Integer.parseInt(containedServices[i]));
						relBetweenApps.setServiceByServiceId(stack);
						relBetweenApps.setServiceBySubServiceId(ser);
						srrelationsr.addServicerelation(relBetweenApps);
					}
				}
			}

		}
	}


	/**
	 * 计算组合服务的qos
	 * @return
	 */
	private ServiceQos computeComServiceQos(int serviceid){
		Service s = srs.getUniqueService(String.valueOf(serviceid));
		ServiceQos qos = new ServiceQos();
		qos.setServiceId(serviceid);
		qos.setServiceName(s.getServiceName());
		qos.setServiceType(s.getServiceType());

		double reliability = 1.0, availability = 1.0, serviceTime = 0.0, serviceCost = 0.0, busyDegree =1.0, avgEvaluation = 0.0, qosValue = 0.0;

		if(s.getCombineType() != null){
        	List<Service> sers = new ArrayList<Service>();//子服务列表
        	//可靠性组合和适用性组合的子服务列表都是通过Condition获取的
        	if(s.getCombineType().equalsIgnoreCase("CombineC") == false){
				List<Condition> cons = conditionsr.getConditionDao().findByServiceId(serviceid);
				for(int i = 0; i < cons.size(); i++){
					sers.add(cons.get(i).getServiceBySubServiceId());
				}
				if(s.getCombineType().equalsIgnoreCase("CombineA")){
					for(int i = 0; i < sers.size(); i++){
						ServiceQos temp = computeServiceQos(sers.get(i).getServiceId(), "ServiceReliability");
						reliability *= temp.getReliability();
						availability *= temp.getAvailability();
						serviceTime += temp.getServiceTime();
						serviceCost += temp.getServiceCost();
						busyDegree *= temp.getBusyDegree();
						avgEvaluation += temp.getAvgEvaluation();
						qosValue += temp.getServiceQos();
					}
				}
				else if(s.getCombineType().equalsIgnoreCase("CombineB")){
					for(int i = 0; i < sers.size(); i++){
						ServiceQos temp = computeServiceQos(sers.get(i).getServiceId(), "");
						reliability *= temp.getReliability();
						availability *= temp.getAvailability();
						serviceTime += temp.getServiceTime();
						serviceCost += temp.getServiceCost();
						busyDegree *= temp.getBusyDegree();
						avgEvaluation += temp.getAvgEvaluation();
						qosValue += temp.getServiceQos();
					}
				}
				if(sers.size() > 0) {
					serviceTime /= sers.size();
					serviceCost /= sers.size();
					avgEvaluation /= sers.size();
					qosValue /= sers.size();
				}
				qos.setReliability(reliability);
				qos.setAvailability(availability);
				qos.setServiceTime(serviceTime);
				qos.setServiceCost(serviceCost);
				qos.setBusyDegree(busyDegree);
				qos.setAvgEvaluation(avgEvaluation);
			}
			else{   //流程式组合
				//分析组合流程中所调用的服务，并计算其QoS属性（目前按顺序结构来计算）
				ParseYawlFile yawl = new ParseYawlFile();
				Map<Service, Integer> invokedServices = yawl.analyseCombinedBusiness(s.getBusinessFile());
				Set<Service> services = invokedServices.keySet();
				Iterator it = services.iterator();
				int alltimes = 0;
				while(it.hasNext()){
					Service task = (Service)it.next();
					int times = invokedServices.get(task);
					alltimes += times;
					System.out.println("invoke:"+task.getServiceId()+" " + times);
					ServiceQos temp = computeServiceQos(task.getServiceId(), task.getPreferredTarget());
					availability *= Math.pow(temp.getAvailability(), times);
					busyDegree *= Math.pow(temp.getBusyDegree(), times);
					avgEvaluation += temp.getAvgEvaluation() * times;
					qosValue += temp.getServiceQos()* times;
					//其他属性在注册时已更新
				}
				if(alltimes > 0) {
					avgEvaluation /= alltimes;
					qosValue /= alltimes;
				}
				qos.setReliability(s.getServiceReliability());
				qos.setAvailability(availability);
				qos.setServiceTime(s.getServiceTime());
				qos.setServiceCost(s.getServiceCost());
				qos.setBusyDegree(busyDegree);
				qos.setAvgEvaluation(avgEvaluation);
			}
			qosValue = (double) Math.round(qosValue * 10000) / 10000; //保留4位小数
			System.out.println(qosValue);
			qos.setServiceQos(qosValue);
		}
		return qos;
	}

	/**
	 * 获取所有服务的QoS，
	 * 简单服务没有偏好指标，取平均权重
	 * 组合服务按照偏好指标计算QoS
	 */
	public String getAllServiceQos(){
		allQos.clear();
		List<Service> allsers = srs.getAll();
		for(int i = 0; i < allsers.size(); i++){
			Service s = allsers.get(i);
			ServiceQos qos = new ServiceQos();
			if(s.getCombineType() == null){
				qos = computeServiceQos(s.getServiceId(), null);
			}
			else{
				qos = computeComServiceQos(s.getServiceId());
			}
			allQos.add(qos);
		}
		return SUCCESS;
	}

	/**
	 * 计算简单服务的Qos
	 * @param serviceid     服务ID
	 * @param preferredTarget  qos偏好指标
	 * @return
	 */
	public ServiceQos computeServiceQos(int serviceid, String preferredTarget){
		Service s = srs.getUniqueService(String.valueOf(serviceid));
		double maxReliability = srs.getMaxServiceReliability();
		double minReliability = srs.getMinServiceReliability();
		double maxServicecost = srs.getMaxServiceCost();
		double minServicecost = srs.getMinServiceCost();
		double maxServicetime = srs.getMaxServiceTime();
		double minServicetime = srs.getMinServiceTime();
		double maxAvgEvaluation = evaluationsr.getMaxAvgEvaluation();
		double minAvgEvaluation = evaluationsr.getMinAvgEvaluation();
		//qos计算公式
		MonitorDataFromIstio monitorData = new MonitorDataFromIstio();//从Istio获取可用性和繁忙程度
		double reliability = s.getServiceReliability();
		double serviceCost = s.getServiceCost();
		double serviceTime = s.getServiceTime();
		double avgEvaluation = evaluationsr.getAvgEvaluation(serviceid);
		double original_avgEvaluation = avgEvaluation;
		double availability = 1.0;
		double busyDegree = 0.1;
		if(s.getIsExternal() == 0){ //内部开发的服务
			availability = monitorData.getAvailability(s.getServiceName());
			busyDegree = monitorData.getBusyDegree(s.getServiceName());
		}
		else{  //外部服务只有一个实例
			//计算服务的繁忙程度，为负指标,转化成服务可用实例比例
			int currentScale = 1;
			int currentLoad = runlogsr.getServiceCurrentLoad(serviceid);
			int maxload = s.getMaxLoad() != null? s.getMaxLoad() : Integer.parseInt(default_maxload);
			/*else{    //内部服务需要查询部署的实例数量
				String deployId = "deployment:" + s.getTeam() + "-" + s.getAccessRule() + ":" + s.getServiceName();
				String scaleStr = iwrUtil.getServiceScale(deployId);
				currentScale = Integer.parseInt(scaleStr);
			}*/
			busyDegree = currentLoad * 1.0 / (currentScale * maxload);
		}

		//QoS指标均一化
		if(maxReliability == minReliability){
			reliability = 1;
		}
		else{  //服务可靠性为正指标
			reliability = (reliability - minReliability) / (maxReliability - minReliability);
		}
		if(maxServicecost == minServicecost){
			serviceCost = 1;
		}
		else{   //服务成本为负指标
			serviceCost = (maxServicecost - serviceCost) / (maxServicecost - minServicecost);
		}
		if(maxServicetime == minServicetime){
			serviceTime = 1;
		}
		else{    //服务运行时间为负指标
			serviceTime = (maxServicetime - serviceTime) / (maxServicetime - minServicetime);
		}
		if(maxAvgEvaluation == minAvgEvaluation){
			avgEvaluation = 1;
		}
		else{  //用户平均评分为正指标
			avgEvaluation = (avgEvaluation - minAvgEvaluation) / (maxAvgEvaluation - minAvgEvaluation);
		}
		double original_busyDegree = busyDegree;
		busyDegree = 1.0 - busyDegree;   //转化成服务可用负载比例，正指标

		//QOS权重矩阵
		AHP ahp = new AHP(6, preferredTarget);
		Matrix weights = ahp.getWeights();
		Double qosValue = weights.getData()[0][0] * reliability + weights.getData()[1][0] * availability + weights.getData()[2][0] * serviceTime + weights.getData()[3][0] * serviceCost + weights.getData()[4][0] * busyDegree + weights.getData()[5][0] * avgEvaluation;
		qosValue = (double) Math.round(qosValue * 10000) / 10000; //保留4位小数
		System.out.println(qosValue);

		//不用均一化后的值，给用户显示原始的值
		ServiceQos qos = new ServiceQos(s.getServiceId(), s.getServiceName(), s.getServiceType(), s.getServiceReliability(), availability, s.getServiceTime(), s.getServiceCost(), original_busyDegree, original_avgEvaluation, qosValue);
		return qos;
	}

	/**
	 * 计算相同服务类内服务列表的服务QoS
	 * @param serviceClassId
	 * @param preferredTarget
	 * @return
	 */
	public List<ServiceQos> computeServiceQosInClass(ServiceclassId serviceClassId, String preferredTarget){
		List<ServiceQos>  serQoSs = new ArrayList<ServiceQos>();
		String sersStr = serclasssr.findById(serviceClassId).getServices();
		if(sersStr.isEmpty() == false){
			String[] sers = sersStr.split(",");
			for(int i = 0; i < sers.length; i++){
				if(sers[i].isEmpty() == false){
					Service s = srs.getUniqueService(sers[i]);
					ServiceQos serviceQos = computeServiceQos(s.getServiceId(), preferredTarget);
					serQoSs.add(serviceQos);
				}
			}
		}
		return serQoSs;
	}

	/**
	 * 获取服务类的综合QoS，为其服务的平均QoS
	 * @param serviceClassId
	 * @param preferredTarget
	 * @return
	 */
	public double getQosInClass(ServiceclassId serviceClassId, String preferredTarget){
		double qosValue = 0;
		List<ServiceQos>  serQoSs = computeServiceQosInClass(serviceClassId, preferredTarget);
		for(int i = 0; i < serQoSs.size(); i++){
			qosValue += serQoSs.get(i).getServiceQos();
		}
		if(serQoSs.size() != 0){
			qosValue /= serQoSs.size();
		}
		return qosValue;
	}

	/**
	 * 针对指定服务类（功能相同）内的各服务按综合QoS排序
	 * @param serviceType
	 * @param serviceTarget
	 * @param serviceRange
	 * @return
	 */
	/*public List<ServiceQos> groupInServiceclass(String serviceType, String serviceTarget, String serviceRange){
		ServiceclassId classid = new ServiceclassId(serviceType, serviceTarget, serviceRange);
		Serviceclass serclass = serclasssr.findById(classid);
		String servicesInClass = serclass.getServices();
		String[] sers = servicesInClass.split(",");
		List<ServiceQos> qosList = new ArrayList<ServiceQos>();
		for(int i = 0; i < sers.length; i++){
			if(sers[i].length() != 0){
				Service s = srs.getUniqueService(sers[i]);
				double w1 = 0.167, w2 = 0.167, w3 = 0.167, w4 = 0.167, w5 = 0.167, w6 = 0.165;   //各QoS指标的权重
				qosList.add(computeServiceQos(s.getServiceId(), w1, w2, w3, w4, w5, w6));
			}
		}
		//按照服务综合Qos降序排序
		ListSortUtil<ServiceQos> sortList = new ListSortUtil<ServiceQos>();
		sortList.sort(qosList, "serviceQos", "desc");
		return qosList;

		//分组呢？？？
	}*/

	/**
	 * 分析流程结构并保存到数据库
	 * @param
	 */
	/*public void analyzeProcess(Service process){
		String processfile = process.getBusinessFile();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String loginUser = (String) session.get("user");
		String loginPassword = (String) session.get("password");
		ParseYawlFile yawl = new ParseYawlFile();
		yawl.getSpecRoleOrUser(loginUser, loginPassword, processfile);

		//还需解析流程结构，按公式计算相关QoS指标属性。。。。引擎分析？？？？

		//取出子服务
		Service s1, s2, s3;
		Double reliability, servicecost, servicetime, avgEvaluation;
		//是否加事务属性？：补偿、重试、pivot、可取消的
		//顺序
		reliability  = s1.getServiceReliability() * s2.getServiceReliability() * s3.getServiceReliability();
		servicecost = s1.getServiceCost() + s2.getServiceCost() + s3.getServiceCost();
		servicetime = Double.parseDouble(s1.getServiceTime()) + Double.parseDouble(s2.getServiceTime()) + Double.parseDouble(s3.getServiceTime());
		avgEvaluation = Math.min(evaluationsr.getAvgEvaluation(s1.getServiceId()), evaluationsr.getAvgEvaluation(s2.getServiceId()), evaluationsr.getAvgEvaluation(s3.getServiceId()));

		Double p1, p2, p3;
		//选择
		reliability  = p1 * s1.getServiceReliability() + p2 * s2.getServiceReliability() + p3 * s3.getServiceReliability();
		servicecost = p1 * s1.getServiceCost() + p2 * s2.getServiceCost() + p3 * s3.getServiceCost();
		servicetime = p1 * Double.parseDouble(s1.getServiceTime()) + p2 * Double.parseDouble(s2.getServiceTime()) + p3 * Double.parseDouble(s3.getServiceTime());
		avgEvaluation = p1 * evaluationsr.getAvgEvaluation(s1.getServiceId()) + p2 * evaluationsr.getAvgEvaluation(s2.getServiceId()) + p3 * evaluationsr.getAvgEvaluation(s3.getServiceId());

		//并行
		reliability  = Math.min(s1.getServiceReliability(), s2.getServiceReliability(), s3.getServiceReliability());
		servicecost = s1.getServiceCost() + s2.getServiceCost() + s3.getServiceCost();
		servicetime = Math.max(Double.parseDouble(s1.getServiceTime()), Double.parseDouble(s2.getServiceTime()), Double.parseDouble(s3.getServiceTime()));
		avgEvaluation = Math.min(evaluationsr.getAvgEvaluation(s1.getServiceId()), evaluationsr.getAvgEvaluation(s2.getServiceId()), evaluationsr.getAvgEvaluation(s3.getServiceId()));

		int iteration_num;
		//循环
		reliability  = Math.pow(s1.getServiceReliability(), iteration_num);
		servicecost = iteration_num * s1.getServiceCost();
		servicetime = iteration_num * Double.parseDouble(s1.getServiceTime());
		avgEvaluation = evaluationsr.getAvgEvaluation(s1.getServiceId());

		to do ....

		//多个组合方案怎么保存？？？要有备选集
		//若运行失败，重新分析提供方案？？

		//协调机制？？？

	}*/


	public String getApplyService(){
		int userid = Integer.parseInt(nowuser);
		appliedservices.clear();
		List<Service> allsers = srs.getAllService();
		List<Service> mysers = getMyService(userid);
		allsers.removeAll(mysers);   //没有使用权限的服务
		List<Temp> tempsers = tempSr.findyByUserId(userid);
		List<Service> appliedsers = new ArrayList<Service>(); //已申请但未审批的服务
		for(int i = 0; i < tempsers.size(); i++){
			appliedsers.add(srs.getUniqueService(tempsers.get(i).getServiceId().toString()));
		}
		List<UserSpecSer> specsers = userSpecSr.findSpecSerByUserId(userid);
		List<Service> hadsers = new ArrayList<Service>();  //已申请成功的服务
		for(int i = 0; i < specsers.size(); i++){
			hadsers.add(specsers.get(i).getService());
		}
		allsers.addAll(hadsers); //整体的申请服务列表
		for(int i = 0; i < allsers.size(); i++){
			Service ser = allsers.get(i);
			if(appliedsers.contains(ser)){
				ser.setServiceState("auditing&cancel");
			}
			else if(hadsers.contains(ser)){
				ser.setServiceState("applied&remove");
			}
			else{
				ser.setServiceState("applicable&add");
			}
			appliedservices.add(ser);
		}
		return SUCCESS;
	}


	//  getter setter
	public String getApplyString() {
		return applyString;
	}

	public void setApplyString(String applyString) {
		this.applyString = applyString;
	}

	public UserService getUserSr() {
		return userSr;
	}

	public void setUserSr(UserService userSr) {
		this.userSr = userSr;
	}

	public RoleService getRolesr() {
		return rolesr;
	}

	public void setRolesr(RoleService rolesr) {
		this.rolesr = rolesr;
	}

	public TempService getTempSr() {
		return tempSr;
	}

	public void setTempSr(TempService tempSr) {
		this.tempSr = tempSr;
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

	public Serviceresult getSrt() {
		return srt;
	}

	public void setSrt(Serviceresult srt) {
		this.srt = srt;
	}

	public ServiceresultService getSrresultsr() {
		return srresultsr;
	}

	public void setSrresultsr(ServiceresultService srresultsr) {
		this.srresultsr = srresultsr;
	}

	public String getNowuser() {
		return nowuser;
	}

	public void setNowuser(String nowuser) {
		this.nowuser = nowuser;
	}

	public PermissionServiceService getPermissionservicesr() {
		return permissionservicesr;
	}

	public void setPermissionservicesr(PermissionServiceService permissionservicesr) {
		this.permissionservicesr = permissionservicesr;
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

	public String getInctns() {
		return inctns;
	}

	public void setInctns(String inctns) {
		this.inctns = inctns;
	}

	public String getInvars() {
		return invars;
	}

	public void setInvars(String invars) {
		this.invars = invars;
	}

	public String getInrange() {
		return inrange;
	}

	public void setInrange(String inrange) {
		this.inrange = inrange;
	}


	public String getInbusiness() {
		return inbusiness;
	}

	public void setInbusiness(String inbusiness) {
		this.inbusiness = inbusiness;
	}

	public String getInpts() {
		return inpts;
	}

	public void setInpts(String inpts) {
		this.inpts = inpts;
	}

	public String getIntype() {
		return intype;
	}

	public void setIntype(String intype) {
		this.intype = intype;
	}

	public String getInlevel() {
		return inlevel;
	}

	public void setInlevel(String inlevel) {
		this.inlevel = inlevel;
	}

	public String getInname() {
		return inname;
	}

	public void setInname(String inname) {
		this.inname = inname;
	}

	public String getIntt() {
		return intt;
	}

	public void setIntt(String intt) {
		this.intt = intt;
	}

	public String getInadd() {
		return inadd;
	}

	public void setInadd(String inadd) {
		this.inadd = inadd;
	}

	public String getIndesc() {
		return indesc;
	}

	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

    public File getSpecificationFile() {
        return specificationFile;
    }

    public void setSpecificationFile(File specificationFile) {
        this.specificationFile = specificationFile;
    }

    public String getServiceQoSOptimizationTarget() {
		return serviceQoSOptimizationTarget;
	}


	public void setServiceQoSOptimizationTarget(String serviceQoSOptimizationTarget) {
		this.serviceQoSOptimizationTarget = serviceQoSOptimizationTarget;
	}


	public List<Parameter> getPrts() {
		return prts;
	}

	public void setPrts(List<Parameter> prts) {
		this.prts = prts;
	}

	public ParameterService getParametersr() {
		return parametersr;
	}

	public void setParametersr(ParameterService parametersr) {
		this.parametersr = parametersr;
	}

	public String getUserviceid() {
		return userviceid;
	}

	public void setUserviceid(String userviceid) {
		this.userviceid = userviceid;
	}

	public List<DTreeNode> getDtnodes() {
		return dtnodes;
	}

	public void setDtnodes(List<DTreeNode> dtnodes) {
		this.dtnodes = dtnodes;
	}

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
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

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public List<Condition> getC() {
		return c;
	}

	public void setC(List<Condition> c) {
		this.c = c;
	}

	public List<Variable> getV() {
		return v;
	}

	public void setV(List<Variable> v) {
		this.v = v;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Service getSr() {
		return sr;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
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

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceScale() {
		return serviceScale;
	}

	public void setServiceScale(String serviceScale) {
		this.serviceScale = serviceScale;
	}

	public String getDockerImage() {
		return dockerImage;
	}

	public void setDockerImage(String dockerImage) {
		this.dockerImage = dockerImage;
	}

	public String getAccessRule() {
		return accessRule;
	}

	public void setAccessRule(String accessRule) {
		this.accessRule = accessRule;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setSr(Service sr) {
		this.sr = sr;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	public String getServiceCost() {
		return serviceCost;
	}


	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}


	public String getServiceReliability() {
		return serviceReliability;
	}


	public void setServiceReliability(String serviceReliability) {
		this.serviceReliability = serviceReliability;
	}


	public String getMaxLoad() {
		return maxLoad;
	}

	public String getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(String isExternal) {
		this.isExternal = isExternal;
	}


	public void setMaxLoad(String maxLoad) {
		this.maxLoad = maxLoad;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}


	public List<Service> getSelected() {
		return selected;
	}

	public void setSelected(List<Service> selected) {
		this.selected = selected;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public List<String> getInterest() {
		return interest;
	}

	public void setInterest(List<String> interest) {
		this.interest = interest;
	}

	public ServicerelationService getSrrelationsr() {
		return srrelationsr;
	}

	public void setSrrelationsr(ServicerelationService srrelationsr) {
		this.srrelationsr = srrelationsr;
	}


	public List<Service> getAllsers() {
		return allsers;
	}

	public void setAllsers(List<Service> allsers) {
		this.allsers = allsers;
	}

	public List<Service> getAcceptedservices() {
		return acceptedservices;
	}

	public void setAcceptedservices(List<Service> acceptedservices) {
		this.acceptedservices = acceptedservices;
	}


	public List<Service> getAppliedservices() {
		return appliedservices;
	}


	public void setAppliedservices(List<Service> appliedservices) {
		this.appliedservices = appliedservices;
	}


	public List<ServiceQos> getAllQos() {
		return allQos;
	}


	public void setAllQos(List<ServiceQos> allQos) {
		this.allQos = allQos;
	}


	public List<Service> getRanklistByRuntimes() {
		return ranklistByRuntimes;
	}

	public void setRanklistByRuntimes(List<Service> ranklistByRuntimes) {
		this.ranklistByRuntimes = ranklistByRuntimes;
	}

	public List<Service> getProvidedservices() {
		return providedservices;
	}

	public void setProvidedservices(List<Service> providedservices) {
		this.providedservices = providedservices;
	}

	public List<Service> getCalledservices() {
		return calledservices;
	}

	public void setCalledservices(List<Service> calledservices) {
		this.calledservices = calledservices;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getQueryserviceid() {
		return queryserviceid;
	}

	public void setQueryserviceid(String queryserviceid) {
		this.queryserviceid = queryserviceid;
	}

	public String getQueryServiceresult() {
		return queryServiceresult;
	}

	public void setQueryServiceresult(String queryServiceresult) {
		this.queryServiceresult = queryServiceresult;
	}


	public EvaluationService getEvaluationsr() {
		return evaluationsr;
	}

	public void setEvaluationsr(EvaluationService evaluationsr) {
		this.evaluationsr = evaluationsr;
	}

	public LicenceService getLicencesr() {
		return licencesr;
	}

	public void setLicencesr(LicenceService licencesr) {
		this.licencesr = licencesr;
	}

	public RunlogService getRunlogsr() {
		return runlogsr;
	}

	public void setRunlogsr(RunlogService runlogsr) {
		this.runlogsr = runlogsr;
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


	public AttachmentService getAttachmentsr() {
		return attachmentsr;
	}

	public void setAttachmentsr(AttachmentService attachmentsr) {
		this.attachmentsr = attachmentsr;
	}

	public String getSpecJson() {
		return specJson;
	}

	public void setSpecJson(String specJson) {
		this.specJson = specJson;
	}

	public String getSelectedtype() {
		return selectedtype;
	}

	public void setSelectedtype(String selectedtype) {
		this.selectedtype = selectedtype;
	}

	public String getSelectedbusiness() {
		return selectedbusiness;
	}

	public void setSelectedbusiness(String selectedbusiness) {
		this.selectedbusiness = selectedbusiness;
	}

	public List<String> getServicetypes() {
		return servicetypes;
	}

	public void setServicetypes(List<String> servicetypes) {
		this.servicetypes = servicetypes;
	}

	public List<String> getServicebusinesses() {
		return servicebusinesses;
	}

	public void setServicebusinesses(List<String> servicebusinesses) {
		this.servicebusinesses = servicebusinesses;
	}


	public ServicelinksService getSerlinkssr() {
		return serlinkssr;
	}


	public void setSerlinkssr(ServicelinksService serlinkssr) {
		this.serlinkssr = serlinkssr;
	}


	public ServiceclassService getSerclasssr() {
		return serclasssr;
	}


	public void setSerclasssr(ServiceclassService serclasssr) {
		this.serclasssr = serclasssr;
	}

}