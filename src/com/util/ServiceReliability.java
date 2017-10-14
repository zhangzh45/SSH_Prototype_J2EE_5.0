package com.util;

public class ServiceReliability {
	
	private Integer serviceId;
	private String serviceName;
	private String serviceAddress;
	private Integer runTime;
	private Integer failTime;
	private Double successRate;
	
	
	public ServiceReliability() {
	}
	
	
	public ServiceReliability(Integer serviceId, String serviceName,
			String serviceAddress, Double successRate) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceAddress = serviceAddress;
		this.successRate = successRate;
	}
	
	public ServiceReliability(Integer serviceId, String serviceName,
			String serviceAddress, Integer runTime, Integer failTime,
			Double successRate) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceAddress = serviceAddress;
		this.runTime = runTime;
		this.failTime = failTime;
		this.successRate = successRate;
	}
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceAddress() {
		return serviceAddress;
	}
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
	public Integer getRunTime() {
		return runTime;
	}
	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}
	public Integer getFailTime() {
		return failTime;
	}
	public void setFailTime(Integer failTime) {
		this.failTime = failTime;
	}
	public Double getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(Double successRate) {
		this.successRate = successRate;
	}
	
}
