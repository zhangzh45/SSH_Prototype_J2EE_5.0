package com.bean;

/**
 * Servicelinks entity. @author MyEclipse Persistence Tools
 */

public class Servicelinks implements java.io.Serializable {

	// Fields

	private Integer linksid;
	private Integer serviceId;
	private Integer subServiceId;
	private Integer parentAppId;

	// Constructors

	/** default constructor */
	public Servicelinks() {
	}

	/** full constructor */
	public Servicelinks(Integer serviceId, Integer subServiceId,
			Integer parentAppId) {
		this.serviceId = serviceId;
		this.subServiceId = subServiceId;
		this.parentAppId = parentAppId;
	}

	// Property accessors

	public Integer getLinksid() {
		return this.linksid;
	}

	public void setLinksid(Integer linksid) {
		this.linksid = linksid;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getSubServiceId() {
		return this.subServiceId;
	}

	public void setSubServiceId(Integer subServiceId) {
		this.subServiceId = subServiceId;
	}

	public Integer getParentAppId() {
		return this.parentAppId;
	}

	public void setParentAppId(Integer parentAppId) {
		this.parentAppId = parentAppId;
	}

}