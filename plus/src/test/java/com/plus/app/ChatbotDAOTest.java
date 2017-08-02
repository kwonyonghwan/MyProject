package com.plus.app;

import static org.junit.Assert.fail;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.MatchingDTO;
import com.plus.persistence.ChatbotDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class ChatbotDAOTest {
	
	@Inject
	private ChatbotDAO dao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertChatbotDAO() throws Exception {
		MatchingDTO dto = new MatchingDTO();
		dto.setMemberid("testuser2");
		dto.setMatchingagegroup("20");
		dto.setMatchinglatitude(123.2);
		dto.setMatchinglongitude(12.3);
		dto.setMatchingoptional("ddd");
		dto.setMatchingpeoplenumber(5);
		dto.setMatchingcategory("√‡±∏");
		Date time =  new Date(); 
		dto.setMatchingtime(time);
		
		dao.insertWordList(dto);
	}//testInsertChatbotDAO
	
}//class
