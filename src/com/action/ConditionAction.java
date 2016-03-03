package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Condition;
import com.bean.Parameter;
import com.bean.Service;
import com.bean.Variable;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ConditionService;
import com.service.SerService;
import com.service.VariableService;
import com.service.ParameterService;
import com.util.TopoInf;
import com.util.RelationInf;


public class ConditionAction extends ActionSupport
{
	private ConditionService conditionsr = new ConditionService();
	private SerService srs = new SerService();
	private VariableService variablesr = new VariableService();
	private ParameterService parametersr = new ParameterService();

	String option1;
	String option2;
	String option3;
	
	String opt1;
	String opt2;
	
	String var1;

	String e1;
	String e2;
	
	String relationFather;
	
	List<Service> services = new ArrayList<Service>();
	List<Service> allservices = new ArrayList<Service>();
	
	List<Condition> conditions = new ArrayList<Condition>();
	List<TopoInf> topo = new ArrayList<TopoInf>();
	List<RelationInf> relations = new ArrayList<RelationInf>();
	
	List<String> combineServices = new ArrayList<String>();
	List<Integer> combineTimes = new ArrayList<Integer>();
	

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

	public List<RelationInf> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationInf> relations) {
		this.relations = relations;
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

	public String saveConbineService()
	{
		Service s = new Service();
		s.setServiceType("Combine");
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
		int father = Integer.parseInt(relationFather);
		
		List<Condition> sons = new ArrayList<Condition>();
		
		sons = conditionsr.getServiceCondition(father);
		relations.clear();
		RelationInf ref = new RelationInf();
		ref.setSonid(Integer.toString((father)));
		ref.setType(srs.getServiceType(father));
		relations.add(ref);
		
		for(int i = 0; i < sons.size(); i++)
		{
			int sonid = sons.get(i).getServiceBySubServiceId().getServiceId();
			
			RelationInf re = new RelationInf();
			
			re.setSonid(Integer.toString(sonid));
			re.setType(srs.getServiceType(sonid));
			re.setDesc(srs.getUniqueService(Integer.toString(sonid)).getServiceDesc());
			re.setCondition(sons.get(i).getCondtionExpression());
			
			String pas = "";
			List<Parameter> ps = new ArrayList<Parameter>();
			ps = parametersr.getServiceParameter(sonid);
			for(int j = 0; j < ps.size(); j++)
			{
				pas += ps.get(j).getParametername();
				pas += ",";
			}
			re.setParameter(pas);
			
			relations.add(re);
		}
		
		return SUCCESS;
	}
	
	public String busyClass()
	{
		int busyclass = 1;
		
		try
		{
			conditions.clear();
			List<Condition> cons = new ArrayList<Condition>();
			List<Integer> fathers = new ArrayList<Integer>();
			List<Integer> sons = new ArrayList<Integer>();
			List<Integer> all = new ArrayList<Integer>();
			Service service=new Service();
			Service subservice=new Service();
			cons = conditionsr.getAllCondition();
			for(int i = 0; i < cons.size(); i++)
			{
				fathers.add(cons.get(i).getServiceByServiceId().getServiceId());
				sons.add(cons.get(i).getServiceBySubServiceId().getServiceId());
			}
			int fatherid = 0;
			for(int i = cons.size() - 1; i >= 0; i--)
			{
				int father = cons.get(i).getServiceByServiceId().getServiceId();
				if(all.contains(father) == false)
				{
					all.add(father);
					service.setServiceId(Integer.valueOf(busyclass));
					subservice.setServiceId(Integer.valueOf(father));
					conditions.add(new Condition(service,subservice,"",null));
					fatherid = conditions.size() + busyclass;
					//System.out.print(1);
				}
				else
				{
					fatherid = all.indexOf(father) + busyclass + 1;
					//System.out.print(fatherid);
				}
				
				int son = cons.get(i).getServiceBySubServiceId().getServiceId();
				  service.setServiceId(Integer.valueOf(fatherid));
				    subservice.setServiceId(Integer.valueOf(son));
					conditions.add(new Condition(service,subservice, "",null));
				all.add(son);
				//System.out.print(3);
				
			}
			//conditions = conditionsr.getAllCondition();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String workClass()
	{
		int busyclass = 1;
		
		try
		{
			conditions.clear();
			List<Condition> cons = new ArrayList<Condition>();
			List<Integer> fathers = new ArrayList<Integer>();
			List<Integer> sons = new ArrayList<Integer>();
			List<Integer> all = new ArrayList<Integer>();
			Service service=new Service();
			Service subservice=new Service();
			cons = conditionsr.getAllCondition();
			for(int i = 0; i < cons.size(); i++)
			{
				fathers.add(cons.get(i).getServiceByServiceId().getServiceId());
				sons.add(cons.get(i).getServiceBySubServiceId().getServiceId());
			}
			int fatherid = 0;
			for(int i = cons.size() - 1; i >= 0; i--)
			{
				int father = cons.get(i).getServiceByServiceId().getServiceId();
				if(all.contains(father) == false)
				{
					all.add(father);
					service.setServiceId(Integer.valueOf(busyclass));
					subservice.setServiceId(Integer.valueOf(father));
					conditions.add(new Condition(service,subservice,"",null));
					fatherid = conditions.size() + busyclass;
					//System.out.print(1);
				}
				else
				{
					fatherid = all.indexOf(father) + busyclass + 1;
					//System.out.print(fatherid);
				}
				
				int son = cons.get(i).getServiceBySubServiceId().getServiceId();
			    service.setServiceId(Integer.valueOf(fatherid));
			    subservice.setServiceId(Integer.valueOf(son));
				conditions.add(new Condition(service,subservice, "",null));
				all.add(son);
				//System.out.print(3);
				
			}
			//conditions = conditionsr.getAllCondition();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
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
}