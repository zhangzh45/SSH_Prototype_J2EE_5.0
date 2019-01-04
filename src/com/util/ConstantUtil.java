package com.util;

//常量类
public class ConstantUtil {

	//注 ：所有URL中的IP地址必须是运行对应项目的服务器IP地址

	//rancher api keys
	private static final String rancherAPIKeys = "token-l5p2q:96ngxr77nsxlp5fjz2k44jvwpc4r6l89x9dkb9t6hhqltkc9tqm44h";

	//查询rancher的网址
	private static final String searchRancherURL = "https://222.200.180.59:8443/v3/";

	//rancher2.0上部署和管理服务的指定项目空间GrassLand的项目ID
	private static final String grasslandProjectId = "c-vhcnl:p-dkqgg";

	//rancher2.0上部署和暴露服务的指定主机IP
	private static final String nodeIP = "222.200.180.59";

	//rancher2.0上部署服务的指定主机IDima
	private static final String nodeId = "c-vhcnl:m-77eb26772e5a";

	//部署服务的参数默认json字符串
	private static final String defaultDeployParams = "{'hostIPC':false,'hostNetwork':false,'hostPID':false,'paused':false,'type':'workload','namespaceId':'team1-private','scale':2,'dnsPolicy':'ClusterFirst','restartPolicy':'Always','labels':{},'containers':[{'initContainer':false,'restartCount':0,'stdin':true,'stdinOnce':false,'tty':true,'type':'container','privileged':false,'allowPrivilegeEscalation':false,'readOnly':false,'runAsNonRoot':false,'namespaceId':'team1-private','imagePullPolicy':'Always','environmentFrom':[],'resources':{'requests':{},'limits':{}},'capAdd':[],'capDrop':[],'image':'ubuntu:xenial','ports':[{'containerPort':'80','sourcePort':'30001','type':'containerPort','kind':'NodePort','protocol':'TCP'}],'livenessProbe':null,'name':'test','volumeMounts':[]}],'scheduling':{'node':{'nodeId':'c-vhcnl:m-77eb26772e5a'}},'deploymentConfig':{'minReadySeconds':0,'type':'deploymentConfig','revisionHistoryLimit':10,'strategy':'RollingUpdate','maxSurge':1,'maxUnavailable':0},'name':'test','volumes':[]}";

	//组织管理中心的发布地址
	private static final String demoEndpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";

	//从sysuclient端获取所有角色的URL
	private static final String getAllRoleURL = "http://127.0.0.1:8030/sysuClient/new/getAllRole.action";

	//统计图片的存放文件路径
	private static final String statisticsPicture = "E:\\workspace\\idea_projects\\SSH_Prototype_J2EE_5.0\\WebRoot\\images\\company.jpeg";

	//映射中心的根据组织角色获取业务角色的URL
	private static final String getBusiRoleByOrganRoleURL = "http://localhost:3000/rolemap/getBusiRoleByOrganRole/";

	//获取流程角色的URL，必须填本机IP的地址
	private static final String getSpecRoleURL = "http:\\\\localhost:8090\\SSH_Prototype_J2EE_5.0\\getSpecRoleFromSpec.action?specid=";

	//利用层次分析法AHP确定QoS各属性权重中，平均随机一致性指标RI的取值（根据判断矩阵的维数决定，此处维数n=6）
	private static final double  ri = 1.26;

	//istio中获取服务遥测数据prometheus的URL
    private static final String  prometheus = "http://222.200.180.59:32339/api/v1/query?query=";
    //prometheus = "http://222.200.180.59:32339/api/v1/query?query=istio_requests_total{destination_app=\"helloworld\", response_code=\"200\"}";
    //istio中获取服务请求总数的方法名，可在后面添加查询字段“istio_requests_total{destination_app=\"helloworld\"}”

    public static String getSearchrancherurl() {
		return searchRancherURL;
	}

	public static String getGrasslandProjectId() {
		return grasslandProjectId;
	}

	public static String getNodeIP() {
		return nodeIP;
	}

	public static String getNodeId() {
		return nodeId;
	}

	public static String getDefaultDeployParams() {
		return defaultDeployParams;
	}

	public static String getDemoendpoint() {
		return demoEndpoint;
	}

	public static String getGetallroleurl() {
		return getAllRoleURL;
	}

	public static String getRancherapikeys() {
		return rancherAPIKeys;
	}

	public static String getStatisticspicture() {
		return statisticsPicture;
	}

	public static String getGetbusirolebyorganroleurl() {
		return getBusiRoleByOrganRoleURL;
	}

	public static String getGetspecroleurl() {
		return getSpecRoleURL;
	}

	public static double getRi() {
		return ri;
	}

    public static String getPrometheus() {
        return prometheus;
    }

}