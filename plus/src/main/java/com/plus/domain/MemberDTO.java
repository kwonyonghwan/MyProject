package com.plus.domain;

public class MemberDTO {
	private String memberid;
	private String memberpw;
	private String membername;
	private String memberaddress;
	private String memberphonenumber;
	private String memberintroduction;
	private String memberthumimage;
	private String memberblocktime;

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

	public String getMemberphonenumber() {
		return memberphonenumber;
	}

	public void setMemberphonenumber(String memberphonenumber) {
		this.memberphonenumber = memberphonenumber;
	}

	public String getMemberintroduction() {
		return memberintroduction;
	}

	public void setMemberintroduction(String memberintroduction) {
		this.memberintroduction = memberintroduction;
	}

	public String getMemberthumimage() {
		return memberthumimage;
	}

	public void setMemberthumimage(String memberthumimage) {
		this.memberthumimage = memberthumimage;
	}

	public String getMemberblocktime() {
		return memberblocktime;
	}

	public void setMemberblocktime(String memberblocktime) {
		this.memberblocktime = memberblocktime;
	}

	@Override
	public String toString() {
		return "memberDTO [memberid=" + memberid + ", memberpw=" + memberpw + ", membername=" + membername
				+ ", memberaddress=" + memberaddress + ", memberphonenumber=" + memberphonenumber
				+ ", memberintroduction=" + memberintroduction + ", memberthumimage=" + memberthumimage
				+ ", memberblocktime=" + memberblocktime + ", toString()=" + super.toString() + "]";
	}

}//class
