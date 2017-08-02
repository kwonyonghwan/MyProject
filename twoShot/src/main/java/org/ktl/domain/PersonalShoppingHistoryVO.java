package org.ktl.domain;

public class PersonalShoppingHistoryVO {
	
	String memberid;
	String shoppinghistory;
	
	// getter & setter
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getShoppinghistory() {
		return shoppinghistory;
	}
	public void setShoppinghistory(String shoppinghistory) {
		this.shoppinghistory = shoppinghistory;
	}
	
	@Override
	public String toString() {
		return "PersonalShoppingHistoryVO [memberid=" + memberid + ", shoppinghistory=" + shoppinghistory + "]";
	}

}// class
