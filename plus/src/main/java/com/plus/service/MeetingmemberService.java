package com.plus.service;

import java.util.List;

import com.plus.domain.MeetingmemberDTO;

public interface MeetingmemberService {

	public void deleteMeetingMember (MeetingmemberDTO meetingmemberDTO);
	
	public void insertMeetingMember(List<MeetingmemberDTO> meetingmemberList);
	
}//interface
