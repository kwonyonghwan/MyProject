package org.ktl.domain;

import java.util.List;

public class JsonData4D3 {
	
	Integer pno;
	String productname;
	String productthumimage;
	Double confidence;
	Integer imagesize;
	String rootdata;
	
	List<RecommendVO> children;

	public void setAllData(Integer pno, String productname, 
			String productthumimage, Double confidence, Integer imagesize, 	String rootdata ){
		this.pno = pno;
		this.productname = productname;
		this.productthumimage = productthumimage;
		this.confidence = confidence;
		this.imagesize = imagesize;
		this.rootdata = rootdata;
	}
	
	
	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public Integer getImagesize() {
		return imagesize;
	}

	public void setImagesize(Integer imagesize) {
		this.imagesize = imagesize;
	}

	public String getRootdata() {
		return rootdata;
	}

	public void setRootdata(String rootdata) {
		this.rootdata = rootdata;
	}

	public List<RecommendVO> getChildren() {
		return children;
	}

	public void setChildren(List<RecommendVO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "JsonData4D3 [pno=" + pno + ", productname=" + productname + ", productthumimage=" + productthumimage
				+ ", confidence=" + confidence + ", imagesize=" + imagesize + ", rootdata=" + rootdata + ", children="
				+ children + "]";
	}
	
	

	
	
}// class
