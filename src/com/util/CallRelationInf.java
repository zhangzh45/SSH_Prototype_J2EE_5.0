package com.util;

public class CallRelationInf {
	String fatherid;
	String sonid;
	String fathertype;
	String sontype;
	String fatherbusiness;
	String sonbusiness;
	String fatheraddress;
	String sonaddress;
	String fatherparameter;
	String sonparameter;
	String condition;
	String desc;
	
	public String getSonid() {
		return sonid;
	}
	public void setSonid(String sonid) {
		this.sonid = sonid;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getFatherid() {
		return fatherid;
	}
	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}
	public String getFathertype() {
		return fathertype;
	}
	public void setFathertype(String fathertype) {
		this.fathertype = fathertype;
	}
	public String getSontype() {
		return sontype;
	}
	public void setSontype(String sontype) {
		this.sontype = sontype;
	}
	
	public String getFatherbusiness() {
		return fatherbusiness;
	}
	public void setFatherbusiness(String fatherbusiness) {
		this.fatherbusiness = fatherbusiness;
	}
	public String getSonbusiness() {
		return sonbusiness;
	}
	public void setSonbusiness(String sonbusiness) {
		this.sonbusiness = sonbusiness;
	}
	public String getFatheraddress() {
		return fatheraddress;
	}
	public void setFatheraddress(String fatheraddress) {
		this.fatheraddress = fatheraddress;
	}
	public String getSonaddress() {
		return sonaddress;
	}
	public void setSonaddress(String sonaddress) {
		this.sonaddress = sonaddress;
	}
	public String getFatherparameter() {
		return fatherparameter;
	}
	public void setFatherparameter(String fatherparameter) {
		this.fatherparameter = fatherparameter;
	}
	public String getSonparameter() {
		return sonparameter;
	}
	public void setSonparameter(String sonparameter) {
		this.sonparameter = sonparameter;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	public CallRelationInf() {
	}
	
	
	
	public CallRelationInf(String fatherid, String sonid, String fathertype,
			String sontype, String fatherbusiness, String sonbusiness,
			String fatheraddress, String sonaddress, String fatherparameter,
			String sonparameter, String condition, String desc) {
		super();
		this.fatherid = fatherid;
		this.sonid = sonid;
		this.fathertype = fathertype;
		this.sontype = sontype;
		this.fatherbusiness = fatherbusiness;
		this.sonbusiness = sonbusiness;
		this.fatheraddress = fatheraddress;
		this.sonaddress = sonaddress;
		this.fatherparameter = fatherparameter;
		this.sonparameter = sonparameter;
		this.condition = condition;
		this.desc = desc;
	}
	
	public CallRelationInf(String fatherid, String sonid, String fathertype,
			String sontype, String fatheraddress, String sonaddress) {
		super();
		this.fatherid = fatherid;
		this.sonid = sonid;
		this.fathertype = fathertype;
		this.sontype = sontype;
		this.fatheraddress = fatheraddress;
		this.sonaddress = sonaddress;
	}
	
	
	
	public CallRelationInf(String fatherid, String sonid, String fathertype,
			String sontype, String fatherbusiness, String sonbusiness,
			String fatheraddress, String sonaddress, String fatherparameter,
			String sonparameter) {
		super();
		this.fatherid = fatherid;
		this.sonid = sonid;
		this.fathertype = fathertype;
		this.sontype = sontype;
		this.fatherbusiness = fatherbusiness;
		this.sonbusiness = sonbusiness;
		this.fatheraddress = fatheraddress;
		this.sonaddress = sonaddress;
		this.fatherparameter = fatherparameter;
		this.sonparameter = sonparameter;
	}
	
	public CallRelationInf(String fatherid, String sonid, String fathertype,
			String sontype, String fatheraddress, String sonaddress,
			String fatherparameter, String sonparameter) {
		super();
		this.fatherid = fatherid;
		this.sonid = sonid;
		this.fathertype = fathertype;
		this.sontype = sontype;
		this.fatheraddress = fatheraddress;
		this.sonaddress = sonaddress;
		this.fatherparameter = fatherparameter;
		this.sonparameter = sonparameter;
	}
	
	
	
	@Override  
	public boolean equals(Object obj) {  
		CallRelationInf sri = (CallRelationInf)obj;  
		if(fatherid == null){
			fatherid = "0";
		}
		if(sonid == null){
			sonid = "0";
		}
		return fatherid.equals(sri.fatherid) && sonid.equals(sri.sonid);   
	}  
	
	/*@Override  
	public int hashCode() {  
		if(fatherid == null){
			fatherid = "0";
		}
		if(sonid == null){
			sonid = "0";
		}
		String in = fatherid + " " + sonid;  
		return in.hashCode();  
	}  */
}