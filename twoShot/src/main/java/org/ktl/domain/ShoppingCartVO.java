package org.ktl.domain;

public class ShoppingCartVO {
	
	private String memberid;
	private int cno;
	private int pno;
	private String productname;
	private int productprice;
	private int productcount;
	private String productthumimage;
	private int productsize;  //발사이즈
	private String productstatus; // <현재 배송완료, 배송중, 결제완료, 미결제>와 같은 상태를 나타낸다.  
	private String productcolor;
	private String productmodel;
	
	
	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

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


	public int getProductcount() {
		return productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

	public String getProductthumimage() {
		return productthumimage;
	}

	public void setProductthumimage(String productthumimage) {
		this.productthumimage = productthumimage;
	}

	public int getProductsize() {
		return productsize;
	}

	public void setProductsize(int productsize) {
		this.productsize = productsize;
	}

	public String getProductstatus() {
		return productstatus;
	}

	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}

	public String getProductcolor() {
		return productcolor;
	}

	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}

	public String getProductmodel() {
		return productmodel;
	}

	public void setProductmodel(String productmodel) {
		this.productmodel = productmodel;
	}


	@Override
	public String toString() {
		return "ShoppingCartVO [memberid=" + memberid + ", cno=" + cno + ", pno=" + pno + ", productname=" + productname
				+ ", productprice=" + productprice + ", productcount=" + productcount + ", productthumimage="
				+ productthumimage + ", productsize=" + productsize + ", productstatus=" + productstatus
				+ ", productcolor=" + productcolor + ", productmodel=" + productmodel + "]";
	}

	// 총 금액 구하는 메서드( 제품당 가격 * 개수)
	public int getProductTotalPrice(){

		return productprice * productcount;
		
	} // jsp에서 가져올 때 ${cartVO.getProductTotalPrice()}

}
