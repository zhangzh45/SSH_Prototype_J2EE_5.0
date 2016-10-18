package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algorithm.Aprioir;
import com.algorithm.AprioirItemSet;
import com.algorithm.AprioirResult;
import com.bean.Role;
import com.bean.UserRole;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.UserRoleService;

public class RoleAction extends ActionSupport
{
	private RoleService rolesr;
	private Role role;
	private List<Role> roles = new ArrayList<Role>();
	String option1;
	private UserRoleService userrolesr;
	List<AprioirResult> apresults = new ArrayList<AprioirResult>();
	private Map<String,List<Role>> mapRoles =new HashMap<String, List<Role>>();
	public Map<String, List<Role>> getMapRoles() {
		return mapRoles;
	}
	public void setMapRoles(Map<String, List<Role>> mapRoles) {
		this.mapRoles = mapRoles;
	}
	public List<AprioirResult> getApresults() {
		return apresults;
	}
	public void setApresults(List<AprioirResult> apresults) {
		this.apresults = apresults;
	}
	public UserRoleService getUserrolesr() {
		return userrolesr;
	}
	public void setUserrolesr(UserRoleService userrolesr) {
		this.userrolesr = userrolesr;
	}
	public RoleService getRolesr() {
		return rolesr;
	}
	public void setRolesr(RoleService rolesr) {
		this.rolesr = rolesr;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	public String addRole()
	{
		try
		{
			this.rolesr.addRole(role);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listRole()
	{
		try
		{
			roles = this.rolesr.getAllRole();
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * @method 提供外部访问角色数据
	 * @return 以json格式返回所有的角色信息
	 */
	public String jsonListRole() {
	     List<Role> jsonListRoles = new ArrayList<Role>();
	     if (null == this.rolesr) {
	    	 LOG.error("roleService初始化错误"+this.rolesr);
	    	 return SUCCESS;
	     }
	     roles = this.rolesr.getAllRole();
	     if (null == roles ) {
	    		 return SUCCESS;
	     }
	    
	     for (Role role : roles) {
	    	Role roleList = new Role();
	    	roleList.setRoleId(role.getRoleId());
	    	roleList.setRoleName(role.getRoleName());
	        jsonListRoles.add(roleList);
	     }
	     mapRoles.put("roles", jsonListRoles);
	     return SUCCESS;
	}
	public String deleteRole()
	{
		try
		{
			role = rolesr.getUniqueRole(Integer.valueOf(option1));
			//role.setRoleId(Integer.valueOf(option1));
			if(role != null)
			{
				rolesr.deleteRole(role);
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String freRole()
	{
		Aprioir ap2 = new Aprioir();
		ap2.test();
		
		List<UserRole> urs = new ArrayList<UserRole>();
		List<String> usernames = new ArrayList<String>();
		
		urs = userrolesr.getAllRole();
		
		//int num = urs.size();
		double sup = 0.3;
		
		for(int i = 0; i < urs.size(); i++)
		{
			if(usernames.contains(urs.get(i).getUser().getUserId().toString()))
			{
				
			}
			else
			{
				usernames.add(urs.get(i).getUser().getUserId().toString());
			}
		}
		Aprioir ap = new Aprioir();
		for(int i = 0; i < usernames.size(); i++)
		{
			AprioirItemSet set = new AprioirItemSet();
			ap.items.add(set);
		}
		
		for(int i = 0; i < urs.size(); i++)
		{
			int uid = usernames.indexOf(urs.get(i).getUser().getUserId().toString());
			ap.items.get(uid).itemset.add(urs.get(i).getRole().getRoleId().toString());
			
		}
		int num = usernames.size();
		ap.k = 2;
		ap.min_sup = (int) (num * sup);
		ap.aprioirAlgorrithm();
		
		
		for(int i = 0; i < ap.ls.get(2).l.size(); i++)
		{
			System.out.println(ap.ls.get(2).l.get(i).itemset.toString() + ": " + ap.ls.get(2).lfre.get(i).toString());
		}
		apresults.clear();
		for(int i = 1; i <= ap.k; i++)
		{
			System.out.println("!!");
			for(int j = 0; j < ap.ls.get(i).l.size(); j++)
			{
				System.out.println("**");
				AprioirResult ar = new AprioirResult();
				ar.setSetContent(ap.ls.get(i).l.get(j).itemset.toString());
				ar.setFre(ap.ls.get(i).lfre.get(j));
				ar.setK(i + 1);
				apresults.add(ar);
			}
		}
		
		System.out.println(apresults.size());
		return SUCCESS;
		
	}
	
}