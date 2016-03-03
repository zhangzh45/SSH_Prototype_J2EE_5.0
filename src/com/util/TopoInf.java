package com.util;

public class TopoInf {
	
	String from;
	String to;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public boolean compare(TopoInf t)
	{
		if(t.getFrom().equals(from) && t.getTo().equals(to))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
