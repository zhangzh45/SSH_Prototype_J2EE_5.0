package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Service entity. @author MyEclipse Persistence Tools
 */

public class Service implements java.io.Serializable {

	// Fields

	private Integer serviceId;
	private String serviceName;
	private String serviceDesc;
	private Integer maxLoad;
	private String serviceType;
	private String serviceLevel;
	private String relateBusiness;
	private String serviceTarget;
	private String serviceRange;
	private String serviceState;
	private String serviceAddress;
	private String serviceVersion;
	private String serviceMaker;
	private String serviceTime;
	private String serviceHost;
	private String serviceQuery;
	private Integer runTimes;
	private Integer failTimes;
	private Set serviceresults = new HashSet(0);
	private Set licences = new HashSet(0);
	private Set servicerelationsForServiceId = new HashSet(0);
	private Set parameters = new HashSet(0);
	private Set conditionsForSubServiceId = new HashSet(0);
	private Set roleSpecSers = new HashSet(0);
	private Set userSpecSers = new HashSet(0);
	private Set permissionServices = new HashSet(0);
	private Set conditionsForServiceId = new HashSet(0);
	private Set variables = new HashSet(0);
	private Set servicerelationsForSubServiceId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Service() {
	}

	/** minimal constructor */
	public Service(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/** full constructor */
	public Service(Integer serviceId, String serviceName, String serviceDesc,
			Integer maxLoad, String serviceType, String serviceLevel,
			String relateBusiness, String serviceTarget, String serviceRange,
			String serviceState, String serviceAddress, String serviceVersion,
			String serviceMaker, String serviceTime, String serviceHost,
			String serviceQuery, Integer runTimes, Integer failTimes,
			Set serviceresults, Set licences, Set servicerelationsForServiceId,
			Set parameters, Set conditionsForSubServiceId, Set roleSpecSers,
			Set userSpecSers, Set permissionServices,
			Set conditionsForServiceId, Set variables,
			Set servicerelationsForSubServiceId) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.maxLoad = maxLoad;
		this.serviceType = serviceType;
		this.serviceLevel = serviceLevel;
		this.relateBusiness = relateBusiness;
		this.serviceTarget = serviceTarget;
		this.serviceRange = serviceRange;
		this.serviceState = serviceState;
		this.serviceAddress = serviceAddress;
		this.serviceVersion = serviceVersion;
		this.serviceMaker = serviceMaker;
		this.serviceTime = serviceTime;
		this.serviceHost = serviceHost;
		this.serviceQuery = serviceQuery;
		this.runTimes = runTimes;
		this.failTimes = failTimes;
		this.serviceresults = serviceresults;
		this.licences = licences;
		this.servicerelationsForServiceId = servicerelationsForServiceId;
		this.parameters = parameters;
		this.conditionsForSubServiceId = conditionsForSubServiceId;
		this.roleSpecSers = roleSpecSers;
		this.userSpecSers = userSpecSers;
		this.permissionServices = permissionServices;
		this.conditionsForServiceId = conditionsForServiceId;
		this.variables = variables;
		this.servicerelationsForSubServiceId = servicerelationsForSubServiceId;
	}

	// Property accessors

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public Integer getMaxLoad() {
		return this.maxLoad;
	}

	public void setMaxLoad(Integer maxLoad) {
		this.maxLoad = maxLoad;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getRelateBusiness() {
		return this.relateBusiness;
	}

	public void setRelateBusiness(String relateBusiness) {
		this.relateBusiness = relateBusiness;
	}

	public String getServiceTarget() {
		return this.serviceTarget;
	}

	public void setServiceTarget(String serviceTarget) {
		this.serviceTarget = serviceTarget;
	}

	public String getServiceRange() {
		return this.serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	public String getServiceState() {
		return this.serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getServiceAddress() {
		return this.serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getServiceVersion() {
		return this.serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getServiceMaker() {
		return this.serviceMaker;
	}

	public void setServiceMaker(String serviceMaker) {
		this.serviceMaker = serviceMaker;
	}

	public String getServiceTime() {
		return this.serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceHost() {
		return this.serviceHost;
	}

	public void setServiceHost(String serviceHost) {
		this.serviceHost = serviceHost;
	}

	public String getServiceQuery() {
		return this.serviceQuery;
	}

	public void setServiceQuery(String serviceQuery) {
		this.serviceQuery = serviceQuery;
	}

	public Integer getRunTimes() {
		return this.runTimes;
	}

	public void setRunTimes(Integer runTimes) {
		this.runTimes = runTimes;
	}

	public Integer getFailTimes() {
		return this.failTimes;
	}

	public void setFailTimes(Integer failTimes) {
		this.failTimes = failTimes;
	}

	public Set getServiceresults() {
		return this.serviceresults;
	}

	public void setServiceresults(Set serviceresults) {
		this.serviceresults = serviceresults;
	}

	public Set getLicences() {
		return this.licences;
	}

	public void setLicences(Set licences) {
		this.licences = licences;
	}

	public Set getServicerelationsForServiceId() {
		return this.servicerelationsForServiceId;
	}

	public void setServicerelationsForServiceId(Set servicerelationsForServiceId) {
		this.servicerelationsForServiceId = servicerelationsForServiceId;
	}

	public Set getParameters() {
		return this.parameters;
	}

	public void setParameters(Set parameters) {
		this.parameters = parameters;
	}

	public Set getConditionsForSubServiceId() {
		return this.conditionsForSubServiceId;
	}

	public void setConditionsForSubServiceId(Set conditionsForSubServiceId) {
		this.conditionsForSubServiceId = conditionsForSubServiceId;
	}

	public Set getRoleSpecSers() {
		return this.roleSpecSers;
	}

	public void setRoleSpecSers(Set roleSpecSers) {
		this.roleSpecSers = roleSpecSers;
	}

	public Set getUserSpecSers() {
		return this.userSpecSers;
	}

	public void setUserSpecSers(Set userSpecSers) {
		this.userSpecSers = userSpecSers;
	}

	public Set getPermissionServices() {
		return this.permissionServices;
	}

	public void setPermissionServices(Set permissionServices) {
		this.permissionServices = permissionServices;
	}

	public Set getConditionsForServiceId() {
		return this.conditionsForServiceId;
	}

	public void setConditionsForServiceId(Set conditionsForServiceId) {
		this.conditionsForServiceId = conditionsForServiceId;
	}

	public Set getVariables() {
		return this.variables;
	}

	public void setVariables(Set variables) {
		this.variables = variables;
	}

	public Set getServicerelationsForSubServiceId() {
		return this.servicerelationsForSubServiceId;
	}

	public void setServicerelationsForSubServiceId(
			Set servicerelationsForSubServiceId) {
		this.servicerelationsForSubServiceId = servicerelationsForSubServiceId;
	}

}