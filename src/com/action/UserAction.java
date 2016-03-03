package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.algorithm.Aprioir;
import com.algorithm.AprioirItemSet;
import com.bean.Role;
import com.bean.User;
import com.bean.UserRole;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.SerService;
import com.service.UserRoleService;
import com.service.UserService;
import com.util.RegisterKey;

public class UserAction extends ActionSupport
{
	private User user;
	private UserService usersr;
	private RoleService rolesr;
	private UserRoleService userrolesr;
	private SerService srs;
	String option1;
	
	String username;
	
	private List<User> users = new ArrayList<User>();
	private List<Role> roles = new ArrayList<Role>();
	private List<UserRole> userroles = new ArrayList<UserRole>();
	
	private List<String> unames = new ArrayList<String>();
	private List<String> rolenames = new ArrayList<String>();
	private String nowuser;
	
	String serviceNum;
	String runTime;
	String userNum;
	String roleNum;
	
	public SerService getSrs() {
		return srs;
	}
	public void setSrs(SerService srs) {
		this.srs = srs;
	}
	public String getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getRoleNum() {
		return roleNum;
	}
	public void setRoleNum(String roleNum) {
		this.roleNum = roleNum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRolenames() {
		return rolenames;
	}
	public void setRolenames(List<String> rolenames) {
		this.rolenames = rolenames;
	}
	public String getNowuser() {
		return nowuser;
	}
	public void setNowuser(String nowuser) {
		this.nowuser = nowuser;
	}
	public List<String> getUnames() {
		return unames;
	}
	public void setUnames(List<String> unames) {
		this.unames = unames;
	}
	public UserRoleService getUserrolesr() {
		return userrolesr;
	}
	public void setUserrolesr(UserRoleService userrolesr) {
		this.userrolesr = userrolesr;
	}
	public List<UserRole> getUserroles() {
		return userroles;
	}
	public void setUserroles(List<UserRole> userroles) {
		this.userroles = userroles;
	}
	public RoleService getRolesr() {
		return rolesr;
	}
	public void setRolesr(RoleService rolesr) {
		this.rolesr = rolesr;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUsersr() {
		return usersr;
	}
	public void setUsersr(UserService usersr) {
		this.usersr = usersr;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	public String dashboard()
	{
		try
		{
			serviceNum = String.valueOf(srs.getServiceNum());
			runTime = String.valueOf(srs.getRunTime());
			roleNum = String.valueOf(rolesr.getRoleNum());
			userNum = String.valueOf(usersr.getUserNum());
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String login()
	{
		try
		{
		
			System.out.println(usersr.getUniqueUser(user.getUserId()).getPassword()+"$");
			System.out.println(user.getPassword()+"$");
			if(usersr.getUniqueUser(user.getUserId()).getPassword().equals(user.getPassword()))
			{
				 List<UserRole> list=userrolesr.getUserRole(user.getUserId());
				username = usersr.getUniqueUser(user.getUserId()).getUserName();
				dashboard();
				
				//RegisterKey.main();
				//System.out.println(new AprioirItemSet().test());
				//new Aprioir().test();
			
			}
			else
			{
				return ERROR;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
			return SUCCESS;
	}
	
	public String addUser()
	{
		try
		{
			user.setUserType(option1);
			usersr.addUser(user);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String listUser()
	{
		users = usersr.getAllUsers();
		return SUCCESS;
	}
	
	public String deleteUser()
	{
		try
		{
			user = usersr.getUniqueUser(Integer.valueOf(option1));
			usersr.deleteUser(user);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String userAndRole()
	{
		users = usersr.getAllUsers();
		roles = rolesr.getAllRole();
		userroles = userrolesr.getAllRole();
		unames.clear();
		rolenames.clear();
		for(int i =  0; i < users.size(); i++)
		{
			unames.add(Integer.toString(users.get(i).getUserId()));
		}
		for(int i =  0; i < roles.size(); i++)
		{
			rolenames.add((roles.get(i).getRoleName()));
		}
		
		return SUCCESS;
	}
}