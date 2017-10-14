package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseJSONUtil 
{
	
	public int getServiceReplicas(String servicesresult, String docker_servicename){
		int replicas = 1;
		JSONArray internalServices = JSONArray.fromObject(servicesresult);
		for(int i = 0 ; i < internalServices.size(); i++){
			JSONObject service = internalServices.getJSONObject(i);
			//String SpecStr = "[" + service.getString("Spec") + "]";
			//JSONArray SpecJson = JSONArray.fromObject(SpecStr);
			JSONObject Spec = JSONObject.fromObject(service.getString("Spec"));
			//if(SpecJson.size() > 0){
				//JSONObject Spec = SpecJson.getJSONObject(0);
				String Name = Spec.getString("Name");
				if(Name.equals(docker_servicename)){
					//String ModeStr = "[" + Spec.getString("Mode") + "]";
					//JSONArray ModeJson = JSONArray.fromObject(ModeStr);
					JSONObject Mode = JSONObject.fromObject(Spec.getString("Mode"));
					//if(ModeJson.size() > 0){
						//JSONObject Mode = ModeJson.getJSONObject(0);
						//String ReplicatedStr = "[" + Mode.getString("Replicated") + "]";
						//JSONArray ReplicatedJson = JSONArray.fromObject(ReplicatedStr);
						JSONObject Replicated = JSONObject.fromObject(Mode.getString("Replicated"));
						//if(ReplicatedJson.size() > 0){
							//JSONObject Replicated = ReplicatedJson.getJSONObject(0);
							if(Replicated.containsKey("Replicas")){
								replicas = Replicated.getInt("Replicas");
								System.out.println("replicas_in:"+replicas+"\n");
							}
						//}
					//}
					break;
				}
			//}
		}
		return replicas;
	}
    
	/**
	 * 获取对应服务的scale（实例数）
	 * @param servicesresult json格式的服务列表
	 * @param servicename 服务名称
	 * @return
	 */
	public String getServiceScale(String servicesresult, String servicename){
		String scaleStr = null;
		if(servicesresult == null) return scaleStr;
		JSONObject obj = JSONObject.fromObject(servicesresult);
		String services = obj.getString("data");
		JSONArray services_arr = JSONArray.fromObject(services);
		for(int i = 0 ; i < services_arr.size(); i++){
			JSONObject service = services_arr.getJSONObject(i);
			if(service.getString("name").equals(servicename)){
				int currentScale = service.getInt("currentScale");
				int scale = service.getInt("scale");
				JSONObject res = new JSONObject();
				res.put("serviceid", service.getString("id"));
				res.put("state", service.getString("state"));
				res.put("currentScale", currentScale);
				res.put("scale", scale);
				scaleStr = res.toString();
				System.out.println("currentScale:"+currentScale+"scale:"+scale+"\n");
				System.out.println("scaleStr:"+scaleStr+"\n");
				break;
			}
		}
		return scaleStr;
	}
}