package com.plus.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.MemberDTO;
import com.plus.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	@Override
	public void insertMember(MemberDTO memberDTO) {
		dao.insertMember(memberDTO);
	}//insertMember

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		dao.deleteMember(memberDTO);
	}//deleteMember

	@Override
	public void updateMember(MemberDTO memberDTO) {
		dao.updateMember(memberDTO);
	}//updateMember

	@Override
	public MemberDTO selectMember(String memberid) {
		return dao.selectMember(memberid);
	}//selectMember

}//class