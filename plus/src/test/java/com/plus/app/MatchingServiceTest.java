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
import com.plus.service.MatchingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MatchingServiceTest {
	
	@Inject
	private MatchingService service;

	@Test
	public void testMatchingService() throws Exception {
		service.matchingLogic();
	}//testMatchingService
	
}//class
