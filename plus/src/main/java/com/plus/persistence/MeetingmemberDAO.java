package com.plus.persistence;

import java.util.List;

import com.plus.domain.MeetingmemberDTO;

public interface MeetingmemberDAO {

	public void deleteMeetingMember (MeetingmemberDTO meetingmemberDTO);
	
	public void insertMeetingMember(List<MeetingmemberDTO> meetingmemberList);
	
}//interface
