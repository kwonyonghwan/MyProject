package com.plus.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.MeetingDTO;
import com.plus.domain.MemberDTO;

@Repository
public class MeetingDAOImpl implements MeetingDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.meetingMapper";
	
	@Override
	public void insertMeeting(MeetingDTO meetingDTO) {
		sqlSession.insert(namespace+".registerMeeting", meetingDTO);
	}//insertMeeting

	@Override
	public void deleteMeeting(int mno) {
		sqlSession.delete(namespace + ".deleteMeeting" , mno);
	}//deleteMeeting

	@Override
	public List<MeetingDTO> selectMeetingList(String memberid) {
		List<Integer> mnoList = new ArrayList<Integer>();
		mnoList = sqlSession.selectList(namespace+".readMeetingList", memberid);
		
		List<MeetingDTO> meetingDTOList = new ArrayList<MeetingDTO>();
		
		for(int i=0; i<mnoList.size(); i++){
			meetingDTOList.add(sqlSession.selectOne(namespace+".readMeetingDetail", mnoList.get(i)));
		}
		
		return meetingDTOList;
	}//selectMeetingList

	@Override
	public MeetingDTO selectMeeting(int mno) {
		return sqlSession.selectOne(namespace+".readMeeting", mno);
	}//selectMeeting

	@Override
	public List<MemberDTO> selectMeetingMember(int mno) {
		List<String> memberList = sqlSession.selectList(namespace+".readMemberList", mno);

		List<MemberDTO> MemberList = new ArrayList<MemberDTO>();
		
		for(int i=0; i<memberList.size(); i++){
			MemberList.add(sqlSession.selectOne(namespace+".readMemberDetail", memberList.get(i)));
		}
		
		return MemberList;
	}//selectMeetingMember

}//class