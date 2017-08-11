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
import com.plus.domain.MemberDTO;
import com.plus.persistence.BlacklistDAO;
import com.plus.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberTest {
	@Inject
	private MemberService service;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectMember() throws Exception {
		String memberid = "testUser2";
	
	
		System.out.println(service.selectMember(memberid));
		
		
	}//testInsertTest_table
	

}//class
