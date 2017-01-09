package com.action;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.algorithm.Aprioir;
import com.algorithm.AprioirItemSet;
import com.bean.Role;
import com.bean.User;
import com.bean.UserRole;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.SerService;
import com.service.UserRoleService;
import com.service.UserService;
import com.util.GetRemoteService;
import com.util.RegisterKey;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class UserAction extends ActionSupport
{
	
	private User user;
	private UserService usersr;
	private RoleService rolesr;
	private UserRoleService userrolesr;
	private SerService srs;
	private String result ="error";
	private String language="Chinese";
	
	
	private GetRemoteService grs = new GetRemoteService();

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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
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
			userNum = grs.getUserNum();
			System.out.println(userNum+"$\n");
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
			Map<String, Object> session = ActionContext.getContext().getSession();
			//System.out.println(usersr.getUniqueUser(user.getUserId()).getPassword()+"$");
			System.out.println(user.getPassword()+"$");
			System.out.println(user.getUserId()+"$");
			if(user.getUserId() == 0 && user.getPassword().equals("1234")){
				dashboard();
				session.put("admin", "true");  
				session.put("user", "0");   //将用户id保存在session中,管理员的userid标记为0
				return SUCCESS;
			}
			else{
				
				String loginresult = grs.loginVerify(String.valueOf(user.getUserId()), user.getPassword());
				
				JSONArray json = JSONArray.fromObject(loginresult ); // 棣栧厛鎶婂瓧绗︿覆杞垚 JSONArray  瀵硅薄
				  System.out.println(json.toString()+"="+loginresult+"\n") ;
				  Map<String ,String> mp=new HashMap<String,String>();
			         if(json.size()>0){
			           for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
			             JSONObject job = json.getJSONObject(i); 
			             if(job.getString("userid").equals(user.getUserId().toString())){
			            	 if(job.getString("LoginVerify").equals("success")){  //鐧诲綍鎴愬姛
			            		 //username = usersr.getUniqueUser(user.getUserId()).getUserName();
			     				 dashboard();
			     				 
			     				/*Map<String, Object> session = ActionContext.getContext().getSession();
			     				 if(job.containsKey("Administrator") && job.getString("Administrator").equalsIgnoreCase("1")){
			     					   //为管理员
			     					session.put("admin", "true");  
			     				 }
			     				 else{
			     					session.put("admin", "false"); 
			     				 }*/
			     				session.put("admin", "false"); 
			     				session.put("user", user.getUserId().toString());   //将用户id保存在session中
			     				return SUCCESS;
			            	 }else{
			            		 return ERROR;
			            	 }	 
			             }
			           }
			         }

			}
			/*if(usersr.getUniqueUser(user.getUserId()).getPassword().equals(user.getPassword()))
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
			}*/
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String logout(){
		try{
			System.out.print("....\n");
			Map<String, Object> session = ActionContext.getContext().getSession();
			//session.remove("user");
			//session.remove("admin");
			session.clear();
			System.out.print(session.toString()+"....\n");
			result="success";
		}catch(Exception e){
			
		}
		return result;
		
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
	
	public String displayLanguage(){
		try{
			HttpSession session=ServletActionContext.getRequest().getSession();
			if(language.equalsIgnoreCase("Chinese")){
				ActionContext.getContext().setLocale(Locale.CHINA);
				
			}
			else if(language.equalsIgnoreCase("English")){
				ActionContext.getContext().setLocale(Locale.US);
			}
			session.setAttribute("WW_TRANS_I18N_LOCALE", ActionContext.getContext().getLocale());
			session.setAttribute("language", language);
			result = language;
		}
		catch(Exception e){
			e.printStackTrace();
			result = ERROR;
		}
		return SUCCESS;
	}
}