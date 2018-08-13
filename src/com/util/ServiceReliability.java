package com.util;

public class ServiceReliability {
	
	private Integer serviceId;
	private String serviceName;
	private String serviceAddress;
	private Integer runTime;
	private Integer failTime;
	private Double successRate;
	private Double reliability;
	
	public ServiceReliability(Integer serviceId, String serviceName,
			Double reliability) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.reliability = reliability;
	}
	
	public ServiceReliability(Integer serviceId, String serviceName,
			String serviceAddress, Integer runTime, Integer failTime,
			Double successRate, Double reliability) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceAddress = serviceAddress;
		this.runTime = runTime;
		this.failTime = failTime;
		this.successRate = successRate;
		this.reliability = reliability;
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
	public Double getReliability() {
		return reliability;
	}
	public void setReliability(Double reliability) {
		this.reliability = reliability;
	}
	
}
