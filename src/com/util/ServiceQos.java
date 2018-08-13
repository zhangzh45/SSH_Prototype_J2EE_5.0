package com.util;


public class ServiceQos
{

	// Fields
	private Integer serviceId;
	private String serviceName;
	private String serviceType;
	private Double reliability;
	private Double availability;
	private Double serviceTime;
	private Double serviceCost;
	private Double busyDegree;
	private Double avgEvaluation;
	private Double serviceQos;
	
	public ServiceQos() {
	}
	

	public ServiceQos(Integer serviceId, String serviceName,
			String serviceType, Double reliability, Double availability,
			Double serviceTime, Double serviceCost, Double busyDegree,
			Double avgEvaluation, Double serviceQos) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.reliability = reliability;
		this.availability = availability;
		this.serviceTime = serviceTime;
		this.serviceCost = serviceCost;
		this.busyDegree = busyDegree;
		this.avgEvaluation = avgEvaluation;
		this.serviceQos = serviceQos;
	}

	public ServiceQos(Integer serviceId, String serviceName,
			String serviceType, Double reliability, Double availability,
			Double serviceTime, Double serviceCost, Double busyDegree,
			Double avgEvaluation) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.reliability = reliability;
		this.availability = availability;
		this.serviceTime = serviceTime;
		this.serviceCost = serviceCost;
		this.busyDegree = busyDegree;
		this.avgEvaluation = avgEvaluation;
	}

	
	public ServiceQos(Integer serviceId, Double reliability,
			Double availability, Double serviceTime, Double serviceCost,
			Double busyDegree, Double avgEvaluation) {
		super();
		this.serviceId = serviceId;
		this.reliability = reliability;
		this.availability = availability;
		this.serviceTime = serviceTime;
		this.serviceCost = serviceCost;
		this.busyDegree = busyDegree;
		this.avgEvaluation = avgEvaluation;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Double getReliability() {
		return reliability;
	}
	public void setReliability(Double reliability) {
		this.reliability = reliability;
	}
	public Double getAvailability() {
		return availability;
	}
	public void setAvailability(Double availability) {
		this.availability = availability;
	}
	public Double getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Double serviceTime) {
		this.serviceTime = serviceTime;
	}
	public Double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}
	public Double getBusyDegree() {
		return busyDegree;
	}
	public void setBusyDegree(Double busyDegree) {
		this.busyDegree = busyDegree;
	}
	public Double getAvgEvaluation() {
		return avgEvaluation;
	}
	public void setAvgEvaluation(Double avgEvaluation) {
		this.avgEvaluation = avgEvaluation;
	}
	public Double getServiceQos() {
		return serviceQos;
	}
	public void setServiceQos(Double serviceQos) {
		this.serviceQos = serviceQos;
	}
}