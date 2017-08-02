package com.plus.domain;

public class MeetingmemberDTO {
	private int mno;
	private String memberid;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	@Override
	public String toString() {
		return "meetingmemberDTO [mno=" + mno + ", memberid=" + memberid + ", toString()=" + super.toString() + "]";
	}

}//class
