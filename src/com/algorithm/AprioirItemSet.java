package com.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AprioirItemSet
{
	public Set<String> itemset = new TreeSet<String>();
	
	
	
	public int test()
	{
		AprioirItemSet cc = new AprioirItemSet();
		cc.itemset.add("1");
		cc.itemset.add("2");
		cc.itemset.add("3");
		
		
		AprioirItemSet c1 = new AprioirItemSet();
		c1.itemset.add("1");
		c1.itemset.add("2");
		
		AprioirItemSet c2 = new AprioirItemSet();
		c2.itemset.add("2");
		c2.itemset.add("3");
		
		AprioirItemSet c3 = new AprioirItemSet();
		c3.itemset.add("1");
		c3.itemset.add("3");
		
		 List<AprioirItemSet> ff = new  ArrayList<AprioirItemSet>();
		 ff.add(c1);
		 ff.add(c2);
		 
		
		 //ff.add(c3);
		 
		 if(hasInfrequentSub(cc, ff))
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
		 
	}
	
	public boolean hasInfrequentSub(AprioirItemSet canItemSet, List<AprioirItemSet> freItemSet)
	{
		for(int i = 0; i < canItemSet.itemset.size(); i++)
		{
			//System.out.println(canItemSet.itemset.toString());
			int counter = 0;
			Iterator<String> it = canItemSet.itemset.iterator();
			Set<String> subitemset = new TreeSet<String>();
			while(it.hasNext())
			{
				String str = it.next();
				if(i != counter)
				{
					subitemset.add(str);
				}
				counter++;
			}
			//System.out.println(subitemset.toString());
			boolean belongto = false;
			for(int j = 0; j < freItemSet.size(); j++)
			{
				if(freItemSet.get(j).itemset.equals(subitemset))
				{
					belongto = true;
				}
			}
			if(belongto == false)
			{
				return true;
			}
		}
		
		return false;
	}
}