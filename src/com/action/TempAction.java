package com.action;


import java.util.Map;

import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;


import com.bean.Service;
import com.bean.Temp;
import com.bean.User;
import com.bean.UserSpecSer;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TempService;
import com.service.UserSpecSerService;


public class TempAction extends ActionSupport{
	private TempService tempser;
	private String tempId;
	private UserSpecSerService usstemp;
	private String userId;
	private String serviceId;
	private String []myBox;
	private String submitToken="1"; 

	public String getSubmitToken() {
		return submitToken;
	}

	public void setSubmitToken(String submitToken) {
		this.submitToken = submitToken;
	}

	public String[] getMyBox() {
		return myBox;
	}

	public void setMyBox(String[] myBox) {
		this.myBox = myBox;
	}

	@JSON(serialize = false)
	public UserSpecSerService getUsstemp() {
		return usstemp;
	}

	public void setUsstemp(UserSpecSerService usstemp) {
		this.usstemp = usstemp;
	}


	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	@JSON(serialize = false)
	public TempService getTempser(){
		return tempser;
	}
	
	public void setTempser(TempService tempser){
		this.tempser=tempser;
	}
	
	
	
	public String agree(){
		
		UserSpecSer uss=new UserSpecSer();
		/*User user=new User();
		user.setUserId(Integer.parseInt(userId));
		uss.setUser(user);*/
		uss.setUserId(Integer.parseInt(userId));
		Service service=new Service();
		service.setServiceId(Integer.parseInt(serviceId));
		//uss.setUser(user);
		uss.setService(service);
		usstemp.add(uss);
		disagree();
		return SUCCESS;
	}

	
	public String disagree(){
		try{
			Temp temp=tempser.findyById(Integer.parseInt(tempId));
			tempser.delete(temp);
			
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return SUCCESS;	
	}
	public boolean reflash(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		//session.setAttribute("submitToken", submitToken);
		if(submitToken.equals("0")){
			submitToken="1";
			session.setAttribute("submitToken", submitToken);
			return false;
		}else{
			
			return true;
		}
		
	}
	public String addAll(){
		
		Temp temp;
		if(Integer.parseInt(myBox[0])!=0){
			temp=tempser.findyById(Integer.parseInt(myBox[0]));
			this.tempId=temp.getTempId().toString();
			this.serviceId=temp.getServiceId().toString();
			this.userId=temp.getUserId().toString();
			agree();
		}
		for(int i=1;i<myBox.length;i++){
			temp=tempser.findyById(Integer.parseInt(myBox[i]));
			this.tempId=temp.getTempId().toString();
			this.serviceId=temp.getServiceId().toString();
			this.userId=temp.getUserId().toString();
			agree();
		}
		return SUCCESS;
	}
	
	public String rejectAll(){
		if(!reflash()){
		Temp temp;
		if(Integer.parseInt(myBox[0])!=0){
			try {
				temp=tempser.findyById(Integer.parseInt(myBox[0]));
				this.tempId=temp.getTempId().toString();
				disagree();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e);
				System.out.println(submitToken);
				return ERROR;
			}
			
		}
		
		for(int i=1;i<myBox.length;i++){
			try {
				temp=tempser.findyById(Integer.parseInt(myBox[i]));
				this.tempId=temp.getTempId().toString();
				disagree();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e);
				return ERROR;
			}
		
		}
		}
		return SUCCESS;
	}

	

}
