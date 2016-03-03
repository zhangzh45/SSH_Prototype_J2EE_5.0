package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ApItemSet
{
	public List<String> itemset = new ArrayList<String>();
	
	public boolean hasInfrequentSub(ApItemSet canItemSet, List<ApItemSet> freItemSet)
	{
		boolean isInfSub = false;
		int size = canItemSet.itemset.size();
		int subNum = 0;
		for(int i = 0; i < freItemSet.size(); i++)
		{
			int counter = 0;
			
			for(int j = 0; j < canItemSet.itemset.size(); j++)
			{
				if(freItemSet.get(i).itemset.contains(canItemSet.itemset.get(j)))
				{
					counter++;
				}
			}
			if(counter == size - 1)
			{
				subNum++;
			}
		}
		if(subNum == size)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean belongTo(ApItemSet a)
	{
		for(int i = 0; i < this.itemset.size(); i++)
		{
			if(a.itemset.contains(this.itemset.get(i)))
			{
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean equalTo(ApItemSet a, ApItemSet b)
	{
		if(a.itemset.size() == b.itemset.size())
		{
			for(int i = 0; i < a.itemset.size(); i++)
			{
				if(b.itemset.contains(a.itemset.get(i)))
				{
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}