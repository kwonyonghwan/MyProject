package org.ktl.domain;

public class RecommendVO {

	Integer pno;
	String productname;
	String productthumimage;
	Double confidence;
	Integer imagesize;
	String rootdata;
	
	
	// getter & setter
	
	
	public String getProductname() {
		return productname;
	}
	public String getRootdata() {
		return rootdata;
	}
	public void setRootdata(String rootdata) {
		this.rootdata = rootdata;
	}
	public Integer getImagesize() {
		return imagesize;
	}
	public void setImagesize(Integer imagesize) {
		this.imagesize = imagesize;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getProductthumimage() {
		return productthumimage;
	}
	public void setProductthumimage(String productthumimage) {
		this.productthumimage = productthumimage;
	}
	public Double getConfidence() {
		return confidence;
	}
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	@Override
	public String toString() {
		return "RecommendVO [pno=" + pno + ", productname=" + productname + ", productthumimage=" + productthumimage
				+ ", confidence=" + confidence + ", imagesize=" + imagesize + ", rootdata=" + rootdata + "]";
	}
	
	
}// class
