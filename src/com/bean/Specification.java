package com.bean;

/**
 * Specification entity. @author MyEclipse Persistence Tools
 */

public class Specification implements java.io.Serializable {

	// Fields

	private Integer rowid;
	private String identifier;
	private String name;
	private String uri;
	private String version;
	private String description;
	private String xml;
	private String filepath;

	// Constructors

	/** default constructor */
	public Specification() {
	}

	/** full constructor */
	public Specification(String identifier, String name, String uri,
			String version, String description, String xml, String filepath) {
		this.identifier = identifier;
		this.name = name;
		this.uri = uri;
		this.version = version;
		this.description = description;
		this.xml = xml;
		this.filepath = filepath;
	}

	// Property accessors

	public Integer getRowid() {
		return this.rowid;
	}

	public void setRowid(Integer rowid) {
		this.rowid = rowid;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getXml() {
		return this.xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}