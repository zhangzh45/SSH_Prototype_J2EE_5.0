package com.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aprioir
{
	public int min_sup;
	public int k;
	public List<AprioirItemSet> items = new ArrayList<AprioirItemSet>();
	
	public List<AprioirItemSet> l1 = new ArrayList<AprioirItemSet>();
	public List<AprioirFrequentSet> ls = new ArrayList<AprioirFrequentSet>();
	
	
	
	
	public void test()
	{
		for(int i = 0; i < AprioirData.data2.length; i++)
		{
			AprioirItemSet a = new AprioirItemSet();
			for(int j = 0; j < AprioirData.data2[i].length; j++)
			{
				a.itemset.add(Integer.toString(AprioirData.data2[i][j]));
			}
			items.add(a);
		}
		double sup = 0.5;
		min_sup = (int) (AprioirData.data2.length * sup);
		k = 10;
		System.out.println("A");
		aprioirAlgorrithm();
		for(int i = 0; i < l1.size(); i++)
		{
			//System.out.println(l1.get(i).itemset.toString());
		}
		
		for(int i = 0; i < ls.get(1).c.size(); i++)
		{
			//System.out.println(ls.get(1).c.get(i).itemset.toString());
		}
		System.out.println("AAA");
		for(int i = 0; i < ls.get(4).l.size(); i++)
		{
			//System.out.println(ls.get(4).l.get(i).itemset.toString() + ": " + ls.get(4).lfre.get(i).toString());
		}
		for(int i = 0; i < ls.get(5).l.size(); i++)
		{
			//System.out.println(ls.get(5).l.get(i).itemset.toString() + ": " + ls.get(5).lfre.get(i).toString());
		}
	}
	
	public void aprioirAlgorrithm()
	{
		for(int i = 0; i <= k; i++)
		{
			AprioirFrequentSet af = new AprioirFrequentSet();
			ls.add(af);
		}
		
		ls.get(0).l = l1 = find_frequent_1_itemsets();
		
		for(int i = 1; i <= k; i++)
		{
			apriori_gen(i);
		}
	}
	
	
	public void apriori_gen(int lk)
	{
		//int sum  = 0;
		for(int i = 0; i < ls.get(lk - 1).l.size(); i++)
		{
			for(int j = 0; j < ls.get(lk - 1).l.size(); j++)
			{
				if(diff_last(ls.get(lk - 1).l.get(i), ls.get(lk - 1).l.get(j)) == true)
				{
					AprioirItemSet c = new AprioirItemSet();
					c.itemset.clear();
					c.itemset.addAll(ls.get(lk - 1).l.get(i).itemset);
					c.itemset.addAll(ls.get(lk - 1).l.get(j).itemset);
					if(c.hasInfrequentSub(c, ls.get(lk - 1).l))
					{
						;
					}
					else
					{
						int alreadyhas = 0;
						//if(ls.get(lk).l.contains(c))
						for(int p = 0; p < ls.get(lk).c.size(); p++)
						{
							AprioirItemSet d = new AprioirItemSet();
							d.itemset.clear();
							d.itemset.addAll(ls.get(lk).c.get(p).itemset);
							d.itemset.addAll(c.itemset);
							if(d.itemset.size() == c.itemset.size())
							{
								alreadyhas = 1;
							}
						}
						if(alreadyhas == 0)
						{
							ls.get(lk).c.add(c);
							int times = this.moreThanMin(c);
							if(times != -1)
							{
								ls.get(lk).l.add(c);
								ls.get(lk).lfre.add(times);
							}
						}
					}
				}
			}
		}
		System.out.println(lk+":"+ls.get(lk).l.size());
	}
	
	public int moreThanMin(AprioirItemSet a)
	{
		int counter = 0;
		for(int i = 0; i < items.size(); i++)
		{
			AprioirItemSet result = new AprioirItemSet();
			result.itemset.clear();
			result.itemset.addAll(a.itemset);
			result.itemset.retainAll(items.get(i).itemset);
			if(result.itemset.size() == a.itemset.size())
			{
				counter++;
			}
		}
		if(counter >= min_sup)
		{
			return counter;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean diff_last(AprioirItemSet a, AprioirItemSet b)
	{
		AprioirItemSet result = new AprioirItemSet();
		result.itemset.addAll(a.itemset);
		result.itemset.retainAll(b.itemset);
		if(result.itemset.size() == a.itemset.size() - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean last_diff(AprioirItemSet a, AprioirItemSet b)
	{
		Iterator<String> it = a.itemset.iterator();
		int counter1 = 0;
		while(it.hasNext())
		{
			String str = it.next();
			if(b.itemset.contains(str))
			{
				counter1++;
			}
		}
		
		Iterator<String> it2 = b.itemset.iterator();
		int counter2 = 0;
		while(it2.hasNext())
		{
			String str = it.next();
			if(b.itemset.contains(str))
			{
				counter2++;
			}
		}
		
		if(counter1 == counter2 && counter1 == a.itemset.size() - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public List<AprioirItemSet> find_frequent_1_itemsets()
	{
		List<String> names = new ArrayList<String>();
		List<Integer> times = new ArrayList<Integer>();
		
		List<AprioirItemSet> l = new ArrayList<AprioirItemSet>();
		
		for(int i = 0; i < items.size(); i++)
		{
			Iterator<String> it = items.get(i).itemset.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				if(names.contains(str))
				{
					int ind = names.indexOf(str);
					times.set(ind, times.get(ind) + 1);
				}
				else
				{
					names.add(str);
					times.add(1);
				}
			}
		}
		
		for(int i = 0; i < times.size(); i++)
		{
			if(times.get(i) >= min_sup)
			{
				AprioirItemSet apis = new AprioirItemSet();
				apis.itemset.add(names.get(i));
				l.add(apis);
			}
		}
		
		return l;
	}
}