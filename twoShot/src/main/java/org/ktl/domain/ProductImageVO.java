package org.ktl.domain;

public class ProductImageVO {
	
	private Integer pno;
	private String productimage;  //상품이미지
	
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	@Override
	public String toString() {
		return "ProductImageVO [pno=" + pno + ", productimage=" + productimage + "]";
	}
	

	
	
}
