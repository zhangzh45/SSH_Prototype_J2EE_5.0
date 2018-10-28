package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mule.MuleConfig;


public class InteractWithRancherUtil
{

	//String searchRancherURL = "http://222.200.180.59:8080/v2-beta/projects/1a5/";
	String searchRancherURL = ConstantUtil.getSearchrancherurl();
	GetRemoteService grs = new GetRemoteService();

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


	/**获取指定应用的信息
	 * @param stackName 应用名称
	 * @return 应用的相关信息
	 */
	public String getStackInfo(String stackName){
		String infoStr = null;
		String getStacksURL = searchRancherURL + "stacks";
		String stackResult = grs.sendToRancher(getStacksURL, null, "GET", false);
		System.out.println("stacksresult:"+stackResult+"\n");
		if(stackResult == null) return infoStr;
		JSONObject obj = JSONObject.fromObject(stackResult);
		String stacks = obj.getString("data");
		JSONArray stacks_arr = JSONArray.fromObject(stacks);
		for(int i = 0 ; i < stacks_arr.size(); i++){
			JSONObject stack = stacks_arr.getJSONObject(i);
			if(stack.getString("name").equals(stackName)){
				JSONObject res = new JSONObject();
				res.put("stackid", stack.getString("id"));
				res.put("state", stack.getString("healthState"));
				infoStr = res.toString();
				System.out.println("infoStr:"+infoStr+"\n");
				break;
			}
		}
		return infoStr;
	}

	/**
	 * 获取应用（stack）的ID
	 * @param stackName 应用的名称
	 * @return
	 */
	public String getStackId(String stackName){
		String stackid = null;
		String stackInfo = getStackInfo(stackName);
		JSONObject stackObj = JSONObject.fromObject(stackInfo);
		if(stackObj.containsKey("stackid")) stackid = stackObj.getString("stackid");
		return stackid;
	}

	/**获取指定应用的所有服务列表
	 * @param stackName 应用名称
	 * @return 应用中的所有服务的相关信息
	 */
	public String getServicesOfStack(String stackName){
		String servicesStr = null;
		String stackid = getStackId(stackName);
		if(stackid == null) return servicesStr;
		String getServicesURL = searchRancherURL + "stacks/" + stackid + "/services";
		String servicesResult = grs.sendToRancher(getServicesURL, null, "GET", false);
		System.out.println("servicesResult:"+servicesResult+"\n");
		if(servicesResult == null) return servicesStr;
		JSONObject obj = JSONObject.fromObject(servicesResult);
		String services = obj.getString("data");
		JSONArray services_arr = JSONArray.fromObject(services);
		JSONArray servicesArr = new JSONArray();
		for(int i = 0 ; i < services_arr.size(); i++){
			JSONObject service = services_arr.getJSONObject(i);
			JSONObject res = new JSONObject();
			res.put("serviceid", service.getString("id"));
			res.put("servicename", service.getString("name"));
			res.put("servicedes", service.getString("description"));
			servicesArr.add(res);
		}
		servicesStr = servicesArr.toString();
		System.out.println("servicesStr:"+servicesStr+"\n");
		return servicesStr;
	}

	/**
	 * 重启指定应用的服务
	 * @param stackid
	 * @return
	 */
	public String activateservicesOfStack(String stackid){
		String result = null;
		if(stackid == null) return result;
		String activateURL = searchRancherURL + "stacks/" + stackid + "/?action=activateservices";
		result = grs.sendToRancher(activateURL, null, "POST", false);
		System.out.println("result:"+result+"\n");
		if(result != null){
			String pullUrl = searchRancherURL + "stacks/" + stackid;
			while(pullServiceState(pullUrl).equalsIgnoreCase("healthy") == false){  //轮询服务是否重启完成
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			result = "success";
		}
		else{
			result = "fail";
		}
		return result;
	}

	/**
	 * 轮询指定内部服务的state
	 * @param pullUrl 查询该服务的api
	 * @return
	 */
	public String pullServiceState(String pullUrl){
		String state = null;
		String servicesresult = grs.sendToRancher(pullUrl, null, "GET", false);
		JSONObject obj = JSONObject.fromObject(servicesresult);
		if(obj.containsKey("healthState")){
			state = obj.getString("healthState");
		}
		return state;
	}

	/**获取指定应用的配置文件
	 * @param stackName 应用名称
	 * @return
	 */
	public String getConfigOfStack(String stackName){
		String stackid = getStackId(stackName);
		if(stackid != null){
			String getConfigURL = searchRancherURL + "stacks/" + stackid + "/?action=exportconfig";
			String configResult = grs.sendToRancher(getConfigURL, null, "POST", false);
			System.out.println("servicesResult:"+configResult+"\n");
			JSONObject configObj = JSONObject.fromObject(configResult);
			String dockerfilecontent = configObj.getString("dockerComposeConfig");
			String rancherfilecontent = configObj.getString("rancherComposeConfig");
			try {
				//保存docker-compose.yml文件
				File dockerfile = new File(new File(MuleConfig.getMuleAppPath() + "/" + stackName), "docker-compose.yml");
				if (!dockerfile.getParentFile().exists())
				{
					dockerfile.getParentFile().mkdirs();
				}
				FileWriter dockerfw = new FileWriter(MuleConfig.getMuleAppPath() + "/" + stackName + "/docker-compose.yml", false);
				BufferedWriter dockerbw = new BufferedWriter(dockerfw);
				dockerbw.write(dockerfilecontent);
				dockerbw.close();
				dockerfw.close();

				//保存rancher-compose.yml文件
				File rancherfile = new File(new File(MuleConfig.getMuleAppPath() + "/" + stackName), "rancher-compose.yml");
				if (!rancherfile.getParentFile().exists())
				{
					rancherfile.getParentFile().mkdirs();
				}
				FileWriter rancherfw = new FileWriter(MuleConfig.getMuleAppPath() + "/" + stackName + "/rancher-compose.yml", false);
				BufferedWriter rancherbw = new BufferedWriter(rancherfw);
				rancherbw.write(rancherfilecontent);
				rancherbw.close();
				rancherfw.close();
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			return "success";
		}
		else return "error";
	}

	/**
	 * 修改指定应用的实例数量
	 * @param stackid 应用id
	 * @param scale 服务实例数量
	 * @return 是否修改成功
	 */
	public boolean editStackScale(String stackid, int scale){
		String getInternalServiceURL = searchRancherURL + "stacks";
		String editServiceURL = getInternalServiceURL + "/" + stackid;
		JSONObject paramObj = new JSONObject();
		paramObj.put("scale", scale);
		String editResult = grs.sendToRancher(editServiceURL, paramObj, "PUT", false);
		if(editResult != null){
			return true;
		}
		else{
			return false;
		}
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