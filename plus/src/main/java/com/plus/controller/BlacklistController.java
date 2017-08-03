package com.plus.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.MemberDTO;
import com.plus.service.BlacklistService;


@RestController
@RequestMapping("/blacklists/*")
public class BlacklistController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Inject 
	BlacklistService service;
	
	@RequestMapping("readBlacklist")
	public List<BlacklistDTO> readBlacklist() {

		List<BlacklistDTO> list = service.selectAll("testUser");

		return list;
	}//readBlacklist()
	
	@RequestMapping(value="insertBlacklist", method = RequestMethod.POST)
	public void insertBlacklist(MemberDTO dto, HttpSession session, Model model) {
		logger.info("----------------------------------------------------------");
		logger.info("dto :"+dto);
		logger.info("session :" + session.getId());
		logger.info("model :" + model);

	}//insertBlacklist()
	
	@RequestMapping("deleteBlacklist")
	public void deleteBlacklist() {

	}//deleteBlacklist()
	
}//class