package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.beq.util.win32.registry.RegistryKey;
import ca.beq.util.win32.registry.RegistryValue;
import ca.beq.util.win32.registry.RootKey;

public class RegisterKey
{	
	public static List<String> main()
	{
		System.loadLibrary("jRegistryKey");
		List<String> keys = new ArrayList<String>();
		RegistryKey r = new RegistryKey(RootKey.HKEY_CURRENT_USER, "Software");  
		if(r.hasValues()) 
		{  
		   Iterator i = r.values();  
		   while(i.hasNext()) 
		   {  
		      RegistryValue v = (RegistryValue)i.next();  
		      System.out.println(v.toString());
		      keys.add(v.toString());
		   } // while  
		} // if
		return keys;
	}
}

