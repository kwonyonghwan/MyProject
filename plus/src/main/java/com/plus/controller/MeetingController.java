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
@RequestMapping("/meetings/*")
public class MeetingController {

	private static final Logger logger = LoggerFactory.getLogger(MeetingController.class);

	@Inject 
	BlacklistService service;
	
	@RequestMapping("doA")
	public ResponseEntity<List<BlacklistDTO>> doA() {
		logger.info("doA called.................");

		List<BlacklistDTO> list = service.selectAll("testUser");

		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
		/*return "restControllerTest";*/
	}
	
	@RequestMapping(value="loginPost", method = RequestMethod.POST)
	public void loginPOST(@RequestBody String body) throws Exception{
		
	}//loginPOST

}//class
