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
	@Inject
	private GoogleGeocodingAPI localeSearch;
	
	@Override
	public void insertMesage(ChatbotDTO ChatbotDTO) throws Exception {
		
		//api�� ������ ������ 
		//api���� ������ �ޱ� 
		MatchingTempDTO tempDto = chatbot.runChatbot(ChatbotDTO.getSentence());
		tempDto.setMemberid(ChatbotDTO.getMemberid());
		
		//���� �����Ϳ��� ���浵 ���� 
		MatchingDTO matchingDTO = new MatchingDTO();
		if(tempDto.getMatchinglocation().equals("NULL_location")){
			matchingDTO = localeSearch.addressToCoord(matchingDTO, ChatbotDTO.getAddress());
		}else{
			matchingDTO = localeSearch.addressToCoord(matchingDTO, tempDto.getMatchinglocation());
		}
		matchingDTO.setMemberid(ChatbotDTO.getMemberid());
		matchingDTO.setMatchingagegroup(tempDto.getMatchingagegroup());
		matchingDTO.setMatchingcategory(tempDto.getMatchingcategory());
		matchingDTO.setMatchingoptional(tempDto.getMatchingoptional());
		matchingDTO.setMatchingpeoplenumber(tempDto.getMatchingpeoplenumber());
		matchingDTO.setMatchingtime(tempDto.getDate());
		
		dao.insertWordList(matchingDTO);
	}//insertMesage()

}//class