package org.ktl.service;


import java.util.Date;
import java.util.List;

import org.ktl.domain.MemberVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.ShoppingCartVO;
import org.ktl.dto.LoginDTO;

public interface MemberService {
	
	public void join(MemberVO mVo) throws Exception;  //회원가입
	
	public MemberVO login(LoginDTO dto) throws Exception;  //로그인
	
	public void keepLogin(String memberid, String sessionId, Date next) throws Exception; // 자동 로그인을 위한 로그인 정보를 유지
	
	public MemberVO checkLoginBefore(String value); //과거에 접속한 사용자인지 확인 
	
	public List<ShoppingCartVO> cartList(String memberId) throws Exception;  //장바구니 목록
	
	public void putCart(ShoppingCartVO cVo) throws Exception;  //장바구니에 넣기 

	public void deleteCart(Integer pno) throws Exception; //장바구니 삭제
	
	public ProductVO orderPage(String memberId, Integer pno) throws Exception; // 주문하는 화면
	
	public void putOrder(ShoppingCartVO cVo) throws Exception;  // 주문 넣기
	
	public List<ShoppingCartVO> orderComplete(ShoppingCartVO cVo) throws Exception;  //주문 완료화면
	
}
