package com.action;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hsqldb.lib.HashSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.Request;
import sun.util.logging.resources.logging;

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
import com.bean.ServiceDAO;
import com.bean.Servicerelation;
import com.bean.Serviceresult;
import com.bean.SimpleService;
import com.bean.SpecTaskRoleUser;
import com.bean.Specification;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserRole;
import com.bean.UserSpecSer;
import com.bean.Variable;
import com.server.ServiceInfo;
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
import com.service.ServicerelationService;
import com.service.ServiceresultService;
import com.service.SpecTaskRoleUserService;
import com.service.SpecificationService;
import com.service.TempService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.UserSpecSerService;
import com.service.VariableService;
import com.util.BuiltInVar;
import com.util.DTreeNode;
import com.util.GetRemoteService;
import com.util.MuleXMLParser;
import com.util.ParseYawlFile;
import com.util.graph.CycleDetector;
import com.util.graph.DirectedGraph;


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
	
	

	private UserRoleService userrolesr;
	private RolePermissionService rolepermissionsr;
	private PermissionServiceService permissionservicesr;
	private ServiceresultService srresultsr;
	private Serviceresult srt;
	private ServicerelationService srrelationsr;
	
	String maxLoad;
	String option1;
	String option2;
	File myFile;
	File uploadFile;
	
	String sch;
	String nowuser;
	
	List<Service> services = new ArrayList<Service>();
	List<Service> allsers = new ArrayList<Service>();
	List<Service> acceptedservices = new ArrayList<Service>();
	List<Service> selected = new ArrayList<Service>();
	List<Service> ranklistByRuntimes = new ArrayList<Service>();
	List<Service> providedservices = new ArrayList<Service>();
	List<Service> calledservices = new ArrayList<Service>();
	
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
    
	String serviceid = "";	

	private String queryserviceid = "";
	private String queryServiceresult = "";

	EvaluationService evaluationsr = new EvaluationService();
	LicenceService licencesr = new LicenceService();
	RunlogService runlogsr = new RunlogService();
	SpecificationService specsr;
	SpecTaskRoleUserService strusr = new SpecTaskRoleUserService();
	AttachmentService attachmentsr = new AttachmentService();
	
	String specJson = "";
	String specid;
	
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
			//if(srt != null)
			//{
			srt.setServiceid(Integer.parseInt(serviceid));
			srt.setService(srs.getUniqueService(serviceid));
			this.srresultsr.addServiceresult(srt);
			Service s = new Service();     //改配置之后，更新该服务的审核状态
			s = srs.getUniqueService(serviceid);
			if(s.getServiceState() != "NO"){
				s.setServiceState("NO");
				srs.update(s);
			}
			//}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String register(){
		/*ParseYawlFile yawl = new ParseYawlFile();
		List<SpecTaskRoleUser> strulist = new ArrayList<SpecTaskRoleUser>();
		strulist = yawl.getSpecRoleOrUser("E:/mule-standalone-3.3.1/apps/mmn.yawl");
		for(int i = 0; i < strulist.size(); i++){
			strusr.addSpecTaskRoleUser(strulist.get(i));
		}*/
		
		/*ServiceInfo.getProvidedAppAndSpec(1);
		ServiceInfo.getProvidedAppication(1);
		ServiceInfo.getServiceFromRole(1);
		ServiceInfo.getSpecRoleFromSpec("www");
		
		ServiceInfo.getAllSpec(1);
		ServiceInfo.getMySpec(1);
		ServiceInfo.loadAllSpec();*/
		
		if(maxLoad.isEmpty() || maxLoad == null) maxLoad = default_maxload;
		sr.setMaxLoad(Integer.valueOf(maxLoad));
		sr.setServiceState("NO");
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		sr.setServiceProvider(nowuser);
		try{
            //String realpath = ServletActionContext.getServletContext().getRealPath("/files");
            //System.out.println("realpath: "+realpath);
    		String realpath = MuleConfig.getMuleAppPath() + "/" + sr.getServiceName();
			realpath = realpath.replaceAll("\\\\", "/");
			
            if (myFile != null && myFile.length() != 0) {
            	System.out.println("\n!!!!!realpath: "+realpath+"\n");
            	
            	String filename = sr.getServiceName() + ".yawl";
            	//realpath = realpath + "/" + sr.getServiceName();
            	//String filename = uploadFile.getName();
                File savefile = new File(new File(realpath), filename);
                if (!savefile.getParentFile().exists())
                {
                    savefile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(myFile, savefile);
                MuleXMLParser.parse(savefile);
                ActionContext.getContext().put("message", "文件上传成功");
                //sr.setBusinessFile(realpath + "/business.xml");
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
					// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
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
	    		//getSpecRole(sr.getBusinessFile()); //解析流程文件
	    		try{
	    			ParseYawlFile yawl = new ParseYawlFile();
	    			yawl.getSpecRoleOrUser(sr.getBusinessFile());
	    			
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
							// TODO Auto-generated catch block
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
	    	return SUCCESS;
		}
		return ERROR;
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
			//System.out.println(services.size());
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
			//System.out.println(services.size());
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
				sr.setServiceState("NULL");
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
				
				List<Servicerelation> servicerelations = new ArrayList<Servicerelation>();
				servicerelations = srrelationsr.getSrrelationDao().findByServiceId(Integer.parseInt(option1));
				for(int i = 0; i < servicerelations.size(); i++){
					srrelationsr.getSrrelationDao().delete(servicerelations.get(i));
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
				
				String filepath = sr.getAttachments();
				if(filepath != null){
					List<Attachment> attaches = new ArrayList<Attachment>();
					attaches = attachmentsr.findByFilepath(filepath);
					for(int i = 0; i < attaches.size(); i++){
						attachmentsr.deleteAttachment(attaches.get(i));
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
	         
	        OutputStream os = new FileOutputStream("E:\\myeclipse_projects\\SSH_Prototype_J2EE_5.0\\WebRoot\\images\\company.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
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
        dpd.setValue("APPLICATION " + counter[0], counter[0] * 100 / services.size());  //输入数据
        dpd.setValue("SERVICE " + counter[1], counter[1] * 100 / services.size());
        dpd.setValue("BUSINESS " + counter[2], counter[2] * 100 / services.size());
        dpd.setValue("LOCAL " + counter[3], counter[3] * 100 / services.size());
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
			
			//System.out.println(services.size());
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
				if(services.get(i).getCombineType() != null)// .getServiceType().equals("Combine"))
				{
					Integer id = services.get(i).getServiceId();
					//System.out.println(id);
					//conditionsr.getAllCondition();
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
		//System.out.println(nowuser);
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("admin").equals("true")){//管理员拥有所有的服务
			services = srs.getAll();   //Service();
		}else{
			services=getMyService(Integer.parseInt(nowuser));
		}
		return SUCCESS;
	}
	
	public List<Service> getMyService(int userid)
	{
		services.clear();
		List<Integer> rs = new ArrayList<Integer>();
		List<UserRole> urs = new ArrayList<UserRole>();
		for(UserSpecSer uss:userSpecSr.findSpecSerByUserId(userid)){
			services.add(uss.getService());
		}
		//services=userSpecSr.findSpecSerByUserId(userid);
		urs = userrolesr.getUserRole(userid);
		rs.clear();
		for(int i = 0; i < urs.size(); i++)
		{
			rs.add(urs.get(i).getRole().getRoleId());
		}
		//rs = getApplicationRoles();
		
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
		
		//包括自己注册的服务
		List<Service> provided = new ArrayList<Service>();
		provided = srs.getProvidedService(String.valueOf(userid));
		provided.removeAll(services);
		services.addAll(provided);
		
		//同时要是审核通过的服务
		List<Service> accepted = new ArrayList<Service>();
		accepted = srs.getAcceptedService();
		services.retainAll(accepted);
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
	
	
	
	public String combineAService()
	{
		acceptedservices = srs.getAcceptedService();
		List<Service> ser = srs.getAllService();
		acceptedservices.retainAll(ser);
		allsers.clear();
		allsers = srs.getAll();
		dtnodes.clear();
		prts.clear();
		try
		{
			services = srs.getAllService();
			List<Integer> num = new ArrayList<Integer>();
			for(int i = 0; i < services.size(); i++)
			{
				num.add(0);
			}
			for(int i = 0; i < services.size() - 1; i++)
			{
				for(int j = i + 1; j < services.size(); j++)
				{
					//组合不是组合服务的服务，暂时不考虑多重组合的问题
					if(services.get(i).getCombineType() == null && services.get(j).getCombineType() == null){
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
		List<Service> ser = srs.getAllService();
		acceptedservices.retainAll(ser);
		
		allsers.clear();
		allsers = srs.getAll();
		try
		{
			services = srs.getAllService();
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
					//组合不是组合服务的服务，暂时不考虑多重组合的问题
					if(services.get(i).getCombineType() == null && services.get(j).getCombineType() == null){
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
	
	public String addCombineA()
	{
		String callservice = inpts.replaceAll("s", ",");
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
		sr.setServiceProvider(nowuser);
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		sr.setCombineType("CombineA");
		
		sr.setCallService(callservice);
		//srs.getSrDAO().save(sr);
		
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
	
	public String addCombineB()
	{
		String callservice = inpts.replaceAll("s", ",");
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
		sr.setServiceProvider(nowuser);
		sr.setRunTimes(0);
		sr.setFailTimes(0);
		sr.setCombineType("CombineB");
		System.out.print(callservice+"\n");
		sr.setCallService(callservice);
		//srs.getSrDAO().save(sr);
		
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
	
	public String conbineServiceB() // 已经被弃用了
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
					&&	(false == services.get(i).getServiceRange().equals(services.get(j).getServiceRange()))
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
			
			//System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 判断要注册服务的调用关系是否符合规则
	 * @return
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
		/*dg.addNode(sr.getServiceId());                 //要注册的服务已临时存到服务列表里了
		for(int i = 0; i < callservices.length; i++){
			if(callservices[i].length() > 0){
				dg.addNode(Integer.parseInt(callservices[i]));
				dg.addEdge(sr.getServiceId(), Integer.parseInt(callservices[i]));
			}
		}*/
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
		
		/*List<Service> accepted = new ArrayList<Service>();
		accepted = srs.getAcceptedService();
		providedservices.retainAll(accepted);*/
		
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
		JSONArray json = JSONArray.fromObject(positionresult );
		System.out.println(json.toString()+"="+positionresult+"\n") ;
		//Map<String ,String> mp=new HashMap<String,String>();
		String positions = "";
	    if(json.size()>0){
	    	for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
	    		JSONObject job = json.getJSONObject(i);
				/*mp.put("userId",nowuser);
				mp.put("orgName","测试1组织系统");
				mp.put("appName","服务管理中心");
				mp.put("positions",job.getString("positions"));
				json.add(mp);*/
				System.out.print("positions:"+json.toString());
				positions = job.getString("positions");
				break;
	    	}
	    	
	    }
	    
	    
		List<Integer> myroles = new ArrayList<Integer>();
		List<Role> allroles = new ArrayList<Role>();
		allroles = rolesr.getAllRole();
	    
	   // String rolesresult = grs.postForm(url, nowuser, "测试1组织系统", "服务管理中心", positions) 
		String rolesresult = grs.getApplicationRoles(json.toString());
		System.out.println(json.toString()+"="+rolesresult+"\n") ;
		/*String[] roles = rolesresult.split(",");
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
			
		}*/
		
		if(json.size()>0){
			for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
				JSONObject job = json.getJSONObject(i); 
	            for(int j = 0; j < allroles.size(); j++){
	            	 if(job.getString("busiName").equals(allroles.get(j).getRoleName())){
	            		 Role role = new Role();
	            		 role = allroles.get(j);
	            		 myroles.add(role.getRoleId());
		             }
	            }
	             
	       }
	    }
		
	    return myroles;
	}

	/**
	 * 根据流程id获取业务角色
	 * @return
	 */
	public String getSpecRoleFromSpec(){
		ServiceInfo si = new ServiceInfo();
		try{
			specJson = si.getSpecRoleFromSpec(specid);
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
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
		for(int i = 0; i < dtnodes.size(); i++){
			int father = dtnodes.get(i).getFather();
			String content = dtnodes.get(i).getContent();
			String sid = content.substring(content.lastIndexOf(" ")+1, content.length());
			for(int j = 0; j < subsers.size(); j++){
				if(subsers.get(j).equalsIgnoreCase(sid)){ 
					if(fathers.contains(father) == false){
						fathers.add(father);
					}
					subsers.remove(j);
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

	public void setSr(Service sr) {
		this.sr = sr;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	public String getMaxLoad() {
		return maxLoad;
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

	public String getSpecid() {
		return specid;
	}

	public void setSpecid(String specid) {
		this.specid = specid;
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
	
}





