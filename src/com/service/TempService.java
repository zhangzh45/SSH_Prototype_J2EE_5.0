package com.service;

import java.util.List;

import com.bean.Temp;
import com.bean.TempDAO;

public class TempService {
	private TempDAO tempdao;

	public TempDAO getTempdao() {
		return tempdao;
	}

	public void setTempdao(TempDAO tempdao) {
		this.tempdao = tempdao;
	}
	
	public void add(int serviceId,int userId){
		Temp temp=new Temp();
		temp.setServiceId(serviceId);
		temp.setUserId(userId);
		tempdao.save(temp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Temp> findyByUserId(int userId){
		return tempdao.findByUserId(userId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Temp> getAll(){
		return tempdao.findAll();
	}
	public Temp findyById(int tempid){
		return tempdao.findById(tempid);
	}
	public void delete(Temp temp){
		tempdao.delete(temp);
	}
	
	public List<Temp> findByServiceId(int serviceId){
		return tempdao.findByServiceId(serviceId);
	}

}
