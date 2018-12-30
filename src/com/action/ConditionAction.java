package com.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import java.util.List;
import com.bean.Condition;
import com.bean.Parameter;
import com.bean.Service;
import com.bean.Servicelinks;
import com.bean.Servicerelation;
import com.bean.Variable;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ConditionService;
import com.service.SerService;
import com.service.ServicelinksService;
import com.service.ServicerelationService;
import com.service.VariableService;
import com.service.ParameterService;
import com.util.CallRelationInf;
import com.util.DTreeNode;
import com.util.TopoInf;
import com.util.RelationInf;


public class ConditionAction extends ActionSupport
{
	private ConditionService conditionsr = new ConditionService();
	private SerService srs = new SerService();
	private VariableService variablesr = new VariableService();
	private ParameterService parametersr = new ParameterService();
	private ServicerelationService srrelationsr;
	private ServicelinksService serlinkssr = new ServicelinksService();

	String option1;
	String option2;
	String option3;
	
	String opt1;
	String opt2;
	
	String var1;

	String e1;
	String e2;
	
	String relationFather;
	String serviceGranularity;
	
	List<Service> services = new ArrayList<Service>();
	List<Service> allservices = new ArrayList<Service>();
	List<Service> combinedservices = new ArrayList<Service >();
	
	List<Condition> conditions = new ArrayList<Condition>();
	List<Servicerelation> srrelations = new ArrayList<Servicerelation>();
	List<TopoInf> topo = new ArrayList<TopoInf>();
	List<RelationInf> relations = new ArrayList<RelationInf>();
	List<CallRelationInf> callrelations = new ArrayList<CallRelationInf>();
	List<CallRelationInf> calldetails = new ArrayList<CallRelationInf>();
	
	List<String> combineServices = new ArrayList<String>();
	List<Integer> combineTimes = new ArrayList<Integer>();
	
	
	String numOfLevelclass = "";
	

	public String getNumOfLevelclass() {
		return numOfLevelclass;
	}

	public void setNumOfLevelclass(String numOfLevelclass) {
		this.numOfLevelclass = numOfLevelclass;
	}

	public ParameterService getParametersr() {
		return parametersr;
	}

	public void setParametersr(ParameterService parametersr) {
		this.parametersr = parametersr;
	}

	public String getRelationFather() {
		return relationFather;
	}

	public void setRelationFather(String relationFather) {
		this.relationFather = relationFather;
	}
	
	public String getServiceGranularity() {
		return serviceGranularity;
	}

	public void setServiceGranularity(String serviceGranularity) {
		this.serviceGranularity = serviceGranularity;
	}

