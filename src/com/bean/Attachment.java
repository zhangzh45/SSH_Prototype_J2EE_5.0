package com.bean;

/**
 * Attachment entity. @author MyEclipse Persistence Tools
 */

public class Attachment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String filepath;
	private String filecontent;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** minimal constructor */
	public Attachment(String filepath) {
		this.filepath = filepath;
	}

	/** full constructor */
	public Attachment(String filepath, String filecontent) {
		this.filepath = filepath;
		this.filecontent = filecontent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilecontent() {
		return this.filecontent;
	}

	public void setFilecontent(String filecontent) {
		this.filecontent = filecontent;
	}

}