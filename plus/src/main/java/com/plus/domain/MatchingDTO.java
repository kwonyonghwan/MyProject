package com.plus.domain;

import java.util.Date;

public class MatchingDTO {
	
	private String memberid;
	private String matchingcategory;
	private double matchinglatitude;
	private double matchinglongitude;
	private Date matchingtime;
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
	public double getMatchinglatitude() {
		return matchinglatitude;
	}
	public void setMatchinglatitude(double matchinglatitude) {
		this.matchinglatitude = matchinglatitude;
	}
	public double getMatchinglongitude() {
		return matchinglongitude;
	}
	public void setMatchinglongitude(double matchinglongitude) {
		this.matchinglongitude = matchinglongitude;
	}
	public Date getMatchingtime() {
		return matchingtime;
	}
	public void setMatchingtime(Date matchingtime) {
		this.matchingtime = matchingtime;
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
		return "MatchingDTO [memberid=" + memberid + ", matchingcategory=" + matchingcategory + ", matchinglatitude="
				+ matchinglatitude + ", matchinglongitude=" + matchinglongitude + ", matchingtime=" + matchingtime
				+ ", matchingpeoplenumber=" + matchingpeoplenumber + ", matchingagegroup=" + matchingagegroup
				+ ", matchingoptional=" + matchingoptional + "]";
	}

}//class
