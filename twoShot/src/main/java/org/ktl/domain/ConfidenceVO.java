package org.ktl.domain;

public class ConfidenceVO {

	private String startdata;
	private String enddata;
	private Double confidence;
	
	// getter & setter
	public String getStartdata() {
		return startdata;
	}
	public void setStartdata(String startdata) {
		this.startdata = startdata;
	}
	public String getEnddata() {
		return enddata;
	}
	public void setEnddata(String enddata) {
		this.enddata = enddata;
	}
	public Double getConfidence() {
		return confidence;
	}
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	
	@Override
	public String toString() {
		return "ConfidenceVO [startdata=" + startdata + ", enddata=" + enddata + ", confidence=" + confidence + "]";
	}

}// class
g