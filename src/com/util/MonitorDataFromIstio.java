package com.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//从istio获取服务监控的运行时数据
//提供了接口获取服务的响应时间、运行次数等，需要添加查询字段
//并需要对数据进行简单的处理，目前没有完整的数据，都是聚合后的统计数据

//需要获取的QoS属性数据
//可用性
//繁忙程度
//可靠性
//响应时间
//后面两项需要更新到service数据库中
public class MonitorDataFromIstio
{

	GetRemoteService grs = new GetRemoteService();

	public MonitorDataFromIstio() {
	}

	/**
	 * 从istio得到可靠性数据
	 * @param serviceName
	 * @return
	 */
	public double getReliability(String serviceName) {
		double reliability = 1.0;
		int totalNum = getRequestTotal(serviceName);
		int successNum = getRequestSuccessTotal(serviceName);
		if(totalNum != 0){
			reliability = successNum * 1.0 / totalNum;
		}
		reliability = (double) Math.round(reliability * 10000) / 10000; //保留4位小数
		System.out.println(reliability);
		return reliability;
	}

	/**
	 * 从istio得到响应时间数据
	 * @param serviceName
	 * @return
	 */
	public double getServiceTime(String serviceName) {
		return getAvgRequestTime(serviceName);
	}

	/**
	 * 从istio得到可用性数据
	 * @param serviceName
	 * @return
	 */
	public double getAvailability(String serviceName) {
		double availability = 1.0;
		int availableNum = getRequestAvailableTotal(serviceName);
		int totalNum = getRequestTotal(serviceName);
		if(totalNum != 0){
			availability = availableNum * 0.1 / totalNum;
		}
		availability = (double) Math.round(availability * 10000) / 10000; //保留4位小数
		System.out.println(availability);
		return availability;
	}

	/**
	 * 从istio得到繁忙程度数据
	 * @param serviceName
	 * @return
	 */
	public double getBusyDegree(String serviceName) {
		return getAvgRequestRate(serviceName);
	}

	/**
	 * 获取指定服务的请求总数
	 * @param serviceName
	 * @return
	 */
	public int getRequestTotal(String serviceName){
		int requestNum = 0;
	    String prometheus = ConstantUtil.getPrometheus();
	    String query = "sum(istio_requests_total{destination_app='" + serviceName + "'})";
	    String queryURL = prometheus + query;
	    System.out.println(queryURL);
		String result = null;
	    try{
			result = sendHttp(queryURL);
		}catch(Exception e){
	    	e.printStackTrace();
		}
		System.out.println(result);
	    if(result != null){
			String num = parseIstioResult(result);
			if(num == null){
				requestNum = 0;
			}
			else{
				requestNum = Integer.parseInt(num);
			}
		}
		return requestNum;
    }

	/**
	 * 获取指定服务的请求成功总数
	 * @param serviceName
	 * @return
	 */
	public int getRequestSuccessTotal(String serviceName){
		int requestSuccessNum = 0;
		String prometheus = ConstantUtil.getPrometheus();
		String query = "sum(istio_requests_total{destination_app='" + serviceName + "',response_code='200'})";
		String queryURL = prometheus + query;
		System.out.println(queryURL);
		String result = null;
		try{
			result = sendHttp(queryURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(result);
		if(result != null){
			String num = parseIstioResult(result);
			if(num == null){
				requestSuccessNum = 0;
			}
			else{
				requestSuccessNum = Integer.parseInt(num);
			}
		}
		return requestSuccessNum;
	}

	/**
	 * 获取指定服务的请求可用的总数
	 * 返回结果为404，视为服务不可用
	 * @param serviceName
	 * @return
	 */
	public int getRequestAvailableTotal(String serviceName){
		int requestAvailableNum = 0;
		String prometheus = ConstantUtil.getPrometheus();
		String query = "sum(istio_requests_total{destination_app='" + serviceName + "',response_code!='404'})";
		String queryURL = prometheus + query;
		System.out.println(queryURL);
		String result = null;
		try{
			result = sendHttp(queryURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(result);
		if(result != null){
			String num = parseIstioResult(result);
			if(num == null){
				requestAvailableNum = 0;
			}
			else{
				requestAvailableNum = Integer.parseInt(num);
			}
		}
		return requestAvailableNum;
	}

	/**
	 * 获取指定服务的平均响应时间
	 * @param serviceName
	 * @return
	 */
	public double getAvgRequestTime(String serviceName){
		double requestTime = 0.1;  //以秒为单位
		String prometheus = ConstantUtil.getPrometheus();
		String query = "avg(istio_request_duration_seconds_sum{destination_app='" + serviceName + "'})";
		String queryURL = prometheus + query;
		System.out.println(queryURL);
		String result = null;
		try{
			result = sendHttp(queryURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(result);
		if(result != null){
			String time = parseIstioResult(result);
			if(time == null){
				requestTime = 1;
			}
			else{
				requestTime = Double.parseDouble(time);
			}
		}
		requestTime = (double) Math.round(requestTime * 10000) / 10000; //保留4位小数
		System.out.println(requestTime);
		return requestTime;
	}

	/**
	 * 获取指定服务的请求比例/速率，视作繁忙程度
	 * 时间跨度：1小时
	 * @param serviceName
	 * @return
	 */
	public double getAvgRequestRate(String serviceName){
		double requestRate = 0.8;  //以秒为单位
		String prometheus = ConstantUtil.getPrometheus();
		String query = "avg(rate(istio_requests_total{destination_app='" + serviceName + "'}[1h]))";
		String queryURL = prometheus + query;
		System.out.println(queryURL);
		String result = null;
		try{
			result = sendHttp(queryURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(result);
		if(result != null){
			String rate = parseIstioResult(result);
			if(rate == null){
				requestRate = 1;
			}
			else{
				requestRate = Double.parseDouble(rate);
			}
		}
		requestRate = (double) Math.round(requestRate * 10000) / 10000; //保留4位小数
		System.out.println(requestRate);
		return requestRate;
	}

    public String parseIstioResult(String str){
		String num = null;
		JSONObject obj = JSONObject.fromObject(str);
		if(obj.containsKey("status") && obj.getString("status").equals("success")){
			String data = obj.getString("data");
			JSONObject dataObj = JSONObject.fromObject(data);
			if(dataObj.containsKey("result")){
				JSONArray resultArr = JSONArray.fromObject(dataObj.get("result"));
				for(int i = 0; i < resultArr.size(); i++){
					JSONObject resultObj = resultArr.getJSONObject(i);
					if(resultObj.containsKey("value")){
						String value = resultObj.getString("value");
						if(value != null && value.length() > 2){
							return getStringInQuotationMarks(value);
						}
					}
					break;
				}
			}
		}
		return num;
	}

	/**
	 * 提取引号中间的字符串
	 * @param str
	 * @return
	 */
	public String getStringInQuotationMarks (String str){
		System.out.println("strbefore:" + str);
		Pattern p = Pattern.compile("\"(.*?)\"");
		Matcher m=p.matcher(str);
		int i = 0;
		while(m.find())
		{
			//str=str.replace(m.group(),""+(i++));
			str = m.group().trim().replace("\"","");
			break;
		}
		System.out.println("after:"+str);
		return str;
	}

	/**
	 * 发送http请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String sendHttp(String url) throws Exception {
		URL localURL = new URL(url);
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;
		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
		}
		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);
			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (inputStreamReader != null) {
				inputStreamReader.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return resultBuffer.toString();
	}



}

