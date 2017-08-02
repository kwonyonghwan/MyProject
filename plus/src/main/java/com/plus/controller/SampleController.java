package com.plus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plus.domain.BlacklistDTO;
import com.plus.service.BlacklistService;

@RestController
@RequestMapping("/test/*")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Inject 
	BlacklistService service;

	@RequestMapping(value="loginPost", method = RequestMethod.POST)
	public void loginPOST(@RequestBody String body) throws Exception{
		
		/*if(mVo == null) {  //�α��� �ȵ� ���¶��
			return ;  // �̰�η� �̵�!
		
		}//if
		
		// MemberVO mVo = (MemberVO)session.getAttribute("login");   �ٸ� ��ο��� ȣ���. 
		session.setAttribute("login", mVo);
		
//		System.out.println(" ����!!!!!!!!!!!!! "+session.getId());
		
		model.addAttribute("memberVO", mVo);

		if(dto.isUseCookie()){  //����ڰ� �ڵ��α����� ������ ��� �ʿ��� ����� �߰�
			
			int amount = 60* 60*24*7; // loginCookie���� ������� �ð� ������ DB�� �����Ѵ�. 
			
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		
			service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		}
		int amount = 60* 60*24*1;
		Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		*/
//		return resultDto; //�α����� �Ǹ�(��,id == pw)�̸� �̵��� ���.
	}//loginPOST
	
}//class
