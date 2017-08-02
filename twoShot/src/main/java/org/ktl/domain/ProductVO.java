package org.ktl.domain;

public class ProductVO {

	private int pno;  //상품번호
	private String productname;  //상품명
	private int productprice;    //상품가격
	private String productmodel; //모델명
	private String productcategory;  //카테고리
	private int productsize;  //상품사이즈
	private String productcolor; //상품색상
	private int productheight; //상품 길이
	private String productdetail;  // 상세설명(txt)
	private String productbottomimage; // 신발밑창사진
	private String manufacturerid;  //매장
	private String productthumimage;  //썸네일이미지
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public String getProductmodel() {
		return productmodel;
	}
	public void setProductmodel(String productmodel) {
		this.productmodel = productmodel;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public int getProductsize() {
		return productsize;
	}
	public void setProductsize(int productsize) {
		this.productsize = productsize;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	public int getProductheight() {
		return productheight;
	}
	public void setProductheight(int productheight) {
		this.productheight = productheight;
	}
	public String getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}
	public String getProductbottomimage() {
		return productbottomimage;
	}
	public void setProductbottomimage(String productbottomimage) {
		this.productbottomimage = productbottomimage;
	}
	public String getManufacturerid() {
		return manufacturerid;
	}
	public void setManufacturerid(String manufacturerid) {
		this.manufacturerid = manufacturerid;
	}
	public String getProductthumimage() {
		return productthumimage;
	}
	public void setProductthumimage(String productthumimage) {
		this.productthumimage = productthumimage;
	}
	@Override
	public String toString() {
		return "productVO [pno=" + pno + ", productname=" + productname + ", productprice=" + productprice
				+ ", productmodel=" + productmodel + ", productcategori=" + productcategory + ", productsize="
				+ productsize + ", productcolor=" + productcolor + ", productheight=" + productheight
				+ ", productdetail=" + productdetail + ", productbottomimage=" + productbottomimage
				+ ", manufacturerid=" + manufacturerid + ", productthumimage=" + productthumimage + "]";
	}
	

}
