package org.ktl.domain;

import java.sql.Date;

public class MemberVO {

	private String memberid;
	private String memberpw;
	private String membername;
	private String memberaddress;
	private int memberfootwidth;
	private int memberfootheight;
	private String memberfootimage;
	private int memberfootperimeter;
	
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public int getMemberfootwidth() {
		return memberfootwidth;
	}
	public void setMemberfootwidth(int memberfootwidth) {
		this.memberfootwidth = memberfootwidth;
	}
	public int getMemberfootheight() {
		return memberfootheight;
	}
	public void setMemberfootheight(int memberfootheight) {
		this.memberfootheight = memberfootheight;
	}
	public String getMemberfootimage() {
		return memberfootimage;
	}
	public void setMemberfootimage(String memberfootimage) {
		this.memberfootimage = memberfootimage;
	}
	public int getMemberfootperimeter() {
		return memberfootperimeter;
	}
	public void setMemberfootperimeter(int memberfootperimeter) {
		this.memberfootperimeter = memberfootperimeter;
	}
	@Override
	public String toString() {
		return "memberVO [memberid=" + memberid + ", memberpw=" + memberpw + ", membername=" + membername
				+ ", memberaddress=" + memberaddress + ", memberfootwidth=" + memberfootwidth + ", memberfootheight="
				+ memberfootheight + ", memberfootimage=" + memberfootimage + ", memberfootperimeter="
				+ memberfootperimeter + "]";
	}
	

}
