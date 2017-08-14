package com.plus.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plus.domain.MemberDTO;
import com.plus.service.MemberService;

@RestController
@RequestMapping("/members/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	/* ------ login, POST -------- 로그인 결과처리하는곳 */
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public int loginPOST(@RequestBody MemberDTO dto, HttpSession session, Model model) throws Exception {

		MemberDTO resultDto = service.selectMember(dto);

		if (resultDto == null) { // 로그인 안된 상태라면
			return -1;		
		}

		session.setAttribute("login", resultDto);

		return 1; // 로그인이 되면(즉,id == pw)이면 이동할 경로.

	}// loginPOST
	
	
	@RequestMapping(value = "registerPost", method = RequestMethod.POST)
	public int registerPost(@RequestBody MemberDTO dto, HttpSession session, Model model) throws Exception {

		service.insertMember(dto);

		return 1; 
		
	}// loginPOST

}// class
