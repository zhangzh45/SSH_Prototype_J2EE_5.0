package com.bean;

/**
 * Evaluation entity. @author MyEclipse Persistence Tools
 */

public class Evaluation implements java.io.Serializable {

	// Fields

	private Integer evaluationId;
	private Integer evaluationUser;
	private Integer evaluationService;
	private Integer evaluationMark;
	private String suggestion;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** minimal constructor */
	public Evaluation(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}

	/** full constructor */
	public Evaluation(Integer evaluationId, Integer evaluationUser,
			Integer evaluationService, Integer evaluationMark, String suggestion) {
		this.evaluationId = evaluationId;
		this.evaluationUser = evaluationUser;
		this.evaluationService = evaluationService;
		this.evaluationMark = evaluationMark;
		this.suggestion = suggestion;
	}

	// Property accessors

	public Integer getEvaluationId() {
		return this.evaluationId;
	}

	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}

	public Integer getEvaluationUser() {
		return this.evaluationUser;
	}

	public void setEvaluationUser(Integer evaluationUser) {
		this.evaluationUser = evaluationUser;
	}

	public Integer getEvaluationService() {
		return this.evaluationService;
	}

	public void setEvaluationService(Integer evaluationService) {
		this.evaluationService = evaluationService;
	}

	public Integer getEvaluationMark() {
		return this.evaluationMark;
	}

	public void setEvaluationMark(Integer evaluationMark) {
		this.evaluationMark = evaluationMark;
	}

	public String getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

}