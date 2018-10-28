package com.util;

import com.mule.MuleConfig;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

///获取服务监控的运行时数据
public class MonitorData
{

	//String searchRancherURL = "http://222.200.180.59:8080/v2-beta/projects/1a5/";
	String searchRancherURL = ConstantUtil.getSearchrancherurl();
	GetRemoteService grs = new GetRemoteService();


	public void getDataFromGrassland(){
		//可靠性数据
		//可用性数据
		//响应时间
		//繁忙程度
	}


	public void getReliability(){

	}
	public void getAvailiability(){

	}
	public void getTime(){

	}
	public void getLoadDegree(){

	}


	/**
	 * 实现通过rancher API自动部署服务
	 * 目前是指定项目和部署主机，启动的容器端口指定为80
	 * @param serviceName 服务名称
	 * @param namespace  部署的命名空间
	 * @param scale  服务的部署规模
	 * @param dockerImage  服务的docker镜像
	 * @param servicePort  服务的暴露端口
	 * @return 部署成功的服务ID
	 */
	public String deployService(String serviceName, String namespace, String scale, String dockerImage, String servicePort){
		String projectId  = ConstantUtil.getGrasslandProjectId();
		String nodeId = ConstantUtil.getNodeId();
		String params = ConstantUtil.getDefaultDeployParams();
		JSONObject paramObj = JSONObject.fromObject(params);
		paramObj.put("namespaceId", namespace);
		paramObj.put("scale", Integer.parseInt(scale));
		if(paramObj.containsKey("containers")){
			String containers = paramObj.get("containers").toString();
			containers = containers.substring(1, containers.length() - 1); //删除字符串首尾的[]，使符合json格式
			JSONObject containersObj = JSONObject.fromObject(containers);
			containersObj.put("namespaceId", namespace);
			containersObj.put("image", dockerImage);
			if(containersObj.containsKey("ports")){
				String ports = containersObj.get("ports").toString();
				ports = ports.substring(1, ports.length() - 1); //删除字符串首尾的[]，使符合json格式
				JSONObject portsObj = JSONObject.fromObject(ports);
				try{
					int port = Integer.parseInt(servicePort);
					portsObj.put("sourcePort", servicePort);
				}catch(Exception e){   //端口转化失败，表明是选择了随机端口
					if(portsObj.containsKey("sourcePort")){
						portsObj.remove("sourcePort");
					}
				}
				containersObj.put("ports", "[" + portsObj.toString() + "]"); //补全字符串首尾的[]，使符合json格式
			}
			containersObj.put("name", serviceName);
			paramObj.put("containers", "[" + containersObj.toString() + "]"); //补全字符串首尾的[]，使符合json格式
		}
		paramObj.put("name", serviceName);
		System.out.println(paramObj.toString());
		String deployUrl = searchRancherURL + "projects/" + projectId + "/workload";
		String deployResult = grs.sendToRancher(deployUrl, paramObj, "POST", false);
		if(deployResult != null){
			System.out.println(deployResult);
			JSONObject serviceObj = JSONObject.fromObject(deployResult);
			if(serviceObj.containsKey("id")){
				return serviceObj.get("id").toString();
			}
		}
		return null;   //表示部署失败
	}

	/**
	 * 获取服务的地址：主机IP:PORT
	 * 主机IP指定为部署服务的主机IP
	 * @param serviceId  服务ID
	 * @return 服务的访问地址
	 */
	public String getServiceAddress(String serviceId){
		String projectId  = ConstantUtil.getGrasslandProjectId();
		String nodeIP = ConstantUtil.getNodeIP();
		String getServiceURL = searchRancherURL + "projects/" + projectId + "/workloads/" + serviceId;
		String result = grs.sendToRancher(getServiceURL, null, "GET", false);
		if(result != null){
			System.out.println(result);
			JSONObject resultObj = JSONObject.fromObject(result);
			if(resultObj.containsKey("publicEndpoints")){
				String endpointsStr = resultObj.get("publicEndpoints").toString();
				endpointsStr = endpointsStr.substring(1, endpointsStr.length() - 1);
				JSONObject endpointsObj = JSONObject.fromObject(endpointsStr);
				if(endpointsObj.containsKey("port")){
					String port = endpointsObj.get("port").toString();
					String serviceAddress = "http://" + nodeIP + ":" + port;
					return serviceAddress;
				}
			}
		}
		return null;   //表示查询失败
	}

	/**
	 * 获取对应服务的scale（实例数）
	 * @param deployId 服务部署的ID
	 * @return
	 */
	public String getServiceScale(String deployId){
		String scaleStr = null;
		String getInternalServiceURL = searchRancherURL + "project/" + ConstantUtil.getGrasslandProjectId() + "/workloads/" + deployId;
		String servicesresult = grs.sendToRancher(getInternalServiceURL, null, "GET", false);  //json格式的服务列表
		System.out.println("servicesresult:"+servicesresult+"\n");
		if(servicesresult == null) return scaleStr;
		JSONObject obj = JSONObject.fromObject(servicesresult);
		scaleStr = obj.getString("scale");
		return scaleStr;
	}

    /**
     * 移除rancher上部署的相应服务
     * @param serviceId 服务ID
     * @return 布尔值，表示是否删除成功
     */
    public boolean deleteService(String serviceId){
        String projectId  = ConstantUtil.getGrasslandProjectId();
        String deleteServiceURL = searchRancherURL + "projects/" + projectId + "/workloads/" + serviceId;
        String result = grs.sendToRancher(deleteServiceURL, null, "DELETE", false);
        if(result != null){
            System.out.println(result);
            return true;
        }
        return false;   //表示删除失败
    }
}