package org.ktl.domain;

public class SupportVO {
	
	String freqdata;
	Double support;
	
	// getter & setter
	public String getFreqdata() {
		return freqdata;
	}
	public void setFreqdata(String freqdata) {
		this.freqdata = freqdata;
	}
	public Double getSupport() {
		return support;
	}
	public void setSupport(Double support) {
		this.support = support;
	}
	
	@Override
	public String toString() {
		return "supportVO [freqdata=" + freqdata + ", support=" + support + "]";
	}


}// class
