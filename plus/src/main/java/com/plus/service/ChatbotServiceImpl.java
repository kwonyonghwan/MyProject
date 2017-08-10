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
	
		//api�� ������ ������ 
		MatchingTempDTO tempDto = new MatchingTempDTO();
		tempDto.setMemberid(ChatbotDTO.getMemberid());
		tempDto = chatbot.runChatbot(ChatbotDTO.getSentence());
		
	//	https://apis.daum.net/local/geo/addr2coord?apikey={apikey}&q=���� Ư����ġ�� ���ֽ� ÷�ܷ� 242&output=json
		
		//api���� ������ �ޱ� 
	//	MatchingDTO dto = new MatchingDTO();
		
		//���� �����Ϳ��� ���浵 ���� 
		
		//dao.insertWordList(dto);
	}//insertMesage()



}//class