package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.action.ServiceAction;
import com.bean.Parameter;
import com.bean.RoleSpecSer;
import com.bean.Service;
import com.bean.UserRole;
import com.bean.UserSpecSer;
import com.service.SerService;
import com.service.UserSpecSerService;

import org.json.JSONArray;
import org.json.JSONObject;


public class WebServiceUtil 
{
	private static String SERVICES_HOST = "";
    private static String SERVICES_URL = "";
    private static String QUERY_URL = "";
   
	protected WebServiceUtil(){}
    
    public static List<String> main(String serviceHost, String serviceURL, String queryMethod, String input, List<String> OutputAtt)
    {
    	SERVICES_HOST = serviceHost;
    	SERVICES_URL = serviceURL;
    	QUERY_URL = queryMethod;
    	String results = "";
	    List<String> resultList = getOutput(input, OutputAtt);
        for(String eachResult:resultList)
        {
           results += eachResult;
           results += "\n";
        }
        return resultList;
    }
    
    public static InputStream getSoapInputStream(String url)
    {
        InputStream inputStream = null;
        try
        {
        	URL urlObj = new URL(url);
        	URLConnection urlConn = urlObj.openConnection();
        	urlConn.setRequestProperty("Host", SERVICES_HOST);    //具体webService相关
        	urlConn.connect();
        	inputStream = urlConn.getInputStream();
        }
        catch(MalformedURLException e)
        {
        	e.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        return inputStream;
    }
    
    public static List<String> getOutput(String input, List<String> OutputAtt)
    {
        List<String> resultList = new ArrayList<String>();
        Document document;
        DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
        documentBF.setNamespaceAware(true);
        try
        {
        	DocumentBuilder documentB = documentBF.newDocumentBuilder();
        	InputStream inputStream;
        	if(input.equals("undefined"))
        	{
        		inputStream = getSoapInputStream(SERVICES_URL + "/" + QUERY_URL); //###
        	}
        	else
        	{
        		inputStream = getSoapInputStream(SERVICES_URL + "/" + QUERY_URL + input); //###
        	}
        		
        	document = documentB.parse(inputStream);
        	int len;
        	
        	if(OutputAtt.size() > 0)
        	{
        		len = document.getElementsByTagName(OutputAtt.get(0)).getLength();
        	}
        	else
        	{
        		len = document.getChildNodes().getLength();
        	}
        	//NodeList nl2 = document.getElementsByTagName("ADDRESS");
        	//int len = nl.getLength();
        	for(int i = 0; i < len; i++)
        	{
        		String result = "";
        		if(OutputAtt.size() > 0)
        		{
	            	for(int j = 0; j < OutputAtt.size(); j++)
	            	{
	            		NodeList nl = document.getElementsByTagName(OutputAtt.get(j));
	            		Node n = nl.item(i);
	            		String att = n.getFirstChild().getNodeValue();
	            		System.out.println(n.getFirstChild().getNodeName() + ":"+att);
	            		result += att;
	            	}
        		}
        		else
        		{
        			NodeList nl = document.getChildNodes();
                	Node n = nl.item(i);
                	result = n.getFirstChild().getNodeValue();
        		}
        		resultList.add(result);
        	}
        	inputStream.close();
        }
        catch(UnsupportedEncodingException e)
        {
        	e.printStackTrace();
        }
        catch (DOMException e)
        {
        	e.printStackTrace();
        }
        catch (ParserConfigurationException e)
        {
        	e.printStackTrace();
        }
        catch(SAXException e)
        {
        	e.printStackTrace();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
        }
        resultList.add("全部结果如上");
        return resultList;
    }
    
}