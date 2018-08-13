package com.service.interfce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.action.ServiceAction;
import com.bean.Service;
import com.bean.Serviceclass;
import com.bean.ServiceclassId;
import com.bean.SimpleService;
import com.opensymphony.xwork2.ActionSupport;
import com.server.ServiceInfo;
import com.service.SerService;
import com.service.ServiceclassService;


/**
 * 
 * @author zhangzhao
 * 连接editor，提供服务资源的接口
 *
 */
public class EditorConnectionInterface extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	ServiceclassService sclasssr = new ServiceclassService();
	SerService srs = new SerService();
	
	public ServiceclassService getSclasssr() {
		return sclasssr;
	}

	public void setSclasssr(ServiceclassService sclasssr) {
		this.sclasssr = sclasssr;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	
	/**
	 * 获取系统中的所有服务类，包含服务类型、服务目标和服务范围
	 * @return
	 */
	public String getServiceClasses(){
		List<Serviceclass> classes = new ArrayList<Serviceclass>();
		classes = sclasssr.findAll();
		Map<ServiceclassId, List<Service>> map = new HashMap<ServiceclassId, List<Service>>();
		for(int i = 0; i < classes.size(); i++){
			Serviceclass sclass = new Serviceclass();
			sclass = classes.get(i);
			List<Service> serslist = new ArrayList<Service>();
			String services = sclass.getServices();
			if(services != null){
				String[] sers = services.split(",");
				for(int j = 0 ; j < sers.length; j++){
					if(sers[j].length() != 0){
						Service s = srs.getUniqueService(sers[j]);
						serslist.add(s);
					}
				}
			}
			map.put(sclass.getId(), serslist);
		}
		return map.toString();
		//return success?????
	}
	
	/**
	 * 根据指定的服务类ID获取其中的子服务
	 * @param id 服务类ID
	 * @return
	 */
	public List<Service> getServicesFromClass(ServiceclassId id){
		Serviceclass sclass = sclasssr.findById(id); 
		List<Service> serslist = new ArrayList<Service>();
		String services  = sclass.getServices();
		if(services != null){
			String[] sers = services.split(",");
			for(int j = 0 ; j < sers.length; j++){
				if(sers[j].length() != 0){
					Service s = srs.getUniqueService(sers[j]);
					serslist.add(s);
				}
			}
		}
		return serslist;
	}

	
}
