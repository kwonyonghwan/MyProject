package com.plus.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.ChatbotDTO;
import com.plus.domain.MatchingDTO;
import com.plus.domain.MatchingTempDTO;
import com.plus.persistence.ChatbotDAO;
import com.plus.util.*;


@Service
public class ChatbotServiceImpl implements ChatbotService{

	@Inject
	private ChatbotDAO dao;
	@Inject
	private CallAiAPi chatbot;
	
	@Override
	public void insertMesage(ChatbotDTO ChatbotDTO) throws Exception {
		
		System.out.println("------------insertMesage------------------");
	
		//api에 데이터 던지기 
		MatchingTempDTO tempDto = new MatchingTempDTO();
		tempDto.setMemberid(ChatbotDTO.getMemberid());
		tempDto = chatbot.runChatbot(ChatbotDTO.getSentence());
		
	//	https://apis.daum.net/local/geo/addr2coord?apikey={apikey}&q=제주 특별자치도 제주시 첨단로 242&output=json
		
		//api에서 데이터 받기 
	//	MatchingDTO dto = new MatchingDTO();
		
		//받은 데이터에서 위경도 추출 
		
		//dao.insertWordList(dto);
	}//insertMesage()



}//class