package com.plus.domain;

import java.util.Date;

public class ChattingDTO {
	private int mno;
	private String memberid;
	private String chat;
	private Date chattime;

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

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Date getChattime() {
		return chattime;
	}

	public void setChattime(Date chattime) {
		this.chattime = chattime;
	}

	@Override
	public String toString() {
		return "chattingDTO [mno=" + mno + ", memberid=" + memberid + ", chat=" + chat + ", chattime=" + chattime
				+ ", toString()=" + super.toString() + "]";
	}

}//class
