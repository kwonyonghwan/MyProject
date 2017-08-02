package org.ktl.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ktl.domain.MemberVO;
import org.ktl.persistence.MemberDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	
	@Test
	public void testInsertMember() throws Exception {

		MemberVO mVo = new MemberVO();
		mVo.setMemberid("���̵�");
		mVo.setMemberpw("1234");
		mVo.setMembername("��������");
		mVo.setMemberaddress("������ ���ʵ�");
		mVo.setMemberfootwidth(16);
		mVo.setMemberfootheight(8);
		mVo.setMemberfootperimeter(26);
		
		System.out.println(mVo);
	}
	
}