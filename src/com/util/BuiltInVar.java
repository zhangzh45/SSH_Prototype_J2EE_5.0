package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuiltInVar
{
	public static String[] times = {"year", "month", "date", "hour", "minute", "second", "day"};
	
	
	public static String getVarValue(String s)
	{
		List<String> ls = new ArrayList<String>();
		for(int i = 0; i < times.length; i++)
		{
			ls.add(times[i]);
		}
		
		if(ls.contains(s))
		{
			Date dt = new Date();
			if(s.equals("year"))
			{
				DateFormat df = new SimpleDateFormat("yyyy");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else if(s.equals("month"))
			{
				DateFormat df = new SimpleDateFormat("MM");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else if(s.equals("date"))
			{
				DateFormat df = new SimpleDateFormat("dd");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else if(s.equals("hour"))
			{
				DateFormat df = new SimpleDateFormat("HH");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else if(s.equals("minute"))
			{
				DateFormat df = new SimpleDateFormat("mm");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else if(s.equals("second"))
			{
				DateFormat df = new SimpleDateFormat("ss");//设置显示格式
				String nowTime="";
				nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
				return nowTime;
			}
			else
			{
				return "NULL";
			}
		}
		else
		{
			return "NULL";
		}
	}
	
}