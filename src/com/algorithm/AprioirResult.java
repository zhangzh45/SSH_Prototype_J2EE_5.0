package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AprioirResult
{
	String setContent;
	int fre;
	int k;
	
	public String getSetContent() {
		return setContent;
	}
	public void setSetContent(String setContent) {
		this.setContent = setContent;
	}
	public int getFre() {
		return fre;
	}
	public void setFre(int fre) {
		this.fre = fre;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	@Override
	public String toString() {
		return "AprioirResult [setContent=" + setContent + ", fre=" + fre
				+ ", k=" + k + "]";
	}
	
}