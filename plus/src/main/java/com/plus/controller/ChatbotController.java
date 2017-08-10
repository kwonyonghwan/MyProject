package com.plus.controller;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plus.domain.BlacklistDTO;
import com.plus.domain.ChatbotDTO;
import com.plus.service.BlacklistService;
import com.plus.service.ChatbotService;

@RestController
@RequestMapping("/chatbots/*")
public class ChatbotController {

	private static final Logger logger = LoggerFactory.getLogger(ChatbotController.class);

	@Inject 
	private ChatbotService service;
	
	@RequestMapping(value="sentencePost", method = RequestMethod.POST)
	public void sentencePost(@RequestBody ChatbotDTO dto) throws Exception{
		
		System.out.println(dto.toString());
		service.insertMesage(dto);
		//return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}//sentencePost()

}//class