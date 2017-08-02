package com.plus.service;

import com.plus.domain.MemberDTO;

public interface MemberService {

	public void insertMember(MemberDTO memberDTO);
	
	public void deleteMember(MemberDTO memberDTO);
	
	public void updateMember(MemberDTO memberDTO);
	
	public MemberDTO selectMember(String memberid);

}//interface
