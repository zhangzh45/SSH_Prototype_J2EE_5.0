package com.bean;

/**
 * Searchsite entity. @author MyEclipse Persistence Tools
 */

public class Searchsite implements java.io.Serializable {

	// Fields

	private Integer siteid;
	private String address;
	private String pagecontrol;
	private String supplier;
	private String area;

	// Constructors

	/** default constructor */
	public Searchsite() {
	}

	/** minimal constructor */
	public Searchsite(Integer siteid) {
		this.siteid = siteid;
	}

	/** full constructor */
	public Searchsite(Integer siteid, String address, String pagecontrol,
			String supplier, String area) {
		this.siteid = siteid;
		this.address = address;
		this.pagecontrol = pagecontrol;
		this.supplier = supplier;
		this.area = area;
	}

	// Property accessors

	public Integer getSiteid() {
		return this.siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPagecontrol() {
		return this.pagecontrol;
	}

	public void setPagecontrol(String pagecontrol) {
		this.pagecontrol = pagecontrol;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}