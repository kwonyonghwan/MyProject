package com.plus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.MeetingmemberDTO;

@Repository
public class MeetingmemberDAOImpl implements MeetingmemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.meetingmemberMapper";

	@Override
	public void deleteMeetingMember(MeetingmemberDTO meetingmemberDTO) {
		sqlSession.delete(namespace + ".deleteMeetingMember", meetingmemberDTO);
	}//deleteMeetingMember

	@Override
	public void insertMeetingMember(List<MeetingmemberDTO> meetingmemberList) {
		sqlSession.insert(namespace + ".insertMeetingMember", meetingmemberList);
	}//insertMeetingMember

}//class