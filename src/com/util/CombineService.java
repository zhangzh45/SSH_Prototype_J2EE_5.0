package com.util;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class CombineService {
	public static String main(String s) {
		  // TODO Auto-generated method stub
		  
		  //String endpoint = "http://localhost:8080/ServiceInf/DemoPort?wsdl";
		  String endpoint = "http://localhost:8020/SSH_Prototype_J2EE_5.0/GetServiceInfoPort?wsdl";
          //直接引用远程的wsdl文件
         //以下都是套路 
		  try
		  {
	          Service service = new Service();
	          Call call = (Call) service.createCall();
	          call.setTargetEndpointAddress(endpoint);  
	          call.setOperationName(new QName("http://server/", "sayHello")); //WSDL里面描述的接口名称
	          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
	                        javax.xml.rpc.ParameterMode.IN);//接口的参数
	          call.addParameter("arg1", org.apache.axis.encoding.XMLType.XSD_STRING,
                      javax.xml.rpc.ParameterMode.IN);//接口的参数
	          call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
	          String temp = s;
	          String result2 = (String)call.invoke(new Object[]{temp, temp});
	          //给方法传递参数，并且调用方法
	          //System.out.println("result is "+result2);
	          result2 = result2;
	          return result2;
		  }
		  catch (Exception e) 
		  {
			  
			  //endpoint="http://localhost:8080/SayHello/Demo2Port?wsdl";
			  endpoint = "http://zhangzhao-pc:8080/SSH_Prototype_J2EE_5.0/GetServiceInfoPort?wsdl";
			  try
			  {
				  Service service = new Service();
		          Call call = (Call) service.createCall();
		          call.setTargetEndpointAddress(endpoint);
		          //call.setOperationName(new QName("http://server/", "sayHello")); //WSDL里面描述的接口名称
		          call.setOperationName(new QName("http://zhangzhao-pc:8080/SSH_Prototype_J2EE_5.0/GetServiceInfoPort/", "getAllService")); //WSDL里面描述的接口名称
		          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
		                        javax.xml.rpc.ParameterMode.IN);//接口的参数
		          call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
		          String temp = s;
		          String result2 = (String)call.invoke(new Object[]{temp});
		          //给方法传递参数，并且调用方法
		          //System.out.println(result2 + "I am SayHello ");
		          result2 = result2 + e.toString();
		          return result2;
			  }
			  catch(Exception e1)
			  {
				  e1.printStackTrace();
			  }
		  }
		  return "All service crashed!"; 
		}
		//统计服务使用情况
		//网上服务搜索
		//服务关系可视化
		//服务组合
}
