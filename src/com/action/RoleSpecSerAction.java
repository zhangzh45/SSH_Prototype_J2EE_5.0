package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.json.JSONArray;

import com.bean.Role;
import com.bean.RoleSpecSer;
import com.bean.Service;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserRole;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.RoleSpecSerService;
import com.service.SerService;
import com.service.TempService;
import com.service.UserSpecSerService;

public class RoleSpecSerAction extends ActionSupport{
	private  RoleSpecSerService roleSpecSerService;
	private String RoleSpecSerString;
	private String rssId;
	private String roleName;
	private String serviceName;
	private RoleService roleService;
	private SerService serService;
	private UserSpecSerService ussInrss;
	private TempService tempInRss;
	public TempService getTempInRss() {
		return tempInRss;
	}
	public void setTempInRss(TempService tempInRss) {
		this.tempInRss = tempInRss;
	}
	public UserSpecSerService getUssInrss() {
		return ussInrss;
	}
	public void setUssInrss(UserSpecSerService ussInrss) {
		this.ussInrss = ussInrss;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public SerService getSerService() {
		return serService;
	}

	public void setSerService(SerService serService) {
		this.serService = serService;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRssId() {
		return rssId;
	}
	public void setRssId(String rssId) {
		this.rssId = rssId;
	}
   @JSON (serialize=false)
	public String getRoleSpecSerString() {
		return RoleSpecSerString;
	}
	public void setRoleSpecSerString(String roleSpecSerString) {
		RoleSpecSerString = roleSpecSerString;
	}
	public RoleSpecSerService getRoleSpecSerService() {
		return roleSpecSerService;
	}
	public void setRoleSpecSerService(RoleSpecSerService roleSpecSerService) {
		this.roleSpecSerService = roleSpecSerService;
	}
	
	public String loadRoleSpecSer(){
		List<RoleSpecSer> listrss=roleSpecSerService.findAll();
		JSONArray roleSpecSerJson=new JSONArray();
		for(RoleSpecSer rss :listrss){
			Map<String,String> map=new HashMap<String,String>();
			Role role=rss.getRole();
			Service service=rss.getService();
			map.put("rssId", rss.getRssId().toString());
			map.put("roleId", role.getRoleId().toString());
			map.put("roleName", role.getRoleName());
			map.put("roleDesc", role.getRoleDesc());
			map.put("serviceId", service.getServiceId().toString());
			map.put("serviceName", service.getServiceName());
			map.put("serviceType", service.getServiceType());
			map.put("serviceLevel", service.getServiceLevel());
			map.put("serviceDesc", service.getServiceDesc());
			roleSpecSerJson.put(map);
		}
		RoleSpecSerString=roleSpecSerJson.toString();
		return SUCCESS;
	}
	
	public String deleteRoleSpecSer(){
		RoleSpecSer rss=roleSpecSerService.findById(Integer.parseInt(rssId));
		roleSpecSerService.delete(rss);
		return SUCCESS;
	}
	
	public String addRoleService(){
		List list=roleService.findUserSpecSerByRoleName(roleName.trim());
		List<Service> service=serService.findyByServiceName(serviceName.trim());
	    List<Role> role=roleService.findyByRoleName(roleName.trim());
	    /*删除用户特例服务表中拥有该角色的且拥有该服务的用户的该项服务的记录*/
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Object[] object=(Object[])list.get(i);
				Role r=(Role)object[0];
				User user=(User)object[2];
				Service userSpecService=(Service)object[4];
					if(userSpecService.getServiceId().equals(service.get(0).getServiceId())){
					    ussInrss.deleteByServiceUserId(userSpecService.getServiceId(), user.getUserId());
					}
			}
		}
		/*删除temp表中申请名为serviceName的服务并且拥有名为roleName的角色的用户申请记录*/
		List<Temp> listTemp=tempInRss.findByServiceId(service.get(0).getServiceId());
		List userRoleList=roleService.findUserByRoleName(roleName.trim());
		if(listTemp.size()>0){
			for(int i=0;i<listTemp.size();i++){
				for(int j=0;j<userRoleList.size();j++){
					Object[] ob=(Object[])userRoleList.get(j);
					User user=(User)ob[2];
					if(user.getUserId().equals(listTemp.get(0).getTempId())){
						tempInRss.delete(listTemp.get(0));
					}
				}
			}
		}
		/*添加角色特有服务*/
		RoleSpecSer rss=new RoleSpecSer();
		String Id=role.get(0).getRoleId().toString()+service.get(0).getServiceId().toString();
		rss.setRssId(Integer.parseInt(Id));
		rss.setRole(role.get(0));
		rss.setService(service.get(0));
		roleSpecSerService.add(rss);
		return SUCCESS;
	}

}
