package com.action;

import com.bean.Role;
import com.bean.User;
import com.bean.UserRole;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserRoleService;

public class UserRoleAction extends ActionSupport
{
	UserRoleService userrolesr = new UserRoleService();

	String guss;
	String grls;
	String gops;
	
	public String getGuss() {
		return guss;
	}

	public void setGuss(String guss) {
		this.guss = guss;
	}

	public String getGrls() {
		return grls;
	}

	public void setGrls(String grls) {
		this.grls = grls;
	}

	public String getGops() {
		return gops;
	}

	public void setGops(String gops) {
		this.gops = gops;
	}

	public UserRoleService getUserrolesr() {
		return userrolesr;
	}

	public void setUserrolesr(UserRoleService userrolesr) {
		this.userrolesr = userrolesr;
	}
	
	public String addUserRole()
	{
		System.out.println(guss);
		System.out.println(grls);
		System.out.println(gops);
		
		String[] uss = guss.split(";");
		String[] rls = grls.split(";");
		String[] ops = gops.split(";");
		for(int i = 0; i < uss.length; i++)
		{
			if(uss[i].length() > 0)
			{
				String user = uss[i].split(":")[0];
				String role = rls[i].split(":")[0];
				
				if(ops[i].equals("get"))
				{
					UserRole ur = new UserRole();
					User usr=new User();
					usr.setUserId(Integer.parseInt(user));
					ur.setUser(usr);
					Role rol=new Role();
					rol.setRoleId(Integer.parseInt(role));
					ur.setRole(rol);
					userrolesr.addRole(ur);
				}
				else if(ops[i].equals("lose"))
				{
					//UserRole ur = new UserRole();
					//ur.setUserid(Integer.parseInt(user));
					//ur.setRoleid(Integer.parseInt(role));
					userrolesr.delUserrole(userrolesr.getUniquerole(user, role));
				}		
			}
		}
		return SUCCESS;
	}
}