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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BlacklistDAOTest {
	@Inject
	private BlacklistDAO dao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTest_table() throws Exception {
		String memberid = "testUser";
		List<BlacklistDTO> blacklist = new ArrayList<BlacklistDTO>();
		blacklist = dao.selectAll(memberid);
	
		System.out.println(blacklist.get(0).getBlacklistmemberid());
		
	}//testInsertTest_table
	
	@Test
	public void testInsertBlacklist() throws Exception {

		BlacklistDTO dto = new BlacklistDTO();
		dto.setMemberid("test");
		dto.setBlacklistmemberid("testUser");
		
		System.out.println(dao.insertBlacklist(dto));
		
	}//testInsertBlacklist
	
}//class
