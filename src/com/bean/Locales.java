package com.bean;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Locales {
	
	//因为本实例也需要实现国际化所以使用current作为用户当前的Locale
	private Locale current;
	
	//将当前系统支持的全部语言保持在Map对象中
	Map<String, Locale> locales = new Hashtable<String, Locale>();
	
	//取得用户当前Locale的setter方法
	public void setCurrent(Locale cur){
		this.current = cur;
	}
	
	
	
	public Locale getCurrent() {
		return current;
	}



	public void setLocales(Map<String, Locale> locales) {
		this.locales = locales;
	}



	//取得本系统所支持的全部语言
	public Map<String, Locale> getLocales(){
		
		ResourceBundle bundle = ResourceBundle.getBundle("messageResource" , current);
		
		//添加当前系统支持的语言key是系统支持语言的显示名字value是系统支持语言的Locale实例
		locales.put(bundle.getString("usen"), Locale.US);
		locales.put(bundle.getString("zhcn"), Locale.CHINA);
		return locales;
	}
}
