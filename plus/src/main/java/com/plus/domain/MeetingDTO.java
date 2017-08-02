package com.plus.domain;

import java.util.Date;

public class MeetingDTO {
	private int mno;
	private String meetingcategory;
	private String meetinglocation;
	private Date meetingtime;
	private String meetingstate;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMeetingcategory() {
		return meetingcategory;
	}

	public void setMeetingcategory(String meetingcategory) {
		this.meetingcategory = meetingcategory;
	}

	public String getMeetinglocation() {
		return meetinglocation;
	}

	public void setMeetinglocation(String meetinglocation) {
		this.meetinglocation = meetinglocation;
	}

	public Date getMeetingtime() {
		return meetingtime;
	}

	public void setMeetingtime(Date meetingtime) {
		this.meetingtime = meetingtime;
	}

	public String getMeetingstate() {
		return meetingstate;
	}

	public void setMeetingstate(String meetingstate) {
		this.meetingstate = meetingstate;
	}

	@Override
	public String toString() {
		return "meetingDTO [mno=" + mno + ", meetingcategory=" + meetingcategory + ", meetinglocation="
				+ meetinglocation + ", meetingtime=" + meetingtime + ", meetingstate=" + meetingstate + ", toString()="
				+ super.toString() + "]";
	}

}//class
