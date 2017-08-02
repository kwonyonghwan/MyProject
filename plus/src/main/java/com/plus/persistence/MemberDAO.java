package com.plus.persistence;

import com.plus.domain.MemberDTO;

public interface MemberDAO {

	public void insertMember(MemberDTO memberDTO);
	
	public void deleteMember(MemberDTO memberDTO);
	
	public void updateMember(MemberDTO memberDTO);
	
	public MemberDTO selectMember(String memberid);
	
}//interface
