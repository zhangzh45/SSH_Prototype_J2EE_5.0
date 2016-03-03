package com.bean;

/**
 * Serviceresult entity. @author MyEclipse Persistence Tools
 */

public class Serviceresult implements java.io.Serializable {

	// Fields

	private Integer resultid;
	private Service service;
	private String resultDesc;
	private String resultType;
	private String resultName;

	// Constructors

	/** default constructor */
	public Serviceresult() {
	}

	/** minimal constructor */
	public Serviceresult(Integer resultid) {
		this.resultid = resultid;
	}

	/** full constructor */
	public Serviceresult(Integer resultid, Service service, String resultDesc,
			String resultType, String resultName) {
		this.resultid = resultid;
		this.service = service;
		this.resultDesc = resultDesc;
		this.resultType = resultType;
		this.resultName = resultName;
	}

	// Property accessors

	public Integer getResultid() {
		return this.resultid;
	}

	public void setResultid(Integer resultid) {
		this.resultid = resultid;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getResultDesc() {
		return this.resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getResultType() {
		return this.resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultName() {
		return this.resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

}