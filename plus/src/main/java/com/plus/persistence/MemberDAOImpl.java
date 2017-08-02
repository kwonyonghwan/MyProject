package com.plus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.memberMapper";

	@Override
	public void insertMember(MemberDTO memberDTO) {
	   sqlSession.insert(namespace+".insertMember", memberDTO);
	}//insertMember

	@Override
	public void deleteMember(MemberDTO memberDTO) {
	   sqlSession.delete(namespace+".deleteMember", memberDTO);
	}//deleteMember

	@Override
	public void updateMember(MemberDTO memberDTO) {
	   sqlSession.update(namespace+".updateMember", memberDTO);
	}//updateMember

	@Override
	public MemberDTO selectMember(String memberid) {
	   return sqlSession.selectOne(namespace+".selectMember", memberid);
	}//selectMember
	
}//class