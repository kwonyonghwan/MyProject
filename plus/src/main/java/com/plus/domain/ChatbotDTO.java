package com.plus.domain;

public class ChatbotDTO {
	private String memberid;
	private String sentence;
	private String address;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ChatbotDTO [memberid=" + memberid + ", sentence=" + sentence + ", address=" + address + "]";
	}

}//class
