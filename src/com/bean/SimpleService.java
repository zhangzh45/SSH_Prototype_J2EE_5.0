package com.bean;

public class SimpleService implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private String appRoleUrl;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getAppRoleUrl() {
		return appRoleUrl;
	}
	public void setAppRoleUrl(String appRoleUrl) {
		this.appRoleUrl = appRoleUrl;
	}
	

	
}
