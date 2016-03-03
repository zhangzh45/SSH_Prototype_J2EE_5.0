package com.util;

import java.io.*; 
import java.util.*; 
import org.w3c.dom.*; 
import javax.xml.parsers.*; 

public class MuleXMLParser
{ 
	public static void parse(File f)
	{
		try
		{
			//File f=new File("data_10k.xml"); 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder =factory.newDocumentBuilder(); 
			Document doc = builder.parse(f); 
			NodeList nl = doc.getElementsByTagName("flow");
			NodeList nl2 = doc.getElementsByTagName("sub-flow");
			System.out.println(nl.getLength());
			for (int i = 0; i < nl.getLength(); i++)
			{
				Element e = (Element)nl.item(i);
				System.out.println(e.getAttribute("name"));
				//System.out.println((Element)(nl.item(i)).getAttributes());
				//System.out.println(doc.getElementsByTagName("logger").item(i).getFirstChild().getNodeValue()); 
			}
			for(int i = 0; i < nl2.getLength(); i++)
			{
				Element e = (Element)nl2.item(i);
				System.out.println(e.getAttribute("name"));
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
}