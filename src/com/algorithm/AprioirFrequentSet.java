package com.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AprioirFrequentSet
{
	public List<AprioirItemSet> l = new ArrayList<AprioirItemSet>();
	public List<AprioirItemSet> c = new ArrayList<AprioirItemSet>();
	public List<Integer> lfre = new ArrayList<Integer>();
	
	public List<AprioirItemSet> getL() {
		return l;
	}
	public void setL(List<AprioirItemSet> l) {
		this.l = l;
	}
	public List<AprioirItemSet> getC() {
		return c;
	}
	public void setC(List<AprioirItemSet> c) {
		this.c = c;
	}
	public List<Integer> getLfre() {
		return lfre;
	}
	public void setLfre(List<Integer> lfre) {
		this.lfre = lfre;
	}
	
}