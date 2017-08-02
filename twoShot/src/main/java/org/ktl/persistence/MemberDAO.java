package org.ktl.persistence;
import java.util.Date;
import java.util.List;

// ���ο� ����� ��ϰ� ��ȸ ó��
import org.ktl.domain.MemberVO;
import org.ktl.domain.ProductVO;
import org.ktl.domain.ShoppingCartVO;
import org.ktl.dto.LoginDTO;

public interface MemberDAO {

	public MemberVO login(LoginDTO dto) throws Exception; //로그인
	
	public void keepLogin(String memberid, String sessionId, Date next); // sessionKey와 sessionId를 업데이트
	
	public MemberVO checkMemberWithSessionkey(String value);  //loginCookie에 기록된 값으로 사용자의 정보를 조회
	
	public void join(MemberVO mVo) throws Exception;  //회원가입
	
	public MemberVO readMember(String memberid) throws Exception;  //�����ȸ
	
	public MemberVO readWithPW(String memberid, String memberpw) throws Exception;
	
	public List<ShoppingCartVO> cartList(String memberId) throws Exception; //장바구니 목록

	public void putCart(ShoppingCartVO cVo) throws Exception; // 장바구니에 상품 넣기 
	
	public void deleteCart(Integer pno) throws Exception;  //장바구니 삭제
	
	public ProductVO orderPage(String memberId, Integer pno) throws Exception; //주문 화면

	public void putOrder(ShoppingCartVO cVo) throws Exception; // 주문 넣기
	
	public List<ShoppingCartVO> orderComplete(ShoppingCartVO cVo) throws Exception; //주문 완료화면
	
}