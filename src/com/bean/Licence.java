package com.bean;

/**
 * Licence entity. @author MyEclipse Persistence Tools
 */

public class Licence implements java.io.Serializable {

	// Fields

	private Integer licenceId;
	private Service service;
	private String licenceType;
	private String licenceTime;
	private String licenceCode;
	private String licenceLocation;

	// Constructors

	/** default constructor */
	public Licence() {
	}

	/** minimal constructor */
	public Licence(Integer licenceId, Service service) {
		this.licenceId = licenceId;
		this.service = service;
	}

	/** full constructor */
	public Licence(Integer licenceId, Service service, String licenceType,
			String licenceTime, String licenceCode, String licenceLocation) {
		this.licenceId = licenceId;
		this.service = service;
		this.licenceType = licenceType;
		this.licenceTime = licenceTime;
		this.licenceCode = licenceCode;
		this.licenceLocation = licenceLocation;
	}

	// Property accessors

	public Integer getLicenceId() {
		return this.licenceId;
	}

	public void setLicenceId(Integer licenceId) {
		this.licenceId = licenceId;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getLicenceType() {
		return this.licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}

	public String getLicenceTime() {
		return this.licenceTime;
	}

	public void setLicenceTime(String licenceTime) {
		this.licenceTime = licenceTime;
	}

	public String getLicenceCode() {
		return this.licenceCode;
	}

	public void setLicenceCode(String licenceCode) {
		this.licenceCode = licenceCode;
	}

	public String getLicenceLocation() {
		return this.licenceLocation;
	}

	public void setLicenceLocation(String licenceLocation) {
		this.licenceLocation = licenceLocation;
	}

}