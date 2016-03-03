package com.bean;
// default package



/**
 * Temp entity. @author MyEclipse Persistence Tools
 */

public class Temp  implements java.io.Serializable {


    // Fields    

     private Integer tempId;
     private Integer serviceId;
     private Integer userId;


    // Constructors

    /** default constructor */
    public Temp() {
    }

    
    /** full constructor */
    public Temp(Integer tempId,Integer serviceId, Integer userId){
    	this.tempId=tempId;
    	this.serviceId=serviceId;
    	this.userId=userId;
    }
    public Temp(Integer serviceId, Integer userId) {
        this.serviceId = serviceId;
        this.userId = userId;
    }

   
    // Property accessors

    public Integer getTempId() {
        return this.tempId;
    }
    
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getServiceId() {
        return this.serviceId;
    }
    
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
   








}