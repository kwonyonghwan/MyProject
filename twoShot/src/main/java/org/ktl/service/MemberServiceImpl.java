package org.ktl.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.ktl.controller.BoardController;
import org.ktl.domain.MemberVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.ShoppingCartVO;
import org.ktl.dto.LoginDTO;
import org.ktl.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//CB42A808250D8E67D055E530D64E5D34


@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private MemberDAO dao;

	/*--- 로그인 ---*/
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		
		return dao.login(dto);
	}

	/*--- 자동로그인, 로그인유지 ---*/
	@Override
	public void keepLogin(String memberid, String sessionId, Date next) throws Exception {
		System.out.println("서비스에서 세션아이디 : " + sessionId);
		dao.keepLogin(memberid, sessionId, next);
	}
	
	/*--- 기존에 로그인한 사용자인지 확인 ---*/
	@Override
	public MemberVO checkLoginBefore(String value) {
		
		return dao.checkMemberWithSessionkey(value);
	}
	
	/*--- 회원가입 ---*/
	@Override
	public void join(MemberVO mVo) throws Exception {
		
		dao.join(mVo);
	}

	
	/*--- 장바구니 목록---*/
	@Override
	public List<ShoppingCartVO> cartList(String memberId) throws Exception {
		
		return dao.cartList(memberId);
	}

	/*--- 장바구니에 넣기--*/
	@Override
	public void putCart(ShoppingCartVO cVo) throws Exception {
		
		dao.putCart(cVo);
	}

	/*--- 장바구니 삭제--*/
	@Override
	public void deleteCart(Integer pno) throws Exception {
		
		dao.deleteCart(pno);
	}

	/*--- 주문 화면--*/
	@Override
	public ProductVO orderPage(String memberId, Integer pno) throws Exception {
		
		return dao.orderPage(memberId, pno);   //로그인한 회원이 상품 선택시, 해당하는 번호를 불러온다. 
	}
	
	
	/*--- 주문 넣기--*/
	@Override
	public void putOrder(ShoppingCartVO cVo) throws Exception {
		
		dao.putOrder(cVo);
	}

	/*--- 주문 목록--*/
	@Override
	public List<ShoppingCartVO> orderComplete(ShoppingCartVO cVo) throws Exception {
		
		return dao.orderComplete(cVo);
	}

	
}
