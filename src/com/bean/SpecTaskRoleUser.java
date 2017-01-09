package com.bean;

/**
 * SpecTaskRoleUser entity. @author MyEclipse Persistence Tools
 */

public class SpecTaskRoleUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String specIdentifier;
	private String taskId;
	private String taskName;
	private String roleId;
	private String participantId;

	// Constructors

	/** default constructor */
	public SpecTaskRoleUser() {
	}

	/** full constructor */
	public SpecTaskRoleUser(String specIdentifier, String taskId,
			String taskName, String roleId, String participantId) {
		this.specIdentifier = specIdentifier;
		this.taskId = taskId;
		this.taskName = taskName;
		this.roleId = roleId;
		this.participantId = participantId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpecIdentifier() {
		return this.specIdentifier;
	}

	public void setSpecIdentifier(String specIdentifier) {
		this.specIdentifier = specIdentifier;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getParticipantId() {
		return this.participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

}