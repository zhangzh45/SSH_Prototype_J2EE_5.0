package com.util;


public class ServiceQuality
{

	// Fields

	private Integer serviceId;
	private Integer runTime;
	private Integer failTime;
	private Double Qos;
	private Integer evaluationNumber;
	private Double avg;
	private Double f;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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
	public Double getQos() {
		return Qos;
	}
	public void setQos(Double qos) {
		Qos = qos;
	}
	public Integer getEvaluationNumber() {
		return evaluationNumber;
	}
	public void setEvaluationNumber(Integer evaluationNumber) {
		this.evaluationNumber = evaluationNumber;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public Double getF() {
		return f;
	}
	public void setF(Double f) {
		this.f = f;
	}
	
}