package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;



import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

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
	/*public  String getApplicationRoles(String positionsResult) {
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
	 }*/
	
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
    
    
    public String postForm(String url, String userId, String organName, String appName, String positions) {  
        String reponse = "";
    	
    	// 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("empId", userId));  
        formparams.add(new BasicNameValuePair("organName", organName));  
        formparams.add(new BasicNameValuePair("appName", appName));
        formparams.add(new BasicNameValuePair("positions", positions));  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = (HttpEntity) response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    reponse = EntityUtils.toString((org.apache.http.HttpEntity) entity, "UTF-8");
                    System.out.println("Response content: " + EntityUtils.toString((org.apache.http.HttpEntity) entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
       return reponse;
    }  
    
    
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static String httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
              //  entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	System.out.println("********发送成功！********");
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                	jsonResult = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                } catch (Exception e) {
                	System.out.println("post请求提交失败:" + url);
                }
            }
        } catch (IOException e) {
        	System.out.println("post请求提交失败:" + url);
        }
        return jsonResult;
    }
    
    
    
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String httpGet(String url){
        //get请求返回结果
        String strResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	System.out.println("********发送成功！********");
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                //jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
            	System.out.println("get请求提交失败:" + url);
            }
        } catch (IOException e) {
        	System.out.println("get请求提交失败:" + url);
        }
        return strResult;
    }
    
    /**
     * 从sysuclient端获取所有角色
     * @param userid
     * @param password
     * @return
     */
    public  String getAllRole(String user, String password) {
    	String url = "http://127.0.0.1:8080/sysuClient/new/getAllRole.action?userid="+user+"&passwd="+password;
    	result = httpGet(url);
    	/*String url = "http://127.0.0.1:8080/sysuClient/new/getAllRole.action";
    	JSONObject param = new JSONObject();
    	param.put("userid", user);
    	param.put("passwd", password);
    	result = httpPost(url, param, true);*/
    	System.out.println("roleresult"+result);
    	return result;
	}
}
