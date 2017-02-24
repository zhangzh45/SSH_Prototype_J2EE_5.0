package com.service.interfce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.SimpleRole;
import com.bean.SpecTaskRoleUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SpecTaskRoleUserService;

/**
 * 
 * @author yuzaizai
 *获取流程业务角色信息
 */
public class SpecificationRoleInterface extends ActionSupport {
    private  SpecTaskRoleUserService specTaskRoleUserService;
    private Map<String,List<SimpleRole>> specRoleMap = new HashMap<String, List<SimpleRole>>();
    private String specid;
	private static final long serialVersionUID = 1L;

	/**
	 * 根据流程id获取流程的业务角色
	 * @param specid
	 * @return
	 */
	public  String getSpecRoleFromSpec () {
		List<SpecTaskRoleUser> specTaskRoleUserList = new ArrayList<SpecTaskRoleUser>();
		specTaskRoleUserList =  specTaskRoleUserService.getStruDao().findBySpecIdentifier( specid );  // 根据specId获取其对应的业务角色
		List<SimpleRole> simpleRoleList = new ArrayList<SimpleRole>(); 
		for ( int i = 0; i < specTaskRoleUserList.size(); i++ ) {   // 遍历该流程包含的业务角色
			SpecTaskRoleUser specTaskRoleUser= specTaskRoleUserList.get(i);
			if ( specTaskRoleUser.getRoleId() !=null && specTaskRoleUser.getTaskId()!=null ) {  // 若taskId和roleId不为空
				SimpleRole simpleRole = new SimpleRole();
				// 最终的roleId由流程Id+任务Id+抽象业务角色Id组成
				String roleId = specTaskRoleUser.getSpecIdentifier()+specTaskRoleUser.getTaskId()+specTaskRoleUser.getRoleId();
				simpleRole.setRoleId(roleId);
				simpleRole.setRoleName(specTaskRoleUser.getRoleName());
				simpleRoleList.add(simpleRole);
			}
			specRoleMap.put("roles", simpleRoleList);
		}
		return SUCCESS;
	}

	public String getSpecid() {
		return specid;
	}

	public void setSpecid(String specid) {
		this.specid = specid;
	}
	
	public SpecTaskRoleUserService getSpecTaskRoleUserService() {
		return specTaskRoleUserService;
	}

	public void setSpecTaskRoleUserService(
			SpecTaskRoleUserService specTaskRoleUserService) {
		this.specTaskRoleUserService = specTaskRoleUserService;
	}
	
	public Map<String, List<SimpleRole>> getSpecRoleMap() {
		return specRoleMap;
	}

	public void setSpecRoleMap(Map<String, List<SimpleRole>> specRoleMap) {
		this.specRoleMap = specRoleMap;
	}

}
