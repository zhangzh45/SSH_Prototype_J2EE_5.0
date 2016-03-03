package com.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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
import org.json.JSONArray;

import sun.misc.Request;

import com.mule.MuleConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bean.Condition;
import com.bean.Parameter;
import com.bean.PermissionService;
import com.bean.Role;
import com.bean.RolePermission;
import com.bean.RoleSpecSer;
import com.bean.Service;
import com.bean.ServiceDAO;
import com.bean.Serviceresult;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserRole;
import com.bean.UserSpecSer;
import com.bean.Variable;
import com.service.ConditionService;
import com.service.EvaluationService;
import com.service.ParameterService;
import com.service.PermissionServiceService;
import com.service.RolePermissionService;
import com.service.RoleSpecSerService;
import com.service.SerService;
import com.service.ServiceresultService;
import com.service.TempService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.UserSpecSerService;
import com.service.VariableService;
import com.util.BuiltInVar;
import com.util.DTreeNode;
import com.util.MuleXMLParser;


public class ServiceAction extends ActionSupport{
	
	private Service sr=new Service();
	private SerService srs;
	private ConditionService conditionsr;
	private VariableService variablesr;
	private ParameterService parametersr;
	private UserSpecSerService userSpecSr;
	private TempService tempSr;
	private RoleSpecSerService roleSpecSr;
	private UserService userSr;
	private String applyString;
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

	private UserRoleService userrolesr;
	private RolePermissionService rolepermissionsr;
	private PermissionServiceService permissionservicesr;
	private ServiceresultService srresultsr;
	private Serviceresult srt;
	
	String maxLoad;
	String option1;
	String option2;
	File myFile;
	
	String sch;
	String nowuser;
	
	List<Service> services = new ArrayList<Service>();
	List<Service> selected = new ArrayList<Service>();
	
	List<Condition> conditions = new ArrayList<Condition>();
	List<Variable> variables = new ArrayList<Variable>();
	
	List<Condition> c = new ArrayList<Condition>();
	List<Variable> v = new ArrayList<Variable>();
	
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
    private String inpts;
    private String inrange;
    
    private String inctns;
    private String invars;
    
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

