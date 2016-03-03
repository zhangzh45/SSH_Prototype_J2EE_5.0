package com.bean;

/**
 * Searchinf entity. @author MyEclipse Persistence Tools
 */

public class Searchinf implements java.io.Serializable {

	// Fields

	private Integer id;
	private String inf;
	private String value;

	// Constructors

	/** default constructor */
	public Searchinf() {
	}

	/** minimal constructor */
	public Searchinf(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Searchinf(Integer id, String inf, String value) {
		this.id = id;
		this.inf = inf;
		this.value = value;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInf() {
		return this.inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}