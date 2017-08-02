package com.plus.domain;

public class BlacklistDTO {
	private String memberid;
	private String blacklistmemberid;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getBlacklistmemberid() {
		return blacklistmemberid;
	}

	public void setBlacklistmemberid(String blacklistmemberid) {
		this.blacklistmemberid = blacklistmemberid;
	}

	@Override
	public String toString() {
		return "blacklistDTO [memberid=" + memberid + ", blacklistmemberid=" + blacklistmemberid + ", toString()="
				+ super.toString() + "]";
	}

}//class
