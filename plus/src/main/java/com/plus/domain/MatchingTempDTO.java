package com.plus.domain;

import java.util.Date;

public class MatchingTempDTO {
	
	private String memberid;
	private String matchingcategory;
	private String matchinglocation;
	private Date date;
	private Date time;
	private int matchingpeoplenumber;
	private String matchingagegroup;
	private String matchingoptional;

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMatchingcategory() {
		return matchingcategory;
	}
	public void setMatchingcategory(String matchingcategory) {
		this.matchingcategory = matchingcategory;
	}
	public String getMatchinglocation() {
		return matchinglocation;
	}
	public void setMatchinglocation(String matchinglocation) {
		this.matchinglocation = matchinglocation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getMatchingpeoplenumber() {
		return matchingpeoplenumber;
	}
	public void setMatchingpeoplenumber(int matchingpeoplenumber) {
		this.matchingpeoplenumber = matchingpeoplenumber;
	}
	public String getMatchingagegroup() {
		return matchingagegroup;
	}
	public void setMatchingagegroup(String matchingagegroup) {
		this.matchingagegroup = matchingagegroup;
	}
	public String getMatchingoptional() {
		return matchingoptional;
	}
	public void setMatchingoptional(String matchingoptional) {
		this.matchingoptional = matchingoptional;
	}

	@Override
	public String toString() {
		return "MatchingTempDTO [memberid=" + memberid + ", matchingcategory=" + matchingcategory
				+ ", matchinglocation=" + matchinglocation + ", date=" + date + ", time=" + time
				+ ", matchingpeoplenumber=" + matchingpeoplenumber + ", matchingagegroup=" + matchingagegroup
				+ ", matchingoptional=" + matchingoptional + "]";
	}

}//class
