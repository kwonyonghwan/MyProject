package com.plus.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.MemberDTO;
import com.plus.service.BlacklistService;
import com.plus.service.SidebarService;


@RestController
@RequestMapping("/sidebars/*")
public class SidebarController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	/*@Inject 
	SidebarService service;*/
	
	@RequestMapping("readSidebar")
	public void readSidebar(@RequestBody MemberDTO memberDTO) {

		System.out.println(memberDTO.toString());
	}//readBlacklist()
	
}//class