	public List<RelationInf> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationInf> relations) {
		this.relations = relations;
	}

	public List<CallRelationInf> getCallrelations() {
		return callrelations;
	}

	public void setCallrelations(List<CallRelationInf> callrelations) {
		this.callrelations = callrelations;
	}

	public List<CallRelationInf> getCalldetails() {
		return calldetails;
	}

	public void setCalldetails(List<CallRelationInf> calldetails) {
		this.calldetails = calldetails;
	}

	public List<String> getCombineServices() {
		return combineServices;
	}

	public void setCombineServices(List<String> combineServices) {
		this.combineServices = combineServices;
	}

	public List<Integer> getCombineTimes() {
		return combineTimes;
	}

	public void setCombineTimes(List<Integer> combineTimes) {
		this.combineTimes = combineTimes;
	}

	public List<TopoInf> getTopo() {
		return topo;
	}

	public void setTopo(List<TopoInf> topo) {
		this.topo = topo;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public ConditionService getConditionsr() {
		return conditionsr;
	}

	public void setConditionsr(ConditionService conditionsr) {
		this.conditionsr = conditionsr;
	}

	
	public ServicelinksService getSerlinkssr() {
		return serlinkssr;
	}

	public void setSerlinkssr(ServicelinksService serlinkssr) {
		this.serlinkssr = serlinkssr;
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

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Service> getAllservices() {
		return allservices;
	}

	public void setAllservices(List<Service> allservices) {
		this.allservices = allservices;
	}
	
	public VariableService getVariablesr() {
		return variablesr;
	}

	public void setVariablesr(VariableService variablesr) {
		this.variablesr = variablesr;
	}

	public String getVar1() {
		return var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	public String getE1() {
		return e1;
	}

	public void setE1(String e1) {
		this.e1 = e1;
	}

	public String getE2() {
		return e2;
	}

	public void setE2(String e2) {
		this.e2 = e2;
	}
	
	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	
	public ServicerelationService getSrrelationsr() {
		return srrelationsr;
	}

	public void setSrrelationsr(ServicerelationService srrelationsr) {
		this.srrelationsr = srrelationsr;
	}
	
	public List<Servicerelation> getSrrelations() {
		return srrelations;
	}

	public void setSrrelations(List<Servicerelation> srrelations) {
		this.srrelations = srrelations;
	}

	public List<Service> getCombinedservices() {
		return combinedservices;
	}

	public void setCombinedservices(List<Service> combinedservices) {
		this.combinedservices = combinedservices;
	}

	List<DTreeNode> dtnodes = new ArrayList<DTreeNode>();
	List<Service> selected = new ArrayList<Service>();
	
	public List<DTreeNode> getDtnodes() {
		return dtnodes;
	}

	public void setDtnodes(List<DTreeNode> dtnodes) {
		this.dtnodes = dtnodes;
	}
	
	public List<Service> getSelected() {
		return selected;
	}

	public void setSelected(List<Service> selected) {
		this.selected = selected;
	}

	public String saveConbineService()
	{
		Service s = new Service();
		s.setCombineType("Combine");
		//s.setServiceType("Combine");
		s.setServiceTarget("NULL");
		s.setServiceRange("NULL");
		int id = srs.register(s);
		
		
		Condition c1 = new Condition();
		c1.setCondtionExpression(e1);
		Service service=new Service();
		Service subService=new Service();
		service.setServiceId(Integer.valueOf(opt1));
		c1.setServiceByServiceId(service);
	//	Service subService=new Service();
		service.setServiceId(id);
		c1.setServiceByServiceId(service);
		conditionsr.addCondition(c1);
		
		Condition c2 = new Condition();
		c2.setCondtionExpression(e2);
		
		subService.setServiceId(Integer.valueOf(opt2));
		c2.setServiceBySubServiceId(subService);
		service.setServiceId(id);
		c2.setServiceByServiceId(service);
		conditionsr.addCondition(c2);
		
		Variable v = new Variable();
		
		v.setService(service);
		v.setVariableDesc("...");
		v.setVariableName(var1);
		variablesr.addVariable(v);
		
		return SUCCESS;
	}
	
	public String getServiceRelation() 
	{
		conditions = conditionsr.getAllCondition();
		
		topo.clear();
		for(int i = 0; i < conditions.size(); i++)
		{
			TopoInf t = new TopoInf();
			t.setFrom("0");
			t.setTo(conditions.get(i).getServiceByServiceId().getServiceId().toString());
			
			boolean contains = false;
			for(int j = 0;  j < topo.size(); j++)
			{
				if(topo.get(j).compare(t))
				{
					contains = true;
					break;
				}
				
			}
			if(contains == false)
			{
				topo.add(t);
			}
		}
		
		for(int i = 0; i < conditions.size(); i++)
		{
			TopoInf t = new TopoInf();
			t.setFrom(conditions.get(i).getServiceByServiceId().getServiceId().toString());
			t.setTo(conditions.get(i).getServiceBySubServiceId().getServiceId().toString());
			
			boolean contains = false;
			for(int j = 0;  j < topo.size(); j++)
			{
				if(topo.get(j).compare(t))
				{
					contains = true;
					break;
				}
				
			}
			if(contains == false)
			{
				topo.add(t);
			}
		}
		
		System.out.print(topo.size());
		
		return SUCCESS;
	}
	
	public String relationDetail()
	{
		System.out.println("relationFather:"+relationFather);
		int fatherid = Integer.parseInt(relationFather);  //选择的是组合服务
		Service fatherService = srs.getUniqueService(relationFather);
		callrelations.clear();
		calldetails.clear();
		CallRelationInf fatherSerCri = new CallRelationInf(relationFather, fatherService.getServiceType(), fatherService.getRelateBusiness(), fatherService.getServiceName(), fatherService.getServiceAddress());
		calldetails.add(fatherSerCri);
		//处理组合服务中的父服务与子服务间的关系，从condition表获取
		List<Condition> conditions = conditionsr.getConditionDao().findByServiceId(fatherid);
		for(int i = 0 ; i < conditions.size(); i++) {
			Condition condition = conditions.get(i);
			Service subSer = condition.getServiceBySubServiceId();
			String subSerId = String.valueOf(subSer.getServiceId());
			CallRelationInf subSerCri = new CallRelationInf(subSerId, subSer.getServiceType(), subSer.getRelateBusiness(), subSer.getServiceName(), subSer.getServiceAddress());
			if (calldetails.contains(subSerCri) == false) {
				calldetails.add(subSerCri);
			}
			CallRelationInf cri = new CallRelationInf(relationFather, subSerId, fatherService.getServiceType(), subSer.getServiceType(), fatherService.getRelateBusiness(), subSer.getRelateBusiness(), fatherService.getServiceName(), subSer.getServiceName());
			callrelations.add(cri);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 将组合服务按照业务分类
	 * @return
	 */
	public String workClass()
	{
		try
		{
			services = srs.getAllService();
			dtnodes.clear();
			selected.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(services.get(i).getCombineType() != null)
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
				String ct = selected.get(i).getRelateBusiness();
				if(content.contains(ct) == false)
				{
					nodeid.add(0);
					nodeContent.add(ct);
					content.add(ct);
				}
				int pos = content.indexOf(ct);
				String ct2 = ct + " " + selected.get(i).getServiceId();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(String.valueOf(selected.get(i).getServiceId()));
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				List<Condition> conlist = conditionsr.getConditionDao().findByServiceId(selected.get(i).getServiceId());
				for(int j = 0; j < conlist.size(); j++){
					String ct3 = ct2 + " " + conlist.get(j).getServiceBySubServiceId().getServiceId();
					nodeid.add(pos2 + 1);
					nodeContent.add(String.valueOf(conlist.get(j).getServiceBySubServiceId().getServiceId()));
					content.add(ct3);
				}
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
   
	/**
	 * 将服务按级别分类
	 * @return
	 */
	public String levelClass()
	{
		try
		{
			services.clear();
			services = srs.getAll();
			dtnodes.clear();
			//selected.addAll(services);
			List<Integer> num = new ArrayList<Integer>();
			for(int i = 0; i < services.size(); i++)
			{
				if(services.get(i).getServiceLevel() != null && !services.get(i).getServiceLevel().isEmpty()){
					num.add(1);
				}
				else{
					num.add(0);
				}
			}
			for(int i = 0; i < services.size() - 1; i++)
			{
				for(int j = i + 1; j < services.size(); j++)
				{
					if(services.get(i).getServiceLevel() != null && services.get(j).getServiceLevel() != null && services.get(i).getServiceLevel().equals(services.get(j).getServiceLevel())){
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
				String ct = "Level " + selected.get(i).getServiceLevel();
				if(content.contains(ct) == false)
				{
					nodeid.add(0);
					nodeContent.add(ct);
					content.add(ct);
				}
				int pos = content.indexOf(ct);
				String ct2 = ct + " " + selected.get(i).getServiceId();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(String.valueOf(selected.get(i).getServiceId()));
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				List<Servicerelation> srrlist = srrelationsr.getSrrelationDao().findByServiceId(selected.get(i).getServiceId());
				for(int j = 0; j < srrlist.size(); j++){
					String ct3 = ct2 + " " + srrlist.get(j).getServiceBySubServiceId().getServiceId();
					nodeid.add(pos2 + 1);
					nodeContent.add(String.valueOf(srrlist.get(j).getServiceBySubServiceId().getServiceId()));
					content.add(ct3);
				}
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

	public String getCombinedService(){
		combinedservices.clear();
		combinedservices = srs.getCombinedService();
		return SUCCESS;
	}
	
	/**
	 * 将组合服务按照技术分类
	 */
	public String busyClass(){
		try
		{
			services = srs.getAllService();
			dtnodes.clear();
			selected.clear();
			for(int i = 0; i < services.size(); i++)
			{
				if(services.get(i).getCombineType() != null)
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
				String ct2 = ct + " " + selected.get(i).getServiceId();
				if(content.contains(ct2) == false)
				{
					nodeid.add(pos + 1);
					nodeContent.add(String.valueOf(selected.get(i).getServiceId()));
					content.add(ct2);
				}
				int pos2 = content.indexOf(ct2);
				List<Condition> conlist = conditionsr.getConditionDao().findByServiceId(selected.get(i).getServiceId());
				for(int j = 0; j < conlist.size(); j++){
					String ct3 = ct2 + " " + conlist.get(j).getServiceBySubServiceId().getServiceId();
					nodeid.add(pos2 + 1);
					nodeContent.add(String.valueOf(conlist.get(j).getServiceBySubServiceId().getServiceId()));
					content.add(ct3);
				}
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
	
	public String combineRelation()
	{
		conditions = conditionsr.getAllCondition();
		
		combineServices.clear();
		combineTimes.clear();
		String relation = "";
		int s = 0;
		
		for(int i = 1; i < conditions.size(); i++)
		{
			if(conditions.get(i).getServiceByServiceId().getServiceId().equals(conditions.get(s).getServiceByServiceId().getServiceId()) && i != conditions.size() - 1)
			{
			}
			else
			{
				System.out.println(s + " " + i);
				for(int j = s; j < i; j++)
				{
					relation += conditions.get(j).getServiceBySubServiceId().getServiceId();
					if(j != i - 1)
					{
						relation += ',';
					}
				}
				if(i == conditions.size() - 1)
				{
					relation += ',';
					relation += conditions.get(i).getServiceBySubServiceId().getServiceId();
				}
				if(combineServices.contains(relation) == false)
				{
					combineServices.add(relation);
					combineTimes.add(1);
				}
				else
				{
					int index = combineServices.indexOf(relation);
					combineTimes.set(index, combineTimes.get(index) + 1);
				}
				
				s = i;
				relation = "";
			}
		}
		
		System.out.println(combineServices.size() + "@");
		
		for(int i = 0; i < combineServices.size(); i++)
		{
			System.out.print(combineServices.get(i));
			System.out.println(" " + combineTimes.get(i));
		}
		
		return SUCCESS;
	}
	
	
	public List<Integer> busyClassByConditiontype(List<Condition> cons, int busyclass, List<Integer> all, String classByConditionType, int index){
		//cons排序
		Collections.sort(cons, new Comparator<Condition>() {
            public int compare(Condition arg0, Condition arg1) {
                return arg0.getServiceByServiceId().getServiceId().compareTo(arg1.getServiceByServiceId().getServiceId());
            }
        });
		all.clear();
		int fatherid = 0;
		int lastsizeOfConditions = conditions.size();
		int count = 0;
		for(int i = cons.size() - 1; i >= 0; i--)
		{
			int sametypeBefore = conditions.size();
			int father = cons.get(i).getServiceByServiceId().getServiceId();
			String condtionType = srs.getServiceType(father);
			System.out.print("condtionType:"+condtionType);
			if(condtionType.equalsIgnoreCase("web") || condtionType.equalsIgnoreCase("webservice")){
				//conditionsOfWebService.get(i).setCondtionType("WebService");
				condtionType = "WebService";
			}else if(condtionType.equalsIgnoreCase("http") || condtionType.equalsIgnoreCase("mule") || condtionType.equalsIgnoreCase("mulehttp")){
				condtionType = "Http";
			}else if(condtionType.equalsIgnoreCase("url")){
				condtionType = "URL";
			}else{
				condtionType = "Other";
			}
			System.out.print(condtionType);
			
			if(condtionType.equalsIgnoreCase(classByConditionType) || all.contains(father)){
				
				
				if(all.contains(father) == false)
				{
					//count = 0;
					all.add(father);
					Service service=new Service();
					Service subservice=new Service();
					subservice.setServiceId(Integer.valueOf(father));
					//if(conditions.size() == lastsizeOfConditions){
						service.setServiceId(Integer.valueOf(busyclass) + index + lastsizeOfConditions);
					//}else{
					//	service.setServiceId(Integer.valueOf(busyclass) + index + conditions.size());
					//}
					
					System.out.print("\n"+(Integer.valueOf(busyclass) + index + conditions.size()) + "----"+Integer.valueOf(father)+": "+classByConditionType+"\n");
					conditions.add(new Condition(service,subservice,"",null, classByConditionType));
					fatherid = conditions.size() + busyclass + index;
				}
				else
				{
					//count++;
					//if(count == 1){
					//	fatherid = all.indexOf(father) + busyclass + index + (conditions.size() - lastsizeOfConditions) - 1;
					//}else{
					//int subtype = 
						fatherid = all.indexOf(father) + busyclass + index + 1 + lastsizeOfConditions;
						//fatherid = all.indexOf(father) + busyclass + index + lastsizeOfConditions + 1;
					//}
					
					//System.out.print("\nconditions.size() - lastsizeOfConditions: "+ (conditions.size() - lastsizeOfConditions)+"\n");
				}
				System.out.print("fatherid:"+fatherid+"   ");
				int son = cons.get(i).getServiceBySubServiceId().getServiceId();
				Service service=new Service();
				Service subservice=new Service();
				service.setServiceId(Integer.valueOf(fatherid));
				subservice.setServiceId(Integer.valueOf(son));
				conditions.add(new Condition(service,subservice, "",null, classByConditionType));
				all.add(son);
				System.out.print("\n"+Integer.valueOf(fatherid) + "----"+Integer.valueOf(son)+": "+classByConditionType+"\n");
			}
		}
		System.out.print("conditions.size(): "+conditions.size());
		return all;
	}
	
	/**
	 * 查找服务调用关系
	 * @return
	 */
	public String callRelationDetail(){   //非递归遍历
		callrelations.clear();
		calldetails.clear();
		if(serviceGranularity.equalsIgnoreCase("single")){  //查看输入服务的调用关系
			String fatherid = relationFather;
			Service fatherService = srs.getUniqueService(fatherid);
			System.out.print("relationFather:"+relationFather+"\n");
			callrelations = getSingleServiceRelations(fatherService);
		}
		else if(serviceGranularity.equalsIgnoreCase("all")){ //查看所有服务的调用关系
			callrelations = getAllServiceRelations();
		}
		System.out.print("calldetails:"+calldetails.size());
		System.out.print("callrelations:"+callrelations.size());
		for(int i = 0; i < callrelations.size();i++){
			System.out.print("callrelations:"+callrelations.get(i).getFatherid()+":"+callrelations.get(i).getSonid());
		}
		return SUCCESS;
	}

	/**
	 * 获取指定服务的调用关系
	 * @param fatherService
	 * @return
	 */
	public List<CallRelationInf> getSingleServiceRelations(Service fatherService){
		List<CallRelationInf> results = new ArrayList<CallRelationInf>();
		String fatherSerId = String.valueOf(fatherService.getServiceId());
		CallRelationInf fatherCri = new CallRelationInf(fatherSerId, fatherService.getServiceType(), fatherService.getRelateBusiness(),fatherService.getServiceName(),fatherService.getServiceAddress());
		if(calldetails.contains(fatherCri) == false){
			calldetails.add(fatherCri);
		}

		//处理注册显式定义的调用关系、应用与其内部服务的调用关系，从service表的callservice字段获取
		String callServices = fatherService.getCallService();
		if(callServices != null && callServices.length() > 0){
			String[] callservice = callServices.split(",");
			for(int i = 0; i < callservice.length; i++){
				if(callservice[i] != null && callservice[i].isEmpty() == false){
					Service calledSer = srs.getUniqueService(callservice[i]);
					String calledSerId = String.valueOf(calledSer.getServiceId());
					CallRelationInf calledSerCri = new CallRelationInf(calledSerId, calledSer.getServiceType(), calledSer.getRelateBusiness(),calledSer.getServiceName(),calledSer.getServiceAddress());
					if(calldetails.contains(calledSerCri) == false){
						calldetails.add(calledSerCri);
					}
					CallRelationInf cri = new CallRelationInf(fatherSerId, calledSerId, fatherService.getServiceType(), calledSer.getServiceType(), fatherService.getRelateBusiness(), calledSer.getRelateBusiness(), fatherService.getServiceName(), calledSer.getServiceName());
					results.add(cri);
				}
			}
		}

		//处理应用/流程内部的服务之间的调用关系，从servicelinks表获取
		List<Servicelinks> serLinks = serlinkssr.findByServiceId(fatherService.getServiceId());
		for(int i = 0 ;i < serLinks.size(); i++){
			Service calledSer = srs.getUniqueService(String.valueOf(serLinks.get(i).getSubServiceId()));
			String calledSerId = String.valueOf(calledSer.getServiceId());
			CallRelationInf calledSerCri = new CallRelationInf(calledSerId, calledSer.getServiceType(), calledSer.getRelateBusiness(),calledSer.getServiceName(),calledSer.getServiceAddress());
			if(calldetails.contains(calledSerCri) == false){
				calldetails.add(calledSerCri);
			}
			CallRelationInf cri = new CallRelationInf(fatherSerId, calledSerId, fatherService.getServiceType(), calledSer.getServiceType(), fatherService.getRelateBusiness(), calledSer.getRelateBusiness(), fatherService.getServiceName(), calledSer.getServiceName());
			results.add(cri);
		}

		//处理组合服务中的父服务与子服务间的关系，从condition表获取
		if(fatherService.getCombineType() != null){  //说明是组合服务
			List<Condition> conditions = conditionsr.getConditionDao().findByServiceId(fatherService.getServiceId());
			for(int i = 0 ; i < conditions.size(); i++){
				Condition condition = conditions.get(i);
				Service subSer = condition.getServiceBySubServiceId();
				String subSerId = String.valueOf(subSer.getServiceId());
				CallRelationInf subSerCri = new CallRelationInf(subSerId, subSer.getServiceType(), subSer.getRelateBusiness(),subSer.getServiceName(),subSer.getServiceAddress());
				if(calldetails.contains(subSerCri) == false){
					calldetails.add(subSerCri);
				}
				CallRelationInf cri = new CallRelationInf(fatherSerId, subSerId, fatherService.getServiceType(), subSer.getServiceType(), fatherService.getRelateBusiness(), subSer.getRelateBusiness(), fatherService.getServiceName(), subSer.getServiceName());
				results.add(cri);
			}
		}
		return results;
	}

	/**
	 * 获取所有服务的调用关系
	 * @return
	 */
	public List<CallRelationInf> getAllServiceRelations(){
		List<CallRelationInf> results = new ArrayList<CallRelationInf>();
		List<Service> allServices = srs.getAll();
		for(int i = 0; i < allServices.size(); i++){
			Service singleService = allServices.get(i);
			List<CallRelationInf> tempResults = getSingleServiceRelations(singleService);
			/*  拓扑图显示不了单节点
			if(tempResults.isEmpty()){ //该服务没有调用其他服务,因此调用的服务为null
				CallRelationInf cri = new CallRelationInf(String.valueOf(singleService.getServiceId()), null, singleService.getServiceType(), null, singleService.getRelateBusiness(), null, singleService.getServiceName(), null);
				results.add(cri);
			}*/
			//无重复并集
			tempResults.removeAll(results);
			results.addAll(tempResults);
		}
		return results;
	}

	
	/*
	 * 将服务类型转换成前台调用拓扑图节点的类型
	 */
	public String toNodeType(String servicetype){
		if(servicetype.toLowerCase().contains("application")){
			servicetype = "APPLICATION";
		}
		else if(servicetype.toLowerCase().contains("service")){
			servicetype = "SERVICE";
		}
		else if(servicetype.toLowerCase().contains("business")){
			servicetype = "BUSINESS";
		}
		else if(servicetype.toLowerCase().contains("local")){
			servicetype = "LOCAL";
		}
		return servicetype;
	}
	
	/**
	 * 获取所有的服务调用关系和详情
	 */
	public void getAllCallrelation(){
		callrelations.clear();
		List<Servicerelation> relationlist = new ArrayList<Servicerelation>();
		relationlist = srrelationsr.getAllServicerelation();
		for(int i = 0; i < relationlist.size(); i++){
			Servicerelation rel = new Servicerelation();
			rel = relationlist.get(i);
			CallRelationInf callrel = new CallRelationInf();
			Service service = new Service();
			service = rel.getServiceByServiceId();
			Service subservice = new Service();
			subservice = rel.getServiceBySubServiceId();
			callrel.setFatherid(String.valueOf(service.getServiceId()));
			callrel.setFathertype(service.getServiceType());
			callrel.setFatheraddress(service.getServiceAddress());
			callrel.setSonid(String.valueOf(subservice.getServiceId()));
			callrel.setSontype(subservice.getServiceType());
			callrel.setSonaddress(subservice.getServiceAddress());
			callrelations.add(callrel);
		}
		calldetails.clear();
		List<Service> serlist = new ArrayList<Service>();
		serlist = srs.getAllService();
		for(int i = 0; i < serlist.size(); i++){
			Service ser = new Service();
			ser = serlist.get(i);
			CallRelationInf callrel = new CallRelationInf();
			callrel.setFatheraddress(ser.getServiceAddress());
			callrel.setSonid(String.valueOf(ser.getServiceId()));
			callrel.setSontype(ser.getServiceType());
			callrel.setSonaddress(ser.getServiceAddress());
			String sonparam = "";
			List<Parameter> sonps = new ArrayList<Parameter>();
			sonps = parametersr.getServiceParameter(ser.getServiceId());
			for(int j = 0; j < sonps.size(); j++)
			{
				if(sonps.get(j).getParametername() == null){
					sonps.get(j).setParametername("parametername is null");
				}
				if(j == sonps.size() - 1){
					sonparam += sonps.get(j).getParametername();
				}else{
					sonparam += sonps.get(j).getParametername();
					sonparam += ",";
				}
			}
			sonparam = sonparam == null? "" : sonparam;
			callrel.setSonparameter(sonparam);
			calldetails.add(callrel);
		}
	}
	
}