package com.bean;

/**
 * Searchkeyword entity. @author MyEclipse Persistence Tools
 */

public class Searchkeyword implements java.io.Serializable {

	// Fields

	private Integer searchkeywordid;
	private String keywordname;
	private String keyword;
	private String keywordvalue;
	private String keyworddesc;

	// Constructors

	/** default constructor */
	public Searchkeyword() {
	}

	/** minimal constructor */
	public Searchkeyword(Integer searchkeywordid) {
		this.searchkeywordid = searchkeywordid;
	}

	/** full constructor */
	public Searchkeyword(Integer searchkeywordid, String keywordname,
			String keyword, String keywordvalue, String keyworddesc) {
		this.searchkeywordid = searchkeywordid;
		this.keywordname = keywordname;
		this.keyword = keyword;
		this.keywordvalue = keywordvalue;
		this.keyworddesc = keyworddesc;
	}

	// Property accessors

	public Integer getSearchkeywordid() {
		return this.searchkeywordid;
	}

	public void setSearchkeywordid(Integer searchkeywordid) {
		this.searchkeywordid = searchkeywordid;
	}

	public String getKeywordname() {
		return this.keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeywordvalue() {
		return this.keywordvalue;
	}

	public void setKeywordvalue(String keywordvalue) {
		this.keywordvalue = keywordvalue;
	}

	public String getKeyworddesc() {
		return this.keyworddesc;
	}

	public void setKeyworddesc(String keyworddesc) {
		this.keyworddesc = keyworddesc;
	}

}