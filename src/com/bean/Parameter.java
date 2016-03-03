package com.bean;

/**
 * Parameter entity. @author MyEclipse Persistence Tools
 */

public class Parameter implements java.io.Serializable {

	// Fields

	private Integer parameterid;
	private Service service;
	private String parametertype;
	private String parametername;
	private String parameterdesc;

	// Constructors

	/** default constructor */
	public Parameter() {
	}

	/** minimal constructor */
	public Parameter(Integer parameterid, Service service) {
		this.parameterid = parameterid;
		this.service = service;
	}

	/** full constructor */
	public Parameter(Integer parameterid, Service service,
			String parametertype, String parametername, String parameterdesc) {
		this.parameterid = parameterid;
		this.service = service;
		this.parametertype = parametertype;
		this.parametername = parametername;
		this.parameterdesc = parameterdesc;
	}

	// Property accessors

	public Integer getParameterid() {
		return this.parameterid;
	}

	public void setParameterid(Integer parameterid) {
		this.parameterid = parameterid;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getParametertype() {
		return this.parametertype;
	}

	public void setParametertype(String parametertype) {
		this.parametertype = parametertype;
	}

	public String getParametername() {
		return this.parametername;
	}

	public void setParametername(String parametername) {
		this.parametername = parametername;
	}

	public String getParameterdesc() {
		return this.parameterdesc;
	}

	public void setParameterdesc(String parameterdesc) {
		this.parameterdesc = parameterdesc;
	}

}