package com.bean;


/**
 * Runlog entity. @author MyEclipse Persistence Tools
 */

public class Runlog implements java.io.Serializable {

	// Fields

	private Integer runid;
	private Integer serviceid;
	private Integer userid;
	private String starttime;
	private String finishtime;
	private String runstate;
	private String rundesc;

	// Constructors

	/** default constructor */
	public Runlog() {
	}

	/** minimal constructor */
	public Runlog(Integer serviceid, Integer userid) {
		this.serviceid = serviceid;
		this.userid = userid;
	}

	/** full constructor */
	public Runlog(Integer serviceid, Integer userid, String starttime,
			String finishtime, String runstate, String rundesc) {
		this.serviceid = serviceid;
		this.userid = userid;
		this.starttime = starttime;
		this.finishtime = finishtime;
		this.runstate = runstate;
		this.rundesc = rundesc;
	}

	// Property accessors

	public Integer getRunid() {
		return this.runid;
	}

	public void setRunid(Integer runid) {
		this.runid = runid;
	}

	public Integer getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getFinishtime() {
		return this.finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

	public String getRunstate() {
		return this.runstate;
	}

	public void setRunstate(String runstate) {
		this.runstate = runstate;
	}

	public String getRundesc() {
		return this.rundesc;
	}

	public void setRundesc(String rundesc) {
		this.rundesc = rundesc;
	}

}