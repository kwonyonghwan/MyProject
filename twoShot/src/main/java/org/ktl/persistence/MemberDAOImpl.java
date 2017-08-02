package org.ktl.persistence;
// MemberDAO 

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.ktl.controller.BoardController;
import org.ktl.domain.MemberVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.ShoppingCartVO;
import org.ktl.dto.LoginDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.istack.internal.logging.Logger;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.ktl.mapper.MemberMapper";

	
	/* ----- 회원가입 ----- */
	@Override
	public void join(MemberVO mVo) throws Exception{
		
		System.out.println("2");
		sqlSession.insert(namespace + ".join", mVo);
		
	}
 
	
	/* --- 로그인에서 sessionKey와 sessionId를 업데이트---*/
	@Override
	public void keepLogin(String memberid, String sessionId, Date next) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memberid", memberid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next); //

		System.out.println("DAO에서 세션id : " + sessionId);
		
		sqlSession.update(namespace + ".keepLogin", paramMap);
	}

	
	/* --- loginCookie에 기록된 값으로 사용자의 정보를 조회---*/
	@Override
	public MemberVO checkMemberWithSessionkey(String value) {  
		System.out.println("memverDAO-----------------------------");
		System.out.println(value);
		
		return sqlSession.selectOne(namespace + ".checkUserWithSessionkey", value);
	}
	
	@Override
	public MemberVO readMember(String memberid) throws Exception {
		return (MemberVO) sqlSession.selectOne(namespace +".selectMember", memberid);
	}
	
			
	@Override
	public MemberVO readWithPW(String memberid, String memberpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();  
		//readWithPW()�� �Ķ���Ͱ� 2�� �̻��̾ Map Ÿ���� ��ü ����
		
		paramMap.put("memberid", memberid);
		paramMap.put("memberpw", memberpw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}

	
	/* ----- Login ----- */
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".login", dto);
	}
	
	/* --- 장바구니 목록---*/
	@Override
	public List<ShoppingCartVO> cartList(String memberId) throws Exception {
				
		return sqlSession.selectList(namespace + ".cartList", memberId);
	
	}
	
	/* --- 장바구니에 넣기 ---*/
	@Override
	public void putCart(ShoppingCartVO cVo) throws Exception {
		
		sqlSession.insert(namespace + ".putCart", cVo);
	}

	/* --- 카드 삭제---*/
	@Override
	public void deleteCart(Integer pno) throws Exception {
		
		sqlSession.delete(namespace + ".deleteCart", pno);
	}
	

	/* --- 주문화면 ---*/
	@Override
	public ProductVO orderPage(String memberId, Integer pno) throws Exception {
		
		 
		return sqlSession.selectOne(namespace + ".orderPage", memberId);
	}

	/* --- 주문넣기---*/
	@Override
	public void putOrder(ShoppingCartVO cVo) throws Exception {
		
		sqlSession.insert(namespace + ".putOrder", cVo);
	}

	/* --- 주문완료 화면---*/
	@Override
	public List<ShoppingCartVO> orderComplete(ShoppingCartVO cVo) throws Exception {
		
		return sqlSession.selectList(namespace + ".orderComplete", cVo);
	}
	
}
