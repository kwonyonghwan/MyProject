package com.plus.service;

import java.util.List;

import com.plus.domain.MeetingDTO;
import com.plus.domain.MemberDTO;

public interface MeetingService {

	public void insertMeeting (MeetingDTO meetingDTO);
	
	public void deleteMeeting (int mno);

	public List<MeetingDTO> selectMeetingList(String memberid);
	
	public MeetingDTO selectMeeting(int mno);
	
	public List<MemberDTO> selectMeetingMember(int mno);
	
}//interface
