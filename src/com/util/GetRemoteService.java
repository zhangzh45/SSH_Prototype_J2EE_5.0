package com.util;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;



import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//从服务端获取服务
/**
 *从服务中心获取用户对应的服务
 * @author liaoyu
 *
 */
public class GetRemoteService {
		 private static  String result;

		 /**
		  * 用户登录验证
		  * @param userid
		  * @param password
		  * @return
		  */
	     public  String loginVerify(String userid, String password) {
	    	//调用的组织管理中心的地址
	 		String endpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";
	 		System.out.println(userid+"result");
        //直接引用远程的wsdl文件
       //以下都是套路 
		  try
		  {
	          Service service = new Service();
	          Call call = (Call) service.createCall();
	          call.setTargetEndpointAddress(endpoint);
	          call.setOperationName(new QName("http://server.com/", "loginVerify")); //WSDL里面描述的接口名称
	          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
	                        javax.xml.rpc.ParameterMode.IN);//接口的参数
	          call.addParameter("arg1", org.apache.axis.encoding.XMLType.XSD_STRING,
                      javax.xml.rpc.ParameterMode.IN);//接口的参数
	          call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
	          //String result2 = (String)call.invoke(new Object[]{temp, temp});
	          //List<Map<String,Object>> li=new ArrayList<Map<String,Object>>();
	        //  JSONArray js=new JSONArray();
	        
	          //result= (String)call.invoke(new Object[]{userid});
	         result = (String)call.invoke(new Object[]{userid, password});
	          //给方法传递参数，并且调用方法
	         // System.out.println("result is "+result2);
	       
	          System.out.println(result+"///");
	          return result;
	         
		  }
		  catch (Exception e) 
		  {
			  //WebServiceService server = new WebServiceService();
			  //WebServiceDelegate dd = server.getWebServicePort();
			  
			  //String result = dd.sayHello("hewei");
			  
			  //System.out.println(result);
            System.err.println(e.toString());
            return null;
		  }
		}
	
	     /**
	      * 判断用户是不是管理员
	      * @param userid
	      * @return
	      */
	     public  boolean isAdmin(String userid) {
		    	//调用的组织管理中心的地址
		 		String endpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";
		 		System.out.println(userid+"result");
	        //直接引用远程的wsdl文件
	       //以下都是套路 
			  try
			  {
		          Service service = new Service();
		          Call call = (Call) service.createCall();
		          call.setTargetEndpointAddress(endpoint);
		          call.setOperationName(new QName("http://server.com/", "isAdmin")); //WSDL里面描述的接口名称
		          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
		                        javax.xml.rpc.ParameterMode.IN);//接口的参数
		         result = (String)call.invoke(new Object[]{userid});
		          System.out.println(result+"///");
		          
		          
		          JSONArray json = JSONArray.fromObject(result ); // 棣栧厛鎶婂瓧绗︿覆杞垚 JSONArray  瀵硅薄
				  System.out.println(json.toString()+"="+result+"\n") ;
				  Map<String ,String> mp=new HashMap<String,String>();
			         if(json.size()>0){
			           for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
			             JSONObject job = json.getJSONObject(i); 
			             if(job.getString("userid").equals(userid)){
			            		 if(job.containsKey("Administrator") && job.getString("Administrator").equalsIgnoreCase("1")){
			     					return true;    //为管理员
			     				 }else{
			     					return false;
			     				 }
			            }else{
			            	return false;
			            }	 
			          }
			        }
		          
		          return false;
		         
			  }
			  catch (Exception e) 
			  {
	            System.err.println(e.toString());
	            return false;
			  }
			}  
	     
	     
	     /**
	      * 从组织管理系统获取组织角色
	      * @param userid
	      * @param password
	      * @return
	      */
	     public  String getPosition(String userid) {
		    	//调用的组织管理中心的地址
		 		String endpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";
		 		System.out.println(userid+"result");
	        //直接引用远程的wsdl文件
	       //以下都是套路 
			  try
			  {
		          Service service = new Service();
		          Call call = (Call) service.createCall();
		          call.setTargetEndpointAddress(endpoint);
		          call.setOperationName(new QName("http://server.com/", "getPosition")); //WSDL里面描述的接口名称
		          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
		                        javax.xml.rpc.ParameterMode.IN);//接口的参数
		          call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
		          result = (String)call.invoke(new Object[]{userid});
		          //给方法传递参数，并且调用方法
		          System.out.println(result+"///");
		          return result;
		         
			  }
			  catch (Exception e) 
			  {
	            System.err.println(e.toString());
	            return null;
			  }
			}   
	     
	     
	/**
	 * 从映射中心获得用户对应的应用角色
	 * @param userid
	 * @param positionlist
	 * @return
	 */
	public  String getApplicationRoles(String positionsResult) {
    	//调用的映射中心的地址
 		String endpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";
	 	  
    //直接引用远程的wsdl文件
   //以下都是套路 
	  try
	  {
          Service service = new Service();
          Call call = (Call) service.createCall();
          call.setTargetEndpointAddress(endpoint);
          call.setOperationName(new QName("http://server.com/", "getPosition")); //WSDL里面描述的接口名称
          call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
                        javax.xml.rpc.ParameterMode.IN);//接口的参数
          call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
          //String result2 = (String)call.invoke(new Object[]{temp, temp});
          //List<Map<String,Object>> li=new ArrayList<Map<String,Object>>();
        //  JSONArray js=new JSONArray();
        
          //result= (String)call.invoke(new Object[]{userid});
         result = (String)call.invoke(new Object[]{positionsResult});
          //给方法传递参数，并且调用方法
         // System.out.println("result is "+result2);
       
          System.out.println(result);
          return result;
         
	  }
	  catch (Exception e) 
	  {
        System.err.println(e.toString());
        return null;
	  }
	 }
	
	/**
     * 从组织管理中心获取用户数量
     * @return
     */
    public  String getUserNum() {
	    //调用的组织管理中心的地址
	 	String endpoint = "http://127.0.0.1:8020/demo/EmployeeServerInterfacePort?wsdl";
	 	String UserNum = "";
		  try
		  {
	          Service service = new Service();
	          Call call = (Call) service.createCall();
	          call.setTargetEndpointAddress(endpoint);
	          call.setOperationName(new QName("http://server.com/", "getEmployeeNum")); //WSDL里面描述的接口名称
	          result = (String)call.invoke(new Object[]{});
	          System.out.println(result+"///");
	          JSONArray json = JSONArray.fromObject(result ); // 棣栧厛鎶婂瓧绗︿覆杞垚 JSONArray  瀵硅薄
			  System.out.println(json.toString()+"="+result+"\n") ;
			  Map<String ,String> mp=new HashMap<String,String>();
		         if(json.size()>0){
		           for(int i=0;i<json.size();i++){// 閬嶅巻 jsonarray 鏁扮粍锛屾妸姣忎竴涓璞¤浆鎴?json 瀵硅薄
		             JSONObject job = json.getJSONObject(i); 
		             UserNum = job.getString("userNum"); 
		             break;
		          }
		        }
		  }
		  catch (Exception e) 
		  {
          	System.err.println(e.toString());
		  }
		  return UserNum;
		} 
}
