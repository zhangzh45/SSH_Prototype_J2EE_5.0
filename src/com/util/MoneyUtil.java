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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MoneyUtil 
{
	private static String SERVICES_HOST = "www.webxml.com.cn";
    private static String WEATHER_SERVICES_URL = "http://webservice.webxml.com.cn/WebServices/ForexRmbRateWebService.asmx/";
    private static String WEATHER_QUERY_URL = WEATHER_SERVICES_URL
                                              + "getForexRmbRate";
    
    static List<String> cityName = new ArrayList<String>();
    
    private MoneyUtil(){}
    
    public static List<String> main()
    {
    	String results = "";
	    //int provinceCode = getProvinceCode("广东");    //3119
	    //int cityCode = getCityCode(provinceCode, "广州");    //974
	    List<String> weatherList = getBuyPrice();
        for(int i = 0; i < weatherList.size(); i++)
        {
           results += cityName.get(i);
           results += " ";
           results += weatherList.get(i);
           results += "\n";
           weatherList.set(i, cityName.get(i) + weatherList.get(i));
        }
        System.out.println(results);
        return weatherList;
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
    
    public static List<String> getBuyPrice()
    {
        List<String> priceList = new ArrayList<String>();
        Document document;
        DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
        documentBF.setNamespaceAware(true);
        try
        {
        	DocumentBuilder documentB = documentBF.newDocumentBuilder();
        	InputStream inputStream = getSoapInputStream(WEATHER_QUERY_URL); //###
        	document = documentB.parse(inputStream);
        	NodeList nl2 = document.getElementsByTagName("Name");
        	NodeList nl = document.getElementsByTagName("mBuyPrice");
        	int len = nl.getLength();
        	for(int i = 0; i < len; i++)
        	{
        		Node n = nl.item(i);
        		String weather = n.getFirstChild().getNodeValue(); 
        		priceList.add(weather);
        		n = nl2.item(i);
        		String city = n.getFirstChild().getNodeValue();
        		cityName.add(city);
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
        return priceList;
    }
    
}