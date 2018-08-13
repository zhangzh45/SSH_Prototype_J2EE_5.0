package com.util;

//常量类
public class ConstantUtil {
	
	//注 ：所有URL中的IP地址必须是运行对应项目的服务器IP地址
	
	
	//查询rancher的网址
	//private static final String searchRancherURL = "http://222.200.180.59:8080/v2-beta/projects/1a347/"; 
	private static final String searchRancherURL = "https://222.200.180.59:8443/v3"; 
	
	
	//组织管理中心的发布地址
	private static final String demoEndpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl"; 
	
	//从sysuclient端获取所有角色的URL
	private static final String getAllRoleURL = "http://127.0.0.1:8090/sysuClient/new/getAllRole.action"; 
	
	//rancher api keys
	private static final String rancherAPIKeys = "token-l5p2q:96ngxr77nsxlp5fjz2k44jvwpc4r6l89x9dkb9t6hhqltkc9tqm44h"; 
	
	//统计图片的存放文件路径
	private static final String statisticsPicture = "E:\\workspace\\myeclipse_projects\\SSH_Prototype_J2EE_5.0\\WebRoot\\images\\company.jpeg";
	
	//映射中心的根据组织角色获取业务角色的URL
	private static final String getBusiRoleByOrganRoleURL = "http://localhost:3000/rolemap/getBusiRoleByOrganRole/";
	
	//获取流程角色的URL，必须填本机IP的地址
	private static final String getSpecRoleURL = "http:\\\\172.18.49.245:8090\\SSH_Prototype_J2EE_5.0\\getSpecRoleFromSpec.action?specid=";
	
	public static String getSearchrancherurl() {
		return searchRancherURL;
	}

	public static String getDemoendpoint() {
		return demoEndpoint;
	}

	public static String getGetallroleurl() {
		return getAllRoleURL;
	}

	public static String getRancherapikeys() {
		return rancherAPIKeys;
	}

	public static String getStatisticspicture() {
		return statisticsPicture;
	}

	public static String getGetbusirolebyorganroleurl() {
		return getBusiRoleByOrganRoleURL;
	}

	public static String getGetspecroleurl() {
		return getSpecRoleURL;
	}

}
