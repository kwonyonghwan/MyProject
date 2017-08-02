package com.plus.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.plus.domain.MeetingDTO;
import com.plus.domain.MemberDTO;

@Service
public class MeetingServiceImpl implements MeetingService{

	@Override
	public void insertMeeting(MeetingDTO meetingDTO) {
	}//insertMeeting

	@Override
	public void deleteMeeting(int mno) {
	}//deleteMeeting

	@Override
	public List<MeetingDTO> selectMeetingList(String memberid) {
		return null;
	}//selectMeetingList

	@Override
	public MeetingDTO selectMeeting(int mno) {
		return null;
	}//selectMeeting

	@Override
	public List<MemberDTO> selectMeetingMember(int mno) {
		return null;
	}//selectMeetingMember

}//calss
