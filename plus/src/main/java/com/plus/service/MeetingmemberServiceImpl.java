package com.plus.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import com.plus.domain.MeetingmemberDTO;
import com.plus.persistence.MeetingmemberDAO;

@Repository
public class MeetingmemberServiceImpl implements MeetingmemberService {

	@Inject
	private MeetingmemberDAO dao;

	@Override
	public void deleteMeetingMember(MeetingmemberDTO meetingmemberDTO) {
		dao.deleteMeetingMember(meetingmemberDTO);
	}//deleteMeetingMember

	@Override
	public void insertMeetingMember(List<MeetingmemberDTO> meetingmemberList) {
		dao.insertMeetingMember(meetingmemberList);
	}//insertMeetingMember

}// class