package com.plus.controller;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.plus.domain.BlacklistDTO;
import com.plus.domain.MemberDTO;
import com.plus.service.MemberService;

@RestController
@RequestMapping("/members/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	/* ------ login, POST -------- 로그인 결과처리하는곳*/
	@RequestMapping(value="loginPost", method = RequestMethod.POST)
	public BlacklistDTO loginPOST(@RequestBody MemberDTO dto) throws Exception{
		
		System.out.println(dto.toString());
		BlacklistDTO dto1 = new BlacklistDTO();
		dto1.setBlacklistmemberid("DDD");
		dto1.setMemberid("dddd");
		
		return dto1;
		
		//MemberDTO resultDto = service.selectMember(dto.getMemberid());
		
		/*if(resultDto == null){
			return "fail";
		}else{
			return "success";
		}*/
		
		/*if(mVo == null) {  //로그인 안된 상태라면
			return ;  // 이경로로 이동!
		
		}//if
		
		// MemberVO mVo = (MemberVO)session.getAttribute("login");   다른 경로에서 호출시. 
		session.setAttribute("login", mVo);
		
//		System.out.println(" 여기!!!!!!!!!!!!! "+session.getId());
		
		model.addAttribute("memberVO", mVo);

		if(dto.isUseCookie()){  //사용자가 자동로그인을 선택한 경우 필요한 기능을 추가
			
			int amount = 60* 60*24*7; // loginCookie값이 유지디는 시간 정보를 DB에 저장한다. 
			
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		
			service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		}
		int amount = 60* 60*24*1;
		Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		*/
//		return resultDto; //로그인이 되면(즉,id == pw)이면 이동할 경로.
	}//loginPOST
	
}//class
