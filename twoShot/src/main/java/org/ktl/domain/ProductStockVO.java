package org.ktl.domain;
//상품 재고 관련 
public class ProductStockVO {
	
	private int pno;
	private int productsize;
	private int productstock;
	private String productbottomimage;
	private String productcolor;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getProductsize() {
		return productsize;
	}
	public void setProductsize(int productsize) {
		this.productsize = productsize;
	}
	public int getProductstock() {
		return productstock;
	}
	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}
	public String getProductbottomimage() {
		return productbottomimage;
	}
	public void setProductbottomimage(String productbottomimage) {
		this.productbottomimage = productbottomimage;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	
	
	@Override
	public String toString() {
		return "ProductStockVO [pno=" + pno + ", productsize=" + productsize + ", productstock=" + productstock
				+ ", productbottomimage=" + productbottomimage + ", productcolor=" + productcolor + "]";
	}
	
}
