package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import com.bean.Runlog;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RunlogService;

public class RunlogAction extends ActionSupport
{
	private RunlogService runlogsr;
	List<Runlog> rls = new ArrayList<Runlog>();

	String serviceid;
	String userid;

	public RunlogService getRunlogsr() {
		return runlogsr;
	}

	public void setRunlogsr(RunlogService runlogsr) {
		this.runlogsr = runlogsr;
	}
	
	public List<Runlog> getRls() {
		return rls;
	}

	public void setRls(List<Runlog> rls) {
		this.rls = rls;
	}
	
	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String runlog(){
		try{
			rls.clear();
			System.out.print(serviceid+"\n");
			int sid = Integer.parseInt(serviceid);
			System.out.print("sid:"+sid+"\n");
			rls = runlogsr.findByServiceid(sid);
			System.out.println("rls:" + rls.size()+"\n");
			/*for(int i=0;i < rls.size(); i++){
				System.out.println(rls.get(i).getStarttime()+"\n");
				Date starttime = rls.get(i).getStarttime();
				
				String timeString = starttime.toString().substring(0, starttime.toString().indexOf("."));
				System.out.println(timeString+"\n");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    Date datetime = sdf.parse(timeString);
				System.out.println("date:"+starttime+"\n");
				System.out.println("date:"+datetime+"\n");
				rls.get(i).setStarttime(datetime);
				
			}*/
			System.out.println("rls:" + rls.size()+"\n");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
}