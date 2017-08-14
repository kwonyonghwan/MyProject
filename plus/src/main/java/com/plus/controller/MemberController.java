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

	/* ------ login, POST -------- �α��� ���ó���ϴ°� */
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public int loginPOST(@RequestBody MemberDTO dto, HttpSession session, Model model) throws Exception {

		MemberDTO resultDto = service.selectMember(dto);

		if (resultDto == null) { // �α��� �ȵ� ���¶��
			return -1;		
		}

		session.setAttribute("login", resultDto);

		return 1; // �α����� �Ǹ�(��,id == pw)�̸� �̵��� ���.

	}// loginPOST
	
	
	@RequestMapping(value = "registerPost", method = RequestMethod.POST)
	public int registerPost(@RequestBody MemberDTO dto, HttpSession session, Model model) throws Exception {

		service.insertMember(dto);

		return 1; 
		
	}// loginPOST

}// class