	public Service getSr() {
		return sr;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
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
	
	public String addOutput()
	{
		try
		{
			if(srt != null)
			{
				this.srresultsr.addServiceresult(srt);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String register(){
		//execute();
		sr.setMaxLoad(Integer.valueOf(maxLoad));
		sr.setServiceState("NO");
		sr.setRunTimes(0);
		sr.setFailTimes(0);
    	this.srs.register(sr);
    	
    	System.out.println("ok!");
    	try
    	{
            //String realpath = ServletActionContext.getServletContext().getRealPath("/files");
            //System.out.println("realpath: "+realpath);
    		String realpath = MuleConfig.getMuleAppPath() + "/"+sr.getServiceName();
            if (myFile != null) {
                File savefile = new File(new File(realpath), "mule-config.xml");
                if (!savefile.getParentFile().exists())
                {
                    savefile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(myFile, savefile);
                MuleXMLParser.parse(savefile);
                ActionContext.getContext().put("message", "文件上传成功");
            }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
 		
    	return SUCCESS;
    }
	
	

	public String execute()
	{
		//ServiceDAO serviceDao = new ServiceDAO(); 
		
		//ActionContext.getContext().getSession().put("nimei", nimei);
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
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("ss", ss);
	}
	
	public String approveService(){
		List<Temp> tempList=tempSr.getAll();
		JSONArray json=new JSONArray();
		for(int i=0;i<tempList.size();i++){
			Map<String,String> map=new HashMap<String,String>();
			Temp temp=tempList.get(i);
			User user=userSr.getUniqueUser(temp.getUserId());
			Service service=srs.getUniqueService(temp.getServiceId().toString());
			map.put("tempId", temp.getTempId().toString());
			map.put("applyId", user.getUserId().toString());
			map.put("applyName", user.getUserName());
			map.put("applyType", user.getUserType());
			map.put("serviceId", service.getServiceId().toString());
			map.put("serviceName", service.getServiceName());
			map.put("serviceType", service.getServiceType());
			map.put("serviceDesc", service.getServiceDesc());
			map.put("serviceLevel", service.getServiceLevel());
			json.put(map);
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
		try
		{
			services = srs.getAcceptedService();
			System.out.println(services.size());
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
	
	public String getWebService()
	{
		try
		{
			services = srs.getWebService();
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

	public String getURL()
	{
		try
		{
			services = srs.getURLService();
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
			services = srs.getAllService();
			System.out.println(services.size());
			
			JFreeChart chart=ChartFactory.createPieChart("Service Type",getDataset(),true,true,false);
	        //chart.setTitle(new TextTitle("某公司组织结构图",new Font("宋体",Font.BOLD+Font.ITALIC,20)));
	        
	        LegendTitle legend=chart.getLegend(0);//设置Legend
	        //legend.setItemFont(new Font("宋体",Font.BOLD,14));
	        PiePlot plot=(PiePlot) chart.getPlot();//设置Plot
	        //plot.setLabelFont(new Font("隶书",Font.BOLD,16));
	         
	        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\SSH_Prototype_J2EE_5.0\\images\\company.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
	        ChartUtilities.writeChartAsJPEG(os, chart, 500, 400);
	        //使用一个面向application的工具类，将chart转换成JPEG格式的图片。第3个参数是宽度，第4个参数是高度。
	        
	        os.close();//关闭输出流
	        System.out.println("");
	        //return chart;
			
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	private DefaultPieDataset getDataset()
    {
        DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
        int counter[] = {0,0,0,0};
        services = srs.getAllService();
        for(int i = 0; i < services.size(); i++)
        {
        	if(services.get(i).getServiceType().equals("Web"))
        	{
        		counter[0]++;
        	}
        	else if(services.get(i).getServiceType().equals("URL"))
        	{
        		counter[1]++;
        	}
        	else if(services.get(i).getServiceType().equals("Local"))
        	{
        		counter[2]++;
        	}
        	else
        	{
        		counter[3]++;
        	}
        }
        dpd.setValue("WebService " + counter[0], counter[0] * 100 / services.size());  //输入数据
        dpd.setValue("URL " + counter[1], counter[1] * 100 / services.size());
        dpd.setValue("LocalAPP " + counter[2], counter[2] * 100 / services.size());
        dpd.setValue("Other " + counter[3], counter[3] * 100 / services.size());
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
				if(services.get(i).getServiceType().equals("Combine"))
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
		
		services=getMyService(Integer.parseInt(nowuser));
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
				List<PermissionService> pss = new ArrayList<PermissionService>();
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
		return services;
	}
	
	public String combineAService()
	{
		dtnodes.clear();
		prts.clear();
		
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
				String ct2 = ct + selected.get(i).getServiceTarget();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(selected.get(i).getServiceTarget());
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				String ct3 = ct2 + selected.get(i).getServiceRange();
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
			
			//System.out.println(services.size());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		
		
		//return SUCCESS;
	}
	
	public String combineBService()
	{
		
		try
		{
			services = srs.getAllService();
			dtnodes.clear();
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
				String ct2 = ct + selected.get(i).getServiceTarget();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(selected.get(i).getServiceTarget());
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				String ct3 = ct2 + selected.get(i).getServiceRange();
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
			//System.out.println(services.size());
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
		sr = new Service();
		
		sr.setServiceAddress(inadd);
		sr.setServiceTarget(intt);
		sr.setServiceDesc(indesc);
		sr.setServiceName(inname);
		sr.setServiceType(intype);
		sr.setServiceRange(inrange);
		
		srs.getSrDAO().save(sr);
		
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
			}
		}
		
		System.out.print(BuiltInVar.getVarValue("year"));
		
		return SUCCESS;
	}
	
	public String addCombineB()
	{
		sr = new Service();
		
		sr.setServiceAddress(inadd);
		sr.setServiceTarget(intt);
		sr.setServiceDesc(indesc);
		sr.setServiceName(inname);
		sr.setServiceType(intype);
		sr.setServiceRange(inrange);
		
		srs.getSrDAO().save(sr);
		
		int sid = sr.getServiceId();
		
		String[] ss = inpts.split("s");
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
				conditionsr.getConditionDao().save(cc);
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
		
		//System.out.print(BuiltInVar.getVarValue("year"));
		
		return SUCCESS;
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
}
