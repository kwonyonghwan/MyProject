package com.plus.app;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plus.domain.BlacklistDTO;
import com.plus.persistence.BlacklistDAO;
import com.plus.persistence.MeetingDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MeetingDAOTest {
	@Inject
	private MeetingDAO dao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void selectMeetingListTest() throws Exception {

		String memberid = "testuser2";
		System.out.println(dao.selectMeetingList(memberid).toString() );

	}//selectMeetingListTest
	
	@Test
	public void selectMeetingMemberTest() throws Exception {

		int mno = 2;
		System.out.println(dao.selectMeetingMember(mno).toString() );

	}//selectMeetingMemberTest

}//class